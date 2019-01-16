package Tools;

import EV3.BrickLight;
import EV3.Display;
import EV3.Wait;
import lejos.hardware.Sound;

public abstract class Alert {

	private static int line =  0;
	
	/**
	 * Makes a beep, turns on red light and displays a message.
	 * @param message
	 */
	public static void notify(String message) {
		
		// Beep
		Sound.beep();
	
		// Brick lights
		BrickLight.on(2);
		
		// Display message
		Display.resetScreen();
		Display.text(message, 0, 0);
		
	}
	
	/**
	 * Makes a beep, turns on red light and displays a message.
	 * @param message
	 * @param delay - How much time (in Milliseconds) to stop the program.
	 */
	public static void notify(String message, int delay) {

		// Beep
		Sound.beep();
	
		// Brick lights
		BrickLight.on(2);
		
		// Display message
		Display.resetScreen();
		Display.text(message, 0, 0);
		
		// Wait:
		Wait.time(delay);
	}
	
	/**
	 * Adds a name - value text to the screen.
	 * Every new call adds a new line.
	 * Good for debugging.
	 * @param name
	 * @param value
	 */
	public static void view(String name, double value) {
		Display.text(name + ": " + value, 0, line);
		line+=30;
	}
	
	/**
	 * Deletes all of the names and values and clears the screen.
	 */
	public static void deleteAll() {
		Display.resetScreen();
		line = 0;
	}
	
}
