package components;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.Lang;
import display.Start;

/**
 * @author Razican (Iban Eguia)
 */
public class Window extends JFrame implements Internationalizable {

	private static final long	serialVersionUID	= - 8641413596663241575L;
	private static Window		instance;

	private Window()
	{
		super();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage((new ImageIcon("img/app-icon.png")).getImage());
		setSize(800, 600);
		Lang.setLine(this, "creator_title");
		setLocationRelativeTo(null);
		// setExtendedState(getExtendedState() | MAXIMIZED_BOTH);

		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(final WindowEvent winEvt)
			{
				if ( ! ((Start) Window.getInstance().getContentPane())
				.getMapEditor().isSaved())
				{
					final String[] options = {Lang.getLine("confirm_yes"),
					Lang.getLine("confirm_no")};
					final JOptionPane pane = new JOptionPane(
					Lang.getLine("close_mess_not_saved"),
					JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION,
					new ImageIcon("img/warning.png"), options, options[1]);
					final JDialog dialog = pane.createDialog(Lang
					.getLine("close_not_saved"));
					dialog.setLocationRelativeTo(Window.this);
					dialog.setVisible(true);

					if (pane.getValue() == options[0])
					{
						dispose();
					}
					dialog.dispose();
				}
				else
				{
					dispose();
				}
			}
		});
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

	@Override
	public void changeLanguage(final String newText)
	{
		setTitle(newText);
	}
}