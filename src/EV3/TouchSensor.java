package EV3;

import EV3Library.Touch;
import lejos.hardware.port.Port;

public class TouchSensor {
	
	Touch ts;
	
	/**
	 * @param port - The sensor's port.
	 */
	public TouchSensor(Port port) {
		ts = new Touch(port);
	}
	
	/**
	 * @return - True if the sensor is currently touched, false if not.
	 */
	public boolean isTouched() {
		return ts.isTouched();
	}
	
	/**
	 * Close the sensor.
	 */
	public void close() {
		ts.close();
	}
	
}
