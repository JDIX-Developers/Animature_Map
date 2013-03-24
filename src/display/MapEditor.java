package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

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
	private boolean				isSaved;
	private File				saveFile;

	/**
	 * Create the panel.
	 */
	public MapEditor()
	{
		this.isSaved = true;
		setLayout(new BorderLayout(0, 0));

		lblLoad = new ILabel();
		Lang.setLine(lblLoad, "no_map");
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLoad, BorderLayout.CENTER);
	}

	/**
	 * @param m - Map to edit
	 * @param saveFile - The file in which to save the map
	 * @throws SpriteException - if the sprite is not set
	 */
	public void setMap(Map m, File saveFile) throws SpriteException
	{
		if (saveFile != null)
		{
			this.isSaved = true;
		}

		this.saveFile = saveFile;
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

		graphs.setColor(Color.BLACK);

		// Horizontal lines
		for (int i = 1; i < map.getHeight(); i++)
		{
			graphs.drawLine(0, i * 32, img.getWidth(), i * 32);
		}

		// Vertical lines
		for (int i = 1; i < map.getWidth(); i++)
		{
			graphs.drawLine(i * 32, 0, i * 32, img.getHeight());
		}

		return new ImageIcon(img);
	}

	/**
	 * @return Whether the actual map has been saved or not
	 */
	public boolean isSaved()
	{
		return isSaved;
	}

	/**
	 * Tell the map editor that the map has been saved
	 */
	public void saved()
	{
		this.isSaved = true;
	}

	/**
	 * @return The file in which to save the map
	 */
	public File getFile()
	{
		return saveFile;
	}

	/**
	 * @return Whether there is a map in the MapEditor or not
	 */
	public boolean hasMap()
	{
		return map != null;
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
		try
		{
			if (tree.getSelectedSquare() != null)
			{
				int x, y;

				x = ((e.getX() - (lblMap.getWidth() - 32 * map.getWidth()) / 2) / 32);
				y = ((e.getY() - (lblMap.getHeight() - 32 * map.getWidth()) / 2) / 32);

				if (x >= 0 && x < map.getWidth() && y >= 0
				&& y < map.getHeight())
				{
					isSaved = false;
					map.setSquare(x, y, tree.getSelectedSquare());
					lblMap.setIcon(printGrid(map.getImage()));
				}
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