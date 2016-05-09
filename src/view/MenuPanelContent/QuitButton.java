package view.MenuPanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class QuitButton extends JButton {

	public QuitButton() {

		// Design of QUIT Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameQuit.png"));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
