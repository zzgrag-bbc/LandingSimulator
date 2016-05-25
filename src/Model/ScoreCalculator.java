package Model;

import Listener.VictoryCollisionListener;

public class ScoreCalculator {

	private int difficulty;
	private int remainingFuel;
	private int usedTime;
	private int score;

	private ActorUfo actorUfo;
	private GameTimer gameTimer = new GameTimer();
	private VictoryCollisionListener victoryCollisionListener;

	public ScoreCalculator() {
		setVariables();
	}

	private void setVariables() {
		difficulty = victoryCollisionListener.getDifficultyScore();
		remainingFuel = actorUfo.getFuel();
		usedTime = gameTimer.getPassedTimeInSeconds();
	}

	public void calculateScore() {
		setScore(difficulty + remainingFuel - usedTime);
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

}
