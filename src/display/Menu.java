package display;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Razican (Iban Eguia)
 */
public class Menu extends JMenuBar {

	private static final long	serialVersionUID	= -2674054941368737779L;

	private JMenu				file, help;

	/**
	 * Create the menu.
	 */
	public Menu()
	{
		super();

		file = new JMenu("File");// Lang.getLine("menu_file"));
		help = new JMenu("Help");// Lang.getLine("menu_help"));

		JMenuItem open = new JMenuItem("Open...");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem save_where = new JMenuItem("Save...");

		file.add(open);
		file.add(save);
		file.add(save_where);

		add(file);
		add(help);
	}
}