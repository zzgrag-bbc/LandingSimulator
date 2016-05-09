package view.MenuPanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import Model.Zeit;
import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class StartButton extends JButton {

	public StartButton() {

		// Design of Start Button
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(ImageLoader.loadIcon("Menupanel/ButtonIngameStart.png"));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				final Timer timer = new Timer();
				final Zeit z = new Zeit();
				z.setEin(0);
				final TimerTask task = new TimerTask() {
					public void run() {
						if (Zeit.getAus() == 1) {
							timer.cancel();
						} else {
							z.macheZeit();
						}
					}
				};
				timer.scheduleAtFixedRate(task, 0, 1000);
				setEnabled(false);
			}
		});
	}
}