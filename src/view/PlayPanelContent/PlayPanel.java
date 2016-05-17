package view.PlayPanelContent;

import java.awt.Color;

import Model.ActorLandingSpace;
import Model.ActorLandscape;
import Model.ActorUfo;
import ch.aplu.jgamegrid.GGButton;
import ch.aplu.jgamegrid.GGButtonListener;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;

@SuppressWarnings("serial")
public class PlayPanel extends GameGrid implements GGButtonListener{

	public PlayPanel() {
		setNbVertCells(216);
		setNbHorzCells(320);
		setCellSize(5);
		setGridColor(Color.RED);
		setBgImagePath("images/IngameScreen/background.jpg");
		setSimulationPeriod(10);
	}

	public void setUfoPosition() {
		ActorUfo ufo = new ActorUfo();
		addActor(ufo, new Location(150, 10));
		addKeyListener(ufo);
	}

	public void setStartButtonPosition() {
//		ActorStartButton actorStartButton = new ActorStartButton();
//		addActor(actorStartButton, new Location(150, 100));
		GGButton actorStartButton = new GGButton("images/Menupanel/ButtonIngameStart.png");
		addActor(actorStartButton, new Location(150, 100));
		actorStartButton.addButtonListener(this);
//		addMouseListener((GGMouseListener) this, GGMouse.lPress);
	}

	public void startUfo() {
		doRun();
	}

	public void setLandscapePositions() {

		ActorLandscape landscape = new ActorLandscape();
		addActor(landscape, new Location(159, 110));

		ActorLandingSpace ActorLandingSpace1 = new ActorLandingSpace();
		addActor(ActorLandingSpace1, new Location(60, 211));

		ActorLandingSpace ActorLandingSpace2 = new ActorLandingSpace();
		addActor(ActorLandingSpace2, new Location(190, 195));

		ActorLandingSpace ActorLandingSpace3 = new ActorLandingSpace();
		addActor(ActorLandingSpace3, new Location(290, 100));
	}

	@Override
	public void buttonClicked(GGButton button) {
		System.out.println("clicked");
		
	}

	@Override
	public void buttonPressed(GGButton button) {
		System.out.println("pressed");
		
	}

	@Override
	public void buttonReleased(GGButton button) {
		System.out.println("released");
		
	}
}