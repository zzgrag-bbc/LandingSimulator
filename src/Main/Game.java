package Main;
import java.awt.EventQueue;
import Listener.GameOverCollisionListener;
import Listener.VictoryCollisionListener;
import Model.ScoreCalculator;
import view.MainFrame;
import view.MenuPanelContent.ScorePanel;
import view.PlayPanelContent.GameGridPanel;
import view.Screens.GameOverScreen;
import view.Screens.VictoryScreen;

/**
 * Kreiert alle Panels, welche später von Funktionen aufgerufen werden.
 */

public class Game {

	private GameOverScreen gameOverScreen = new GameOverScreen();
	private VictoryScreen victoryScreen = new VictoryScreen();
	private GameGridPanel playPanel;
	private GameOverCollisionListener gameOverCollisionListener;
	private VictoryCollisionListener victoryCollisionListener;
	private MainFrame mainFrame;
	private ScorePanel scorePanel = new ScorePanel();
	private ScoreCalculator scoreCalculator;
	
	/**
	 * Erstellt Panels sowie Listeners.
	 */
	
	public Game()
	{
		scoreCalculator = new ScoreCalculator(scorePanel);
		gameOverCollisionListener = new GameOverCollisionListener();
		victoryCollisionListener = new VictoryCollisionListener();
		playPanel = new GameGridPanel(gameOverCollisionListener, victoryCollisionListener);
		mainFrame = new MainFrame(playPanel, gameOverScreen, victoryScreen, scorePanel);
		
		gameOverCollisionListener.setPlayPanelAndMainFrame(playPanel, mainFrame);
		victoryCollisionListener.setPlayPanelAndMainFrame(playPanel, mainFrame, scoreCalculator );
	}
	
	/**
	 * Starpunkt der Applikation
	 * @param args
	 */
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}	
}
