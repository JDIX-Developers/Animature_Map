package components;

import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import map.Sprite;
import utils.Lang;

/**
 * A simple JTree created with a Sprite
 * 
 * @author Razican (Iban Eguia)
 */
public class SpriteTree extends JTree {

	private static final long	serialVersionUID	= - 3757649473919856946L;

	private Sprite				sprite;

	/**
	 * Creates a JTree from a Sprite
	 * 
	 * @param sprite - The sprite to use for the JTree
	 */
	public SpriteTree(Sprite sprite)
	{
		super(new ITreeNode());
		this.sprite = sprite;
		setRootVisible(false);

		ITreeNode root = (ITreeNode) treeModel.getRoot();

		Lang.setLine(root, "tree_squares");

		for (Entry<String, Entry<Byte, Byte>> ent: sprite.getHierarchy()
		.entrySet())
		{
			System.out.println(ent.getKey());
			String[] path = ent.getKey().split("/");
			setNode(root, path, 0);
		}
	}

	private void setNode(DefaultMutableTreeNode root, String[] path, int cPath)
	{
		@SuppressWarnings ("rawtypes")
		Enumeration e = root.preorderEnumeration();

		DefaultMutableTreeNode n = null;
		while (e.hasMoreElements())
		{
			DefaultMutableTreeNode cn = (DefaultMutableTreeNode) e
			.nextElement();

			if (cn.getUserObject().equals(path[cPath]))
			{
				n = cn;
				break;
			}
		}

		if (n == null)
		{
			n = new DefaultMutableTreeNode(path[cPath]);
			root.add(n);
		}

		if (cPath < path.length - 1)
		{
			setNode(n, path, cPath + 1);
		}
	}

	/**
	 * Returns the full representation of the selected square
	 * 
	 * @return The ImageIcon of the current selected element in 128x128 pixels
	 */
	public ImageIcon getSelectedIcon()
	{
		return null; // TODO
	}

	/**
	 * Returns a square ready to be painted in the map
	 * 
	 * @return a 32x32 pixel BufferedImage
	 */
	public BufferedImage getSelectedImage()
	{
		return null; // TODO
	}
}