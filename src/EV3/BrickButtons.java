package EV3;

import lejos.hardware.Button;
import lejos.hardware.Key;

public abstract class BrickButtons {// Fine... Can be improved...

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
	
	public static void waitForAnyPress() {
		Button.waitForAnyPress();
	}
	
	public static void waitFoAnyEvent() {
		Button.waitForAnyEvent();
	}

	public static boolean isPressed(Buttons button) {
			return enumToButton(button).isDown();
	}

	public static boolean isReleased(Buttons button) {
		return enumToButton(button).isUp();
	}

	public static void waitForPress(Buttons button) {
		enumToButton(button).waitForPress();
	}

//	public static void waitForRelease(Buttons button) {
//		enumToButton(button)
//	}

	public static void waitForBump(Buttons button) {
		enumToButton(button).waitForPressAndRelease();
	}
}
