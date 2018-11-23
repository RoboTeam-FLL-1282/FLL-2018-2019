package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;
public abstract class MoveTank {

	static EV3LargeRegulatedMotor leftWheel;
	static EV3LargeRegulatedMotor rightWheel;
	
	/**
	 * Must be called before any other method.
	 * @param leftMotorPort - Left motor's port.
	 * @param rightMotorPort - Right motor's port.
	 */
	public static void setMainMotors(Port leftMotorPort, Port rightMotorPort) {
		leftWheel = new EV3LargeRegulatedMotor(leftMotorPort);
		rightWheel = new EV3LargeRegulatedMotor(rightMotorPort);
	}
	
	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 */
	private static void move(int leftSpeed, int rightSpeed) {
		if(leftSpeed > 0)
			leftWheel.forward();
		else
			leftWheel.backward();
		if(rightSpeed > 0)
			rightWheel.forward();
		else
			rightWheel.backward();
	}
	
	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param rotations
	 * @param brakeAtEnd
	 */
	public static void onForRotations(int leftSpeed, int rightSpeed, int rotations, boolean brakeAtEnd) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay(((rotations*360)/leftSpeed)*1000);
		if(brakeAtEnd) {
			leftWheel.stop(true);
			rightWheel.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param degrees
	 * @param brakeAtEnd
	 */
	public static void onForDegrees(int leftSpeed, int rightSpeed, int degrees, boolean brakeAtEnd) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay((degrees/leftSpeed)*1000);
		if(brakeAtEnd) {
			leftWheel.stop(true);
			rightWheel.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param seconds
	 * @param brakeAtEnd
	 */
	public static void onForSeconds(int leftSpeed, int rightSpeed, int seconds, boolean brakeAtEnd) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay(seconds*1000);
		if(brakeAtEnd) {
			leftWheel.stop(true);
			rightWheel.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param dis
	 * @param brakeAtEnd
	 */
	public static void onForCent(int leftSpeed, int rightSpeed, double distance, boolean brakeAtEnd) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay((long)(distance/leftSpeed)*1000);
		if(brakeAtEnd) {
			leftWheel.stop(true);
			rightWheel.stop(true);
		}
	}

	/**
	 * Immediately returns.
	 * @param leftSpeed
	 * @param rightSpeed
	 */
	public static void on(int leftSpeed, int rightSpeed) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
	}

	/**
	 * Stops the motors.
	 */
	public static void off() {
		leftWheel.stop(true);
		rightWheel.stop(true);
	}

	/**
	 * Use when the motor is no longer needed.
	 */
	public static void close() {
		leftWheel.close();
		rightWheel.close();
	}

}
