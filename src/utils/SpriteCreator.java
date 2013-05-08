package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Razican (Iban Eguia)
 */
public class SpriteCreator {

	private static final byte	NOANDABLE		= 0;
	private static final byte	ANDABLE			= 1;
	private static final byte	CAMBIABLE		= 2;
	private static final byte	SALTABLE		= 4;
	private static final byte	TRANSPORTABLE	= 8;
	private static final byte	LEIBLE			= 16;

	/**
	 * @param args Arguments for the application
	 */
	public static void main(final String[] args)
	{
		final byte[] arr128 = {0x00, (byte) 0x80, 0x00, 0x00,
		CAMBIABLE | ANDABLE, 0x01, 0x00, ANDABLE, 0x02, 0x00, ANDABLE, 0x03,
		0x00, ANDABLE, 0x04, 0x00, ANDABLE, 0x05, 0x00, ANDABLE, 0x06, 0x00,
		ANDABLE, 0x07, 0x00, NOANDABLE, 0x08, 0x00, NOANDABLE, 0x09, 0x00,
		NOANDABLE, 0x0A, 0x00, NOANDABLE, 0x0B, 0x00, NOANDABLE, 0x0C, 0x00,
		NOANDABLE, /*
					 * 0x0D, 0x00, ANDABLE, 0x0E, 0x00, ANDABLE, 0x0F, 0x00,
					 * ANDABLE,
					 */
		0x00, 0x01, ANDABLE, 0x01, 0x01, ANDABLE, 0x02, 0x01, ANDABLE, 0x03,
		0x01, ANDABLE, 0x04, 0x01, ANDABLE, 0x05, 0x01, ANDABLE, 0x06, 0x01,
		NOANDABLE, 0x07, 0x01, NOANDABLE, 0x08, 0x01, NOANDABLE, 0x09, 0x01,
		NOANDABLE, 0x0A, 0x01, NOANDABLE, 0x0B, 0x01, NOANDABLE, 0x0C, 0x01,
		NOANDABLE, 0x0D, 0x01, NOANDABLE, 0x0E, 0x01, NOANDABLE, 0x0F, 0x01,
		NOANDABLE, 0x00, 0x02, ANDABLE, 0x01, 0x02, ANDABLE, 0x02, 0x02,
		ANDABLE, 0x03, 0x02, ANDABLE, 0x04, 0x02, ANDABLE, 0x05, 0x02, ANDABLE,
		0x06, 0x02, NOANDABLE, 0x07, 0x02, NOANDABLE, 0x08, 0x02,
		NOANDABLE | LEIBLE, 0x09, 0x02, NOANDABLE | LEIBLE, 0x0A, 0x02,
		NOANDABLE, 0x0B, 0x02, NOANDABLE, 0x0C, 0x02, NOANDABLE, 0x0D, 0x02,
		NOANDABLE, 0x0E, 0x02, NOANDABLE, 0x0F, 0x02, TRANSPORTABLE, 0x00,
		0x03, NOANDABLE, 0x01, 0x03, NOANDABLE, 0x02, 0x03, NOANDABLE, 0x03,
		0x03, NOANDABLE, 0x04, 0x03, NOANDABLE, 0x05, 0x03, NOANDABLE, 0x06,
		0x03, NOANDABLE, 0x07, 0x03, NOANDABLE, 0x08, 0x03, NOANDABLE, 0x09,
		0x03, NOANDABLE, 0x0A, 0x03, NOANDABLE, 0x0B, 0x03, NOANDABLE, 0x0C,
		0x03, NOANDABLE, 0x0D, 0x03, NOANDABLE, 0x0E, 0x03, NOANDABLE, 0x0F,
		0x03, NOANDABLE, 0x00, 0x04, NOANDABLE, 0x01, 0x04, NOANDABLE, 0x02,
		0x04, NOANDABLE, 0x03, 0x04, NOANDABLE, 0x04, 0x04, NOANDABLE, 0x05,
		0x04, NOANDABLE, 0x06, 0x04, NOANDABLE, 0x07, 0x04, NOANDABLE, 0x08,
		0x04, NOANDABLE, 0x09, 0x04, NOANDABLE, 0x0A, 0x04, NOANDABLE, 0x0B,
		0x04, NOANDABLE, 0x0C, 0x04, NOANDABLE, 0x0D, 0x04, NOANDABLE, 0x0E,
		0x04, NOANDABLE, 0x0F, 0x04, TRANSPORTABLE, 0x00, 0x05, NOANDABLE,
		0x01, 0x05, NOANDABLE, 0x02, 0x05, NOANDABLE, 0x03, 0x05, NOANDABLE,
		0x04, 0x05, NOANDABLE, 0x05, 0x05, NOANDABLE, 0x06, 0x05, NOANDABLE,
		0x07, 0x05, NOANDABLE, 0x08, 0x05, NOANDABLE, 0x09, 0x05, NOANDABLE,
		0x0A, 0x05, NOANDABLE, 0x0B, 0x05, NOANDABLE, 0x0C, 0x05, NOANDABLE,
		0x0D, 0x05, NOANDABLE, 0x0E, 0x05, NOANDABLE, 0x0F, 0x05, NOANDABLE,
		0x00, 0x06, NOANDABLE, 0x01, 0x06, NOANDABLE, 0x02, 0x06, NOANDABLE,
		0x03, 0x06, NOANDABLE, 0x04, 0x06, NOANDABLE,/*
													 * 0x05, 0x06, NOANDABLE,
													 * 0x06, 0x06, NOANDABLE,
													 */0x07, 0x06,
		TRANSPORTABLE, 0x08, 0x06, NOANDABLE, 0x09, 0x06, NOANDABLE, 0x0A,
		0x06, NOANDABLE, 0x0B, 0x06, NOANDABLE, 0x0C, 0x06, NOANDABLE, 0x0D,
		0x06, NOANDABLE, 0x0E, 0x06, NOANDABLE, 0x0F, 0x06, NOANDABLE, 0x00,
		0x07, NOANDABLE, 0x01, 0x07, NOANDABLE, 0x02, 0x07, NOANDABLE, 0x03,
		0x07, NOANDABLE, 0x04, 0x07, NOANDABLE, 0x05, 0x07, NOANDABLE, 0x06,
		0x07, NOANDABLE, 0x07, 0x07, NOANDABLE, 0x08, 0x07, NOANDABLE, 0x09,
		0x07, NOANDABLE, 0x0A, 0x07, NOANDABLE, 0x0B, 0x07, NOANDABLE, 0x0C,
		0x07, NOANDABLE, 0x0D, 0x07, NOANDABLE, 0x0E, 0x07, NOANDABLE, 0x0F,
		0x07, NOANDABLE, 0x00, 0x08, NOANDABLE, 0x01, 0x08, NOANDABLE, 0x02,
		0x08, NOANDABLE, 0x03, 0x08, NOANDABLE, 0x04, 0x08, NOANDABLE, 0x05,
		0x08, NOANDABLE, 0x06, 0x08, NOANDABLE, 0x07, 0x08, NOANDABLE, 0x08,
		0x08, NOANDABLE, 0x09, 0x08, TRANSPORTABLE, 0x0A, 0x08, NOANDABLE,
		0x0B, 0x08, NOANDABLE, 0x0C, 0x08, NOANDABLE,/*
													 * 0x0D, 0x08, NOANDABLE,
													 * 0x0E, 0x08, NOANDABLE,
													 * 0x0F, 0x08, NOANDABLE,
													 */
		};

		final byte[] arr24 = Arrays.copyOf(arr128, arr128.length);
		arr24[1] = 0x18;
		final byte[] arr32 = Arrays.copyOf(arr128, arr128.length);
		arr32[1] = 0x20;
		final byte[] arr48 = Arrays.copyOf(arr128, arr128.length);
		arr48[1] = 0x30;
		final byte[] arr64 = Arrays.copyOf(arr128, arr128.length);
		arr64[1] = 0x40;

		try
		{
			FileOutputStream st = new FileOutputStream("sprites/sprite128.spr");
			st.write(arr128);
			st.close();

			st = new FileOutputStream("sprites/sprite64.spr");
			st.write(arr64);
			st.close();

			st = new FileOutputStream("sprites/sprite48.spr");
			st.write(arr48);
			st.close();

			st = new FileOutputStream("sprites/sprite32.spr");
			st.write(arr32);
			st.close();

			st = new FileOutputStream("sprites/sprite24.spr");
			st.write(arr24);
			st.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		final HashMap<String, Map.Entry<Byte, Byte>> m = new HashMap<>();

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
		m.put("Path/Corner_Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x00)));
		m.put("Soil/Flowers", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x06), new Byte((byte) 0x00)));
		m.put("Others/Black", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x07), new Byte((byte) 0x00)));
		m.put("Pokemon_Center/Wall/Top_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x00)));
		m.put("Pokemon_Center/Wall/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x00)));
		m.put("Fence/Corner/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x00)));
		m.put("Fence/Corner/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x00)));
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
		m.put("Path/Corner_Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x01)));
		m.put("Others/Postbox_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x01)));
		m.put("Soil/Bush", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x07), new Byte((byte) 0x01)));
		m.put("Pokemon_Center/Wall/Bottom_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x01)));
		m.put("Pokemon_Center/Wall/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x01)));
		m.put("Fence/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0A), new Byte((byte) 0x01)));
		m.put("Fence/Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0B), new Byte((byte) 0x01)));
		m.put("Shop/Roof/Bottom_CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x01)));
		m.put("Shop/Roof/Bottom_CenterR", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x01)));
		m.put("Shop/Wall/Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0E), new Byte((byte) 0x01)));
		m.put("Path/Top_Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x00), new Byte((byte) 0x02)));
		m.put("Path/Top_Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x01), new Byte((byte) 0x02)));
		m.put("Path/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x02)));
		m.put("Path/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x02)));
		m.put("Path/Corner_Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x02)));
		m.put("Path/Corner_Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x02)));
		m.put("Others/Postbox_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x02)));
		m.put("Fence/Center", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x07), new Byte((byte) 0x02)));
		m.put("Fence/Fence_Poster", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x02)));
		m.put("Others/Poster", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x09), new Byte((byte) 0x02)));
		m.put("Fence/Corner/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x02)));
		m.put("Fence/Corner/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x02)));
		m.put("Shop/Wall/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0C), new Byte((byte) 0x02)));
		m.put("Shop/Wall/CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x02)));
		m.put("Shop/Wall/Door", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0E), new Byte((byte) 0x02)));
		m.put("Tree/Ordinary/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x03)));
		m.put("Tree/Ordinary/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x03)));
		m.put("Tree/Shadow/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x03)));
		m.put("Tree/Shadow/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x03)));
		m.put("Hause/Roof/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x03)));
		m.put("Hause/Roof/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x03)));
		m.put("Hause/Roof/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x03)));
		m.put("Hause/Wall/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x03)));
		m.put("Hause/Wall/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x03)));
		m.put("Pokemon_Center/Roof/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Roof/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Roof/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Wall/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Wall/Top_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Wall/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
		(byte) 0x03)));
		m.put("Tree/Ordinary/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x00), new Byte(
		(byte) 0x04)));
		m.put("Tree/Ordinary/Center_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x01), new Byte(
		(byte) 0x04)));
		m.put("Tree/Shadow/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x04)));
		m.put("Tree/Shadow/Center_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x04)));
		m.put("Hause/Roof/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x04)));
		m.put("Hause/Roof/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x04)));
		m.put("Hause/Roof/Center_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x04)));
		m.put("Hause/Wall/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x04)));
		m.put("Hause/Wall/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x04)));
		m.put("Pokemon_Center/Roof/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Roof/Center_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Roof/Center_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Wall/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Wall/Bottom_CenterL",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Wall/Door", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x04)));
		m.put("Tree/Ordinary/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x00), new Byte(
		(byte) 0x05)));
		m.put("Tree/Ordinary/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x01), new Byte(
		(byte) 0x05)));
		m.put("Tree/Shadow/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x05)));
		m.put("Tree/Shadow/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x05)));
		m.put("Hause/Roof/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x05)));
		m.put("Hause/Roof/Bottom_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x05)));
		m.put("Hause/Roof/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x05)));
		m.put("Hause/Window/Big_Left_Door",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x05)));
		m.put("Hause/Window/Big_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x05)));
		m.put("Hause/Window/Big_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x05)));
		m.put("Pokemon_Center/Roof/Bottom1",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x05)));
		m.put("Pokemon_Center/Roof/Bottom2",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x05)));
		m.put("Shop/Roof/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x05)));
		m.put("Shop/Roof/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x05)));
		m.put("Shop/Roof/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x05)));
		m.put("Lab/Roof/Top/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x06)));
		m.put("Lab/Roof/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x06)));
		m.put("Lab/Roof/Top/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x06)));
		m.put("Lab/Roof/Top/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x06)));
		m.put("Lab/Roof/Top/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x06)));
		m.put("Hause/Door", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x07), new Byte((byte) 0x06)));
		m.put("Hause/Window/Small_Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x06)));
		m.put("Hause/Window/Big_Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x06)));
		m.put("Pokemon_Center/Roof/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x06)));
		m.put("Pokemon_Center/Roof/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x06)));
		m.put("Shop/Roof/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x06)));
		m.put("Shop/Roof/Center_CenterR", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x06)));
		m.put("Shop/Roof/Center_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x06)));
		m.put("Lab/Roof/Center/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x07)));
		m.put("Lab/Roof/Center/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x07)));
		m.put("Lab/Roof/Center/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x07)));
		m.put("Lab/Roof/Center/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x07)));
		m.put("Lab/Roof/Center/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x07)));
		m.put("Lab/Wall/Top/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x07)));
		m.put("Lab/Wall/Top/DoubleW_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x07)));
		m.put("Lab/Wall/Top/Window_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x07)));
		m.put("Lab/Wall/Top/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x07)));
		m.put("Lab/Wall/Top/Window_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x07)));
		m.put("Lab/Wall/Top/DoubleW_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x07)));
		m.put("Lab/Wall/Top/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x07)));
		m.put("Shop/Roof/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x07)));
		m.put("Shop/Roof/CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x07)));
		m.put("Shop/Roof/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x07)));
		m.put("Lab/Roof/Bottom/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x08)));
		m.put("Lab/Roof/Bottom_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x08)));
		m.put("Lab/Roof/Bottom/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x08)));
		m.put("Lab/Roof/Bottom/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x08)));
		m.put("Lab/Roof/Bottom/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x08)));
		m.put("Lab/Wall/Bottom/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x08)));
		m.put("Lab/Wall/Bottom/DoubleW_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x08)));
		m.put("Lab/Wall/Bottom/Window_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x08)));
		m.put("Lab/Wall/Bottom/Door", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x08)));
		m.put("Lab/Wall/Bottom/Window_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x08)));
		m.put("Lab/Wall/Bottom/DoubleW_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x08)));
		m.put("Lab/Wall/Bottom/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x08)));

		try
		{
			final ObjectOutputStream os = new ObjectOutputStream(
			new FileOutputStream("sprites/sprite.dspr"));
			os.writeObject(m);
			os.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}