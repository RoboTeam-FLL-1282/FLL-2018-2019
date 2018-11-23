package Motion;

import EV3.ColorSensor;
import EV3.MoveTank;
import lejos.hardware.port.Port;

public class BlackLineAlignment {

	/**
	 * The robot drives until it recognizes a black line.
	 * Then it aligns on the black line using two color sensors.
	 * @param speed
	 * @param port1
	 * @param port2
	 * @param blackValue
	 */
	public void align(int speed, Port port1, Port port2, double blackValue) {

		ColorSensor leftSensor = new ColorSensor(port1);
		leftSensor.setReflectedLightMode();
		ColorSensor rightSensor = new ColorSensor(port2);
		rightSensor.setReflectedLightMode();
		while(leftSensor.reflectedLight()>blackValue && rightSensor.reflectedLight()>blackValue) {
			MoveTank.on(speed, speed);
		}

		if(leftSensor.reflectedLight()<blackValue) {
			while(rightSensor.reflectedLight()>blackValue) {
				MoveTank.on(0, speed);
			}
			MoveTank.off();

		}else {
			while(leftSensor.reflectedLight()>blackValue) {
				MoveTank.on(speed, 0);
			}
			MoveTank.off();
		}
	}
}
