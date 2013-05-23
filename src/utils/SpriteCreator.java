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
		//@formatter:off
		final byte[] arr128 = 
		{0x00, (byte) 0x80,

		0x00, 0x00, CHANGEABLE | WALKABLE | GRASSANIM,
		0x01, 0x00, WALKABLE,
		0x02, 0x00, WALKABLE,
		0x03, 0x00, WALKABLE,
		0x04, 0x00, WALKABLE,
		0x05, 0x00, WALKABLE,
		0x06, 0x00, WALKABLE,
		0x07, 0x00, NONWALKABLE,
		0x08, 0x00, NONWALKABLE,
		0x09, 0x00, NONWALKABLE,
		0x0A, 0x00, NONWALKABLE,
		0x0B, 0x00, NONWALKABLE,
		0x0C, 0x00, WALKABLE,
		0x0D, 0x00, WALKABLE,
		0x0E, 0x00, WALKABLE,
		0x0F, 0x00, WALKABLE,
		0x10, 0x00, WALKABLE,
		0x11, 0x00, NONWALKABLE,
		0x12, 0x00, NONWALKABLE,
		0x13, 0x00, NONWALKABLE,

		0x00, 0x01, WALKABLE,
		0x01, 0x01, WALKABLE,
		0x02, 0x01, WALKABLE,
		0x03, 0x01, WALKABLE,
		0x04, 0x01, WALKABLE,
		0x05, 0x01, WALKABLE,
		0x06, 0x01, NONWALKABLE,
		0x07, 0x01, NONWALKABLE,
		0x08, 0x01, NONWALKABLE,
		0x09, 0x01, NONWALKABLE,
		0x0A, 0x01, NONWALKABLE,
		0x0B, 0x01, NONWALKABLE,
		0x0C, 0x01, NONWALKABLE,
		0x0D, 0x01, NONWALKABLE,
		0x0E, 0x01, NONWALKABLE,
		0x0F, 0x01, WALKABLE,
		0x10, 0x01, NONWALKABLE,
		0x11, 0x01, NONWALKABLE,
		0x12, 0x01, NONWALKABLE,
		0x13, 0x01, NONWALKABLE,

		0x00, 0x02, WALKABLE,
		0x01, 0x02, WALKABLE,
		0x02, 0x02, WALKABLE,
		0x03, 0x02, WALKABLE,
		0x04, 0x02, WALKABLE,
		0x05, 0x02, WALKABLE,
		0x06, 0x02, NONWALKABLE,
		0x07, 0x02, NONWALKABLE,
		0x08, 0x02, NONWALKABLE | READABLE,
		0x09, 0x02, NONWALKABLE | READABLE,
		0x0A, 0x02, NONWALKABLE,
		0x0B, 0x02, NONWALKABLE,
		0x0C, 0x02, NONWALKABLE,
		0x0D, 0x02, NONWALKABLE,
		0x0E, 0x02, TRANSPORTABLE,
		0x0F, 0x02, NONWALKABLE,
		0x10, 0x02, NONWALKABLE,
		0x11, 0x02, NONWALKABLE,
		0x12, 0x02, NONWALKABLE,
		0x13, 0x02, NONWALKABLE,

		0x00, 0x03, NONWALKABLE,
		0x01, 0x03, NONWALKABLE,
		0x02, 0x03, NONWALKABLE,
		0x03, 0x03, NONWALKABLE,
		0x04, 0x03, NONWALKABLE,
		0x05, 0x03, NONWALKABLE,
		0x06, 0x03, NONWALKABLE,
		0x07, 0x03, NONWALKABLE,
		0x08, 0x03, NONWALKABLE,
		0x09, 0x03, NONWALKABLE,
		0x0A, 0x03, NONWALKABLE,
		0x0B, 0x03, NONWALKABLE,
		0x0C, 0x03, NONWALKABLE,
		0x0D, 0x03, NONWALKABLE,
		0x0E, 0x03, NONWALKABLE,
		0x0F, 0x03, NONWALKABLE,
		0x10, 0x03, NONWALKABLE,
		0x11, 0x03, NONWALKABLE,
		0x12, 0x03, NONWALKABLE,
		0x13, 0x03, NONWALKABLE,

		0x00, 0x04, NONWALKABLE,
		0x01, 0x04, NONWALKABLE,
		0x02, 0x04, NONWALKABLE,
		0x03, 0x04, NONWALKABLE,
		0x04, 0x04, NONWALKABLE,
		0x05, 0x04, NONWALKABLE,
		0x06, 0x04, NONWALKABLE,
		0x07, 0x04, NONWALKABLE,
		0x08, 0x04, NONWALKABLE,
		0x09, 0x04, NONWALKABLE,
		0x0A, 0x04, NONWALKABLE,
		0x0B, 0x04, NONWALKABLE,
		0x0C, 0x04, NONWALKABLE,
		0x0D, 0x04, NONWALKABLE,
		0x0E, 0x04, TRANSPORTABLE,
		0x0F, 0x04, NONWALKABLE,
		0x10, 0x04, NONWALKABLE,
		0x11, 0x04, NONWALKABLE,
		0x12, 0x04, NONWALKABLE,
		0x13, 0x04, NONWALKABLE,

		0x00, 0x05, NONWALKABLE,
		0x01, 0x05, NONWALKABLE,
		0x02, 0x05, NONWALKABLE,
		0x03, 0x05, NONWALKABLE,
		0x04, 0x05, NONWALKABLE,
		0x05, 0x05, NONWALKABLE,
		0x06, 0x05, NONWALKABLE,
		0x07, 0x05, NONWALKABLE,
		0x08, 0x05, NONWALKABLE,
		0x09, 0x05, NONWALKABLE,
		0x0A, 0x05, NONWALKABLE,
		0x0B, 0x05, NONWALKABLE,
		0x0C, 0x05, NONWALKABLE,
		0x0D, 0x05, NONWALKABLE,
		0x0E, 0x05, NONWALKABLE,
		0x0F, 0x05, NONWALKABLE,
		0x10, 0x05, NONWALKABLE,
		0x11, 0x05, NONWALKABLE,
		0x12, 0x05, NONWALKABLE,
		0x13, 0x05, NONWALKABLE,

		0x00, 0x06, NONWALKABLE,
		0x01, 0x06, NONWALKABLE,
		0x02, 0x06, NONWALKABLE,
		0x03, 0x06, NONWALKABLE,
		0x04, 0x06, NONWALKABLE,
		0x05, 0x06, WALKABLE,
		0x06, 0x06, WALKABLE,
		0x07, 0x06, TRANSPORTABLE,
		0x08, 0x06, NONWALKABLE,
		0x09, 0x06, NONWALKABLE,
		0x0A, 0x06, NONWALKABLE,
		0x0B, 0x06, NONWALKABLE,
		0x0C, 0x06, NONWALKABLE,
		0x0D, 0x06, NONWALKABLE,
		0x0E, 0x06, NONWALKABLE,
		0x0F, 0x06, NONWALKABLE,
		0x10, 0x06, NONWALKABLE,
		0x11, 0x06, NONWALKABLE,
		0x12, 0x06, NONWALKABLE,
		0x13, 0x06, NONWALKABLE,

		0x00, 0x07, NONWALKABLE,
		0x01, 0x07, NONWALKABLE,
		0x02, 0x07, NONWALKABLE,
		0x03, 0x07, NONWALKABLE,
		0x04, 0x07, NONWALKABLE,
		0x05, 0x07, NONWALKABLE,
		0x06, 0x07, NONWALKABLE,
		0x07, 0x07, NONWALKABLE,
		0x08, 0x07, NONWALKABLE,
		0x09, 0x07, NONWALKABLE,
		0x0A, 0x07, NONWALKABLE,
		0x0B, 0x07, NONWALKABLE,
		0x0C, 0x07, NONWALKABLE,
		0x0D, 0x07, NONWALKABLE,
		0x0E, 0x07, NONWALKABLE,

		0x00, 0x08, NONWALKABLE,
		0x01, 0x08, NONWALKABLE,
		0x02, 0x08, NONWALKABLE,
		0x03, 0x08, NONWALKABLE,
		0x04, 0x08, NONWALKABLE,
		0x05, 0x08, NONWALKABLE,
		0x06, 0x08, NONWALKABLE,
		0x07, 0x08, NONWALKABLE,
		0x08, 0x08, TRANSPORTABLE,
		0x09, 0x08, NONWALKABLE,
		0x0A, 0x08, NONWALKABLE,
		0x0B, 0x08, NONWALKABLE,
		0x0C, 0x08, NONWALKABLE,
		0x0D, 0x08, NONWALKABLE,
		0x0E, 0x08, NONWALKABLE,

		0x00, 0x09, WALKABLE,
		0x01, 0x09, NONWALKABLE,
		0x02, 0x09, WALKABLE,
		0x03, 0x09, WALKABLE,
		0x04, 0x09, WALKABLE,
		0x05, 0x09, NONWALKABLE,
		0x06, 0x09, WALKABLE,
		0x07, 0x09, WALKABLE,
		0x08, 0x09, WALKABLE,
		0x09, 0x09, NONWALKABLE,
		0x0A, 0x09, NONWALKABLE,
		0x0B, 0x09, NONWALKABLE,
		0x0D, 0x09, NONWALKABLE,
		0x0E, 0x09, NONWALKABLE,

		0x00, 0x0A, WALKABLE,
		0x01, 0x0A, NONWALKABLE,
		0x02, 0x0A, NONWALKABLE,
		0x03, 0x0A, WALKABLE | TRANSPORTABLE,
		0x04, 0x0A, NONWALKABLE,
		0x05, 0x0A, NONWALKABLE,
		0x06, 0x0A, WALKABLE,
		0x07, 0x0A, WALKABLE,
		0x08, 0x0A, WALKABLE,
		0x09, 0x0A, NONWALKABLE,
		0x0A, 0x0A, NONWALKABLE,
		0x0B, 0x0A, NONWALKABLE,
		0x0D, 0x0A, NONWALKABLE,
		0x0E, 0x0A, NONWALKABLE,

		0x00, 0x0B, NONWALKABLE,
		0x01, 0x0B, NONWALKABLE,
		0x02, 0x0B, NONWALKABLE,
		0x03, 0x0B, NONWALKABLE,
		0x04, 0x0B, NONWALKABLE,
		0x05, 0x0B, WALKABLE,
		0x06, 0x0B, WALKABLE,
		0x07, 0x0B, WALKABLE,
		0x08, 0x0B, WALKABLE,
		0x09, 0x0B, NONWALKABLE,
		0x0A, 0x0B, NONWALKABLE,
		0x0B, 0x0B, WALKABLE,
		0x0C, 0x0B, WALKABLE,
		0x0D, 0x0B, WALKABLE,
		0x0E, 0x0B, WALKABLE,

		0x00, 0x0C, NONWALKABLE,
		0x01, 0x0C, NONWALKABLE,
		0x02, 0x0C, NONWALKABLE,
		0x03, 0x0C, NONWALKABLE,
		0x04, 0x0C, NONWALKABLE,
		0x05, 0x0C, WALKABLE,
		0x06, 0x0C, NONWALKABLE,
		0x07, 0x0C, NONWALKABLE,
		0x08, 0x0C, NONWALKABLE,
		0x09, 0x0C, WALKABLE | TRANSPORTABLE,
		0x0A, 0x0C, NONWALKABLE,
		0x0B, 0x0C, WALKABLE,
		0x0C, 0x0C, NONWALKABLE,
		0x0D, 0x0C, NONWALKABLE,
		0x0E, 0x0C, NONWALKABLE,
		
		0x00, 0x0D, WALKABLE,
		0x01, 0x0D, NONWALKABLE,
		0x02, 0x0D, WALKABLE,
		0x03, 0x0D, WALKABLE,
		0x04, 0x0D, NONWALKABLE,
		0x05, 0x0D, NONWALKABLE,
		0x06, 0x0D, NONWALKABLE,
		0x07, 0x0D, NONWALKABLE,
		0x08, 0x0D, NONWALKABLE,
		0x09, 0x0D, NONWALKABLE,
		0x0A, 0x0D, NONWALKABLE,
		0x0B, 0x0D, NONWALKABLE,
		0x0C, 0x0D, NONWALKABLE,
		0x0D, 0x0D, NONWALKABLE,
		0x0E, 0x0D, NONWALKABLE,

		0x00, 0x0E, WALKABLE,
		0x01, 0x0E, WALKABLE,
		0x02, 0x0E, WALKABLE,
		0x03, 0x0E, WALKABLE,
		0x04, 0x0E, WALKABLE,
		0x05, 0x0E, NONWALKABLE,
		0x06, 0x0E, NONWALKABLE,
		0x07, 0x0E, NONWALKABLE,
		0x08, 0x0E, NONWALKABLE,
		0x09, 0x0E, WALKABLE,
		0x0A, 0x0E, WALKABLE,
		0x0B, 0x0E, WALKABLE,
		0x0C, 0x0E, NONWALKABLE,
		0x0D, 0x0E, WALKABLE,
		0x0E, 0x0E, WALKABLE,

		0x00, 0x0F, NONWALKABLE,
		0x01, 0x0F, NONWALKABLE,
		0x02, 0x0F, NONWALKABLE,
		0x03, 0x0F, NONWALKABLE,
		0x04, 0x0F, NONWALKABLE,
		0x05, 0x0F, WALKABLE,
		0x06, 0x0F, NONWALKABLE,
		0x07, 0x0F, NONWALKABLE,
		0x08, 0x0F, NONWALKABLE,
		0x09, 0x0F, WALKABLE,
		0x0A, 0x0F, WALKABLE,
		0x0B, 0x0F, WALKABLE,
		0x0C, 0x0F, WALKABLE,
		0x0D, 0x0F, WALKABLE,
		0x0E, 0x0F, WALKABLE,
		0x0F, 0x0F, WALKABLE,
		
		
		0x00, 0x10, NONWALKABLE,
		0x01, 0x10, NONWALKABLE,
		0x02, 0x10, NONWALKABLE,
		0x03, 0x10, NONWALKABLE,
		0x04, 0x10, NONWALKABLE | CHANGEABLE,
		0x05, 0x10, NONWALKABLE | CHANGEABLE,
		0x06, 0x10, NONWALKABLE,
		0x07, 0x10, NONWALKABLE,
		0x08, 0x10, NONWALKABLE,
		0x09, 0x10, NONWALKABLE,
		0x0A, 0x10, NONWALKABLE,
		0x0B, 0x10, NONWALKABLE,
		0x0C, 0x10, NONWALKABLE,
		0x0D, 0x10, NONWALKABLE,
		0x0E, 0x10, NONWALKABLE,
		
		
		0x00, 0x11, NONWALKABLE,
		0x01, 0x11, NONWALKABLE,
		0x02, 0x11, NONWALKABLE,
		0x03, 0x11, NONWALKABLE,
		0x04, 0x11, NONWALKABLE | CHANGEABLE,
		0x05, 0x11, NONWALKABLE | CHANGEABLE,
		0x06, 0x11, NONWALKABLE,
		0x07, 0x11, NONWALKABLE,
		0x08, 0x11, NONWALKABLE,
		0x09, 0x11, NONWALKABLE,
		0x0A, 0x11, NONWALKABLE,
		0x0B, 0x11, NONWALKABLE,
		0x0C, 0x11, NONWALKABLE,
		
		
		0x04, 0x12, NONWALKABLE,
		0x05, 0x12, NONWALKABLE,
		0x06, 0x12, NONWALKABLE,
		0x07, 0x11, WALKABLE,
		0x08, 0x11, WALKABLE,
		0x09, 0x11, NONWALKABLE,
		0x0A, 0x11, NONWALKABLE,
		0x0B, 0x11, NONWALKABLE,
		0x0C, 0x11, NONWALKABLE,
		
		0x04, 0x13, NONWALKABLE,
		0x05, 0x13, NONWALKABLE,
		0x06, 0x13, NONWALKABLE,
		0x07, 0x13, NONWALKABLE,
		0x08, 0x13, NONWALKABLE,
		0x09, 0x13, NONWALKABLE,
		0x0A, 0x13, NONWALKABLE,
		0x0B, 0x13, NONWALKABLE,
		0x0C, 0x13, NONWALKABLE,
		
		

		};
		//@formatter:on

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

		//@formatter:off
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
		m.put("Pokemon_Center/Outdoor/Wall/Top_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x00)));
		m.put("Pokemon_Center/Outdoor/Wall/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x00)));
		m.put("Fence/Corner/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x00)));
		m.put("Fence/Corner/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Floor/Shadow", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Floor/Floor", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Door/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Door/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0F), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Door/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x10), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Wardrobe/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x11), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Wardobe/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x12), new Byte((byte) 0x00)));
		m.put("Lab/Indoor/Wardobe/Left_Top_Shadow", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x13), new Byte((byte) 0x00)));
		
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
		m.put("Pokemon_Center/Outdoor/Wall/Bottom_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x08), new Byte(
		(byte) 0x01)));
		m.put("Pokemon_Center/Outdoor/Wall/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x01)));
		m.put("Fence/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0A), new Byte((byte) 0x01)));
		m.put("Fence/Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0B), new Byte((byte) 0x01)));
		m.put("Shop/Outdoor/Roof/Bottom_CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x01)));
		m.put("Shop/Outdoor/Roof/Bottom_CenterR", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x01)));
		m.put("Shop/Outdoor/Wall/Right", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0E), new Byte((byte) 0x01)));
		m.put("Lab/Indoor/Floor/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0F), new Byte((byte) 0x01)));
		m.put("Lab/Indoor/Plant/Top", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x010), new Byte((byte) 0x01)));
		m.put("Lab/Indoor/Wardrobe/Left_Center", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x11), new Byte((byte) 0x01)));
		m.put("Lab/Indoor/Wardrobe/Right_Cente", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x12), new Byte((byte) 0x01)));
		m.put("Lab/Indoor/Wardrobe/Left_Bottom_Shadow", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x13), new Byte((byte) 0x01)));
		
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
		m.put("Shop/Outdoor/Wall/Left", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0C), new Byte((byte) 0x02)));
		m.put("Shop/Outdoor/Wall/CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x02)));
		m.put("Shop/Outdoor/Wall/Door", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0E), new Byte((byte) 0x02)));
		m.put("Lab/Indoor/Plant/Top_Shadow", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x0F), new Byte((byte) 0x02)));
		m.put("Lab/Indoor/Plant/Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x10), new Byte((byte) 0x02)));
		m.put("Lab/Indoor/Wardrobe/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x11), new Byte((byte) 0x02)));
		m.put("Lab/Indoor/Wardrobe/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x12), new Byte((byte) 0x02)));
		m.put("Lab/Indoor/Others/Books", new SimpleImmutableEntry<Byte, Byte>(new Byte(
		(byte) 0x13), new Byte((byte) 0x02)));
		
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
		m.put("Pokemon_Center/Outdoor/Roof/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Outdoor/Roof/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Outdoor/Roof/Top_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Outdoor/Wall/Top_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Outdoor/Wall/Top_CenterR",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x03)));
		m.put("Pokemon_Center/Outdoor/Wall/Top_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
		(byte) 0x03)));
		m.put("Lab/Indoor/Plant/Bottom_Shadow",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0F), new Byte(
		(byte) 0x03)));
		m.put("Lab/Indoor/Wall/Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x10), new Byte(
		(byte) 0x03)));
		m.put("Lab/Indoor/Wall/Window_Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x11), new Byte(
		(byte) 0x03)));
		m.put("Lab/Indoor/Wall/Machine_Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x12), new Byte(
		(byte) 0x03)));
		m.put("Lab/Indoor/Wall/Board_Top",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x13), new Byte(
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
		m.put("House/Outdoor/Roof/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x04)));
		m.put("House/Outdoor/Roof/Center", new SimpleImmutableEntry<Byte, Byte>(
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
		m.put("Pokemon_Center/Outdoor/Roof/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Outdoor/Roof/Center_Center",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Outdoor/Roof/Center_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Outdoor/Wall/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Outdoor/Wall/Bottom_CenterL",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x04)));
		m.put("Pokemon_Center/Outdoor/Wall/Door", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x04)));
		m.put("Lab/Indoor/Wall/Table_PC", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0F), new Byte((byte) 0x04)));
		m.put("Lab/Indoor/Wall/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x10), new Byte((byte) 0x04)));
		m.put("Lab/Indoor/Wall/Window_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x11), new Byte((byte) 0x04)));
		m.put("Lab/Indoor/Wall/Machine_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x12), new Byte((byte) 0x04)));
		m.put("Lab/Indoor/Wall/Board_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x13), new Byte((byte) 0x04)));
		
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
		m.put("Pokemon_Center/Outdoor/Roof/Bottom1",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x05)));
		m.put("Pokemon_Center/Outdoor/Roof/Bottom2",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x05)));
		m.put("Shop/Outdoor/Roof/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x05)));
		m.put("Shop/Outdoor/Roof/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x05)));
		m.put("Shop/Outdoor/Roof/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x05)));
		m.put("Lab/Indoor/Wall/Table_Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0F), new Byte((byte) 0x05)));
		m.put("Lab/Indoor/Wall/Table_Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x10), new Byte((byte) 0x05)));
		m.put("Lab/Indoor/Table/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x11), new Byte((byte) 0x05)));
		m.put("Lab/Indoor/Table/Center_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x12), new Byte((byte) 0x05)));
		m.put("Lab/Indoor/Table/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x13), new Byte((byte) 0x05)));

		m.put("Lab/Outdoor/Roof/Top/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x06)));
		m.put("Lab/Outdoor/Roof/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x06)));
		m.put("Lab/Outdoor/Roof/Top/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x06)));
		m.put("Lab/Outdoor/Roof/Top/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x06)));
		m.put("Lab/Outdoor/Roof/Top/Right", new SimpleImmutableEntry<Byte, Byte>(
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
		m.put("Pokemon_Center/Outdoor/Roof/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x06)));
		m.put("Pokemon_Center/Outdoor/Roof/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x06)));
		m.put("Shop/Outdoor/Roof/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x06)));
		m.put("Shop/Outdoor/Roof/Center_CenterR", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x06)));
		m.put("Shop/Outdoor/Roof/Center_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x06)));
		m.put("Lab/Indoor/Wall/Table_Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0F), new Byte((byte) 0x06)));
		m.put("Lab/Indoor/Wall/Table_Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x10), new Byte((byte) 0x06)));
		m.put("Lab/Indoor/Table/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x11), new Byte((byte) 0x06)));
		m.put("Lab/Indoor/Table/Center_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x12), new Byte((byte) 0x06)));
		m.put("Lab/Indoor/Table/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x13), new Byte((byte) 0x06)));

		m.put("Lab/Outdoor/Roof/Center/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Roof/Center/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Roof/Center/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x07)));
		m.put("Lab/Outdoor/Roof/Center/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x07)));
		m.put("Lab/Outdoor/Roof/Center/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Wall/Top/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Wall/Top/DoubleW_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x07)));
		m.put("Lab/Wall/Top/Window_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Wall/Top/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Wall/Top/Window_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x07)));
		m.put("Lab/Wall/Top/DoubleW_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x07)));
		m.put("Lab/Outdoor/Wall/Top/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x07)));
		m.put("Shop/Outdoor/Roof/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x07)));
		m.put("Shop/Outdoor/Roof/CenterL", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x07)));
		m.put("Shop/Outdoor/Roof/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x07)));
		m.put("Lab/Outdoor/Roof/Bottom/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x08)));
		m.put("Lab/Outdoor/Roof/Bottom_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x08)));
		m.put("Lab/Outdoor/Roof/Bottom/Center_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x02), new Byte(
		(byte) 0x08)));
		m.put("Lab/Outdoor/Roof/Bottom/Right_Chimney",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x03), new Byte(
		(byte) 0x08)));
		m.put("Lab/Roof/Bottom/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/DoubleW_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x06), new Byte(
		(byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/Window_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x07), new Byte(
		(byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/Door", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/Window_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/DoubleW_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x08)));
		m.put("Lab/Outdoor/Wall/Bottom/Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x08)));
		m.put("Pokemon_Center/Indoor/Floor/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x08)));
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
		m.put("Pokemon_Center/Indoor/Floor/Floor",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0B), new Byte(
		(byte) 0x0B)));
		m.put("Pokemon_Center/Indoor/Floor/Floor2",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0C), new Byte(
		(byte) 0x0B)));
		m.put("Pokemon_Center/Indoor/Floor/Floor3",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0D), new Byte(
		(byte) 0x0B)));
		m.put("Pokemon_Center/Indoor/Floor/Floor4",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0E), new Byte(
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
		m.put("Pokemon_Center/Indoor/Wardrobe/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Wardrobe/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Wall/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x0C)));
		m.put("House/Indoor/Stairs/Center_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0C)));
		m.put("House/Indoor/Stairs/Center_Rihgt",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Floor/Floor5", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Wall/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Table/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x0C)));
		m.put("Pokemon_Center/Indoor/Table/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x0C)));

		m.put("Pokemon_Center/Indoor/Floor/Poke/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0D)));
		m.put("House/Indoor/TV/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Center_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Right_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Wall/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Wardrobe/Center_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Wardrobe/Center_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Wall/Left_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x0D)));
		m.put("House/Indoor/Stairs/Bottom_Left",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x09), new Byte(
		(byte) 0x0D)));
		m.put("House/Indoor/Stairs/Bottom_Right",
		new SimpleImmutableEntry<Byte, Byte>(new Byte((byte) 0x0A), new Byte(
		(byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Floor/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Wall/Right_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Table/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x0D)));
		m.put("Pokemon_Center/Indoor/Table/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x0D)));
		
		m.put("Pokemon_Center/Indoor/Floor/Poke/Left_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Center_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Right_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Floor/Poke/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Wall/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Wardrobe/Bottom_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Wardrobe/Bottom_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Wall/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Door/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Door/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Door/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Wall/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Cushion/Yellow", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x0E)));
		m.put("Pokemon_Center/Indoor/Cushion/Blue", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x0E)));
		
		m.put("Pokemon_Center/Indoor/Counter/Right_Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/TV/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/TV/Rightop", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/TV/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/TV/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/Floor/Floor1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x0F)));
		m.put("Pokemon_Center/Indoor/PC/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Wall/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Wall/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Floor/Shadow1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Floor/Shadow2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Floor/Shadow3", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Floor/Shadow4", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Door/Top_Left", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Door/Top_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x0F)));
		m.put("Shop/Indoor/Door/Top_Right", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0F), new Byte((byte) 0x0F)));
		
		m.put("Pokemon_Center/Indoor/Counter/Left_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/Counter/Top1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/Counter/Top2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/Counter/Right_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/Machine/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/Machine/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x10)));
		m.put("Pokemon_Center/Indoor/PC/Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Wall/Left_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Wall/Right_Center", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Wall/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Shelves/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Shelves/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Counter/Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Wall/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0D), new Byte((byte) 0x10)));
		m.put("Shop/Indoor/Floor/Head", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0E), new Byte((byte) 0x10)));
		
		m.put("Pokemon_Center/Indoor/Counter/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x00), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/Counter/Bottom1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x01), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/Counter/Bottom2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x02), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/Counter/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x03), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/Machine/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/Machine/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x11)));
		m.put("Pokemon_Center/Indoor/PC/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Wall/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Wall/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Wall/Fridge_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Shelves/Left_Center1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Shelves/Right_Center1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x11)));
		m.put("Shop/Indoor/Counter/Center1", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x11)));
		
		m.put("Shop/Indoor/Glass/Left_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Glass/Center_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Glass/Right_Top", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Floor/Shadow", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Floor/Floor", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Wall/Fridge_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Shelves/Left_Center2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Shelves/Right_Center2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x12)));
		m.put("Shop/Indoor/Counter/Center2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x12)));
		
		m.put("Shop/Indoor/Glass/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x04), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Glass/Center_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x05), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Glass/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x06), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Floor/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x07), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Floor/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x08), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Floor/Right_Bottom2", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x09), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Shelves/Left_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0A), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Shelves/Right_Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0B), new Byte((byte) 0x13)));
		m.put("Shop/Indoor/Counter/Bottom", new SimpleImmutableEntry<Byte, Byte>(
		new Byte((byte) 0x0C), new Byte((byte) 0x13)));
		
		
		//@formatter:on

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