package EV3;

import lejos.hardware.Button;
import lejos.hardware.Key;

public abstract class BrickButtons {

	/**
	 * @param button
	 * @return - A new button according to the button set.
	 */
	private static Key enumToButton(Buttons button) {
		
		switch(button) {
		case UP:
			return Button.UP;
		case DOWN:
			return Button.DOWN;
		case RIGHT:
			return Button.RIGHT;
		case LEFT:
			return Button.LEFT;
		case CENTER:
			return Button.ENTER;
		case ESCAPE:
			return Button.ESCAPE;
		}
		
		return null;
		
	}
	
	/**
	 * Waits for any press.
	 */
	public static void waitForAnyPress() {
		Button.waitForAnyPress();
	}
	
	/**
	 * Waits for any event.
	 */
	public static void waitFoAnyEvent() {
		Button.waitForAnyEvent();
	}

	/**
	 * Checks if a button is currently pressed.
	 * @param button
	 * @return - True if the button is currently pressed and false if not.
	 */
	public static boolean isPressed(Buttons button) {
			return enumToButton(button).isDown();
	}

	/**
	 * Checks if a button is currently released.
	 * @param button
	 * @return - True if the button is currently released and false if not.
	 */
	public static boolean isReleased(Buttons button) {
		return enumToButton(button).isUp();
	}

	/**
	 * Waits for a specific button to be pressed.  
	 * @param button
	 */
	public static void waitForPress(Buttons button) {
		enumToButton(button).waitForPress();
	}

	/**
	 * Waits for a specific button to be bumped (press and release).
	 * @param button
	 */
	public static void waitForBump(Buttons button) {
		enumToButton(button).waitForPressAndRelease();
	}
}
