package EV3;

import EV3Library.UltraSonic;
import lejos.hardware.port.Port;

public class UltraSonicSensor {

	UltraSonic uss;
	
	/**
	 * @param port - The sensor's port.
	 */
	public UltraSonicSensor(Port port) {
		uss = new UltraSonic(port);
	}
	
	/**
	 * @return - Distance in cm from the observed object. 
	 */
	public double distance() {
		return uss.getRange();
	}
	
	/**
	 * Close the sensor.
	 */
	public void close() {
		uss.close();
	}

}
