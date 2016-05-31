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
	 * @param difficultyScore Braucht Difficulty Wert.
	 * @param remainingFuel Braucht übrigen Fuel Wert.
	 */
	
	public void updateScore(int difficultyScore, int remainingFuel) {
		scorePanel.updateScore(calculateScore(difficultyScore, remainingFuel));
	}
	
	/**
	 * Rechnet den Score aus.
	 * @param difficulty Braucht Difficulty Wer.
	 * @param remainingFuel Braucht übrigen Fuel Wert.
	 * @return Gibt Score Wert zurück.
	 */

	private int calculateScore(int difficulty, int remainingFuel) {
		int usedTime = GameTimer.getInstance().getPassedTimeInSeconds();
		return difficulty + remainingFuel - usedTime * 10;
	}

}