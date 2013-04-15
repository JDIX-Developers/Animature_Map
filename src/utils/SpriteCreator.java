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

	private final byte	ANDABLE			= 0;
	private final byte	CAMBIABLE		= 1;
	private final byte	SALTABLE		= 2;
	private final byte	NOANDABLE		= 3;
	private final byte	TRANSPORTABLE	= 4;

	/**
	 * @param args Arguments for the application
	 */
	public static void main(String[] args)
	{
		byte[] arr = {0x00, (byte) 0x80,
		/*
		 * 0x00, 0x00, "CAMBIANTE", 0x01, 0x00, "ANDABLE", 0x02, 0x00,
		 * "ANDABLE",
		 */};

		try
		{
			FileOutputStream st = new FileOutputStream("prueba.spr");
			st.write(arr);
			st.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		HashMap<String, Map.Entry<Byte, Byte>> m = new HashMap<>();

		m.put("Soil/Weed", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x00), new Byte((byte) 0x00)));
		m.put("Soil/Grass1", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x01), new Byte((byte) 0x00)));
		m.put("Soil/Grass2", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x02), new Byte((byte) 0x00)));
		m.put("Soil/Grass3", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x03), new Byte((byte) 0x00)));
		m.put("Soil/Grass4", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x04), new Byte((byte) 0x00)));
		m.put("Path/Center", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x00), new Byte((byte) 0x01)));
		m.put("Path/Top", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x01), new Byte((byte) 0x01)));
		m.put("Path/Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x02), new Byte((byte) 0x01)));
		m.put("Path/Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x03), new Byte((byte) 0x01)));
		m.put("Path/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x04), new Byte((byte) 0x01)));
		m.put("Path/Top_Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x00), new Byte((byte) 0x02)));
		m.put("Path/Top_Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x01), new Byte((byte) 0x02)));
		m.put("Path/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x02)));
		m.put("Path/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x02)));
		// m.put("Soil/Grass", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		// (byte) 0x00), new Byte((byte) 0x00)));
		// m.put("Soil/Soil", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		// (byte) 0x01), new Byte((byte) 0x00)));
		// m.put("Path/Top left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		// (byte) 0x02), new Byte((byte) 0x00)));
		// m.put("Path/Top", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		// (byte) 0x03), new Byte((byte) 0x00)));
		// m.put("Path/Bottom Left", new SimpleImmutableEntry<Byte, Byte>(
		// new Byte((byte) 0x02), new Byte((byte) 0x01)));
		// m.put("Path/Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		// (byte) 0x03), new Byte((byte) 0x01)));
		// m.put("Trees/Top Left (Grass)", new SimpleImmutableEntry<Byte, Byte>(
		// new Byte((byte) 0x00), new Byte((byte) 0x01)));
		// m.put("Trees/Top Right (Grass)", new SimpleImmutableEntry<Byte,
		// Byte>(
		// new Byte((byte) 0x01), new Byte((byte) 0x01)));

		try
		{
			ObjectOutputStream os = new ObjectOutputStream(
			new FileOutputStream("prueba.dspr"));
			os.writeObject(m);
			os.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}