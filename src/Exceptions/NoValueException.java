package Exceptions;

import EV3.BrickLight;
import EV3.Display;
import EV3Library.sound;

public class NoValueException {

	public static void alert(String message) {
		
		// Beep:
		sound.beep(100);
		
		// Brick light:
		BrickLight.on(2);
		
		// Show Alert:
		Display.setScreen();
		Display.resetScreen();
		Display.text("NoValueException: ", 0, 0);
		Display.text(message, 0, 40);
		
	}
	
}
