package display;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Razican (Iban Eguia)
 */
public class Window extends JFrame {

	private static final long	serialVersionUID	= - 8641413596663241575L;
	private static Window		instance;

	private Window()
	{
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage((new ImageIcon("img/app-icon.png")).getImage());
		setSize(800, 600);
		setTitle("Animature Map Creator");
		setLocationRelativeTo(null);
		// setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
	}

	@Override
	public void pack()
	{
		super.pack();
		setSize(800, 600);
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