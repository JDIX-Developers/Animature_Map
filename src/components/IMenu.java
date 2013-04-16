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
	public IMenu(final Action a)
	{
		super(a);
	}

	/**
	 * @param s the text for the menu label
	 * @param b can the menu be torn off
	 */
	public IMenu(final String s, final boolean b)
	{
		super(s, b);
	}

	/**
	 * @param s the text for the menu label
	 */
	public IMenu(final String s)
	{
		super(s);
	}

	@Override
	public void changeLanguage(final String newText)
	{
		setText(newText);
	}
}