package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Razican (Iban Eguia)
 */
public class SpriteCreator {

	private static final byte	NONWALKABLE		= 0;
	private static final byte	WALKABLE		= 1;
	private static final byte	CHANGEABLE		= 2;
	private static final byte	JUMPABLE		= 4;
	private static final byte	TRANSPORTABLE	= 8;
	private static final byte	READABLE		= 16;
	private static final byte	GRASSANIM		= 32;

	/**
	 * @param args Arguments for the application
	 */
	public static void main(final String[] args)
	{
		final byte[] arr128 = {0x00, (byte) 0x80, 0x00, 0x00,
		CHANGEABLE | WALKABLE, 0x01, 0x00, WALKABLE, 0x02, 0x00, WALKABLE,
		0x03, 0x00, WALKABLE, 0x04, 0x00, WALKABLE, 0x05, 0x00, WALKABLE, 0x06,
		0x00, WALKABLE, 0x07, 0x00, NONWALKABLE, 0x08, 0x00, NONWALKABLE, 0x09,
		0x00, NONWALKABLE, 0x0A, 0x00, NONWALKABLE, 0x0B, 0x00, NONWALKABLE,

		0x00, 0x01, WALKABLE, 0x01, 0x01, WALKABLE, 0x02, 0x01, WALKABLE, 0x03,
		0x01, WALKABLE, 0x04, 0x01, WALKABLE, 0x05, 0x01, WALKABLE, 0x06, 0x01,
		NONWALKABLE, 0x07, 0x01, NONWALKABLE, 0x08, 0x01, NONWALKABLE, 0x09,
		0x01, NONWALKABLE, 0x0A, 0x01, NONWALKABLE, 0x0B, 0x01, NONWALKABLE,
		0x0C, 0x01, NONWALKABLE, 0x0D, 0x01, NONWALKABLE, 0x0E, 0x01,
		NONWALKABLE,

		0x00, 0x02, WALKABLE, 0x01, 0x02, WALKABLE, 0x02, 0x02, WALKABLE, 0x03,
		0x02, WALKABLE, 0x04, 0x02, WALKABLE, 0x05, 0x02, WALKABLE, 0x06, 0x02,
		NONWALKABLE, 0x07, 0x02, NONWALKABLE, 0x08, 0x02,
		NONWALKABLE | READABLE, 0x09, 0x02, NONWALKABLE | READABLE, 0x0A, 0x02,
		NONWALKABLE, 0x0B, 0x02, NONWALKABLE, 0x0C, 0x02, NONWALKABLE, 0x0D,
		0x02, NONWALKABLE, 0x0E, 0x02, TRANSPORTABLE,

		0x00, 0x03, NONWALKABLE, 0x01, 0x03, NONWALKABLE, 0x02, 0x03,
		NONWALKABLE, 0x03, 0x03, NONWALKABLE, 0x04, 0x03, NONWALKABLE, 0x05,
		0x03, NONWALKABLE, 0x06, 0x03, NONWALKABLE, 0x07, 0x03, NONWALKABLE,
		0x08, 0x03, NONWALKABLE, 0x09, 0x03, NONWALKABLE, 0x0A, 0x03,
		NONWALKABLE, 0x0B, 0x03, NONWALKABLE, 0x0C, 0x03, NONWALKABLE, 0x0D,
		0x03, NONWALKABLE, 0x0E, 0x03, NONWALKABLE,

		0x00, 0x04, NONWALKABLE, 0x01, 0x04, NONWALKABLE, 0x02, 0x04,
		NONWALKABLE, 0x03, 0x04, NONWALKABLE, 0x04, 0x04, NONWALKABLE, 0x05,
		0x04, NONWALKABLE, 0x06, 0x04, NONWALKABLE, 0x07, 0x04, NONWALKABLE,
		0x08, 0x04, NONWALKABLE, 0x09, 0x04, NONWALKABLE, 0x0A, 0x04,
		NONWALKABLE, 0x0B, 0x04, NONWALKABLE, 0x0C, 0x04, NONWALKABLE, 0x0D,
		0x04, NONWALKABLE, 0x0E, 0x04, TRANSPORTABLE,

		0x00, 0x05, NONWALKABLE, 0x01, 0x05, NONWALKABLE, 0x02, 0x05,
		NONWALKABLE, 0x03, 0x05, NONWALKABLE, 0x04, 0x05, NONWALKABLE, 0x05,
		0x05, NONWALKABLE, 0x06, 0x05, NONWALKABLE, 0x07, 0x05, NONWALKABLE,
		0x08, 0x05, NONWALKABLE, 0x09, 0x05, NONWALKABLE, 0x0A, 0x05,
		NONWALKABLE, 0x0B, 0x05, NONWALKABLE, 0x0C, 0x05, NONWALKABLE, 0x0D,
		0x05, NONWALKABLE, 0x0E, 0x05, NONWALKABLE,

		0x00, 0x06, NONWALKABLE, 0x01, 0x06, NONWALKABLE, 0x02, 0x06,
		NONWALKABLE, 0x03, 0x06, NONWALKABLE, 0x04, 0x06, NONWALKABLE, 0x05,
		0x06, WALKABLE, 0x06, 0x06, WALKABLE, 0x07, 0x06, TRANSPORTABLE, 0x08,
		0x06, NONWALKABLE, 0x09, 0x06, NONWALKABLE, 0x0A, 0x06, NONWALKABLE,
		0x0B, 0x06, NONWALKABLE, 0x0C, 0x06, NONWALKABLE, 0x0D, 0x06,
		NONWALKABLE, 0x0E, 0x06, NONWALKABLE,

		0x00, 0x07, NONWALKABLE, 0x01, 0x07, NONWALKABLE, 0x02, 0x07,
		NONWALKABLE, 0x03, 0x07, NONWALKABLE, 0x04, 0x07, NONWALKABLE, 0x05,
		0x07, NONWALKABLE, 0x06, 0x07, NONWALKABLE, 0x07, 0x07, NONWALKABLE,
		0x08, 0x07, NONWALKABLE, 0x09, 0x07, NONWALKABLE, 0x0A, 0x07,
		NONWALKABLE, 0x0B, 0x07, NONWALKABLE, 0x0C, 0x07, NONWALKABLE, 0x0D,
		0x07, NONWALKABLE, 0x0E, 0x07, NONWALKABLE,

		0x00, 0x08, NONWALKABLE, 0x01, 0x08, NONWALKABLE, 0x02, 0x08,
		NONWALKABLE, 0x03, 0x08, NONWALKABLE, 0x04, 0x08, NONWALKABLE, 0x05,
		0x08, NONWALKABLE, 0x06, 0x08, NONWALKABLE, 0x07, 0x08, NONWALKABLE,
		0x08, 0x08, TRANSPORTABLE, 0x09, 0x08, NONWALKABLE, 0x0A, 0x08,
		NONWALKABLE, 0x0B, 0x08, NONWALKABLE, 0x0D, 0x08, NONWALKABLE, 0x0E,
		0x08, NONWALKABLE,

		0x00, 0x09, WALKABLE, 0x01, 0x09, NONWALKABLE, 0x02, 0x09, WALKABLE,
		0x03, 0x09, WALKABLE, 0x04, 0x09, WALKABLE, 0x05, 0x09, NONWALKABLE,
		0x06, 0x09, WALKABLE, 0x07, 0x09, WALKABLE, 0x08, 0x09, WALKABLE, 0x09,
		0x09, NONWALKABLE, 0x0A, 0x09, NONWALKABLE, 0x0B, 0x09, NONWALKABLE,
		0x0D, 0x09, NONWALKABLE, 0x0E, 0x09, NONWALKABLE,

		0x00, 0x0A, WALKABLE, 0x01, 0x0A, NONWALKABLE, 0x02, 0x0A, NONWALKABLE,
		0x03, 0x0A, WALKABLE | TRANSPORTABLE, 0x04, 0x0A, NONWALKABLE, 0x05,
		0x0A, NONWALKABLE, 0x06, 0x0A, WALKABLE, 0x07, 0x0A, WALKABLE, 0x08,
		0x0A, WALKABLE, 0x09, 0x0A, NONWALKABLE, 0x0A, 0x0A, NONWALKABLE, 0x0B,
		0x0A, NONWALKABLE, 0x0D, 0x0A, NONWALKABLE, 0x0E, 0x0A, NONWALKABLE,

		0x00, 0x0B, NONWALKABLE, 0x01, 0x0B, NONWALKABLE, 0x02, 0x0B,
		NONWALKABLE, 0x03, 0x0B, NONWALKABLE, 0x04, 0x0B, NONWALKABLE, 0x05,
		0x0B, WALKABLE, 0x06, 0x0B, WALKABLE, 0x07, 0x0B, WALKABLE, 0x08, 0x0B,
		WALKABLE, 0x09, 0x0B, NONWALKABLE, 0x0A, 0x0B, NONWALKABLE,

		0x00, 0x0C, NONWALKABLE, 0x01, 0x0C, NONWALKABLE, 0x02, 0x0C,
		NONWALKABLE, 0x03, 0x0C, NONWALKABLE, 0x04, 0x0C, NONWALKABLE, 0x05,
		0x0C, WALKABLE, 0x09, 0x0C, WALKABLE | TRANSPORTABLE, 0x0A, 0x0C,
		NONWALKABLE,

		0x01, 0x0D, NONWALKABLE, 0x09, 0x0D, NONWALKABLE, 0x0A, 0x0D,
		NONWALKABLE,

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

		final HashMap<String, Entry<Byte, Byte>> m = new HashMap<>();

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
		m.put("House/Outdoor/Roof/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x04), new Byte(
		(byte) 0x03)));
		m.put("House/Outdoor/Roof/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x05), new Byte(
		(byte) 0x03)));
		m.put("House/Outdoor/Roof/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x03)));
		m.put("House/Outdoor/Wall/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x03)));
		m.put("House/Outdoor/Wall/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x03)));
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
		m.put("House/Outdoor/Roof/Center_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x04)));
		m.put("House/Outdoor/Wall/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x04)));
		m.put("House/Outdoor/Wall/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x04)));
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
		m.put("House/Outdoor/Roof/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x04), new Byte(
		(byte) 0x05)));
		m.put("House/Outdoor/Roof/Bottom_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x05), new Byte(
		(byte) 0x05)));
		m.put("House/Outdoor/Roof/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x05)));
		m.put("House/Outdoor/Window/Big_Left_Door",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x05)));
		m.put("House/Outdoor/Window/Big_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x05)));
		m.put("House/Outdoor/Window/Big_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x05)));
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
		m.put("House/Indoor/Chair_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x06)));
		m.put("House/Indoor/Chair_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x06)));
		m.put("House/Outdoor/Door", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x06)));
		m.put("House/Outdoor/Window/Small_Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x06)));
		m.put("House/Outdoor/Window/Big_Bottom_Right",
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
		m.put("House/Indoor/Wardrobe/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x08)));
		m.put("House/Indoor/Wardrobe/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
		(byte) 0x08)));

		m.put("House/Indoor/Floor_Shadow",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x00), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Plant/Shadow_Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x01), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Door/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Door/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Door/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x04), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Plant/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x09)));
		m.put("House/Indoor/Carpet/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Carpet/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x09)));
		m.put("House/Indoor/Carpet/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Table/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Table/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Sink/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Sink/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Wardrobe/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x09)));
		m.put("House/Indoor/Wardrobe/Center_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
		(byte) 0x09)));

		m.put("House/Indoor/Floor", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0A)));
		m.put("House/Indoor/Plant/Shadow_Bottom",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x01), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Door/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Door/Bottom_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Door/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x04), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Plant/Bottom",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x05), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Carpet/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x0A)));
		m.put("House/Indoor/Carpet/Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Carpet/Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Table/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Table/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Sink/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Sink/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Wardrobe/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x0A)));
		m.put("House/Indoor/Wardrobe/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
		(byte) 0x0A)));

		m.put("House/Indoor/Wall/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0B)));
		m.put("House/Indoor/TV/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0B)));
		m.put("House/Indoor/Window/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Window/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Picture/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x0B)));
		m.put("House/Indoor/Rug/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x0B)));
		m.put("House/Indoor/Carpet/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Carpet/Bottom",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Carpet/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Stairs/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0B)));
		m.put("House/Indoor/Stairs/Top_Rihgt",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0B)));

		m.put("House/Indoor/Wall/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0C)));
		m.put("House/Indoor/TV/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0C)));
		m.put("House/Indoor/Window/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x0C)));
		m.put("House/Indoor/Window/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x0C)));
		m.put("House/Indoor/Picture/Bottom_Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x04), new Byte(
		(byte) 0x0C)));
		m.put("House/Indoor/Rug/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x0C)));
		m.put("House/Indoor/Stairs/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0C)));
		m.put("House/Indoor/Stairs/Center_Rihgt",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0C)));

		m.put("House/Indoor/TV/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0D)));
		m.put("House/Indoor/Stairs/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0D)));
		m.put("House/Indoor/Stairs/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0D)));

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