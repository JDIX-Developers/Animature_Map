package display;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utils.Lang;

import components.JMenu;
import components.JMenuItem;

/**
 * @author Razican (Iban Eguia)
 */
public class Menu extends JMenuBar {

	private static final long	serialVersionUID	= -2674054941368737779L;

	private JMenu				file, edit, help;
	private JMenuItem			newMap, open, save, save_where;
	private JMenuItem			preferences;

	/**
	 * Create the menu.
	 */
	public Menu()
	{
		super();

		file = new JMenu();
		Lang.setLine(file, "menu_file");
		file.setMargin(new Insets(5, 5, 5, 5));

		edit = new JMenu();
		Lang.setLine(edit, "menu_edit");
		edit.setMargin(new Insets(5, 5, 5, 5));

		help = new JMenu();
		Lang.setLine(help, "menu_help");
		help.setMargin(new Insets(5, 5, 5, 5));
		help.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Create help menu
			}
		});

		newMap = new JMenuItem();
		Lang.setLine(newMap, "menu_new_map");
		newMap.setMargin(new Insets(5, 5, 5, 5));
		open = new JMenuItem();
		Lang.setLine(open, "menu_open...");
		open.setMargin(new Insets(5, 5, 5, 5));
		save = new JMenuItem();
		Lang.setLine(save, "menu_save");
		save.setMargin(new Insets(5, 5, 5, 5));
		save_where = new JMenuItem();
		Lang.setLine(save_where, "menu_save...");
		save_where.setMargin(new Insets(5, 5, 5, 5));

		preferences = new JMenuItem();
		Lang.setLine(preferences, "preferences");
		preferences.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				edit.updateUI();
				Window.getInstance().getGlassPane().setVisible(true);
				Preferences p = new Preferences();

				String[] options = {Lang.getLine("conf_dialog_ok"),
				Lang.getLine("conf_dialog_cancel")};
				JOptionPane pane = new JOptionPane(p,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null,
				options, options[1]);
				JDialog dialog = pane.createDialog(Lang.getLine("preferences"));
				dialog.setLocationRelativeTo(Window.getInstance());
				dialog.setVisible(true);

				if (pane.getValue() == options[0])
				{
					utils.Preferences.setLocale(Lang.getAvailableLocales().get(
					p.getLocaleIndex()));

					Lang.setLang(Lang.getAvailableLocales().get(
					p.getLocaleIndex()));

					Window.getInstance().repaint();
					((JPanel) Window.getInstance().getContentPane()).updateUI();
				}

				Window.getInstance().getGlassPane().setVisible(false);
			}
		});

		file.add(newMap);
		file.add(open);
		file.add(save);
		file.add(save_where);

		edit.add(preferences);

		add(file);
		add(edit);
		add(help);
	}
}