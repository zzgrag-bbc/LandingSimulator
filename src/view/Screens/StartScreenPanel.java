package view.Screens;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import UtilityClasses.ImageLoader;

/**
 * Erstellt Startscreen Panel.
 */

@SuppressWarnings("serial")
public class StartScreenPanel extends JPanel {

	public JButton startButton;
	
	/**
	 * Fügt Buttons in das Startscreen Panel.
	 */
	
	public StartScreenPanel() {

		Icon buttonStartIcon = ImageLoader.loadIcon("Startscreen/buttonStart.jpg");
		Icon buttonQuitIcon = ImageLoader.loadIcon("Startscreen/buttonQuit.jpg");

		startButton = new JButton(buttonStartIcon);
		JButton quitButton = new JButton(buttonQuitIcon);

		setLayout(null);

		startButton.setBounds(820, 560, 280, 100);

		quitButton.setBounds(820, 710, 280, 100);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		repaint();
		add(startButton);
		add(quitButton);
	}

	/**
	 * Setzt Hintergrund Bild.
	 */
	
	@Override
	protected void paintComponent(Graphics startScreenBackground) {

		super.paintComponent(startScreenBackground);
		startScreenBackground.drawImage(ImageLoader.Image("Startscreen/startscreen_background.jpg"), 0, 0, null);
	}
}