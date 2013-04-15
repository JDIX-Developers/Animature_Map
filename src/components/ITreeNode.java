package components;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Internationalizable Tree Node
 * 
 * @author Razican (Iban Eguia)
 */
public class ITreeNode extends DefaultMutableTreeNode implements
Internationalizable {

	private static final long	serialVersionUID	= 2477222581759751680L;

	@Override
	public void changeLanguage(String newText)
	{
		setUserObject(newText);
	}
}