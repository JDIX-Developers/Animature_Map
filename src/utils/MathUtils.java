package utils;

/**
 * @author Razican (Iban Eguia)
 */
public final class MathUtils {

	private MathUtils()
	{
	}

	/**
	 * @param b - Unsigned byte
	 * @return int representing the byte, so for example, 0xFF would be 255, and
	 *         not -1
	 */
	public static int uByteToInt(byte b)
	{
		return b & 0x000000FF;
	}

	/**
	 * @param b - Unsigned byte
	 * @return short representing the byte, so for example, 0xFF would be 255,
	 *         and not -1
	 */
	public static short uByteToShort(byte b)
	{
		return (short) (b & 0x00FF);
	}

	/**
	 * @param b1 - left byte for the short
	 * @param b2 - right byte for the short
	 * @return Short representing the unsigned number contained by the two
	 *         bytes.
	 */
	public static short twoByteToShort(byte b1, byte b2)
	{
		return (short) ((uByteToShort(b1) << 8) + uByteToShort(b2));
	}

	/**
	 * @param b - The byte to convert
	 * @return String with hexadecimal representation of the byte
	 */
	public static String toHex(byte b)
	{
		return String.format("%02X", b);
	}

	/**
	 * @param num - The short to convert
	 * @param i - The number of the byte (1 -> left, 0 -> right)
	 * @return The byte in that position
	 */
	public static byte getByte(short num, int i)
	{
		return (byte) (num >> i * 8);
	}
}
