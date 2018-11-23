package EV3;

import EV3Library.Colour;
import lejos.hardware.port.Port;
import lejos.robotics.Color;

public class ColorSensor { // Done!
	
	Colour cs;
	
	public ColorSensor(Port port) {
		cs = new Colour(port);
	}

	public void setColorMode() {
		cs.setRGBMode();
	}
	
	public void setAmbientLightMode() {
		cs.setAmbientMode();
	}
	
	public void setReflectedLightMode() {
		cs.setRedMode();
	}
	
	public Color color() {
		return cs.getColor(); 
	}
	
	public double ambientLight() {
		cs.setFloodLight(false);
		return cs.getAmbient();
	}
	
	public double reflectedLight() {
		cs.setFloodLight(true);
		return cs.getRed();
	}

	public void close() {
		cs.close();
	}
}
