package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import utils.MathUtils;
import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class Sprite {

	private short												size;
	private int													width;
	private int													height;
	private BufferedImage										image;
	private File												imgPath;
	private HashMap<java.util.Map.Entry<Byte, Byte>, String>	hierarchy;

	/**
	 * @param f The .spr file to load
	 * @throws IOException if there is an IO exception when reading the image
	 * @throws SpriteException if the .spr file is not correct.
	 * @throws ClassNotFoundException if there is an error when loading the
	 *             hierarchy.
	 */
	@SuppressWarnings ("unchecked")
	public Sprite(File f) throws IOException, SpriteException,
	ClassNotFoundException
	{
		FileInputStream st = null;
		try
		{
			st = new FileInputStream(f);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		byte[] array = new byte[(int) f.length()];
		st.read(array);

		short size = MathUtils.twoByteToShort(array[0], array[1]);

		if (size != 0)
		{
			File sprite = new File(f.getAbsolutePath().substring(0,
			f.getAbsolutePath().length() - 3)
			+ "png");

			File imgPath = new File(f.getAbsolutePath().substring(0,
			f.getAbsolutePath().length() - 4));

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f
			.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 4)
			+ ".dspr"));

			hierarchy = (HashMap<Entry<Byte, Byte>, String>) ois.readObject();

			this.image = ImageIO.read(sprite);
			this.size = size;
			this.height = this.image.getHeight() / size;
			this.width = this.image.getWidth() / size;
			this.imgPath = imgPath;
		}
		else
		{
			throw new SpriteException("Sprite not correctly codified");
		}
	}

	/**
	 * @return Width of the sprite
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * @return Height of the sprite
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * @return Size of the squares in the sprite
	 */
	public short getSize()
	{
		return this.size;
	}

	/**
	 * @return Image for the sprite
	 */
	public BufferedImage getImage()
	{
		return this.image;
	}
}
