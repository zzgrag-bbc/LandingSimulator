package view.Screens;

import java.awt.Graphics;

import javax.swing.JPanel;

import Model.GameTimer;
import UtilityClasses.ImageLoader;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.View;
import view.PlayPanelContent.PlayPanel;

@SuppressWarnings("serial")
public class GameOverScreen extends JPanel implements GGActorCollisionListener {
	
	private View view;
	private PlayPanel playPanel;

	public GameOverScreen(View view, PlayPanel playPanel) {
		repaint();
		this.view = view;
		this.playPanel = playPanel;
	}

	
	@Override
	public int collide(Actor arg0, Actor arg1) {
		view.showGameOverScreen();
		playPanel.doPause();
		
		GameTimer.getInstance().stopTimer();
		
		return 0;
	}

	@Override
	protected void paintComponent(Graphics startScreenBackground) {

		super.paintComponent(startScreenBackground);
		startScreenBackground.drawImage(ImageLoader.Image("IngameScreen/GameOverScreen.jpg"), 0, 0, null);
	}
}