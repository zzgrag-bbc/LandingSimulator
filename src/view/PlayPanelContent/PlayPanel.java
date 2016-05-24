package view.PlayPanelContent;

import java.awt.Point;

import Model.ActorLandingSpace;
import Model.ActorLandscape1;
import Model.ActorLandscape2;
import Model.ActorLandscape3;
import Model.ActorLandscape4;
import Model.ActorLandscape5;
import Model.ActorUfo;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;
import view.View;
import view.Screens.GameOverScreen;
import view.Screens.VictoryScreen;

@SuppressWarnings("serial")
public class PlayPanel extends GameGrid {

	public ActorUfo ufo = new ActorUfo();
	public ActorLandscape1 ActorLandscape1 = new ActorLandscape1();
	public ActorLandscape2 ActorLandscape2 = new ActorLandscape2();
	public ActorLandscape3 ActorLandscape3 = new ActorLandscape3();
	public ActorLandscape4 ActorLandscape4 = new ActorLandscape4();
	public ActorLandscape5 ActorLandscape5 = new ActorLandscape5();
	public ActorLandingSpace ActorLandingSpace1 = new ActorLandingSpace();
	public ActorLandingSpace ActorLandingSpace2 = new ActorLandingSpace();
	public ActorLandingSpace ActorLandingSpace3 = new ActorLandingSpace();
	public GameOverScreen gameOverScreen;
	public VictoryScreen victoryScreen;

	private int resolutionX = 1580;
	private int resolutionY = 1040;
	private int cellSize = 5;
	private int simulationPeriod = 10;

	public PlayPanel(View view) {
		gameOverScreen = new GameOverScreen(view, this);
		victoryScreen = new VictoryScreen(view, this);
		setNbVertCells(resolutionY / cellSize);
		setNbHorzCells(resolutionX / cellSize);
		setCellSize(cellSize);
		// setGridColor(Color.RED);
		setBgImagePath("images/IngameScreen/background.jpg");
		setSimulationPeriod(simulationPeriod);
	}

	public void prepareUfo() {
		addActor(ufo, new Location(150, 10));
		addKeyListener(ufo);
		ufo.setCollisionCircle(new Point(1, 1), 42);
	}

	public void startUfo() {
		doRun();
	}

	public void prepareLandscape() {

		addActor(ActorLandscape1, new Location(25, 150));
		ActorLandscape1.setCollisionImage(0);
		ActorLandscape1.addCollisionActor(ufo);
		ActorLandscape1.addActorCollisionListener(gameOverScreen);

		addActor(ActorLandscape2, new Location(95, 110));
		ActorLandscape2.setCollisionImage(0);
		ActorLandscape2.addCollisionActor(ufo);
		ActorLandscape2.addActorCollisionListener(gameOverScreen);

		addActor(ActorLandscape3, new Location(125, 185));
		ActorLandscape3.setCollisionImage(0);
		ActorLandscape3.addCollisionActor(ufo);
		ActorLandscape3.addActorCollisionListener(gameOverScreen);

		addActor(ActorLandscape4, new Location(195, 185));
		ActorLandscape4.setCollisionImage(0);
		ActorLandscape4.addCollisionActor(ufo);
		ActorLandscape4.addActorCollisionListener(gameOverScreen);

		addActor(ActorLandscape5, new Location(280, 160));
		ActorLandscape5.setCollisionImage(0);
		ActorLandscape5.addCollisionActor(ufo);
		ActorLandscape5.addActorCollisionListener(gameOverScreen);
	}

	public void prepareLandingSpace() {

		addActor(ActorLandingSpace1, new Location(55, 205));
		ActorLandingSpace1.setDifficulty(500);
		ActorLandingSpace1.setCollisionImage(0);
		ActorLandingSpace1.addCollisionActor(ufo);
		ActorLandingSpace1.addActorCollisionListener(victoryScreen);

		addActor(ActorLandingSpace2, new Location(183, 190));
		ActorLandingSpace2.setDifficulty(100);
		ActorLandingSpace2.setCollisionImage(0);
		ActorLandingSpace2.addCollisionActor(ufo);
		ActorLandingSpace2.addActorCollisionListener(victoryScreen);

		addActor(ActorLandingSpace3, new Location(290, 100));
		ActorLandingSpace3.setDifficulty(200);
		ActorLandingSpace3.setCollisionImage(0);
		ActorLandingSpace3.addCollisionActor(ufo);
		ActorLandingSpace3.addActorCollisionListener(victoryScreen);
	}

	public GameOverScreen getGameOverScreen() {
		return gameOverScreen;
	}

	public VictoryScreen getVictoryScreen() {
		return victoryScreen;
	}

	public ActorUfo getUfo() {
		return ufo;
	}
}