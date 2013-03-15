package display;

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import map.Square;
import utils.Lang;

import components.JMenu;
import components.JMenuItem;

/**
 * @author Razican (Iban Eguia)
 */
public class Menu extends JMenuBar implements ActionListener {

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
		file.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		file.setMargin(new Insets(5, 5, 5, 5));

		edit = new JMenu();
		Lang.setLine(edit, "menu_edit");
		edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		edit.setMargin(new Insets(5, 5, 5, 5));

		help = new JMenu();
		Lang.setLine(help, "menu_help");
		help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		help.setMargin(new Insets(5, 5, 5, 5));

		newMap = new JMenuItem();
		Lang.setLine(newMap, "menu_new_map");
		newMap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newMap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
		InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		newMap.setMargin(new Insets(5, 5, 5, 5));
		newMap.setActionCommand("new");
		newMap.addActionListener(this);

		open = new JMenuItem();
		Lang.setLine(open, "menu_open...");
		open.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
		InputEvent.CTRL_MASK));
		open.setMargin(new Insets(5, 5, 5, 5));

		save = new JMenuItem();
		Lang.setLine(save, "menu_save");
		save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
		InputEvent.CTRL_MASK));
		save.setMargin(new Insets(5, 5, 5, 5));

		save_where = new JMenuItem();
		Lang.setLine(save_where, "menu_save...");
		save_where.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		save_where.setMargin(new Insets(5, 5, 5, 5));

		preferences = new JMenuItem();
		Lang.setLine(preferences, "preferences");
		preferences.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "new":
				Window.getInstance().getGlassPane().setVisible(true);
				NewMap p = new NewMap();

				String[] options = {Lang.getLine("conf_dialog_ok"),
				Lang.getLine("conf_dialog_cancel")};
				JOptionPane pane = new JOptionPane(p,
				JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null,
				options, options[1]);
				JDialog dialog = pane.createDialog(Lang.getLine("new_map"));
				dialog.setLocationRelativeTo(Window.getInstance());
				dialog.setVisible(true);

				if (pane.getValue() == options[0])
				{
					if (p.getMap() == null)
					{
						// TODO error message
					}
					else if (p.getSprite() == null)
					{
						// TODO error message
					}
					else
					{
						MapEditor mapEditor = (MapEditor) ((Start) Window
						.getInstance().getContentPane()).getTabbedPane()
						.getComponentAt(0);
						Square.setSprite(p.getSprite());
						mapEditor.setMap(p.getMap());
					}
				}

				Window.getInstance().getGlassPane().setVisible(false);
			break;
		}
	}
}