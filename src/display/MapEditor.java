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
import utils.Lang;

import components.JLabel;

import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class MapEditor extends JPanel {

	private static final long	serialVersionUID	= -8557921921364871510L;
	private Map					map;
	private JLabel				lblClickToLoad;

	/**
	 * Create the panel.
	 */
	public MapEditor()
	{
		setLayout(new BorderLayout(0, 0));

		lblClickToLoad = new JLabel();
		Lang.setLine(lblClickToLoad, "no_map");
		lblClickToLoad.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblClickToLoad, BorderLayout.CENTER);
	}

	/**
	 * @param m Map to edit
	 */
	public void setMap(Map m)
	{
		this.map = m;
		loadMap();
	}

	private void loadMap()
	{
		remove(lblClickToLoad);
		JScrollPane panel = new JScrollPane();

		JLabel lblMap = new JLabel(printGrid(map.getImage()));
		panel.setViewportView(lblMap);

		add(panel, BorderLayout.CENTER);

		JTree tree = new JTree(); // TODO Load Sprite's info
		add(tree, BorderLayout.EAST);
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