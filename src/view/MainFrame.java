package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MenuPanelContent.MenuPanel;
import view.MenuPanelContent.ScorePanel;
import view.PlayPanelContent.GameGridPanel;
import view.Screens.GameOverScreen;
import view.Screens.StartScreenPanel;
import view.Screens.VictoryScreen;

/**
 * Erstellt und fügt alle Panels zusammen.
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private StartScreenPanel startScreenPanel;
	private GameGridPanel playPanel;
	private GameOverScreen gameOverScreen;
	private VictoryScreen victoryScreen;
	private ScorePanel scorePanel;

	public MainFrame(GameGridPanel playPanel, GameOverScreen gameOverScreen, VictoryScreen victoryScreen,
			ScorePanel scorePanel) {
		this.playPanel = playPanel;
		this.gameOverScreen = gameOverScreen;
		this.victoryScreen = victoryScreen;
		this.scorePanel = scorePanel;
		setSize(1920, 1080);
		setLayout(new BorderLayout());
		startScreenPanel = new StartScreenPanel();
		startScreenPanel.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		add(startScreenPanel);
		setVisible(true);
	}

	/**
	 * Bereitet das GameGrid und Menu Panel vor.
	 */

	public void start() {
		remove(startScreenPanel);
		MenuPanel menuPanel = new MenuPanel(playPanel, scorePanel);
		add(menuPanel, BorderLayout.WEST);

		add(playPanel, BorderLayout.CENTER);
		pack();

		playPanel.prepareLandscape();
		playPanel.prepareLandingSpace();
		playPanel.prepareUfo();
	}

	public void restart(JPanel endScreen) {
		if (endScreen == gameOverScreen) {
			remove(gameOverScreen);
		} else if (endScreen == victoryScreen) {
			remove(victoryScreen);
		}
		add(playPanel, BorderLayout.CENTER);
	}

	/**
	 * Zeigt GameOver Screen.
	 */

	public void showGameOverScreen() {
		remove(playPanel);
		add(gameOverScreen);
	}
	
	/**
	 * Zeigt Victory Screen.
	 */

	public void showVictoryScreen() {
		remove(playPanel);
		add(victoryScreen);
	}
}
