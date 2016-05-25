package view.Screens;

import java.awt.Graphics;

import javax.swing.JPanel;

import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class GameOverScreen extends JPanel {
	
	public GameOverScreen() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics startScreenBackground) {

		super.paintComponent(startScreenBackground);
		startScreenBackground.drawImage(ImageLoader.Image("IngameScreen/GameOverScreen.jpg"), 0, 0, null);
	}
}