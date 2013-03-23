package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import utils.Lang;

import components.ILabel;
import components.ITabbedPane;

/**
 * @author Razican (Iban Eguia)
 */
public class Start extends JPanel {

	private static final long	serialVersionUID	= -6969744533822338215L;
	private ITabbedPane			tabs;

	/**
	 * Create the panel.
	 */
	public Start()
	{
		setLayout(new BorderLayout(0, 0));

		tabs = new ITabbedPane(ITabbedPane.TOP);
		add(tabs, BorderLayout.CENTER);

		MapEditor mapEditor = new MapEditor();
		tabs.addTab(null, mapEditor);
		Lang.setLine(tabs.getTabAt(0), "map_editor");

		tabs.addTab(null, new SpriteEditor());
		Lang.setLine(tabs.getTabAt(1), "sprite_editor");

		ILabel copyLabel = new ILabel("JDIX Developers");
		copyLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		copyLabel.setForeground(Color.GRAY);
		copyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		copyLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		copyLabel.setBorder(new EmptyBorder(0, 0, 3, 7));
		add(copyLabel, BorderLayout.SOUTH);
	}

	/**
	 * @return Current tabbed pane of the view
	 */
	public ITabbedPane getTabbedPane()
	{
		return tabs;
	}

	/**
	 * @param args Arguments for the program
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(utils.Preferences.getLookAndFeel());
		}
		catch (ClassNotFoundException | InstantiationException
		| IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}

		Window.getInstance().setJMenuBar(new Menu());
		Window.getInstance().setContentPane(new Start());
		Window.getInstance().setVisible(true);
	}
}