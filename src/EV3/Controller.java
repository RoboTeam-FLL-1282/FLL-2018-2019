package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public abstract class Controller { // Fine...

	private static double wheelDiameter = 6.24;
	private static double trackWidth = 10;
	static EV3LargeRegulatedMotor leftWheel = new EV3LargeRegulatedMotor(Ports.A);
	static EV3LargeRegulatedMotor rightWheel = new EV3LargeRegulatedMotor(Ports.D);
	
	public static void setRobotDetails(double wheelDiameter, double trackWidth, Port leftWheelPort, Port rightWheelPort) {
		Controller.wheelDiameter = wheelDiameter;
		Controller.trackWidth = trackWidth;
		leftWheel = new EV3LargeRegulatedMotor(leftWheelPort);
		rightWheel = new EV3LargeRegulatedMotor(rightWheelPort);
	}
	
	public static void setWheelDiameter(double wheelDiameter) {
		Controller.wheelDiameter = wheelDiameter;
	}
	
	public static void setTrackWidth(double trackWidth) {
		Controller.trackWidth = trackWidth;
	}
	
	public static void setMainMotors(Port leftWheelPort, Port rightWheelPort) {
		Controller.leftWheel = new EV3LargeRegulatedMotor(leftWheelPort);
		Controller.rightWheel = new EV3LargeRegulatedMotor(rightWheelPort);
	}
	
	public static double getWheelDiameter() {
		return wheelDiameter;
	}
	
	public static double getTrackWidth() {
		return trackWidth;
	}
	
	public static EV3LargeRegulatedMotor getLeftWheel() {
		return Controller.leftWheel;
	}
	
	public static EV3LargeRegulatedMotor getRightWheel() {
		return Controller.rightWheel;
	}

	public static void resetLeftWheelDegrees() {
		leftWheel.resetTachoCount();
	}
	
	public static void resetRightWheelDegrees() {
		rightWheel.resetTachoCount();
	}
	
	public static double getLeftWheelDegrees() {
		return leftWheel.getTachoCount();
	}
	
	public static double getRightWheelDegrees() {
		return rightWheel.getTachoCount();
	}
	
	public static void close() {
		leftWheel.close();
		rightWheel.close();
	}
}
