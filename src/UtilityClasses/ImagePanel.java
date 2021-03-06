package UtilityClasses;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Neu erstellte Klasse um JPanels Bilder als Hintergrund zu setzen.
 */

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(Icon img) {
		this(((ImageIcon) img).getImage());
	}

	/**
	 * Lässt die Grösse des Bildes bestimmen sowie das Layout.
	 * @param img Braucht Bild Wert.
	 */
	
	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
