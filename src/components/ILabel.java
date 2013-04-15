package components;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @author Razican (Iban Eguia)
 */
public class ILabel extends JLabel implements Internationalizable {

	private static final long	serialVersionUID	= 774349398573896902L;

	/**
	 * Creates a label
	 */
	public ILabel()
	{
		super();
	}

	/**
	 * @param image Image for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public ILabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
	}

	/**
	 * @param image Image for the label
	 */
	public ILabel(Icon image)
	{
		super(image);
	}

	/**
	 * @param text Text for the label
	 * @param icon Icon for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public ILabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}

	/**
	 * @param text Text for the label
	 * @param horizontalAlignment Horizontal alignment
	 */
	public ILabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}

	/**
	 * @param text Text for the label
	 */
	public ILabel(String text)
	{
		super(text);
	}

	@Override
	public void changeLanguage(String newText)
	{
		setText(newText);
	}
}