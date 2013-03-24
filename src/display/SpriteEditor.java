package display;

import javax.swing.JPanel;

/**
 * @author Razican (Iban Eguia)
 */
public class SpriteEditor extends JPanel {

	private static final long	serialVersionUID	= 3039366230827667100L;
	private boolean				isSaved;

	/**
	 * Create the panel.
	 */
	public SpriteEditor()
	{
		this.isSaved = true;
		// TODO Create the editor
	}

	/**
	 * @return Whether the actual map has been saved or not
	 */
	public boolean isSaved()
	{
		return this.isSaved;
	}
}