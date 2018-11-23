package EV3;

import lejos.hardware.motor.Motor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.utility.Delay;

public class MediumMotor {// Done!
	NXTRegulatedMotor motor;

	public MediumMotor(String port) {
		motor = stringToPort(port);
	}

	private NXTRegulatedMotor stringToPort(String port) {
		switch(port){
			case "a":
				return Motor.A;
			case "b":
				return Motor.B;
			case "c":
				return Motor.C;
			case "d":
				return Motor.D;
			case "A":
				return Motor.A;
			case "B":
				return Motor.B;
			case "C":
				return Motor.C;
			case "D":
				return Motor.D;
		}
		return null;
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
		
		if(speed >= 0)
			motor.forward();	// Starts rotation.
		else
			motor.backward();
		
		
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
