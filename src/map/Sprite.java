package map;

import java.awt.Image;
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
	private byte												width;
	private byte												height;
	private BufferedImage										image;
	private BufferedImage										resizedImage;
	private HashMap<String, java.util.Map.Entry<Byte, Byte>>	hierarchy;

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

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f
			.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 4)
			+ ".dspr"));

			hierarchy = (HashMap<String, Entry<Byte, Byte>>) ois.readObject();
			ois.close();

			this.image = ImageIO.read(sprite);
			this.size = size;
			this.height = (byte) (this.image.getHeight() / size);
			this.width = (byte) (this.image.getWidth() / size);

			Image i = this.image.getScaledInstance(this.image.getWidth() / 4,
			this.image.getHeight() / 4, Image.SCALE_FAST);
			this.resizedImage = new BufferedImage(i.getWidth(null),
			i.getHeight(null), BufferedImage.TYPE_INT_RGB);
			this.resizedImage.getGraphics().drawImage(image, 0, 0, null);
		}
		else
		{
			throw new SpriteException("Sprite not correctly codified");
		}
	}

	/**
	 * @return Width of the sprite
	 */
	public byte getWidth()
	{
		return this.width;
	}

	/**
	 * @return Height of the sprite
	 */
	public byte getHeight()
	{
		return this.height;
	}

	/**
	 * @return The real size of the squares
	 */
	public short getRealSize()
	{
		return this.size;
	}

	/**
	 * Returns a 32 pixel per square image for the map creator.
	 * 
	 * @return The BufferedImage for the map creator
	 */
	public BufferedImage getImage()
	{
		return this.resizedImage;
	}

	/**
	 * Returns the real 128 pixel per square image
	 * 
	 * @return The real BufferedImage of the sprite
	 */
	public BufferedImage getRealImage()
	{
		return this.image;
	}

	/**
	 * @return the hierarchy
	 */
	public HashMap<String, java.util.Map.Entry<Byte, Byte>> getHierarchy()
	{
		return hierarchy;
	}
}