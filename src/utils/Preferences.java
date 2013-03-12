package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;

/**
 * @author Razican (Iban Eguia)
 */
public class Preferences {

	private static Preferences	preferences;

	private Locale				locale;

	private Preferences(Locale l)
	{
		locale = l;
	}

	private static void init()
	{
		ObjectInputStream oos;
		try
		{
			oos = new ObjectInputStream(new FileInputStream("config.pref"));
			preferences = (Preferences) oos.readObject();
			oos.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			preferences = new Preferences(Locale.getDefault());
		}
	}

	/**
	 * @return Current locale
	 */
	public static Locale getLocale()
	{
		if (preferences == null)
		{
			init();
		}

		return preferences.locale;
	}

	/**
	 * @param l Locale to set as default
	 */
	public static void setLocale(Locale l)
	{
		if (preferences == null)
		{
			init();
		}

		if (Lang.getAvailableLocales().contains(l))
		{
			preferences.locale = l;
		}
		else
		{
			preferences.locale = Lang.getDefaultLocale();
		}
	}
}