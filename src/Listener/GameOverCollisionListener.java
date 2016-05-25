package Listener;

import Model.GameTimer;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.MainFrame;
import view.PlayPanelContent.PlayPanel;

public class GameOverCollisionListener implements GGActorCollisionListener
{
	private MainFrame mainFrame;
	private PlayPanel playPanel;
	
	@Override
	public int collide(Actor actor1, Actor actor2) {
		mainFrame.showGameOverScreen();
		playPanel.doPause();
		GameTimer.getInstance().stopTimer();
		// MainFrame.MenuPanel.setEnabled(magicLinkToStartButton);
		return 0;
	}

	public void setPlayPanelAndMainFrame(PlayPanel playPanel, MainFrame mainFrame) {
		this.playPanel = playPanel;
		this.mainFrame = mainFrame;
	}
}