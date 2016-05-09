package Model;

import ch.aplu.jgamegrid.Actor;

public class ActorUfo extends Actor {

	public ActorUfo() {
		super("images/IngameScreen/ufo.png");
	}

	public void act() {
		move(1);
		if (!isMoveValid())
			turn(180);
	}
	
}