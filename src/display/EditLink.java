package display;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import map.Link;
import utils.Lang;

import components.ILabel;

/**
 * @author Razican (Iban Eguia)
 */
public class EditLink extends JPanel implements KeyListener {

	private static final long	serialVersionUID	= 2813349405233711479L;
	private JTextField			mapField;
	private JTextField			xField;
	private JTextField			yField;

	/**
	 * Creates a new link
	 */
	public EditLink()
	{
		this(null);
	}

	/**
	 * @param l - The link to edit
	 */
	public EditLink(Link l)
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, 0.0, 1.0, 1.0,
		Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0, 0.0, 0.0, 0.0, 1.0,
		Double.MIN_VALUE};
		setLayout(gridBagLayout);

		ILabel lblMap = new ILabel();
		Lang.setLine(lblMap, "edit_link_map");
		GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.anchor = GridBagConstraints.WEST;
		gbc_lblMap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMap.gridx = 1;
		gbc_lblMap.gridy = 1;
		add(lblMap, gbc_lblMap);

		mapField = new JTextField();
		mapField.addKeyListener(this);
		GridBagConstraints gbc_mapField = new GridBagConstraints();
		gbc_mapField.insets = new Insets(0, 0, 5, 5);
		gbc_mapField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mapField.gridx = 2;
		gbc_mapField.gridy = 1;
		add(mapField, gbc_mapField);
		mapField.setColumns(10);

		ILabel lblXCoord = new ILabel();
		Lang.setLine(lblXCoord, "edit_link_x");
		GridBagConstraints gbc_lblXCoord = new GridBagConstraints();
		gbc_lblXCoord.anchor = GridBagConstraints.WEST;
		gbc_lblXCoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblXCoord.gridx = 1;
		gbc_lblXCoord.gridy = 2;
		add(lblXCoord, gbc_lblXCoord);

		xField = new JTextField();
		xField.addKeyListener(this);
		GridBagConstraints gbc_xField = new GridBagConstraints();
		gbc_xField.insets = new Insets(0, 0, 5, 5);
		gbc_xField.fill = GridBagConstraints.HORIZONTAL;
		gbc_xField.gridx = 2;
		gbc_xField.gridy = 2;
		add(xField, gbc_xField);
		xField.setColumns(10);

		ILabel lblYCoord = new ILabel();
		Lang.setLine(lblYCoord, "edit_link_y");
		GridBagConstraints gbc_lblYCoord = new GridBagConstraints();
		gbc_lblYCoord.anchor = GridBagConstraints.WEST;
		gbc_lblYCoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCoord.gridx = 1;
		gbc_lblYCoord.gridy = 3;
		add(lblYCoord, gbc_lblYCoord);

		yField = new JTextField();
		yField.addKeyListener(this);
		GridBagConstraints gbc_yField = new GridBagConstraints();
		gbc_yField.insets = new Insets(0, 0, 5, 5);
		gbc_yField.fill = GridBagConstraints.HORIZONTAL;
		gbc_yField.gridx = 2;
		gbc_yField.gridy = 3;
		add(yField, gbc_yField);
		yField.setColumns(10);

		if (l != null)
		{
			mapField.setText("" + l.getMap());
			xField.setText("" + l.getX());
			yField.setText("" + l.getY());
		}
		else
		{
			mapField.setText("0");
			xField.setText("0");
			yField.setText("0");
		}
	}

	/**
	 * @return The link created by the user
	 */
	public Link getLink()
	{
		return new Link((short) Integer.parseInt(mapField.getText()),
		(byte) Integer.parseInt(xField.getText()),
		(byte) Integer.parseInt(yField.getText()));
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if (e.getKeyChar() > '9' || e.getKeyChar() < '0')
		{
			e.consume();
		}
		else if ((e.getSource() == xField || e.getSource() == yField)
		&& Integer.parseInt(((JTextField) e.getSource()).getText()
		+ e.getKeyChar()) > 254)
		{
			((JTextField) e.getSource()).setText("254");
			e.consume();
		}
		else if (Integer.parseInt(((JTextField) e.getSource()).getText()
		+ e.getKeyChar()) < 0)
		{
			((JTextField) e.getSource()).setText("0");
			e.consume();
		}
		else if (e.getSource() == mapField
		&& Integer.parseInt(((JTextField) e.getSource()).getText()
		+ e.getKeyChar()) > 65278)
		{
			((JTextField) e.getSource()).setText("65278");
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}