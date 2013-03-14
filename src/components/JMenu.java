package components;

import javax.swing.Action;

/**
 * @author Razican (Iban Eguia)
 */
public class JMenu extends javax.swing.JMenu implements Internationalizable {

	private static final long	serialVersionUID	= -3572785689393671429L;

	/**
	 * Creates the menu
	 */
	public JMenu()
	{
		super();
	}

	/**
	 * @param a Action for the menu
	 */
	public JMenu(Action a)
	{
		super(a);
	}

	/**
	 * @param s the text for the menu label
	 * @param b can the menu be torn off
	 */
	public JMenu(String s, boolean b)
	{
		super(s, b);
	}

	/**
	 * @param s the text for the menu label
	 */
	public JMenu(String s)
	{
		super(s);
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}