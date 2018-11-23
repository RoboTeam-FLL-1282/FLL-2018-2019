package EV3;
import EV3Library.*;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
public abstract class Display {
	
	/**
	 * Set the screen before displaying on it.
	 * Should only be called once.
	 */
	public static void setScreen() {
		LCD.clear();
		Delay.msDelay(500);
	}
	
	/**
	 * Displays text on the screen.
	 * @param text
	 * @param x
	 * @param y
	 */
	public static void text(String text, int x, int y) {
		TextUtils.realDrawString(text, x, y);
	}
	
	/**
	 * Clears the screen.
	 */
	public static void resetScreen() {
		LCD.clear();
	}
}
