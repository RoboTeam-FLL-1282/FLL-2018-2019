package EV3;

import EV3Library.Touch;
import lejos.hardware.port.Port;

public class TouchSensor { // Done!
	
	Touch ts;
	
	public TouchSensor(Port port) {
		ts = new Touch(port);
	}
	
	public boolean isTouched() {
		return ts.isTouched();
	}
	
	public void close() {
		ts.close();
	}
	
}
