package display;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.Lang;

/**
 * @author Razican (Iban Eguia)
 */
public class Window extends JFrame {

	private static final long	serialVersionUID	= - 8641413596663241575L;
	private static Window		instance;

	private Window()
	{
		super();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage((new ImageIcon("img/app-icon.png")).getImage());
		setSize(800, 600);
		setTitle("Animature Map Creator");
		setLocationRelativeTo(null);
		// setExtendedState(getExtendedState() | MAXIMIZED_BOTH);

		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent winEvt)
			{
				if ( ! ((Start) Window.getInstance().getContentPane())
				.getMapEditor().isSaved())
				{
					String[] options = {Lang.getLine("confirm_yes"),
					Lang.getLine("confirm_no")};
					JOptionPane pane = new JOptionPane(
					Lang.getLine("close_mess_not_saved"),
					JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION,
					new ImageIcon("img/warning.png"), options, options[1]);
					JDialog dialog = pane.createDialog(Lang
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
}