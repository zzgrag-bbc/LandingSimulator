package Model;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import view.MenuPanelContent.TimerPanel;

/*
 * Singleton-Pattern
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
	
	private GameTimer() {}
	
	private String sekunden = "00";
	private int sekundenZähler = 0;
	private String minuten = "00";
	private int minutenZähler = 0;
	private String stunden = "00";
	private int stundenZähler = 0;
	private TimerTask task;
	private TimerPanel timerPanel;

	public void setTimerPanel(TimerPanel timerPanel)
	{
		this.timerPanel = timerPanel;
	}
	
	public void start() {
		
		Timer timer = new Timer();
		task = new TimerTask() {
			public void run() {
				GameTimer.this.upateAndGetFormatedTime();
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public void stopTimer()
	{
		task.cancel();
	}

	private void upateAndGetFormatedTime() {

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