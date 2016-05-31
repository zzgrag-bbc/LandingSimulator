package Model;

import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;

/**
 * Adapter Klasse für den XBox Controller.
 */

public class ControllerAdapter {

	private XboxController xBoxController;
	private ActorUfo actorUfo;

	/**
	 * Erstellt einen neuen Controller Adapter.
	 * @param ufo Braucht Wert Ufo.
	 */
	
	public ControllerAdapter(ActorUfo ufo) {

		xBoxController = new XboxController();
		actorUfo = ufo;

		if (!xBoxController.isConnected()) {
			JOptionPane.showMessageDialog(null, "Xbox controller not connected.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);
			xBoxController.release();
			return;
		}
		
		/**
		 * Funktionalität des Controllers.
		 */
		
		xBoxController.addXboxControllerListener(new XboxControllerAdapter() {
			double da = 0.4;
			public void dpad(int direction, boolean pressed) {
				switch (direction){
				case 0:
					actorUfo.setAccelerationY(actorUfo.getAccelerationY() - da);
					actorUfo.setThrustLevel(actorUfo.getThrustLevel() + 1);
					break;
				case 4:
					actorUfo.setAccelerationY(actorUfo.getAccelerationY() + da);
					actorUfo.setThrustLevel(actorUfo.getThrustLevel() - 1);
					if (actorUfo.getAccelerationY() > actorUfo.getAmax()) {
						actorUfo.setAccelerationY(actorUfo.getAmax());
						actorUfo.setThrustLevel(0);
					}
					break;
				case 6:	
					if (actorUfo.getAccelerationX() > 0) {
						actorUfo.setAccelerationX(0);
					}
					actorUfo.setAccelerationX(actorUfo.getAccelerationX() - da);
					break;
				case 2:
					if (actorUfo.getAccelerationX() < 0) {
						actorUfo.setAccelerationX(0);
					}
					actorUfo.setAccelerationX(actorUfo.getAccelerationX() + da);
					break;
				}
			}
		});

	}
}