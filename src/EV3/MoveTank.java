package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;
public abstract class MoveTank {

	static EV3LargeRegulatedMotor leftMotor;
	static EV3LargeRegulatedMotor rightMotor;
	
	/**
	 * Must be called before any other method.
	 * @param leftMotorPort - Left motor's port.
	 * @param rightMotorPort - Right motor's port.
	 */
	public static void setMainMotors(Port leftMotorPort, Port rightMotorPort) {
		leftMotor = new EV3LargeRegulatedMotor(leftMotorPort);
		rightMotor = new EV3LargeRegulatedMotor(rightMotorPort);
	}
	
	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 */
	private static void move(float leftSpeed, float rightSpeed) {
		if(leftSpeed > 0)
			leftMotor.forward();
		else
			leftMotor.backward();
		if(rightSpeed > 0)
			rightMotor.forward();
		else
			rightMotor.backward();
	}
	
	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param rotations
	 * @param brakeAtEnd
	 */
	public static void onForRotations(int leftSpeed, int rightSpeed, int rotations, boolean brakeAtEnd) {
		leftMotor.setSpeed(leftSpeed);
		rightMotor.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay(((rotations*360)/leftSpeed)*1000);
		if(brakeAtEnd) {
			leftMotor.stop(true);
			rightMotor.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param degrees
	 * @param brakeAtEnd
	 */
	public static void onForDegrees(float leftSpeed, float rightSpeed, double degrees, boolean brakeAtEnd) {
		leftMotor.setSpeed(Math.abs(leftSpeed));
		rightMotor.setSpeed(Math.abs(rightSpeed));
		move(leftSpeed, rightSpeed);
		Delay.msDelay((int)((degrees/Math.abs(rightSpeed))*1000));
		if(brakeAtEnd) {
			leftMotor.stop(true);
			rightMotor.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param seconds
	 * @param brakeAtEnd
	 */
	public static void onForSeconds(double leftSpeed, double rightSpeed, double seconds, boolean brakeAtEnd) {
		leftMotor.setSpeed((float)Math.abs(leftSpeed));
		rightMotor.setSpeed((float)Math.abs(rightSpeed));
		move((float)leftSpeed, (float)rightSpeed);
		Delay.msDelay((int)(seconds*1000));
		if(brakeAtEnd) {
			leftMotor.stop(true);
			rightMotor.stop(true);
		}
	}

	/**
	 * @param leftSpeed
	 * @param rightSpeed
	 * @param dis
	 * @param brakeAtEnd
	 */
	public static void onForCent(int leftSpeed, int rightSpeed, double distance, boolean brakeAtEnd) {
		leftMotor.setSpeed(Math.abs(leftSpeed));
		rightMotor.setSpeed(Math.abs(rightSpeed));
		move(leftSpeed, rightSpeed);
		Delay.msDelay((int)((distance/Math.abs(leftSpeed))*1000));
		if(brakeAtEnd) {
			leftMotor.stop(true);
			rightMotor.stop(true);
		}
	}

	/**
	 * Immediately returns.
	 * @param leftSpeed
	 * @param rightSpeed
	 */
	public static void on(int leftSpeed, int rightSpeed) {
		leftMotor.setSpeed(Math.abs(leftSpeed));
		rightMotor.setSpeed(Math.abs(rightSpeed));
		move(leftSpeed, rightSpeed);
	}

	/**
	 * Stops the motors.
	 */
	public static void off() {
		leftMotor.stop(true);
		rightMotor.stop(true);
	}

	/**
	 * Use when the motor is no longer needed.
	 */
	public static void close() {
		leftMotor.close();
		rightMotor.close();
	}

}
