package editor.explorer;

import static java.util.stream.Collectors.toList;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import displace.fs.data.IFile;
import displace.fs.data.IResource;
import displace.fs.data.IWorkspace;

public class GExplorerTree extends JTree {

	private ExplorerTreeListener listener;

	private final Supplier<IWorkspace> workspaceSupplier;

	public GExplorerTree(Supplier<IWorkspace> workspaceSupplier, Function<IResource, String> name,
			Function<IResource, Image> image) {
		super(new GExplorerTreeModel(workspaceSupplier));
		this.workspaceSupplier = workspaceSupplier;
		setCellRenderer(new GExplorerTreeRenderer(name, image));
		setRootVisible(false);
		setShowsRootHandles(true);
		setRowHeight(20);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				treeMouseClicked(e);
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				treeKeyPressed(e);
			}
		});
	}

	protected void treeKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (listener != null) {
				TreePath[] paths = getSelectionPaths();
				for (TreePath path : paths) {
					IResource resource = (IResource) path.getLastPathComponent();
					if (resource.isFile()) {
						IFile file = (IFile) resource;
						listener.onOpenFile(file);
					}
				}
			}
		}
	}

	protected void treeMouseClicked(MouseEvent e) {
		if (listener != null) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (e.getClickCount() > 1) {
					List<IResource> resources = getSelectedResources();
					for (IResource resource : resources) {
						if (resource.isFile()) {
							listener.onOpenFile((IFile) resource);
						}
					}
				} else {
					int rowIndex = getRowForLocation(e.getX(), e.getY());
					if (rowIndex < 0) {
						clearSelection();
					}
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				int rowIndex = getRowForLocation(e.getX(), e.getY());
				if (rowIndex < 0) {
					clearSelection();
				} else if (getSelectionCount() == 0) {
					setSelectionRow(rowIndex);
				}
				listener.onPopupFile(getSelectedResources(), e.getX(), e.getY());
			}
		}
	}

	public List<IResource> getSelectedResources() {
		return getSelectionPathsOrEmpty().stream() //
				.map(path -> (IResource) path.getLastPathComponent()) //
				.collect(toList());
	}

	private List<TreePath> getSelectionPathsOrEmpty() {
		TreePath[] paths = getSelectionPaths();
		if (paths == null) {
			paths = new TreePath[0];
		}
		return new ArrayList<TreePath>(Arrays.asList(paths));
	}

	public void refresh() {
		List<TreePath> selectionPaths = getSelectionPathsOrEmpty();
		clearSelection();
		List<TreePath> paths = new ArrayList<>();
		int rowCount = getRowCount();
		for (int i = 0; i < rowCount; i++) {
			TreePath path = getPathForRow(i);
			if (isExpanded(path)) {
				paths.add(path);
			}
		}
		setModel(new GExplorerTreeModel(workspaceSupplier));
		for (TreePath path : paths) {
			expandPath(path);
		}
		for (TreePath path : selectionPaths) {
			int rowIndex = getRowForPath(path);
			if (rowIndex >= 0) {
				addSelectionRow(rowIndex);
			}
		}
	}

	public ExplorerTreeListener getListener() {
		return listener;
	}

	public void setListener(ExplorerTreeListener listener) {
		this.listener = listener;
	}

	@Override
	public GExplorerTreeModel getModel() {
		return (GExplorerTreeModel) super.getModel();
	}

	public static interface ExplorerTreeListener {

		public void onOpenFile(IFile file);

		public void onPopupFile(List<IResource> resources, int x, int y);

	}

}
