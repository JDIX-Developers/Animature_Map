package map;

import java.awt.image.BufferedImage;
import java.io.File;
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
	 * @param size Size for the squares of the sprite
	 * @throws IOException if there is an IO exception when reading the sprite
	 * @throws SpriteException If the size of the squares is correct
	 */
	public Sprite(File sprite, short size) throws IOException, SpriteException
	{
		if (size == 0)
		{
			throw new SpriteException("Size not valid");
		}
		else
		{
			this.image = ImageIO.read(sprite);
			this.height = this.image.getHeight() / size;
			this.width = this.image.getWidth() / size;
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
