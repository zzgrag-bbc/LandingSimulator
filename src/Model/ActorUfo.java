package Model;

import java.awt.Point;
import java.awt.event.KeyEvent;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGKeyListener;
import ch.aplu.jgamegrid.Location;
import view.MenuPanelContent.FuelPanel;

public class ActorUfo extends Actor implements GGKeyListener {

	private final double startFuel = 700; // Amount of fuel at start
	private final double fuelFactor = 0.5; // Fuel consumption per simulation
	private final double amax = 1.6; // Free acceleration on moon
	private double x; // Position in left direction
	private double y; // Position in downward direction
	private double velocityX; // Speed in horizontal direction
	private double velocityY; // Speed in vertical direction
	private double accelerationX; // Acceleration in horizontal direction
	private double accelerationY; // Acceleration in vertical direction
	private int thrustLevel; // Thrust level
	private double fuel; // Remaining fuel
	private boolean isLanded = false; // Boolean for checking if UFO is already landed
	private double simulationPeriod;

	public ActorUfo(double simulationPeriod) {
		super(false, "images/IngameScreen/ufo.png", 2);
		setCollisionCircle(new Point(1, 1), 42);
		this.simulationPeriod = simulationPeriod;
		new ControllerAdapter(this);
	}

	// Reset Method always called before starting
	public void reset() {

		setDirection(Location.SOUTH);
		x = getLocationStart().x;
		y = getLocationStart().y;
		velocityX = 0;
		velocityY = 0;
		accelerationX = 0;
		accelerationY = amax;
		fuel = startFuel;
		setActEnabled(true);

		isLanded = false;
	}

	public void act() {

		setDirection(Location.SOUTH);
		move(1);
		setSlowDown(2);
		FuelPanel.getFuel().setValue((int) fuel);

		double dtx = 2 * simulationPeriod / 1000.0; // Time scaled: * 2
		double dty = 2 * simulationPeriod / 1000.0; // Time scaled: * 2

		velocityX = velocityX + accelerationX * dtx;
		velocityY = velocityY + accelerationY * dty;
		x = x + velocityX * dtx;
		y = y + velocityY * dty;
		setLocation(new Location((int) x, (int) y));
		fuel = fuel - thrustLevel * fuelFactor;

		if (fuel <= 0) {
			fuel = 0;
			thrustLevel = 0;
			accelerationX = 0;
			accelerationY = amax;
			setThrust(0);
		}

//		if (getLocation().y > 490 && !isLanded) {
//
//			if (velocityY > 10.0) {
//				ufoCrashed.setLocation(new Location(getLocation().x, getLocation().y + 30));
//				ufoCrashed.show();
//				hide();
//			}
//			setActEnabled(false);
//			thrustLevel = 0;
//			setThrust(0);
//			isLanded = true;
//		}
	}

	public boolean keyPressed(KeyEvent evt) {

		if (!gameGrid.isRunning())
			return true;

		if (isLanded) {
			reset();
			gameGrid.doRun();
			return true;
		}

		double da = 0.4;
		switch (evt.getKeyCode()) {

		case KeyEvent.VK_UP:
			accelerationY -= da;
			thrustLevel += 1;
			break;

		case KeyEvent.VK_DOWN:
			accelerationY += da;
			thrustLevel -= 1;
			if (accelerationY > amax) {
				accelerationY = amax;
				thrustLevel = 0;
			}
			break;

		case KeyEvent.VK_LEFT:
			if (accelerationX > 0) {
				accelerationX = 0;
			}
			accelerationX -= da;
			break;

		case KeyEvent.VK_RIGHT:
			if (accelerationX < 0) {
				accelerationX = 0;
			}
			accelerationX += da;
			break;
		}

		if (accelerationY == amax) {
			setThrust(0);
		}

		else {
			setThrust(thrustLevel);
		}

		return true; // Consume
	}

	public boolean keyReleased(KeyEvent evt) {
		return true;
	}

	private void setThrust(int i) {
		if (i < 0) {
			i = 0;
		}

		if (i > 8) {
			i = 8;
		}
	}

	public void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}

	public void setAccelerationX(double accelerationX) {
		this.accelerationX = accelerationX;
	}

	public double getAmax() {
		return amax;
	}

	public double getAccelerationX() {
		return accelerationX;
	}

	public double getAccelerationY() {
		return accelerationY;
	}

	public int getThrustLevel() {
		return thrustLevel;
	}

	public void setThrustLevel(int thrustLevel) {
		this.thrustLevel = thrustLevel;
	}
	
	public int getFuel() {
		 return (int) fuel;
	}
}