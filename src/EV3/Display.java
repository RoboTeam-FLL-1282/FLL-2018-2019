package EV3;
import EV3Library.*;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
public abstract class Display { // Done!
	
	public static void setScreen() {
		LCD.clear();
		Delay.msDelay(500);
	}
	
	public static void text(String text, int x, int y) {
		TextUtils.realDrawString(text, x, y);
	}
	
	public static void resetScreen() {
		LCD.clear();
	}
}
