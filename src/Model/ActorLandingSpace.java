package Model;

import ch.aplu.jgamegrid.Actor;

/**
 * JGameGrid Actor.
 */

public class ActorLandingSpace extends Actor {

	private int difficulty;
	
	/**
	 * Der Bildpfad welches der Actor erhält wird hier hinterlegt.
	 */
	
	public ActorLandingSpace() {
		super("images/IngameScreen/landeplatform.png");
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
}