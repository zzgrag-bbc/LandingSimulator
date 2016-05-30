package Model;

import view.MenuPanelContent.ScorePanel;

/**
 * Rechnet den Score aus, verwendet Timer, gewählte Plattform sowie verbrauchtes Fuel.
 */

public class ScoreCalculator {

	private ScorePanel scorePanel;

	public ScoreCalculator(ScorePanel scorePanel) {
		this.scorePanel = scorePanel;
	}

	/**
	 * Updated den Score.
	 * @param difficultyScore
	 * @param remainingFuel
	 */
	
	public void updateScore(int difficultyScore, int remainingFuel) {
		scorePanel.updateScore(calculateScore(difficultyScore, remainingFuel));
	}
	
	/**
	 * Rechnet den Score aus.
	 * @param difficulty
	 * @param remainingFuel
	 * @return
	 */

	private int calculateScore(int difficulty, int remainingFuel) {
		int usedTime = GameTimer.getInstance().getPassedTimeInSeconds();
		return difficulty + remainingFuel - usedTime * 10;
	}

}