package Tools;

import EV3.BrickLight;
import EV3.Display;
import lejos.hardware.Sound;

public abstract class Alert {

	public static void notify(String message) {
		
		// Beep
		Sound.beep();
	
		// Brick lights
		BrickLight.on(2);
		
		// Display message
		Display.resetScreen();
		Display.text(message, 0, 0);
		
	}
	
}
