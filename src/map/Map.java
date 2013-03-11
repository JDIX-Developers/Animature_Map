package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Razican (Iban Eguia)
 */
public class Map {

	private BufferedImage			bitmap;
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
			// TODO Error message
		}
	}

	private byte[] compress()
	{
		return null;
		// TODO Compress the map
	}

	private void addLinks(byte[] array)
	{
		// TODO Create map's array
	}
}