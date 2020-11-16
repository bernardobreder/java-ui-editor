package editor.explorer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import displace.fs.data.IFolder;
import displace.fs.data.IResource;
import displace.fs.data.IWorkspace;

public class GExplorerTreeModel implements TreeModel {

	/** Listenres */
	private final List<TreeModelListener> listeners = new ArrayList<TreeModelListener>();

	/** Sistema de arquivo */
	private Supplier<IWorkspace> workspaceSupplier;

	public GExplorerTreeModel(Supplier<IWorkspace> workspaceSupplier) {
		this.workspaceSupplier = workspaceSupplier;
	}

	@Override
	public Object getRoot() {
		return workspaceSupplier.get();
	}

	@Override
	public Object getChild(Object parent, int index) {
		IFolder file = (IFolder) parent;
		return file.list().get(index);
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent == null) {
			return 0;
		}
		IResource res = (IResource) parent;
		if (res.isFile()) {
			return 0;
		}
		IFolder file = (IFolder) parent;
		List<IResource> files = file.list();
		if (files == null) {
			return 0;
		}
		return files.size();
	}

	@Override
	public boolean isLeaf(Object node) {
		IResource file = (IResource) node;
		return file.isFile();
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		IFolder parentRes = (IFolder) parent;
		IResource childRes = (IResource) child;
		return parentRes.list().indexOf(childRes);
	}

//	@Deprecated
//	public void refresh() {
//		for (Entry<IFolder, List<IResource>> entry : cache.entrySet()) {
//			IFolder parentFile = entry.getKey();
//			List<IResource> oldFiles = entry.getValue();
//			List<IResource> newFiles = parentFile.list();
//			if (!newFiles.equals(oldFiles)) {
//				entry.setValue(newFiles);
//				Object[] path = path(parentFile).getPath();
//				Collections.sort(newFiles);
//				int i, j;
//				for (i = 0, j = 0; i < oldFiles.size() && j < newFiles.size();) {
//					int cmp = oldFiles.get(i).compareTo(newFiles.get(j));
//					if (cmp > 0) {
//						treeNodesInserted(path, new int[] { j }, new Object[] { newFiles.get(j++) });
//					} else if (cmp < 0) {
//						treeNodesRemoved(path, new int[] { i }, new Object[] { oldFiles.get(i++) });
//					} else {
//						i++;
//						j++;
//					}
//				}
//				for (; i < oldFiles.size(); i++) {
//					treeNodesRemoved(path, new int[] { i }, new Object[] { oldFiles.get(i) });
//				}
//				for (; j < newFiles.size(); j++) {
//					treeNodesInserted(path, new int[] { j }, new Object[] { newFiles.get(j) });
//				}
//			}
//		}
//	}

	public TreePath path(IResource file) {
		LinkedList<IResource> files = new LinkedList<IResource>();
		while (!file.equals(workspaceSupplier.get())) {
			files.addFirst(file);
			file = file.getParent();
		}
		files.addFirst(file);
		return new TreePath(files.toArray());
	}

	public void treeStructureChanged(Object[] path, int[] childIndices, Object[] children) {
		if (listeners.isEmpty()) {
			return;
		}
		TreeModelEvent event = new TreeModelEvent(this, path, childIndices, children);
		for (int n = listeners.size() - 1; n >= 0; n--) {
			listeners.get(n).treeStructureChanged(event);
		}
	}

	public void treeNodesChanged(Object[] path, int[] childIndices, List<IResource> oldFiles) {
		if (listeners.isEmpty()) {
			return;
		}
		TreeModelEvent event = new TreeModelEvent(this, path, childIndices, oldFiles.toArray());
		for (int n = listeners.size() - 1; n >= 0; n--) {
			listeners.get(n).treeNodesChanged(event);
		}
	}

	public void treeNodesInserted(Object[] path, int[] childIndices, Object[] children) {
		if (listeners.isEmpty()) {
			return;
		}
		TreeModelEvent event = new TreeModelEvent(this, path, childIndices, children);
		for (int n = listeners.size() - 1; n >= 0; n--) {
			listeners.get(n).treeNodesInserted(event);
		}
	}

	public void treeNodesRemoved(Object[] path, int[] childIndices, Object[] children) {
		if (listeners.isEmpty()) {
			return;
		}
		TreeModelEvent event = new TreeModelEvent(this, path, childIndices, children);
		for (int n = listeners.size() - 1; n >= 0; n--) {
			listeners.get(n).treeNodesRemoved(event);
		}
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	@Override
	public void addTreeModelListener(TreeModelListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener listener) {
		listeners.remove(listener);
	}

}
