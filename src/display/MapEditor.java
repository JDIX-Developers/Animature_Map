package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import components.ToolBar;

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
	private ToolBar				toolBar;
	private boolean				isSaved;
	private File				saveFile;
	private int					clickX, clickY;

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
		this.isSaved = saveFile != null;

		this.saveFile = saveFile;
		this.map = m;

		remove(lblLoad);

		toolBar = new ToolBar(this);
		add(toolBar, BorderLayout.NORTH);

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

		// TODO Draw links

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
		this.isSaved = this.saveFile != null;
	}

	/**
	 * Tell the map editor that the map has been saved
	 * 
	 * @param path The path of the saved file
	 */
	public void saved(String path)
	{
		this.saveFile = path != null && ! path.equals("") ? new File(path)
		: null;
		this.isSaved = this.saveFile != null;
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

	/**
	 * @return The map currently in the map editor
	 */
	public Map getMap()
	{
		return this.map;
	}

	/**
	 * @param cursor - The cursor to set for the map
	 */
	public void setMapCursor(int cursor)
	{
		lblMap.setCursor(Cursor.getPredefinedCursor(cursor));
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
		if (toolBar.isAddingLink() || toolBar.isEditingLink()
		|| toolBar.isRemovingLink())
		{
			int x, y;

			x = ((e.getX() - (lblMap.getWidth() - 32 * map.getWidth()) / 2) / 32);
			y = ((e.getY() - (lblMap.getHeight() - 32 * map.getWidth()) / 2) / 32);

			if (toolBar.isAddingLink())
			{
				addLink(x, y);
			}
			else if (toolBar.isEditingLink())
			{
				editLink(x, y);
			}
			else if (toolBar.isRemovingLink())
			{
				removeLink(x, y);
			}
		}
	}

	private void addLink(int x, int y)
	{
		// TODO create dialog, etc.
		toolBar.linkAdded();
	}

	private void editLink(int x, int y)
	{
		// TODO create dialog, etc.
		toolBar.linkEdited();
	}

	private void removeLink(int x, int y)
	{
		// TODO create dialog, etc.
		toolBar.linkRemoved();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// MouseInfo.getPointerInfo().getLocation();
		try
		{
			if (tree.getSelectedSquare() != null)
			{
				this.clickX = ((e.getX() - (lblMap.getWidth() - 32 * map
				.getWidth()) / 2) / 32);
				this.clickY = ((e.getY() - (lblMap.getHeight() - 32 * map
				.getWidth()) / 2) / 32);
			}
		}
		catch (SpriteException | CompressionException e1)
		{
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		try
		{
			if (tree.getSelectedSquare() != null && ! toolBar.isAddingLink())
			{
				int x, y;

				x = ((e.getX() - (lblMap.getWidth() - 32 * map.getWidth()) / 2) / 32);
				y = ((e.getY() - (lblMap.getHeight() - 32 * map.getWidth()) / 2) / 32);

				if (x >= 0 && x < map.getWidth() && y >= 0
				&& y < map.getHeight() && x == this.clickX && y == this.clickY)
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
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}