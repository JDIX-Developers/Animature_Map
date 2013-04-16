package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import map.Map;
import map.Sprite;
import map.Square;
import utils.FileChooser;
import utils.Lang;

import components.IButton;
import components.ILabel;

import exceptions.SpriteException;

/**
 * @author Razican (Iban Eguia)
 */
public class NewMap extends JPanel implements KeyListener, ActionListener {

	private static final long	serialVersionUID	= - 4235181786593609509L;

	private Sprite				sprite;
	private final JTextField	textWidth, textHeight;
	private final IButton		btnExamine;
	private final ILabel		lblArchivo;

	/**
	 * Create the panel.
	 */
	public NewMap()
	{
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, 0.0, 1.0, 1.0, 1.0,
		Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0,
		Double.MIN_VALUE};
		setLayout(gridBagLayout);

		final ILabel lblWidthsquares = new ILabel();
		Lang.setLine(lblWidthsquares, "map_width");
		final GridBagConstraints gbc_lblWidthsquares = new GridBagConstraints();
		gbc_lblWidthsquares.anchor = GridBagConstraints.EAST;
		gbc_lblWidthsquares.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidthsquares.gridx = 1;
		gbc_lblWidthsquares.gridy = 0;
		add(lblWidthsquares, gbc_lblWidthsquares);

		textWidth = new JTextField("1");
		textWidth.addKeyListener(this);
		textWidth.setBackground(Color.WHITE);
		final GridBagConstraints gbc_textWidth = new GridBagConstraints();
		gbc_textWidth.gridwidth = 2;
		gbc_textWidth.insets = new Insets(0, 0, 5, 5);
		gbc_textWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWidth.gridx = 2;
		gbc_textWidth.gridy = 0;
		add(textWidth, gbc_textWidth);
		textWidth.setColumns(10);

		final ILabel lblHeightsquares = new ILabel();
		Lang.setLine(lblHeightsquares, "map_height");
		final GridBagConstraints gbc_lblHeightsquares = new GridBagConstraints();
		gbc_lblHeightsquares.anchor = GridBagConstraints.EAST;
		gbc_lblHeightsquares.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightsquares.gridx = 1;
		gbc_lblHeightsquares.gridy = 1;
		add(lblHeightsquares, gbc_lblHeightsquares);

		textHeight = new JTextField("1");
		textHeight.addKeyListener(this);
		textHeight.setBackground(Color.WHITE);
		final GridBagConstraints gbc_textHeight = new GridBagConstraints();
		gbc_textHeight.gridwidth = 2;
		gbc_textHeight.insets = new Insets(0, 0, 5, 5);
		gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeight.gridx = 2;
		gbc_textHeight.gridy = 1;
		add(textHeight, gbc_textHeight);
		textHeight.setColumns(10);

		final ILabel lblSprite = new ILabel();
		Lang.setLine(lblSprite, "map_sprite");
		final GridBagConstraints gbc_lblSprite = new GridBagConstraints();
		gbc_lblSprite.insets = new Insets(0, 0, 0, 5);
		gbc_lblSprite.gridx = 1;
		gbc_lblSprite.gridy = 2;
		add(lblSprite, gbc_lblSprite);

		btnExamine = new IButton();
		Lang.setLine(btnExamine, "btn_examine");
		btnExamine.addActionListener(this);

		lblArchivo = new ILabel();
		lblArchivo.setFont(new Font("Dialog", Font.ITALIC, 12));
		final GridBagConstraints gbc_lblArchivo = new GridBagConstraints();
		gbc_lblArchivo.insets = new Insets(0, 0, 0, 5);
		gbc_lblArchivo.gridx = 2;
		gbc_lblArchivo.gridy = 2;
		add(lblArchivo, gbc_lblArchivo);

		final GridBagConstraints gbc_btnExamine = new GridBagConstraints();
		gbc_btnExamine.insets = new Insets(0, 0, 0, 5);
		gbc_btnExamine.gridx = 3;
		gbc_btnExamine.gridy = 2;
		add(btnExamine, gbc_btnExamine);
	}

	/**
	 * @return The map selected by the user
	 */
	public Map getMap()
	{
		Map map = null;

		if (sprite != null)
		{
			Square.setSprite(sprite);

			try
			{
				map = new Map(Integer.parseInt(textWidth.getText()),
				Integer.parseInt(textWidth.getText()));
			}
			catch (NumberFormatException | SpriteException e)
			{
				e.printStackTrace();
			}
		}

		return map;
	}

	@Override
	public void keyTyped(final KeyEvent e)
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
			else if (Integer.parseInt(((JTextField) e.getSource()).getText()
			+ e.getKeyChar()) < 1)
			{
				((JTextField) e.getSource()).setText("1");
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(final KeyEvent e)
	{
	}

	@Override
	public void keyReleased(final KeyEvent e)
	{
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		if (e.getSource() == btnExamine)
		{
			final File f = FileChooser.openFile(Lang.getLine("sprite_file"),
			"spr");
			if (f != null)
			{
				try
				{
					sprite = new Sprite(f);
					lblArchivo.setText(f.getName());
				}
				catch (IOException | SpriteException | ClassNotFoundException e1)
				{
					sprite = null;

					e1.printStackTrace();

					JOptionPane.showMessageDialog(null,
					Lang.getLine("sprite_load_error"), Lang.getLine("error"),
					JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error.png"));
				}
			}
		}
	}
}