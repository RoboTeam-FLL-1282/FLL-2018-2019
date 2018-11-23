package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public abstract class Controller {

	private static double wheelDiameter = 6.24;
	private static double trackWidth = 10;
	static EV3LargeRegulatedMotor leftWheel = new EV3LargeRegulatedMotor(Ports.A);
	static EV3LargeRegulatedMotor rightWheel = new EV3LargeRegulatedMotor(Ports.D);
	
	/**
	 * Set the default robot details.
	 * @param wheelDiameter - The wheel width.
	 * @param trackWidth - The distance between the wheels.
	 * @param leftWheelPort - Left motor port.
	 * @param rightWheelPort - Right motor port.
	 */
	public static void setRobotDetails(double wheelDiameter, double trackWidth, Port leftWheelPort, Port rightWheelPort) {
		Controller.wheelDiameter = wheelDiameter;
		Controller.trackWidth = trackWidth;
		leftWheel = new EV3LargeRegulatedMotor(leftWheelPort);
		rightWheel = new EV3LargeRegulatedMotor(rightWheelPort);
	}
	
	/**
	 * @param wheelDiameter - The wheel width.
	 */
	public static void setWheelDiameter(double wheelDiameter) {
		Controller.wheelDiameter = wheelDiameter;
	}
	
	/**
	 * @param trackWidth - The distance between the wheels.
	 */
	public static void setTrackWidth(double trackWidth) {
		Controller.trackWidth = trackWidth;
	}
	
	/**
	 * @param leftWheelPort - Left motor port.
	 * @param rightWheelPort - Right motor port.
	 */
	public static void setMainMotors(Port leftWheelPort, Port rightWheelPort) {
		Controller.leftWheel = new EV3LargeRegulatedMotor(leftWheelPort);
		Controller.rightWheel = new EV3LargeRegulatedMotor(rightWheelPort);
	}
	
	/**
	 * @return Wheel diameter.
	 */
	public static double getWheelDiameter() {
		return wheelDiameter;
	}
	
	/**
	 * @return Track width.
	 */
	public static double getTrackWidth() {
		return trackWidth;
	}
	
	/**
	 * @return Left motor.
	 */
	public static EV3LargeRegulatedMotor getLeftWheel() {
		return Controller.leftWheel;
	}
	
	/**
	 * @return Right motor.
	 */
	public static EV3LargeRegulatedMotor getRightWheel() {
		return Controller.rightWheel;
	}

	/**
	 * Reset left motor's degrees (Tacho count).
	 */
	public static void resetLeftWheelDegrees() {
		leftWheel.resetTachoCount();
	}
	
	/**
	 * Reset right motor's degrees (Tacho count).
	 */
	public static void resetRightWheelDegrees() {
		rightWheel.resetTachoCount();
	}
	
	/**
	 * @return Left motor's degrees (Tacho count).
	 */
	public static double getLeftWheelDegrees() {
		return leftWheel.getTachoCount();
	}
	
	/**
	 * @return Right motor's degrees (Tacho count).
	 */
	public static double getRightWheelDegrees() {
		return rightWheel.getTachoCount();
	}
	
	/**
	 * Close the two motors.
	 */
	public static void close() {
		leftWheel.close();
		rightWheel.close();
	}
}
