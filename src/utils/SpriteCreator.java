package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Razican (Iban Eguia)
 */
public class SpriteCreator {

	/**
	 * @param args Arguments for the application
	 */
	public static void main(String[] args)
	{
		byte[] arr = {0x00, (byte) 0x80};

		try
		{
			FileOutputStream st = new FileOutputStream("test.spr");
			st.write(arr);
			st.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		HashMap<String, Map.Entry<Byte, Byte>> m = new HashMap<>();

		m.put("Soil/Grass", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x00), new Byte((byte) 0x00)));
		m.put("Soil/Soil", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x01), new Byte((byte) 0x00)));
		m.put("Path/Top left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x02), new Byte((byte) 0x00)));
		m.put("Path/Top", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x03), new Byte((byte) 0x00)));
		m.put("Path/Bottom Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x01)));
		m.put("Path/Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x03), new Byte((byte) 0x01)));
		m.put("Trees/Top Left (Grass)", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x01)));
		m.put("Trees/Top Right (Grass)", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x01)));

		try
		{
			ObjectOutputStream os = new ObjectOutputStream(
			new FileOutputStream("test.dspr"));
			os.writeObject(m);
			os.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}