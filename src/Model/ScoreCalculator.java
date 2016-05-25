package Model;

import view.MenuPanelContent.ScorePanel;

public class ScoreCalculator {

	private ScorePanel scorePanel;

	public ScoreCalculator(ScorePanel scorePanel) {
		this.scorePanel = scorePanel;
	}

	public void updateScore(int difficultyScore, int remainingFuel) {
		scorePanel.updateScore(calculateScore(difficultyScore, remainingFuel));
	}

	private int calculateScore(int difficulty, int remainingFuel) {
		int usedTime = GameTimer.getInstance().getPassedTimeInSeconds();
		return difficulty + remainingFuel - usedTime * 10;
	}

}