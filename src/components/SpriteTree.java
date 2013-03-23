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
import map.Square;
import utils.MathUtils;
import exceptions.CompressionException;
import exceptions.SpriteException;

/**
 * A simple JTree created with a Sprite
 * 
 * @author Razican (Iban Eguia)
 */
public class SpriteTree extends JTree {

	private static final long	serialVersionUID	= - 3757649473919856946L;

	/**
	 * Creates a JTree from the Sprite
	 * 
	 * @throws SpriteException If the sprite has not been initialized
	 */
	public SpriteTree() throws SpriteException
	{
		super(new DefaultMutableTreeNode("root"));
		Sprite sprite = Square.getSprite();

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
	 * @throws SpriteException If the sprite has not been initialized
	 */
	public ImageIcon getSelectedIcon() throws SpriteException
	{
		Sprite sprite = Square.getSprite();

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) getLastSelectedPathComponent();
		HashMap<String, Entry<Byte, Byte>> coords = sprite.getHierarchy();

		if (node != null && node.isLeaf())
		{
			Image img = sprite.getRealImage();
			Entry<Byte, Byte> coord = coords.get(getPath(node));

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

	private String getPath(DefaultMutableTreeNode node) throws SpriteException
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

		formattedPath = formattedPath.substring(0, formattedPath.length() - 1);

		return formattedPath;
	}

	/**
	 * Returns a square ready to be painted in the map
	 * 
	 * @return a 32x32 pixel BufferedImage
	 * @throws CompressionException If there is a compression error
	 * @throws SpriteException If the sprite has not been initialized
	 */
	public Square getSelectedSquare() throws SpriteException,
	CompressionException
	{
		Sprite sprite = Square.getSprite();

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) getLastSelectedPathComponent();
		HashMap<String, Entry<Byte, Byte>> coords = sprite.getHierarchy();

		if (node != null && node.isLeaf())
		{
			Entry<Byte, Byte> coord = coords.get(getPath(node));

			return Square.load(coord.getKey(), coord.getValue());
		}

		return null;
	}
}