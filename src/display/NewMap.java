package display;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import map.Map;
import map.Sprite;
import utils.Lang;

import components.JButton;
import components.JLabel;

/**
 * @author Razican (Iban Eguia)
 */
public class NewMap extends JPanel implements KeyListener, ActionListener {

	private static final long	serialVersionUID	= -4235181786593609509L;

	private Map					map;
	private Sprite				sprite;
	private JTextField			textWidth, textHeight;
	private JButton				btnExamine;

	/**
	 * Create the panel.
	 */
	public NewMap()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, 0.0, 1.0, 1.0,
		Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0,
		Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblWidthsquares = new JLabel();
		Lang.setLine(lblWidthsquares, "map_width");
		GridBagConstraints gbc_lblWidthsquares = new GridBagConstraints();
		gbc_lblWidthsquares.anchor = GridBagConstraints.EAST;
		gbc_lblWidthsquares.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidthsquares.gridx = 1;
		gbc_lblWidthsquares.gridy = 0;
		add(lblWidthsquares, gbc_lblWidthsquares);

		textWidth = new JTextField();
		textWidth.addKeyListener(this);
		textWidth.setBackground(Color.WHITE);
		GridBagConstraints gbc_textWidth = new GridBagConstraints();
		gbc_textWidth.insets = new Insets(0, 0, 5, 5);
		gbc_textWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWidth.gridx = 2;
		gbc_textWidth.gridy = 0;
		add(textWidth, gbc_textWidth);
		textWidth.setColumns(10);

		JLabel lblHeightsquares = new JLabel();
		Lang.setLine(lblHeightsquares, "map_height");
		GridBagConstraints gbc_lblHeightsquares = new GridBagConstraints();
		gbc_lblHeightsquares.anchor = GridBagConstraints.EAST;
		gbc_lblHeightsquares.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightsquares.gridx = 1;
		gbc_lblHeightsquares.gridy = 1;
		add(lblHeightsquares, gbc_lblHeightsquares);

		textHeight = new JTextField();
		textHeight.setBackground(Color.WHITE);
		GridBagConstraints gbc_textHeight = new GridBagConstraints();
		gbc_textHeight.insets = new Insets(0, 0, 5, 5);
		gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeight.gridx = 2;
		gbc_textHeight.gridy = 1;
		add(textHeight, gbc_textHeight);
		textHeight.setColumns(10);

		JLabel lblSprite = new JLabel();
		Lang.setLine(lblSprite, "map_sprite");
		GridBagConstraints gbc_lblSprite = new GridBagConstraints();
		gbc_lblSprite.insets = new Insets(0, 0, 0, 5);
		gbc_lblSprite.gridx = 1;
		gbc_lblSprite.gridy = 2;
		add(lblSprite, gbc_lblSprite);

		btnExamine = new JButton();
		Lang.setLine(btnExamine, "btn_examine");
		btnExamine.addActionListener(this);
		GridBagConstraints gbc_btnExamine = new GridBagConstraints();
		gbc_btnExamine.insets = new Insets(0, 0, 0, 5);
		gbc_btnExamine.gridx = 2;
		gbc_btnExamine.gridy = 2;
		add(btnExamine, gbc_btnExamine);
	}

	/**
	 * @return The map selected by the user
	 */
	public Map getMap()
	{
		return this.map;
	}

	/**
	 * @return The sprite selected by the user
	 */
	public Sprite getSprite()
	{
		return this.sprite;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if (e.getSource() == textWidth || e.getSource() == textHeight)
		{
			if (e.getKeyChar() > '9' || e.getKeyChar() < '0')
			{
				e.consume();
			}
			else if (Integer.parseInt(((JTextField) e.getSource()).getText()
			+ e.getKeyChar()) > 254)
			{
				((JTextField) e.getSource()).setText("254");
				e.consume();
			}
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnExamine)
		{
			// TODO dialog
		}
	}
}