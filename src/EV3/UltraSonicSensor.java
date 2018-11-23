package EV3;

import EV3Library.UltraSonic;
import lejos.hardware.port.Port;

public class UltraSonicSensor { // Done!

	UltraSonic uss;
	
	public UltraSonicSensor(Port port) {
		uss = new UltraSonic(port);
	}
	
	public double distance() {
		return uss.getRange();
	}
	
	public void close() {
		uss.close();
	}

}
