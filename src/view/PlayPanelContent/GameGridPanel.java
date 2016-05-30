package view.PlayPanelContent;

import Model.ActorLandingSpace;
import Model.ActorLandscape1;
import Model.ActorLandscape2;
import Model.ActorLandscape3;
import Model.ActorLandscape4;
import Model.ActorLandscape5;
import Model.ActorUfo;
import ch.aplu.jgamegrid.GGSound;
import ch.aplu.jgamegrid.GameGrid;
import ch.aplu.jgamegrid.Location;

/**
 * GameGrid auf dem sich alle Actoren befinden.
 */

@SuppressWarnings("serial")
public class GameGridPanel extends GameGrid {

	public ActorLandscape1 ActorLandscape1 = new ActorLandscape1();
	public ActorLandscape2 ActorLandscape2 = new ActorLandscape2();
	public ActorLandscape3 ActorLandscape3 = new ActorLandscape3();
	public ActorLandscape4 ActorLandscape4 = new ActorLandscape4();
	public ActorLandscape5 ActorLandscape5 = new ActorLandscape5();
	public ActorLandingSpace ActorLandingSpace1 = new ActorLandingSpace();
	public ActorLandingSpace ActorLandingSpace2 = new ActorLandingSpace();
	public ActorLandingSpace ActorLandingSpace3 = new ActorLandingSpace();

	private Listener.GameOverCollisionListener gameOverCollisionListener;
	private Listener.VictoryCollisionListener victoryCollisionListener;

	private int resolutionX = 1580;
	private int resolutionY = 1040;
	private int cellSize = 5;
	private int simulationPeriod = 10;
	private ActorUfo ufo = new ActorUfo(simulationPeriod);

	/**
	 * 
	 */
	
	public GameGridPanel(Listener.GameOverCollisionListener gameOverCollisionListener,
			Listener.VictoryCollisionListener victoryCollisionListener) {

		// Lässt Sound abspielen aus dem jarFile.
		playSound(GGSound.DUMMY);
		playSound(GGSound.SOUND);

		this.gameOverCollisionListener = gameOverCollisionListener;
		this.victoryCollisionListener = victoryCollisionListener;

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
	}

	public void prepareLandscape() {

		addActor(ActorLandscape1, new Location(25, 150));
		ActorLandscape1.setCollisionImage(0);
		ActorLandscape1.addCollisionActor(ufo);
		ActorLandscape1.addActorCollisionListener(gameOverCollisionListener);

		addActor(ActorLandscape2, new Location(95, 110));
		ActorLandscape2.setCollisionImage(0);
		ActorLandscape2.addCollisionActor(ufo);
		ActorLandscape2.addActorCollisionListener(gameOverCollisionListener);

		addActor(ActorLandscape3, new Location(125, 185));
		ActorLandscape3.setCollisionImage(0);
		ActorLandscape3.addCollisionActor(ufo);
		ActorLandscape3.addActorCollisionListener(gameOverCollisionListener);

		addActor(ActorLandscape4, new Location(195, 185));
		ActorLandscape4.setCollisionImage(0);
		ActorLandscape4.addCollisionActor(ufo);
		ActorLandscape4.addActorCollisionListener(gameOverCollisionListener);

		addActor(ActorLandscape5, new Location(280, 160));
		ActorLandscape5.setCollisionImage(0);
		ActorLandscape5.addCollisionActor(ufo);
		ActorLandscape5.addActorCollisionListener(gameOverCollisionListener);
	}

	public void prepareLandingSpace() {

		addActor(ActorLandingSpace1, new Location(55, 205));
		ActorLandingSpace1.setDifficulty(500);
		ActorLandingSpace1.setCollisionImage(0);
		ActorLandingSpace1.addCollisionActor(ufo);
		ActorLandingSpace1.addActorCollisionListener(victoryCollisionListener);

		addActor(ActorLandingSpace2, new Location(183, 190));
		ActorLandingSpace2.setDifficulty(100);
		ActorLandingSpace2.setCollisionImage(0);
		ActorLandingSpace2.addCollisionActor(ufo);
		ActorLandingSpace2.addActorCollisionListener(victoryCollisionListener);

		addActor(ActorLandingSpace3, new Location(290, 105));
		ActorLandingSpace3.setDifficulty(200);
		ActorLandingSpace3.setCollisionImage(0);
		ActorLandingSpace3.addCollisionActor(ufo);
		ActorLandingSpace3.addActorCollisionListener(victoryCollisionListener);
	}

	public ActorUfo getUfo() {
		return ufo;
	}
}