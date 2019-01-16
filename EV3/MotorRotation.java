package EV3;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.Port;

public class MotorRotation {
	
	UnregulatedMotor motor;
	
	/**
	 * @param port - The motor's port.
	 */
	public MotorRotation(Port port) {
		motor = new UnregulatedMotor(port);
	}
	
	/**
	 * @return - Current tacho count.
	 */
	public double degrees() {
		return motor.getTachoCount();
	}
	
	/**
	 * @return - Current rotations measure.
	 */
	public double rotations() {
		return motor.getTachoCount()/360.0;
	}
	
	/**
	 * Reset tacho count.
	 */
	public void reset() {
		motor.resetTachoCount();
	}
	
	/**
	 * Close the motor.
	 */
	public void close() {
		motor.close();
	}
}
