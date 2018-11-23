package EV3;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.Port;

public class MotorRotation {// Done!
	
	UnregulatedMotor motor;
	
	public MotorRotation(Port port) {
		motor = new UnregulatedMotor(port);
	}
	
	public double degrees() {
		return motor.getTachoCount();
	}
	
	public double rotations() {
		return motor.getTachoCount()/360.0;
	}
	
	public void reset() {
		motor.resetTachoCount();
	}
	
	public void close() {
		motor.close();
	}
}
