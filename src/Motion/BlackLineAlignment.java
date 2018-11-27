package Motion;

import EV3.ColorSensor;
import EV3.MoveTank;
import Tools.Alert;
import lejos.hardware.port.Port;

public class BlackLineAlignment {

	static double blackValue = Double.NaN;
	
	/**
	 * @param blackValue - The value that the sensor returns when it sees the black line.
	 * It can also be any other color value.
	 */
	public static void setBlackValue(double blackValue) {
		BlackLineAlignment.blackValue = blackValue;
	}
	
	/**
	 * The robot drives until it recognizes a black line.
	 * Then it aligns on the black line using two color sensors.
	 * @param speed
	 * @param leftPort
	 * @param rightPort
	 */
	public static void align(int speed, Port leftPort, Port rightPort) {
		
		if(blackValue == Double.NaN) {
			Alert.notify("The black value is not set!");
		}
		
		ColorSensor leftSensor = new ColorSensor(leftPort);
		leftSensor.setReflectedLightMode();
		ColorSensor rightSensor = new ColorSensor(rightPort);
		rightSensor.setReflectedLightMode();
		while(leftSensor.reflectedLight()>blackValue && rightSensor.reflectedLight()>blackValue) {
			MoveTank.on(speed, speed);
		}

		if(leftSensor.reflectedLight()<blackValue) {
			while(rightSensor.reflectedLight()>blackValue) {
				MoveTank.on(0, speed);
			}
			MoveTank.off();

		}
		else {
			while(leftSensor.reflectedLight()>blackValue) {
				MoveTank.on(speed, 0);
			}
			MoveTank.off();
		}
	}
}
