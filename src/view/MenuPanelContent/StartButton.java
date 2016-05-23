package view.MenuPanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import Model.GameTimer;
import UtilityClasses.ImageLoader;
import view.View;

@SuppressWarnings("serial")
public class StartButton extends JButton {

	public StartButton() {

		// Design of Start Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameStart.png"));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View.getPlayPanel().getUfo().reset();
				View.getPlayPanel().requestFocusInWindow();
				startTimer();
				View.getPlayPanel().startUfo();
			}
		});
	}

	public void startTimer() {
		GameTimer.getInstance().start();
		setEnabled(false);
	}
}