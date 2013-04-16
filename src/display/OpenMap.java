package display;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
public class OpenMap extends JPanel {

	private static final long	serialVersionUID	= - 2133910597250819834L;
	private final ILabel		lblSpriteFile, lblMapFile;
	private final IButton		btnBrowseMap;
	private Map					map;
	private File				file;

	/**
	 * Creates the dialog for opening a map
	 */
	public OpenMap()
	{
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, 0.0, 0.0, 1.0, 1.0,
		Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0, 0.0, 0.0, 1.0,
		Double.MIN_VALUE};
		setLayout(gridBagLayout);

		final ILabel lblSprite = new ILabel();
		lblSprite.setHorizontalAlignment(SwingConstants.TRAILING);
		Lang.setLine(lblSprite, "map_sprite");
		final GridBagConstraints gbc_lblSprite = new GridBagConstraints();
		gbc_lblSprite.anchor = GridBagConstraints.EAST;
		gbc_lblSprite.insets = new Insets(0, 0, 5, 5);
		gbc_lblSprite.gridx = 1;
		gbc_lblSprite.gridy = 1;
		add(lblSprite, gbc_lblSprite);

		lblSpriteFile = new ILabel();
		lblSpriteFile.setHorizontalTextPosition(SwingConstants.LEADING);
		lblSpriteFile.setFont(new Font("Dialog", Font.ITALIC, 12));
		final GridBagConstraints gbc_lblSpriteFile = new GridBagConstraints();
		gbc_lblSpriteFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpriteFile.gridx = 2;
		gbc_lblSpriteFile.gridy = 1;
		add(lblSpriteFile, gbc_lblSpriteFile);

		final IButton btnBrowseSpr = new IButton();
		Lang.setLine(btnBrowseSpr, "btn_examine");
		btnBrowseSpr.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(final ActionEvent e)
			{
				final File f = FileChooser.openFile(
				Lang.getLine("sprite_file"), "spr");
				if (f != null)
				{
					Sprite sprite = null;
					try
					{
						sprite = new Sprite(f);
					}
					catch (IOException | SpriteException
					| ClassNotFoundException e1)
					{
						sprite = null;

						e1.printStackTrace();

						JOptionPane.showMessageDialog(null,
						Lang.getLine("sprite_load_error"),
						Lang.getLine("error"), JOptionPane.ERROR_MESSAGE,
						new ImageIcon("img/error.png"));
					}

					if (sprite != null)
					{
						Square.setSprite(sprite);
						lblSpriteFile.setText(f.getName());
						map = null;
						lblMapFile.setText(null);
						btnBrowseMap.setEnabled(true);
					}
				}
			}
		});
		final GridBagConstraints gbc_btnBrowseSpr = new GridBagConstraints();
		gbc_btnBrowseSpr.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowseSpr.gridx = 3;
		gbc_btnBrowseSpr.gridy = 1;
		add(btnBrowseSpr, gbc_btnBrowseSpr);

		final ILabel lblMap = new ILabel();
		lblMap.setHorizontalAlignment(SwingConstants.TRAILING);
		Lang.setLine(lblMap, "map_file");
		final GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.anchor = GridBagConstraints.EAST;
		gbc_lblMap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMap.gridx = 1;
		gbc_lblMap.gridy = 2;
		add(lblMap, gbc_lblMap);

		lblMapFile = new ILabel();
		lblMapFile.setHorizontalTextPosition(SwingConstants.LEADING);
		lblMapFile.setFont(new Font("Dialog", Font.ITALIC, 12));
		final GridBagConstraints gbc_lblMapFile = new GridBagConstraints();
		gbc_lblMapFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMapFile.gridx = 2;
		gbc_lblMapFile.gridy = 2;
		add(lblMapFile, gbc_lblMapFile);

		btnBrowseMap = new IButton();
		btnBrowseMap.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(final ActionEvent e)
			{
				final File f = FileChooser.openFile(Lang.getLine("map_file"),
				"dmap");
				if (f != null)
				{
					map = null;
					try
					{
						final ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(f));
						map = (Map) ois.readObject();
						ois.close();
					}
					catch (IOException | ClassNotFoundException e2)
					{
						map = null;

						e2.printStackTrace();

						JOptionPane.showMessageDialog(null, Lang
						.getLine("map_load_error"), Lang.getLine("error"),
						JOptionPane.ERROR_MESSAGE, new ImageIcon(
						"img/error.png"));
					}

					if (map != null)
					{
						lblMapFile.setText(f.getName());
						file = f;
					}
				}
			}
		});
		Lang.setLine(btnBrowseMap, "btn_examine");
		btnBrowseMap.setEnabled(false);
		final GridBagConstraints gbc_btnBrowseMap = new GridBagConstraints();
		gbc_btnBrowseMap.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowseMap.gridx = 3;
		gbc_btnBrowseMap.gridy = 2;
		add(btnBrowseMap, gbc_btnBrowseMap);
	}

	/**
	 * @return The map selected by the user
	 */
	public Map getMap()
	{
		return this.map;
	}

	/**
	 * @return The file of the map
	 */
	public File getFile()
	{
		return this.file;
	}
}