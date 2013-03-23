package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

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
public class MapEditor extends JPanel implements TreeSelectionListener {

	private static final long	serialVersionUID	= - 8557921921364871510L;
	private Map					map;
	private Sprite				sprite;
	private ILabel				lblLoad, lblSquareImage;
	private SpriteTree			tree;

	/**
	 * Create the panel.
	 */
	public MapEditor()
	{
		setLayout(new BorderLayout(0, 0));

		lblLoad = new ILabel();
		Lang.setLine(lblLoad, "no_map");
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLoad, BorderLayout.CENTER);
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

		remove(lblLoad);
		JScrollPane mapPanel = new JScrollPane();

		ILabel lblMap = new ILabel(printGrid(map.getImage()));
		mapPanel.setViewportView(lblMap);

		add(mapPanel, BorderLayout.CENTER);

		JPanel treePanel = new JPanel();
		add(treePanel, BorderLayout.EAST);
		treePanel.setLayout(new BorderLayout(0, 0));

		lblSquareImage = new ILabel(new ImageIcon("img/void_square.png"));
		treePanel.add(lblSquareImage, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		treePanel.add(scrollPane, BorderLayout.CENTER);

		tree = new SpriteTree(sprite);
		tree.addTreeSelectionListener(this);
		scrollPane.setViewportView(tree);

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

	@Override
	public void valueChanged(TreeSelectionEvent arg0)
	{
		ImageIcon i = tree.getSelectedIcon();
		if (i != null)
		{
			lblSquareImage.setIcon(i);
		}
	}
}