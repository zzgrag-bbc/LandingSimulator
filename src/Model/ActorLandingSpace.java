package Model;

import ch.aplu.jgamegrid.Actor;

public class ActorLandingSpace extends Actor {

	private int difficulty;
	
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