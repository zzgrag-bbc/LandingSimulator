package Model;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import view.MenuPanelContent.TimerPanel;

/**
 * Funktionalität des Timers.
 */

public class GameTimer {

	private static GameTimer instance;
	
	public static GameTimer getInstance()
	{
		if (instance == null)
		{
			instance = new GameTimer();
		}
		
		return instance;
	}

	private int sekundenZähler = 0;
	private int minutenZähler = 0;
	private int stundenZähler = 0;
	private TimerTask task;
	private TimerPanel timerPanel;

	/**
	 * Setter für Timer Panel.
	 * @param timerPanel
	 */
	
	public void setTimerPanel(TimerPanel timerPanel)
	{
		this.timerPanel = timerPanel;
	}
	
	/**
	 * Startet den Timer.
	 */
	
	public void start() {
		
		Timer timer = new Timer();
		task = new TimerTask() {
			public void run() {
				GameTimer.this.upateAndGetFormatedTime();
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	/**
	 * Lässt den Timer stoppen.
	 */
	
	public void stopTimer()
	{
		task.cancel();
	}

	/**
	 * Wandelt vergagene Zeit in Sekunden um.
	 * @return
	 */

	
	public int getPassedTimeInSeconds()
	{
		return sekundenZähler + (minutenZähler * 60) + (stundenZähler * 60 * 60);
	}
	
	/**
	 * Formattiert und updated Zeit.
	 */
	
	private void upateAndGetFormatedTime() {

		String sekunden = "00";
		String stunden = "00";
		String minuten = "00";
		
		sekundenZähler++;
		if (sekundenZähler <= 59) {
			DecimalFormat df = new DecimalFormat("00");
			sekunden = df.format(sekundenZähler);
		} else {
			sekundenZähler = 0;
			minutenZähler++;
		}

		if (minutenZähler <= 59) {
			DecimalFormat df = new DecimalFormat("00");
			minuten = df.format(minutenZähler);
		} else {
			minutenZähler = 0;
			stundenZähler++;
		}

		DecimalFormat df = new DecimalFormat("00");
		stunden = df.format(stundenZähler);

		String timeOutput = " " + stunden + ":" + minuten + ":" + sekunden;
		
		// The Gui is only updated in case that setTimerPanel is called.
		if (timerPanel != null)
		{
			timerPanel.setTimerText(timeOutput);
		}
	}
}