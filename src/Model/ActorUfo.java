package Model;

import java.awt.Point;
import java.awt.event.KeyEvent;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGKeyListener;
import ch.aplu.jgamegrid.Location;
import view.MenuPanelContent.FuelPanel;

/**
 * JGameGrid Actor Ufo.
 */
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

	/**
	 * Stellt die velocity sowie acceleration zurück auf null.
	 */
	
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

	/**
	 * Setzt dass Ufo in Bewegung.
	 */
	
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
	}
	
	/**
	 * Ist für die Steuerung zuständig. Funktioniert mit der Tastatur.
	 */

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

	/**
	 * Begrenzung des Thrusts.
	 * @param i Thurst Level.
	 */
	
	private void setThrust(int i) {
		if (i < 0) {
			i = 0;
		}

		if (i > 8) {
			i = 8;
		}
	}

	/**
	 * Setter für die Steuerung des XBox Controllers.
	 * @param accelerationY Beschleunigung nach Y Achse.
	 */
	
	public void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}
	
	/**
	 * Setter für die Steuerung des XBox Controllers.
	 * @param accelerationX Beschleunigung nach X Achse.
	 */

	public void setAccelerationX(double accelerationX) {
		this.accelerationX = accelerationX;
	}
	
	/**
	 * Getter für die Steuerung des XBox Controllers.
	 * @return Gibt Wert für Controller zurück.
	 */

	public double getAmax() {
		return amax;
	}
	
	/**
	 * Getter für die Steuerung des XBox Controllers.
	 * @return Gibt Richtung für Controller zurück. Y Achse.
	 */

	public double getAccelerationX() {
		return accelerationX;
	}
	
	/**
	 * Getter für die Steuerung des XBox Controllers.
	 * @return Gibt Richtung für Controller zurück. X Achse.
	 */

	public double getAccelerationY() {
		return accelerationY;
	}
	
	/**
	 * Getter für die Steuerung des XBox Controllers.
	 * @return Gibt Thurst Level zurück.
	 */

	public int getThrustLevel() {
		return thrustLevel;
	}
	
	/**
	 * Setter für die Steuerung des XBox Controllers.
	 * @param thrustLevel Setzt Thrust Level.
	 */

	public void setThrustLevel(int thrustLevel) {
		this.thrustLevel = thrustLevel;
	}
	
	/**
	 * Getter für die Steuerung des XBox Controllers.
	 * @return Erhält Fuel Wert.
	 */
	
	public int getFuel() {
		 return (int) fuel;
	}
}