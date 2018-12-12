package Motion;

import EV3.MoveTank;
import Tools.Alert;

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
	public static void align(int speed) {
		
		blackValue = Aligner.blackValue;
		
		if(blackValue == Double.NaN) {
			Alert.notify("The black value is not set!");
		}
		
		while(Aligner.leftSensor.reflectedLight()>blackValue && Aligner.rightSensor.reflectedLight()>blackValue) {
			MoveTank.on(speed, speed);
		}

		if(Aligner.leftSensor.reflectedLight()<blackValue) {
			while(Aligner.rightSensor.reflectedLight()>blackValue) {
				MoveTank.on(speed, 0);
			}
			MoveTank.off();

		}
		else {
			while(Aligner.leftSensor.reflectedLight()>blackValue) {
				MoveTank.on(0, speed);
			}
			MoveTank.off();
		}
	}
}
