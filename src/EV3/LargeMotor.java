package EV3;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class LargeMotor {// Done!

	EV3LargeRegulatedMotor motor;

	public LargeMotor(Port port) {
		motor = new EV3LargeRegulatedMotor(port);
	}

	public void onForRotations(int speed, int rotations, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay(((rotations*360)/speed)*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}

	public void onForDegrees(int speed, int degrees, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay((degrees/speed)*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}
	
	public void onForSeconds(int speed, int seconds, boolean brakeAtEnd) {

		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.

		// Wait:
		Delay.msDelay(seconds*1000);

		// Break at end?
		if(brakeAtEnd) {
			motor.stop();
		}

	}
	
	public void on(int speed) {
		
		// Set motor speed in degrees/second
		motor.setSpeed(speed);
		motor.forward();	// Starts rotation.
		
	}
	
	public void off() {
		
		// Stop motor.
		motor.stop();
		
	}
	
	// Use when the motor is no longer needed.
	public void close() {
		motor.close();
	}

	public double getSpeed() {
		return motor.getSpeed();
	}
	
}
