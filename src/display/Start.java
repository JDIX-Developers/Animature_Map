package display;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import utils.Lang;

/**
 * @author Razican (Iban Eguia)
 */
public class Start extends JPanel {

	private static final long	serialVersionUID	= -6969744533822338215L;

	/**
	 * Create the panel.
	 */
	public Start()
	{
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		add(tabs, BorderLayout.CENTER);

		tabs.addTab(Lang.getLine("map_editor"), new MapEditor());
		tabs.addTab(Lang.getLine("sprite_editor"), new SpriteEditor());
	}

	/**
	 * @param args Arguments for the program
	 */
	public static void main(String[] args)
	{
		Window.getInstance().setContentPane(new Start());
		Window.getInstance().setSize(800, 600);
		Window.getInstance().setLocationRelativeTo(null);
		Window.getInstance().setJMenuBar(new Menu());
		Window.getInstance().setVisible(true);

	}
}