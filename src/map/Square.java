package map;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import utils.MathUtils;
import exceptions.CompressionException;
import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class Square {

	private static Sprite		sprite;
	private static Square[][]	squares;
	private BufferedImage		image;
	private byte				x, y;

	/**
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @throws CompressionException If there is a compression error
	 */
	private Square(byte x, byte y) throws CompressionException
	{
		if (x == 0xFF || y == 0xFF)
		{
			throw new CompressionException();
		}

		this.x = x;
		this.y = y;

		this.image = new BufferedImage(sprite.getSize(), sprite.getSize(),
		BufferedImage.TYPE_INT_ARGB);

		this.image.createGraphics().drawImage(sprite.getImage(),
		-this.x * sprite.getSize(), -this.y * sprite.getSize(), null);
	}

	/**
	 * @return array with the bytes of the square
	 */
	public byte[] bytes()
	{
		byte[] a = {this.x, this.y};
		return a;
	}

	@Override
	public String toString()
	{
		return "(0x" + MathUtils.toHex(x) + ", 0x" + MathUtils.toHex(y) + ")";
	}

	@Override
	public boolean equals(Object sq)
	{
		return (sq instanceof Square && Arrays.equals(((Square) sq).bytes(),
		bytes()));
	}

	/**
	 * @param s Sprite
	 */
	public static void setSprite(Sprite s)
	{
		sprite = s;
	}

	/**
	 * @return Square's buffered image
	 */
	public BufferedImage getImage()
	{
		return this.image;
	}

	/**
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @return Square in that position of the sprite
	 * @throws SpriteException If the sprite has not been initialized
	 * @throws CompressionException If there is a compression error
	 */
	public static Square load(byte x, byte y) throws SpriteException,
	CompressionException
	{
		int xi = MathUtils.uByteToInt(x), yi = MathUtils.uByteToInt(y);

		if (sprite == null)
		{
			throw new SpriteException();
		}
		if (squares == null)
		{
			squares = new Square[sprite.getWidth() / sprite.getSize()][sprite
			.getHeight() / sprite.getSize()];
		}
		if (xi > sprite.getWidth() / sprite.getSize() - 1
		|| yi > sprite.getHeight() / sprite.getSize() - 1)
		{
			throw new SpriteException("There is no image for coordinates (0x"
			+ MathUtils.toHex(x) + ", 0x" + MathUtils.toHex(y) + ")");
		}
		if (squares[xi][yi] == null)
		{
			squares[xi][yi] = new Square(x, y);
		}

		return squares[xi][yi];
	}
}