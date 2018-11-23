package EV3;

import lejos.hardware.Button;

public abstract class BrickLight {

	/**
	 * Turns on the brick's LEDs. 
	 * @param color - An integer that specifies the LED's color. 
	 */
	public static void on(int color) {
		Button.LEDPattern(color);
	}
	
	/**
	 * Turns off the brick's LEDs.
	 */
	public static void off() {
		Button.LEDPattern(0);
	}
	
}
