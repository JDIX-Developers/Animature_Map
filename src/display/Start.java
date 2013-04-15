package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import components.ILabel;
import components.Window;

/**
 * @author Razican (Iban Eguia)
 */
public class Start extends JPanel {

	private static final long	serialVersionUID	= - 6969744533822338215L;
	private MapEditor			mapEditor;

	/**
	 * Create the panel.
	 */
	public Start()
	{
		setLayout(new BorderLayout(0, 0));

		mapEditor = new MapEditor();
		add(mapEditor, BorderLayout.CENTER);

		ILabel copyLabel = new ILabel("JDIX Developers");
		copyLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		copyLabel.setForeground(Color.GRAY);
		copyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		copyLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		copyLabel.setBorder(new EmptyBorder(0, 0, 3, 7));
		add(copyLabel, BorderLayout.SOUTH);
	}

	/**
	 * @return The current map editor
	 */
	public MapEditor getMapEditor()
	{
		return this.mapEditor;
	}

	/**
	 * Set a new map editor
	 * 
	 * @param m - The new MapEditor
	 */
	public void setMapEditor(MapEditor m)
	{
		remove(mapEditor);
		this.mapEditor = m;
		add(mapEditor, BorderLayout.CENTER);
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