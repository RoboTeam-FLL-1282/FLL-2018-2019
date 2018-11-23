package EV3;

import lejos.hardware.Button;

public abstract class BrickLight { // Done!

	public static void on(int color) {
		Button.LEDPattern(color);
	}
	
	public static void off() {
		Button.LEDPattern(0);
	}
	
}
