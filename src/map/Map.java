package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import utils.Lang;

/**
 * @author Razican (Iban Eguia)
 */
public class Map {

	private BufferedImage			image;		// TODO
	private Square[][]				squares;
	private int						width, height;
	private HashMap<Square, Link>	links;

	/**
	 * @param width Map's width
	 * @param height Map's height
	 */
	public Map(int width, int height)
	{
		this.squares = new Square[height][width];
		this.width = width;
		this.height = height;
		links = new HashMap<>();
	}

	/**
	 * Sets the square in specified coordinates to match specified square
	 * 
	 * @param x X coordinate for the new square
	 * @param y Y coordinate for the new square
	 * @param sq Square to set
	 */
	public void setSquare(int x, int y, Square sq)
	{
		squares[y][x] = sq;
	}

	/**
	 * @param sq Square of the link
	 * @param l Link for the square
	 */
	public void addLink(Square sq, Link l)
	{
		links.put(sq, l);
	}

	/**
	 * @param sq Square of the link to remove
	 */
	public void removeLink(Square sq)
	{
		links.remove(sq);
	}

	/**
	 * @param name Name of the map, to be saved
	 */
	public void save(String name)
	{
		byte[] array = compress();
		addLinks(array);

		try
		{
			(new FileOutputStream(new File("maps/" + name + "/production/map/"
			+ name + ".map"))).write(array);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, Lang.getLine("map_save_error"),
			Lang.getLine("error"), JOptionPane.ERROR_MESSAGE, new ImageIcon(
			"img/error.png"));
		}
	}

	private byte[] compress()
	{
		byte[][] arr2d = new byte[height][2 * width];
		byte[][] arr2dc = new byte[height][2 * width];

		// We load the bidimensional array, square by square
		for (int i = 0; i < this.squares.length; i++)
		{
			for (int h = 0, j = 0; h < this.squares[i].length; h++)
			{
				arr2d[i][j++] = this.squares[i][h].bytes()[0];
				arr2d[i][j++] = this.squares[i][h].bytes()[1];
			}
		}

		short deleted = 0;

		// We first compress in X coordinate
		for (int i = 0; i < arr2d.length; i++)
		{
			for (int h = 0; h < arr2d[i].length; h += 2)
			{
				arr2dc[i][h] = arr2d[i][h];
				arr2dc[i][h + 1] = arr2d[i][h + 1];
				int r = 1;

				while ((h + r * 2) < arr2d[i].length
				&& arr2d[i][h] == arr2d[i][h + r * 2]
				&& arr2d[i][h + 1] == arr2d[i][h + r * 2 + 1])
				{
					r++;
				}

				if (r > 2)
				{
					arr2dc[i][h + 2] = (byte) (r - 1);
					arr2dc[i][h + 3] = (byte) 0xFF;
					for (int j = 4; j < r * 2; j += 2)
					{
						arr2dc[i][h + j + 1] = arr2dc[i][h + j] = (byte) 0xFF;
						deleted++;
					}

					h += r * 2 - 2;
				}
			}
		}

		// Now we compress in Y coordinate
		for (int h = 0; h < arr2d[0].length; h += 2)
		{
			for (int i = 0; i < arr2d.length; i++)
			{
				int r = 1;

				while (i + r < arr2d.length && arr2d[i][h] == arr2d[i + r][h]
				&& arr2d[i][h + 1] == arr2d[i + r][h + 1])
				{
					r++;
				}

				if (r > 2)
				{
					arr2dc[i + 1][h] = (byte) 0xFF;
					arr2dc[i + 1][h + 1] = (byte) (r - 1);
					for (int j = 2; j < r; j++)
					{
						arr2dc[i + j][h + 1] = arr2dc[i + j][h] = (byte) 0xFF;
						deleted++;
					}

					i += r - 1;
				}
			}
		}

		// We create the compressed array
		byte[] arr = new byte[2 + 2 * height * width - deleted * 2];
		arr[0] = (byte) width;
		arr[1] = (byte) height;
		int índice = 2;

		for (byte[] element: arr2dc)
		{
			for (int h = 0; h < element.length; h += 2)
			{
				// We only save if the square has not been deleted
				if (element[h] != (byte) 0xFF || element[h + 1] != (byte) 0xFF)
				{
					arr[índice++] = element[h];
					arr[índice++] = element[h + 1];
				}
			}
		}

		return arr;
	}

	private void addLinks(byte[] array)
	{
		// TODO Create map's array
	}
}