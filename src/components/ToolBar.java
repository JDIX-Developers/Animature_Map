package components;

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import utils.Lang;
import display.MapEditor;

/**
 * @author Razican (Iban Eguia)
 */
public class ToolBar extends JToolBar implements ActionListener {

	private static final long	serialVersionUID	= - 8432386582582038108L;
	private IButton				btnAddLink;
	private boolean				addingLink;

	/**
	 * Creates the ToolBar
	 * 
	 * @param context - The context of the toolbar. It could be either a
	 *            MapEditor or a SpriteEditor
	 */
	public ToolBar(JPanel context)
	{
		super();
		setMargin(new Insets(0, 5, 0, 5));

		if (context instanceof MapEditor)
		{
			loadMapToolBar();
		}
		else
		{
			loadSpriteToolBar();
		}
	}

	private void loadMapToolBar()
	{
		addingLink = false;

		btnAddLink = new IButton(new ImageIcon("img/add-link-icon.png"));
		Lang.setLine(btnAddLink, "add_link");
		btnAddLink.setFocusable(false);
		btnAddLink.addActionListener(this);

		add(btnAddLink);

		// TODO
	}

	private void loadSpriteToolBar()
	{
		// TODO
	}

	/**
	 * @return If the user is adding a link
	 */
	public boolean isAddingLink()
	{
		return this.addingLink;
	}

	/**
	 * Called when the link is added
	 */
	public void linkAdded()
	{
		this.addingLink = false;
		btnAddLink.setSelected(false);
		((MapEditor) getParent()).setMapCursor(Cursor.DEFAULT_CURSOR);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnAddLink)
		{
			if (addingLink)
			{
				linkAdded();
			}
			else
			{
				addingLink = true;
				btnAddLink.setSelected(true);
				((MapEditor) getParent()).setMapCursor(Cursor.CROSSHAIR_CURSOR);
			}
		}
	}
}