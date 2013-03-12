package display;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utils.Lang;

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

		file = new JMenu(Lang.getLine("menu_file"));
		help = new JMenu(Lang.getLine("menu_help"));

		JMenuItem open = new JMenuItem(Lang.getLine("menu_open..."));
		JMenuItem save = new JMenuItem(Lang.getLine("menu_save"));
		JMenuItem save_where = new JMenuItem(Lang.getLine("menu_save..."));

		file.add(open);
		file.add(save);
		file.add(save_where);

		add(file);
		add(help);
	}
}