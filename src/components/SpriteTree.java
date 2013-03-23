package components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import map.Sprite;
import utils.MathUtils;

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
		super(new DefaultMutableTreeNode("root"));
		this.sprite = sprite;

		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel
		.getRoot();

		for (Entry<String, Entry<Byte, Byte>> ent: sprite.getHierarchy()
		.entrySet())
		{
			String[] path = ent.getKey().split("/");
			setNode(root, path, 0);
		}

		expandRow(0);
		setRootVisible(false);
		setShowsRootHandles(true);
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

			if (cn.getUserObject().equals(path[cPath]) && cn != root)
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
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) getLastSelectedPathComponent();
		HashMap<String, Entry<Byte, Byte>> coords = sprite.getHierarchy();

		if (node != null && node.isLeaf())
		{
			TreeNode[] path = node.getPath();
			String formattedPath = "";
			for (TreeNode element: path)
			{
				DefaultMutableTreeNode cN = (DefaultMutableTreeNode) element;

				String pathStr = (String) cN.getUserObject();

				if ( ! pathStr.equals("root"))
				{
					formattedPath += pathStr + "/";
				}
			}

			formattedPath = formattedPath.substring(0,
			formattedPath.length() - 1);

			Image img = sprite.getRealImage();
			Entry<Byte, Byte> coord = coords.get(formattedPath);

			BufferedImage i = new BufferedImage(128, 128,
			BufferedImage.TYPE_INT_RGB);
			Graphics g = i.createGraphics();

			g.drawImage(img, 0, 0, 128, 128,
			128 * MathUtils.uByteToInt(coord.getKey()),
			128 * MathUtils.uByteToInt(coord.getValue()),
			128 * MathUtils.uByteToInt(coord.getKey()) + 128,
			128 * MathUtils.uByteToInt(coord.getValue()) + 128, null);

			return new ImageIcon(i);
		}

		return null;
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