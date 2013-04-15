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
	private IButton				btnAddLink, btnEditLink, btnRemoveLink;
	private boolean				addingLink, editingLink, removingLink;

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

		btnEditLink = new IButton(new ImageIcon("img/edit-link-icon.png"));
		Lang.setLine(btnEditLink, "edit_link");
		btnEditLink.setFocusable(false);
		btnEditLink.addActionListener(this);

		btnRemoveLink = new IButton(new ImageIcon("img/remove-link-icon.png"));
		Lang.setLine(btnRemoveLink, "remove_link");
		btnRemoveLink.setFocusable(false);
		btnRemoveLink.addActionListener(this);

		add(btnAddLink);
		add(btnEditLink);
		add(btnRemoveLink);
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
	 * @return If the user is editing a link
	 */
	public boolean isEditingLink()
	{
		return this.editingLink;
	}

	/**
	 * @return If the user is removing a link
	 */
	public boolean isRemovingLink()
	{
		return this.removingLink;
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

	/**
	 * Called when a link is edited
	 */
	public void linkEdited()
	{
		this.editingLink = false;
		btnEditLink.setSelected(false);
		((MapEditor) getParent()).setMapCursor(Cursor.DEFAULT_CURSOR);
	}

	/**
	 * Called when a link is removed
	 */
	public void linkRemoved()
	{
		this.removingLink = false;
		btnRemoveLink.setSelected(false);
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
				btnEditLink.setSelected(false);
				btnRemoveLink.setSelected(false);
				((MapEditor) getParent()).setMapCursor(Cursor.CROSSHAIR_CURSOR);
			}
		}
		else if (e.getSource() == btnEditLink)
		{
			if (editingLink)
			{
				linkEdited();
			}
			else
			{
				editingLink = true;
				btnEditLink.setSelected(true);
				btnAddLink.setSelected(false);
				btnRemoveLink.setSelected(false);
				((MapEditor) getParent()).setMapCursor(Cursor.CROSSHAIR_CURSOR);
			}
		}
		else if (e.getSource() == btnRemoveLink)
		{
			if (removingLink)
			{
				linkRemoved();
			}
			else
			{
				removingLink = true;
				btnRemoveLink.setSelected(true);
				btnAddLink.setSelected(false);
				btnEditLink.setSelected(false);
				((MapEditor) getParent()).setMapCursor(Cursor.CROSSHAIR_CURSOR);
			}
		}
	}
}