package view.MenuPanelContent;

import javax.swing.JButton;

import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class ChangeButton extends JButton {

	public ChangeButton() {

		// Design of CHANGE Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameChange.png"));
		addActionListener(null);
	}
}