package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import view.MenuPanelContent.MenuPanel;
import view.PlayPanelContent.PlayPanel;
import view.Screens.GameOverScreen;
import view.Screens.StartScreenPanel;
import view.Screens.VictoryScreen;

@SuppressWarnings("serial")
public class View extends JFrame {

	// Instance Variables
	private StartScreenPanel startScreenPanel;
	private static PlayPanel playPanel;

	// Constructor
	private View() {
		setSize(1920, 1080);
		setLayout(new BorderLayout());
		startScreenPanel = new StartScreenPanel(this);
		add(startScreenPanel);
		setVisible(true);
	}

	public void start() {
		remove(startScreenPanel);

		MenuPanel menuPanel = new MenuPanel();
		add(menuPanel, BorderLayout.WEST);

		playPanel = new PlayPanel(this);
		add(playPanel, BorderLayout.CENTER);
		pack();

		playPanel.prepareLandscape();
		playPanel.prepareLandingSpace();
		playPanel.prepareUfo();
	}
	
	public void showGameOverScreen() {
		GameOverScreen gameOverScreenPanel = playPanel.getGameOverScreen();
		remove(playPanel);
		add(gameOverScreenPanel);
	}
	
	public void showVictoryScreen() {
		VictoryScreen victoryScreen = playPanel.getVictoryScreen();
		remove(playPanel);
		add(victoryScreen);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new View();
			}
		});
	}

	public static PlayPanel getPlayPanel() {
		return playPanel;
	}
}
