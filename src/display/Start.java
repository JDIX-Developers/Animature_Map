package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import map.Map;
import map.Sprite;
import map.Square;
import utils.Lang;

import components.JLabel;
import components.JTabbedPane;

import exceptions.SpriteException;

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

		MapEditor mapEditor = new MapEditor();
		tabs.addTab(null, mapEditor);
		Lang.setLine(tabs.getTabAt(0), "map_editor");

		tabs.addTab(null, new SpriteEditor());
		Lang.setLine(tabs.getTabAt(1), "sprite_editor");

		JLabel copyLabel = new JLabel("JDIX Developers");
		copyLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		copyLabel.setForeground(Color.GRAY);
		copyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		copyLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		copyLabel.setBorder(new EmptyBorder(0, 0, 3, 7));
		add(copyLabel, BorderLayout.SOUTH);

		try
		{
			Square.setSprite(new Sprite(new File("sprites/test.png"),
			(short) 32));
			mapEditor.setMap(new Map(30, 20));
		}
		catch (SpriteException | IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), Lang
			.getLine("error"), JOptionPane.ERROR_MESSAGE, new ImageIcon(
			"img/error.png"));
		}
	}

	/**
	 * @param args Arguments for the program
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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