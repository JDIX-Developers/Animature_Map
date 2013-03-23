package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import map.Map;
import map.Sprite;
import map.Square;
import utils.Lang;

import components.ILabel;
import components.SpriteTree;

import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class MapEditor extends JPanel {

	private static final long	serialVersionUID	= - 8557921921364871510L;
	private Map					map;
	private Sprite				sprite;
	private ILabel				lblLoad;

	/**
	 * Create the panel.
	 */
	public MapEditor()
	{
		setLayout(new BorderLayout(0, 0));

		// lblLoad = new ILabel();
		// Lang.setLine(lblLoad, "no_map");
		// lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		// add(lblLoad, BorderLayout.CENTER);
	}

	/**
	 * @param m - Map to edit
	 */
	public void setMap(Map m)
	{
		this.map = m;
		try
		{
			this.sprite = Square.getSprite();
		}
		catch (SpriteException e)
		{
			e.printStackTrace();
		}

		ILabel lblSquareImage = new ILabel(new ImageIcon("img/void_square.png"));
		lblSquareImage.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSquareImage, BorderLayout.NORTH);

		remove(lblLoad);
		JScrollPane panel = new JScrollPane();

		ILabel lblMap = new ILabel(printGrid(map.getImage()));
		panel.setViewportView(lblMap);

		add(panel, BorderLayout.CENTER);

		JTree tree = new SpriteTree(sprite);
		add(tree, BorderLayout.EAST);

		updateUI();
	}

	private ImageIcon printGrid(BufferedImage img)
	{
		Graphics2D graphs = img.createGraphics();
		short size = 0;

		try
		{
			size = map.getSquareSize();
		}
		catch (SpriteException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), Lang
			.getLine("error"), JOptionPane.ERROR_MESSAGE, new ImageIcon(
			"img/error.png"));
		}

		if (size > 0)
		{
			graphs.setColor(Color.BLACK);

			// Horizontal lines
			for (int i = 1; i < map.getHeight(); i++)
			{
				graphs.drawLine(0, i * size, img.getWidth(), i * size);
			}

			// Vertical lines
			for (int i = 1; i < map.getWidth(); i++)
			{
				graphs.drawLine(i * size, 0, i * size, img.getHeight());
			}
		}

		return new ImageIcon(img);
	}
}