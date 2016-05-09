package UtilityClasses;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageLoader {

	// Loads Images
	private static final String IMAGE_LOCATION = "src/images/";

	public static Image Image(String imageName) {
		String path = IMAGE_LOCATION + imageName;
		File tempFile = new File(path);
		if (tempFile.exists() && !tempFile.isDirectory()) {
			return new ImageIcon(path).getImage();
		} else {
			System.out.println("Error: File does not exist or could not be found.");
			return null;
		}

	}

	// Loads Icons
	public static Icon loadIcon(String iconName) {
		final URL resource = ImageLoader.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println(
					"Error in " + ImageLoader.class.getName() + ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
}
