package Model;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.Location;

public class ActorUfo extends Actor {

	public ActorUfo() {
		super("images/IngameScreen/ufo.png");
	}

	public void act() {
		setDirection(Location.SOUTH);
		move(1);
		setSlowDown(5);
	}
}