package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Jordan Aranda Tejada
 */
public class FileChooser {

	/**
	 * Opens a file with a file chooser
	 * 
	 * @param description - The description of the file
	 * @param extensions - The extension of the file. Could be multiple
	 *            extensions.
	 * @return The file loaded
	 */
	public static File openFile(final String description,
	final String ... extensions)
	{
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(description,
		extensions));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		String path = "";
		File file = null;
		try
		{
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
				file = new File(path);
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * Saves a file choosen by a file chooser
	 * 
	 * @param content - The object to save
	 * @param description - The description of the file
	 * @param extension - The extension of the file
	 * @return The path of the saved file
	 */
	public static String saveObjectFile(final Object content,
	final String description, final String extension)
	{
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(description,
		extension));
		String path = "";
		try
		{
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
				if ( ! path.endsWith("." + extension))
				{
					path += "." + extension;
				}
				final File file = new File(path);
				if ((file.exists() && JOptionPane.OK_OPTION == JOptionPane
				.showConfirmDialog(null, Lang.getLine("file_exists_replace"),
				Lang.getLine("file_exists"), JOptionPane.YES_NO_OPTION))
				|| ! file.exists())
				{
					final ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(path));
					oos.writeObject(content);
					oos.close();
				}
			}
			return path;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return path;
		}
	}

	/**
	 * Saves a file choosen by a file chooser
	 * 
	 * @param content - The byte array to save
	 * @param description - The description of the file
	 * @param extension - The extension of the file
	 * @return The path of the saved file
	 */
	public static String saveFile(final byte[] content,
	final String description, final String extension)
	{
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(description,
		extension));
		String path = "";
		try
		{
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
				if ( ! path.endsWith("." + extension))
				{
					path += "." + extension;
				}
				final File file = new File(path);
				if ((file.exists() && JOptionPane.OK_OPTION == JOptionPane
				.showConfirmDialog(null, Lang.getLine("file_exists_replace"),
				Lang.getLine("file_exists"), JOptionPane.YES_NO_OPTION))
				|| ! file.exists())
				{
					final FileOutputStream fos = new FileOutputStream(path);
					fos.write(content);
					fos.close();
				}
			}
			return path;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return path;
		}
	}
}