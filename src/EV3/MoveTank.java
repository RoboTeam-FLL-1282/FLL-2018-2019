package EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;
public abstract class MoveTank { // Done!

	static EV3LargeRegulatedMotor leftWheel;
	static EV3LargeRegulatedMotor rightWheel;
	
	public static void setMainMotors(Port leftMotorPort, Port rightMotorPort) {
		leftWheel = new EV3LargeRegulatedMotor(leftMotorPort);
		rightWheel = new EV3LargeRegulatedMotor(rightMotorPort);
	}
	
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

	public static void onForCent(int leftSpeed, int rightSpeed, double dis, boolean brakeAtEnd) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
		Delay.msDelay((long)(dis/leftSpeed)*1000);
		if(brakeAtEnd) {
			leftWheel.stop(true);
			rightWheel.stop(true);
		}
	}

	public static void on(int leftSpeed, int rightSpeed) {
		leftWheel.setSpeed(leftSpeed);
		rightWheel.setSpeed(rightSpeed);
		move(leftSpeed, rightSpeed);
	}

	public static void off() {
		leftWheel.stop(true);
		rightWheel.stop(true);
	}

	// Use when the motor is no longer needed.
	public static void close() {
		leftWheel.close();
		rightWheel.close();
	}

}
