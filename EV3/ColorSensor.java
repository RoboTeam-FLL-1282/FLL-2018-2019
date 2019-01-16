package EV3;

import EV3Library.Colour;
import lejos.hardware.port.Port;
import lejos.robotics.Color;

public class ColorSensor {
	
	Colour cs;
	
	/**
	 * @param port - Sensor's port.
	 */
	public ColorSensor(Port port) {
		cs = new Colour(port);
	}

	/**
	 * Set the sensor to a color mode (RGB).
	 */
	public void setColorMode() {
		cs.setRGBMode();
	}
	
	/**
	 * Set the sensor to an ambient light mode.
	 */
	public void setAmbientLightMode() {
		cs.setAmbientMode();
	}
	
	/**
	 * Set the sensor to a reflected light mode.
	 */
	public void setReflectedLightMode() {
		cs.setRedMode();
	}
	
	/**
	 * setColorMode() must be called first.
	 * @return - Color object. 
	 */
	public Color color() {
		return cs.getColor(); 
	}
	
	/**
	 * setAmbientLightMode() must be called first.
	 * @return - A value between 0 and 1.
	 */
	public double ambientLight() {
		cs.setFloodLight(false);
		return cs.getAmbient();
	}
	
	/**
	 * setReflectedLightMode() must be called first.
	 * @return - A value between 0 and 1.
	 */
	public double reflectedLight() {
		cs.setFloodLight(true);
		return cs.getRed();
	}

	/**
	 * Close the sensor.
	 */
	public void close() {
		cs.close();
	}
}
