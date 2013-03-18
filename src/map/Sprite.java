package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class Sprite {

	private short			size;
	private int				width;
	private int				height;
	private BufferedImage	image;

	/**
	 * @param sprite Sprite's file
	 * @param img_path The path to the img files
	 * @param size Size for the squares of the sprite
	 * @throws IOException if there is an IO exception when reading the sprite
	 * @throws SpriteException If the size of the squares is correct
	 */
	public Sprite(File sprite, File imgPath, short size) throws IOException,
	SpriteException
	{
		if (size == 0)
		{
			throw new SpriteException("Size not valid");
		}
		else
		{
			this.image = ImageIO.read(sprite);
			this.size = size;
			this.height = this.image.getHeight() / size;
			this.width = this.image.getWidth() / size;
		}
	}

	/**
	 * @param f The .spr file to load
	 */
	public Sprite(File f)
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

		short size = (short) (array[0] << 8 + array[1]);
		File sprite = new File(f.getAbsolutePath()
		+ f.getName().substring(0, f.getName().length() - 3) + "png");
		File imgPath = new File(f.getAbsolutePath()
		+ f.getName().substring(0, f.getName().length() - 4));

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
