package display;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
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
				Window.getInstance().getGlassPane().setVisible(true);
				Preferences p = new Preferences();

				String[] options = {Lang.getLine("conf_dialog_ok"),
				Lang.getLine("conf_dialog_cancel")};
				JOptionPane pane = new JOptionPane(p,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null,
				options, options[1]);
				JDialog dialog = pane.createDialog(Lang.getLine("preferences"));
				dialog.setSize(500, 500);
				dialog.setLocationRelativeTo(Window.getInstance());
				dialog.setVisible(true);

				int option = 0;

				for (int i = 0; i < options.length; i++)
				{
					if (options[i] == pane.getValue())
					{
						option = i;
						break;
					}
				}

				if (option == 0)
				{
					utils.Preferences.setLocale(Lang.getAvailableLocales().get(
					p.getLocaleIndex()));

					Lang.setLang(Lang.getAvailableLocales().get(
					p.getLocaleIndex()));

					// Window.getInstance().repaint();
				}

				Window.getInstance().getGlassPane().setVisible(false);
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