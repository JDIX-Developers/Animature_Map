package components;

import javax.swing.Action;
import javax.swing.JMenu;

/**
 * @author Razican (Iban Eguia)
 */
public class IMenu extends JMenu implements Internationalizable {

	private static final long	serialVersionUID	= - 3572785689393671429L;

	/**
	 * Creates the menu
	 */
	public IMenu()
	{
		super();
	}

	/**
	 * @param a Action for the menu
	 */
	public IMenu(Action a)
	{
		super(a);
	}

	/**
	 * @param s the text for the menu label
	 * @param b can the menu be torn off
	 */
	public IMenu(String s, boolean b)
	{
		super(s, b);
	}

	/**
	 * @param s the text for the menu label
	 */
	public IMenu(String s)
	{
		super(s);
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}