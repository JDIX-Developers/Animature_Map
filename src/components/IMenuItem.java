package components;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

/**
 * @author Razican (Iban Eguia)
 */
public class IMenuItem extends JMenuItem implements Internationalizable {

	private static final long	serialVersionUID	= - 848809240504931272L;

	/**
	 * Creates a JMenuItem with no set text or icon.
	 */
	public IMenuItem()
	{
		super();
	}

	/**
	 * Creates a JMenuItem with the specified text.
	 * 
	 * @param text - the text of the JMenuItem
	 */
	public IMenuItem(final String text)
	{
		super(text);
	}

	/**
	 * Creates a JMenuItem with the specified icon.
	 * 
	 * @param icon - the icon of the JMenuItem
	 */
	public IMenuItem(final Icon icon)
	{
		super(icon);
	}

	/**
	 * Creates a menu item whose properties are taken from the specified Action.
	 * 
	 * @param a - the action of the JMenuItem
	 */
	public IMenuItem(final Action a)
	{
		super(a);
	}

	/**
	 * Creates a JMenuItem with the specified text and icon.
	 * 
	 * @param text - the text of the JMenuItem
	 * @param icon - the icon of the JMenuItem
	 */
	public IMenuItem(final String text, final Icon icon)
	{
		super(text, icon);
	}

	/**
	 * Creates a JMenuItem with the specified text and keyboard mnemonic.
	 * 
	 * @param text - the text of the JMenuItem
	 * @param mnemonic - the keyboard mnemonic for the JMenuItem
	 */
	public IMenuItem(final String text, final int mnemonic)
	{
		super(text, mnemonic);
	}

	@Override
	public void changeLanguage(final String newText)
	{
		setText(newText);
	}
}