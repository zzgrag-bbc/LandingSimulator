package Model;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.util.Monitor;

public class GameOverScreen implements GGActorCollisionListener {

	@Override
	public int collide(Actor arg0, Actor arg1) {
		Monitor.wakeUp();
		System.out.println("Game Over");
		return 0;
	}
}