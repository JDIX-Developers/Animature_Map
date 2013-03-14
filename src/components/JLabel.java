package components;

import javax.swing.Icon;

/**
 * @author Razican (Iban Eguia)
 */
public class JLabel extends javax.swing.JLabel implements Internationalizable {

	private static final long	serialVersionUID	= 774349398573896902L;

	/**
	 * Creates a label
	 */
	public JLabel()
	{
		super();
	}

	/**
	 * @param image Image for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public JLabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
	}

	/**
	 * @param image Image for the label
	 */
	public JLabel(Icon image)
	{
		super(image);
	}

	/**
	 * @param text Text for the label
	 * @param icon Icon for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public JLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}

	/**
	 * @param text Text for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public JLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}

	/**
	 * @param text Text for the label
	 */
	public JLabel(String text)
	{
		super(text);
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}