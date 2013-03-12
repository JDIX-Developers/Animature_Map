package display;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import utils.Lang;

/**
 * @author Razican (Iban Eguia)
 */
public class Menu extends JMenuBar {

	private static final long	serialVersionUID	= -2674054941368737779L;

	private JMenu				file, edit;
	private JMenuItem			help;
	private JMenuItem			open, save, save_where;
	private JMenuItem			preferences;

	/**
	 * Create the menu.
	 */
	public Menu()
	{
		super();

		file = new JMenu(Lang.getLine("menu_file"));
		file.setMargin(new Insets(5, 5, 5, 5));

		edit = new JMenu(Lang.getLine("menu_edit"));
		edit.setMargin(new Insets(5, 5, 5, 5));

		help = new JMenuItem(Lang.getLine("menu_help"));
		help.setMargin(new Insets(5, 5, 5, 5));
		help.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Create help menu
			}
		});

		open = new JMenuItem(Lang.getLine("menu_open..."));
		open.setMargin(new Insets(5, 5, 5, 5));
		save = new JMenuItem(Lang.getLine("menu_save"));
		save.setMargin(new Insets(5, 5, 5, 5));
		save_where = new JMenuItem(Lang.getLine("menu_save..."));
		save_where.setMargin(new Insets(5, 5, 5, 5));

		preferences = new JMenuItem(Lang.getLine("preferences"));
		preferences.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showConfirmDialog(Window.getInstance()
				.getContentPane(), new Preferences(), Lang
				.getLine("preferences"), JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null);
			}
		});

		file.add(open);
		file.add(save);
		file.add(save_where);

		edit.add(preferences);

		add(file);
		add(edit);
		add(help);
	}
}