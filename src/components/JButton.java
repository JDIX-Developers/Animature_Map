package components;

import javax.swing.Action;
import javax.swing.Icon;

/**
 * @author Razican (Iban Eguia)
 */
public class JButton extends javax.swing.JButton implements Internationalizable {

	private static final long	serialVersionUID	= -2868342852969455388L;

	/**
	 * Creates a button
	 */
	public JButton()
	{
		super();
	}

	/**
	 * @param a Action of the button
	 */
	public JButton(Action a)
	{
		super(a);
	}

	/**
	 * @param icon Icon for the button
	 */
	public JButton(Icon icon)
	{
		super(icon);
	}

	/**
	 * @param text Text for the button
	 * @param icon Image for the button
	 */
	public JButton(String text, Icon icon)
	{
		super(text, icon);
	}

	/**
	 * @param text Text for the button
	 */
	public JButton(String text)
	{
		super(text);
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}