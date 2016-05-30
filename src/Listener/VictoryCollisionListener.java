package Listener;

import Model.ActorLandingSpace;
import Model.ActorUfo;
import Model.GameTimer;
import Model.ScoreCalculator;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.MainFrame;
import view.PlayPanelContent.PlayPanel;

/**
 * VictoryCollisionListener ist ein GGActorCollisionListener, welcher von VictoryScreen aufgerufen wird.
 */

public class VictoryCollisionListener implements GGActorCollisionListener {
	private int difficultyScore;
	private MainFrame mainFrame;
	private PlayPanel playPanel;
	private ScoreCalculator scoreCalculator;

	/**
	 * Collide zeigt nachdem das Ufo gelandet ist den VictoryScreen, pausiert das Spiel sowie den Timer und updated den Score.
	 */
	@Override
	public int collide(Actor actor1, Actor actor2) {

		ActorLandingSpace landingSpace = null;

		ActorUfo ufo = null;

		if (actor1 instanceof ActorLandingSpace) {
			landingSpace = (ActorLandingSpace) actor1;
			ufo = (ActorUfo) actor2;
		} else {
			landingSpace = (ActorLandingSpace) actor2;
			ufo = (ActorUfo) actor1;
		}

		mainFrame.showVictoryScreen();
		playPanel.doPause();
		GameTimer.getInstance().stopTimer();
		difficultyScore = landingSpace.getDifficulty();
		scoreCalculator.updateScore(difficultyScore, ufo.getFuel());
		return 0;
	}
	
	/**
	 * Setzt das PlayPanel sowie das MainFrame, welches ihm mitgegeben wird.
	 */

	public void setPlayPanelAndMainFrame(PlayPanel playPanel, MainFrame mainFrame, ScoreCalculator scoreCalculator) {
		this.playPanel = playPanel;
		this.mainFrame = mainFrame;
		this.scoreCalculator = scoreCalculator;
	}
}
