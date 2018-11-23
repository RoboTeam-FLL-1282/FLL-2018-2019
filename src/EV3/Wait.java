package EV3;

import lejos.utility.Delay;

public abstract class Wait {

	/**
	 * @param milliSeconds
	 */
	public static void time(int milliSeconds) {
		Delay.msDelay(milliSeconds);
	}
	
	/**
	 * ----------------------------------------------------------
	 * state: 0 = pressed, 1 = bumped.
	 * 
	 * @param buttonSet
	 * @param state
	 */
	public static void forBrickButtons(Buttons button, int state) {
		if(state == 0) {
			BrickButtons.waitForPress(button);
		}
		else if(state == 1){
			BrickButtons.waitForBump(button);
		}
	}
}
