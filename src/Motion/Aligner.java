package Motion;

import EV3.ColorSensor;
import lejos.hardware.port.Port;

public class Aligner {

	// Members
	static double blackValue = 0.08;
	static double whiteValue = 0.9;
	public static ColorSensor leftSensor;
	public static ColorSensor rightSensor;
	
	/**
	 * @param blackValue
	 */
	public static void setBlackValue(double blackValue) {
		Aligner.blackValue = blackValue;
	}
	
	/**
	 * @param whiteValue
	 */
	public static void setWhiteValue(double whiteValue) {
		Aligner.whiteValue = whiteValue;
	}
	
	/**
	 * Set Color Sensor's ports.
	 * @param leftPort
	 * @param rightPort
	 */
	public static void setSensorsPorts(Port leftPort, Port rightPort) {
		leftSensor = new ColorSensor(leftPort);
		rightSensor = new ColorSensor(rightPort);
		leftSensor.setReflectedLightMode();
		rightSensor.setReflectedLightMode();
		leftSensor.reflectedLight();
		rightSensor.reflectedLight();
	}
	
}
