package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Razican (Iban Eguia)
 */
public class Lang {

	private static ArrayList<Locale>	locales;
	private static Lang					currentLang;
	private Locale						locale;
	private HashMap<String, String>		lines;

	private Lang()
	{
		this(Locale.getDefault());
	}

	private Lang(Locale l)
	{
		if (locales.contains(l))
		{
			this.locale = l;
		}
		else
		{
			this.locale = locales.get(0);
		}

		loadLines();
	}

	@SuppressWarnings ("unchecked")
	private void loadLines()
	{
		ObjectInputStream st = null;

		try
		{
			st = new ObjectInputStream(
			new FileInputStream("lang/" + locale.getDisplayLanguage() + "_"
			+ locale.getCountry() + ".lang"));

			lines = (HashMap<String, String>) st.readObject();

			st.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error loading language file",
			"Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error.png"));
		}
	}

	private HashMap<String, String> getLines()
	{
		return lines;
	}

	private static void initializeLocales()
	{
		locales = new ArrayList<>(1);
		locales.add(new Locale("es", "ES"));
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
}
