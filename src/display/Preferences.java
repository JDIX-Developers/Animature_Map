package display;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Lang;

/**
 * @author Razican (Iban Eguia)
 */
public class Preferences extends JPanel {

	private static final long	serialVersionUID	= -9082799207563983259L;

	/**
	 * Create the panel.
	 */
	public Preferences()
	{
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JLabel lblLanguage = new JLabel(Lang.getLine("pref_lang"));
		panel.add(lblLanguage);

		JComboBox<String> langCombo = new JComboBox<>(Lang.getCombableLocales());
		panel.add(langCombo);

		setSize(600, 600);
	}
}