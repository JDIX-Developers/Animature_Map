package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Razican (Iban Eguia)
 */
public class Lang {

	private static Vector<Locale>	locales;
	private static Lang				currentLang;
	private Locale					locale;
	private HashMap<String, String>	lines;

	private Lang()
	{
		if (locales.contains(Preferences.getLocale()))
		{
			this.locale = Preferences.getLocale();
		}
		else
		{
			this.locale = getDefaultLocale();
		}

		loadLines();
	}

	@SuppressWarnings ("unchecked")
	private void loadLines()
	{
		ObjectInputStream st = null;

		try
		{
			st = new ObjectInputStream(new FileInputStream("lang/"
			+ locale.getLanguage() + "_" + locale.getCountry() + ".lang"));

			lines = (HashMap<String, String>) st.readObject();

			st.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error loading language file: "
			+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,
			new ImageIcon("img/error.png"));
		}
	}

	private HashMap<String, String> getLines()
	{
		return lines;
	}

	@SuppressWarnings ("unchecked")
	private void changeLocale(Locale newLocale)
	{
		HashMap<String, String> newHM = null;
		ObjectInputStream st;

		try
		{
			st = new ObjectInputStream(new FileInputStream("lang/"
			+ newLocale.getLanguage() + "_" + newLocale.getCountry() + ".lang"));
			newHM = (HashMap<String, String>) st.readObject();
			st.close();
		}
		catch (IOException | ClassNotFoundException e1)
		{
			System.err.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "Error loading language file: "
			+ e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE,
			new ImageIcon("img/error.png"));
		}

		for (Map.Entry<String, String> e: lines.entrySet())
		{
			e.getValue().replace(e.getValue(), newHM.get(e.getKey()));
		}
	}

	private static void initializeLocales()
	{
		locales = new Vector<>();
		for (File file: (new File("lang").listFiles()))
		{
			if (file.getName().matches("[a-z]{2}_[A-Z]{2}.lang"))
			{
				String lang = file.getName().substring(0, 2);
				String country = file.getName().substring(3, 5);
				locales.add(new Locale(lang, country));
			}
		}
	}

	/**
	 * @param key Key for the line
	 * @return String for the current language
	 */
	public static String getLine(String key)
	{
		if (locales == null)
		{
			initializeLocales();
		}
		if (currentLang == null)
		{
			currentLang = new Lang();
		}
		return currentLang.getLines().get(key);
	}

	/**
	 * @return Currently available locales
	 */
	public static Vector<Locale> getAvailableLocales()
	{
		if (locales == null)
		{
			initializeLocales();
		}
		if (currentLang == null)
		{
			currentLang = new Lang();
		}
		return locales;
	}

	/**
	 * @return Currently available locales
	 */
	public static Vector<String> getCombableLocales()
	{
		if (locales == null)
		{
			initializeLocales();
		}
		if (currentLang == null)
		{
			currentLang = new Lang();
		}

		Vector<String> combo = new Vector<>(locales.size());

		for (Locale l: locales)
		{
			combo.add(StringUtils.firstToUpper(l.getDisplayLanguage()) + " ("
			+ l.getDisplayCountry() + ")");
		}

		return combo;
	}

	/**
	 * @return Default locale for the program
	 */
	public static Locale getDefaultLocale()
	{
		if (locales == null)
		{
			initializeLocales();
		}
		if (currentLang == null)
		{
			currentLang = new Lang();
		}

		return locales.contains(new Locale("es", "ES")) ? new Locale("es", "ES")
		: locales.get(0);
	}

	/**
	 * @param newLocale New locale for the interface
	 */
	public static void setLang(Locale newLocale)
	{
		if (locales == null)
		{
			initializeLocales();
		}
		if (currentLang == null)
		{
			currentLang = new Lang();
		}

		currentLang.changeLocale(newLocale);
	}
}
