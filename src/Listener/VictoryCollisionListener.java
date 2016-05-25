package Listener;

import Model.ActorLandingSpace;
import Model.GameTimer;
import Model.ScoreCalculator;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.MainFrame;
import view.MenuPanelContent.ScorePanel;
import view.PlayPanelContent.PlayPanel;

public class VictoryCollisionListener implements GGActorCollisionListener {
	private int difficultyScore;
	private MainFrame mainFrame;
	private PlayPanel playPanel;
	private ScoreCalculator scoreCalculator;
	private ScorePanel scorePanel;

	@Override
	public int collide(Actor actor1, Actor actor2) {

		ActorLandingSpace landingSpace = null;

		if (actor1 instanceof ActorLandingSpace) {
			landingSpace = (ActorLandingSpace) actor1;
		}
		if (actor2 instanceof ActorLandingSpace) {
			landingSpace = (ActorLandingSpace) actor1;
		}

		mainFrame.showVictoryScreen();
		playPanel.doPause();
		GameTimer.getInstance().stopTimer();
		difficultyScore = landingSpace.getDifficulty();
		scoreCalculator = new ScoreCalculator();
		scorePanel.updateScore(scoreCalculator.getScore());
		return 0;
	}

	public int getDifficultyScore() {
		return difficultyScore;
	}

	public void setPlayPanelAndMainFrame(PlayPanel playPanel, MainFrame mainFrame, ScorePanel scorePanel) {
		this.playPanel = playPanel;
		this.mainFrame = mainFrame;
		this.scorePanel = scorePanel;
	}
}
