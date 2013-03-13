package display;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Razican (Iban Eguia)
 */
public class Window extends JFrame {

	private static final long	serialVersionUID	= -8641413596663241575L;
	private static Window		instance;

	private Window()
	{
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(null); // TODO set Animature World Icon
		setSize(800, 600);
		setLocationRelativeTo(null);
		setGlassPane(new GlassPane());
		// setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
	}

	/**
	 * @author Razican (Iban Eguia)
	 */
	private class GlassPane extends JPanel {

		private static final long	serialVersionUID	= -1090557698531749088L;

		private GlassPane()
		{
			super();
			setBackground(new Color(0, 0, 0, 50));
		}
	}

	/**
	 * @return Instance for the current Window
	 */
	public static Window getInstance()
	{
		if (instance == null)
		{
			instance = new Window();
		}

		return instance;
	}
}