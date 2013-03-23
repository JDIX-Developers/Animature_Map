package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import map.Map;
import utils.Lang;

import components.ILabel;
import components.SpriteTree;

import exceptions.CompressionException;
import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class MapEditor extends JPanel implements TreeSelectionListener,
MouseListener {

	private static final long	serialVersionUID	= - 8557921921364871510L;
	private Map					map;
	private ILabel				lblLoad, lblSquareImage, lblMap;
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
	 * @throws SpriteException if the sprite is not set
	 */
	public void setMap(Map m) throws SpriteException
	{
		this.map = m;

		remove(lblLoad);
		JScrollPane mapPanel = new JScrollPane();

		lblMap = new ILabel(printGrid(map.getImage()));
		lblMap.addMouseListener(this);
		mapPanel.setViewportView(lblMap);

		add(mapPanel, BorderLayout.CENTER);

		JPanel treePanel = new JPanel();
		add(treePanel, BorderLayout.EAST);
		treePanel.setLayout(new BorderLayout(0, 0));

		lblSquareImage = new ILabel(new ImageIcon("img/void_square.png"));
		treePanel.add(lblSquareImage, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		treePanel.add(scrollPane, BorderLayout.CENTER);

		tree = new SpriteTree();
		tree.addTreeSelectionListener(this);
		scrollPane.setViewportView(tree);

		updateUI();
	}

	private ImageIcon printGrid(BufferedImage img)
	{
		Graphics2D graphs = img.createGraphics();
		short size = 32;

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

		return new ImageIcon(img);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0)
	{
		ImageIcon i = null;
		try
		{
			i = tree.getSelectedIcon();
		}
		catch (SpriteException e)
		{
			e.printStackTrace();
		}

		if (i != null)
		{
			lblSquareImage.setIcon(i);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println((e.getX() / 32) + "," + (e.getY() / 32));
		try
		{
			if (tree.getSelectedSquare() != null)
			{
				byte x, y;

				x = (byte) (e.getX() / 32);
				y = (byte) (e.getY() / 32);

				map.setSquare(x, y, tree.getSelectedSquare());
				lblMap.setIcon(printGrid(map.getImage()));
			}
		}
		catch (SpriteException | CompressionException e1)
		{
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}