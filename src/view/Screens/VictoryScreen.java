package view.Screens;

import java.awt.Graphics;

import javax.swing.JPanel;

import UtilityClasses.ImageLoader;

@SuppressWarnings("serial")
public class VictoryScreen extends JPanel {

	public VictoryScreen() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics victoryScreenBackground) {

		super.paintComponent(victoryScreenBackground);
		victoryScreenBackground.drawImage(ImageLoader.Image("IngameScreen/VictoryScreen.jpg"), 0, 0, null);
	}
}