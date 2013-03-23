package components;

import javax.swing.JTabbedPane;

/**
 * @author Razican (Iban Eguia)
 */
public class ITabbedPane extends JTabbedPane {

	private static final long	serialVersionUID	= 9214709772776627079L;

	/**
	 * Create a tabbed pane
	 */
	public ITabbedPane()
	{
		super();
	}

	/**
	 * @param tabPlacement the placement for the tabs relative to the content
	 * @param tabLayoutPolicy the policy for laying out tabs when all tabs will
	 *            not fit on one run
	 */
	public ITabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
	}

	/**
	 * @param tabPlacement the placement for the tabs relative to the content
	 */
	public ITabbedPane(int tabPlacement)
	{
		super(tabPlacement);
	}

	/**
	 * @param tabIndex The index of the tab to get
	 * @return Tab's title, but Internationalizable
	 */
	public TabTitle getTabAt(int tabIndex)
	{
		return new TabTitle(tabIndex);
	}

	private class TabTitle implements Internationalizable {

		private int	index;

		private TabTitle(int index)
		{
			this.index = index;
		}

		@Override
		public void changeLanguage(String newText)
		{
			setTitleAt(index, newText);
		}
	}
}