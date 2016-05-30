package view.MenuPanelContent;

import javax.swing.JButton;

import UtilityClasses.ImageLoader;

/**
 * Erstellt den Change Button.
 */

@SuppressWarnings("serial")
public class ChangeButton extends JButton {

	/**
	 * Setzt das Layout des Buttons.
	 */
	
	public ChangeButton() {

		// Design of CHANGE Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameChange.png"));
	}
}
