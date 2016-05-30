package Listener;

import Model.GameTimer;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.MainFrame;
import view.PlayPanelContent.GameGridPanel;

/**
 * GameOverCollisionListener ist ein GGActorCollisionListener, welcher von GameOverScreen aufgerufen wird.
 */

public class GameOverCollisionListener implements GGActorCollisionListener
{
	private MainFrame mainFrame;
	private GameGridPanel playPanel;

	/**
	 * Collide zeigt nachdem das Ufo gecrasht ist den GameOverScreen, pausiert das Spiel sowie den Timer.
	 */
	@Override
	public int collide(Actor actor1, Actor actor2) {
		mainFrame.showGameOverScreen();
		playPanel.doPause();
		GameTimer.getInstance().stopTimer();
		return 0;
	}
	
	/**
	 * Setzt das PlayPanel sowie das MainFrame, welches ihm mitgegeben wird.
	 * @param playPanel
	 * @param mainFrame
	 */

	public void setPlayPanelAndMainFrame(GameGridPanel playPanel, MainFrame mainFrame) {
		this.playPanel = playPanel;
		this.mainFrame = mainFrame;
	}
}