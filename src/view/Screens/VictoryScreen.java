package view.Screens;

import java.awt.Graphics;

import javax.swing.JPanel;

import Model.ActorLandingSpace;
import Model.GameTimer;
import UtilityClasses.ImageLoader;
import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import view.View;
import view.PlayPanelContent.PlayPanel;

@SuppressWarnings("serial")
public class VictoryScreen extends JPanel implements GGActorCollisionListener {

	private View view;
	private PlayPanel playPanel;

	public VictoryScreen(View view, PlayPanel playPanel) {
		repaint();
		this.view = view;
		this.playPanel = playPanel;
	}

	@Override
	public int collide(Actor actor1, Actor actor2) {
		
		ActorLandingSpace landingSpace = null;
		
		if ( actor1 instanceof ActorLandingSpace )
		{
			landingSpace = (ActorLandingSpace) actor1;
		}
		if ( actor2 instanceof ActorLandingSpace )
		{
			landingSpace = (ActorLandingSpace) actor1;
		}
				
		view.showVictoryScreen();
		playPanel.doPause();
		System.out.println(landingSpace.getDifficulty());

		GameTimer.getInstance().stopTimer();

		return 0;
	}

	@Override
	protected void paintComponent(Graphics victoryScreenBackground) {

		super.paintComponent(victoryScreenBackground);
		victoryScreenBackground.drawImage(ImageLoader.Image("IngameScreen/VictoryScreen.jpg"), 0, 0, null);
	}
}