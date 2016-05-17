package Model;

import java.util.Timer;
import java.util.TimerTask;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGMouse;
import ch.aplu.jgamegrid.GGMouseListener;
import view.View;

public class ActorStartButton extends Actor implements GGMouseListener {

	public ActorStartButton() {
		super("images/Menupanel/ButtonIngameStart.png");
	}

	public void act() {
		startTimer();
		View.getPlayPanel().startUfo();
	}

	public void startTimer() {
		final Timer timer = new Timer();
		final Zeit z = new Zeit();
		z.setEin(0);
		final TimerTask task = new TimerTask() {
			public void run() {
				if (Zeit.getAus() == 1) {
					timer.cancel();
				} else {
					z.macheZeit();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
		setActEnabled(false);
	}

	@Override
	public boolean mouseEvent(GGMouse arg0) {
		startTimer();
		View.getPlayPanel().startUfo();
		return false;
	}
}
