import java.awt.EventQueue;

import Listener.GameOverCollisionListener;
import Listener.VictoryCollisionListener;
import view.MainFrame;
import view.MenuPanelContent.ScorePanel;
import view.PlayPanelContent.PlayPanel;
import view.Screens.GameOverScreen;
import view.Screens.VictoryScreen;

public class Game {

	private GameOverScreen gameOverScreen = new GameOverScreen();
	private VictoryScreen victoryScreen = new VictoryScreen();
	private PlayPanel playPanel;
	private GameOverCollisionListener gameOverCollisionListener;
	private VictoryCollisionListener victoryCollisionListener;
	private MainFrame mainFrame;
	private ScorePanel scorePanel = new ScorePanel();
	
	public Game()
	{
		gameOverCollisionListener = new GameOverCollisionListener();
		victoryCollisionListener = new VictoryCollisionListener();
		playPanel = new PlayPanel(gameOverCollisionListener, victoryCollisionListener);
		mainFrame = new MainFrame(playPanel, gameOverScreen, victoryScreen, scorePanel);
		
		gameOverCollisionListener.setPlayPanelAndMainFrame(playPanel, mainFrame);
		victoryCollisionListener.setPlayPanelAndMainFrame(playPanel, mainFrame, scorePanel );
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}	
}
