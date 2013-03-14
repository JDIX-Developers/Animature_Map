package components;

import javax.swing.Action;
import javax.swing.Icon;

/**
 * @author Razican (Iban Eguia)
 */
public class JMenuItem extends javax.swing.JMenuItem implements
Internationalizable {

	private static final long	serialVersionUID	= -848809240504931272L;

	/**
	 * Creates a JMenuItem with no set text or icon.
	 */
	public JMenuItem()
	{
		super();
	}

	/**
	 * Creates a JMenuItem with the specified text.
	 * 
	 * @param text - the text of the JMenuItem
	 */
	public JMenuItem(String text)
	{
		super(text);
	}

	/**
	 * Creates a JMenuItem with the specified icon.
	 * 
	 * @param icon - the icon of the JMenuItem
	 */
	public JMenuItem(Icon icon)
	{
		super(icon);
	}

	/**
	 * Creates a menu item whose properties are taken from the specified Action.
	 * 
	 * @param a - the action of the JMenuItem
	 */
	public JMenuItem(Action a)
	{
		super(a);
	}

	/**
	 * Creates a JMenuItem with the specified text and icon.
	 * 
	 * @param text - the text of the JMenuItem
	 * @param icon - the icon of the JMenuItem
	 */
	public JMenuItem(String text, Icon icon)
	{
		super(text, icon);
		// TODO Apéndice de constructor generado automáticamente
	}

	/**
	 * Creates a JMenuItem with the specified text and keyboard mnemonic.
	 * 
	 * @param text - the text of the JMenuItem
	 * @param mnemonic - the keyboard mnemonic for the JMenuItem
	 */
	public JMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
		// TODO Apéndice de constructor generado automáticamente
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}