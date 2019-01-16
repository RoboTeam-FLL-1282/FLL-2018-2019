package EV3;
import EV3Library.Gyro;
import lejos.hardware.port.Port;

public class GyroSensor {

	Gyro gs;
	
	/**
	 * @param port - The sensor's port.
	 */
	public GyroSensor(Port port) {
		gs = new Gyro(port);
	}
	
	/**
	 * @return - The current angle measured by the sensor. 
	 */
	public double angle() {
		return gs.getAngle();
	}
	
	/**
	 * @return - The angular velocity that currently measured by the sensor.
	 */
	public double rate() {
		return gs.getAngularVelocity();
	}
	
	/**
	 * Reset the sensor. The rate and the angle will turn to be zero.
	 */
	public void reset() {
		gs.reset();
	}
	
	/**
	 * Recalibrates the sensor. Might take a few seconds. 
	 */
	public void recalibrate() {
		gs.resetGyro();
	}
	
	/**
	 * Close the sensor.
	 */
	public void close() {
		gs.close();
	}
}
