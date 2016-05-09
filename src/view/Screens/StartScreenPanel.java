package view.Screens;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import UtilityClasses.ImageLoader;
import view.View;

@SuppressWarnings("serial")
public class StartScreenPanel extends JPanel {

	public StartScreenPanel(View view) {

		Icon buttonStartIcon = ImageLoader.loadIcon("Startscreen/buttonStart.jpg");
		Icon buttonQuitIcon = ImageLoader.loadIcon("Startscreen/buttonQuit.jpg");

		JButton startButton = new JButton(buttonStartIcon);
		JButton quitButton = new JButton(buttonQuitIcon);

		setLayout(null);

		startButton.setBounds(820, 560, 280, 100);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.start();
			}
		});

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

	@Override
	protected void paintComponent(Graphics startScreenBackground) {

		super.paintComponent(startScreenBackground);
		startScreenBackground.drawImage(ImageLoader.Image("Startscreen/startscreen_background.jpg"), 0, 0, null);
	}
}