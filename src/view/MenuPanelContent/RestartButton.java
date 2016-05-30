package view.MenuPanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.GameTimer;
import UtilityClasses.ImageLoader;
import view.PlayPanelContent.GameGridPanel;

/**
 * Restart Button.
 */

@SuppressWarnings("serial")
public class RestartButton extends JButton {
	
	public RestartButton(GameGridPanel playPanel) {

		// Design of Start Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameStart.png"));

		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playPanel.getUfo().reset();
				playPanel.requestFocusInWindow();
				GameTimer.getInstance().start();
				setEnabled(false);
				playPanel.doRun();
			}
		});
	}
}