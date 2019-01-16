package Motion;

import EV3.ColorSensor;
import lejos.hardware.port.Port;

public class Aligner {

	// Members
	static double blackValue = 0.09;
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
	
	public static double getLeftSensorValue(Colors color) {
		int precision = (color == Colors.BLACK)?(blackValue+"").length()-2:(blackValue+"").length()-2;
		return LineAlignment.precision(leftSensor.reflectedLight(), precision);
	}
	
	public static double getRightSensorValue(Colors color) {
		int precision = (color == Colors.BLACK)?(blackValue+"").length()-2:(blackValue+"").length()-2;
		return LineAlignment.precision(Unique.colorConvertor(rightSensor.reflectedLight(), color), precision);
	}
	
}
