package view.MenuPanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.GameTimer;
import UtilityClasses.ImageLoader;
import view.PlayPanelContent.PlayPanel;

@SuppressWarnings("serial")
public class RestartButton extends JButton {

	private PlayPanel playPanel;

	public RestartButton(PlayPanel playPanel) {

		this.playPanel = playPanel;
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