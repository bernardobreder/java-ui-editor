package editor.explorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.function.Function;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreeCellRenderer;

import editor.filesystem.IResource;

public class GExplorerTreeRenderer extends JPanel implements TreeCellRenderer {

	private JLabel icon;

	private JLabel text;

	private JLabel status;

	private final Function<IResource, String> name;

	private final Function<IResource, Image> image;

	public GExplorerTreeRenderer(Function<IResource, String> name, Function<IResource, Image> image) {
		super(new BorderLayout(5, 5));
		this.name = name;
		this.image = image;
		setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		add(icon = new JLabel(), BorderLayout.WEST);
		add(text = new JLabel(), BorderLayout.CENTER);
		add(status = new JLabel(), BorderLayout.EAST);
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		GExplorerTreeModel model = (GExplorerTreeModel) tree.getModel();
		IResource file = (IResource) value;
		icon.setIcon(new ImageIcon(image.apply(file)));
		text.setText(name.apply(file));
		status.setText("");
		setOpaque(selected);
		if (selected) {
			setBackground(new Color(0.8f, 0.8f, 1.0f));
		}
		BasicTreeUI treeUI = (BasicTreeUI) tree.getUI();
		int ofIet = treeUI.getLeftChildIndent() + treeUI.getRightChildIndent();
		if (tree.getParent() != null) {
			int parentWidth = tree.getParent().getParent().getPreferredSize().width;
			int pathCount = model.path(file).getPathCount();
			int iconWidth = treeUI.getExpandedIcon().getIconWidth();
			int rowHeight = tree.getRowHeight();
			setPreferredSize(new Dimension(parentWidth - ofIet * pathCount + iconWidth, rowHeight));
		}
		return this;
	}
}
