package Tools;

import EV3.BrickButtons;
import EV3.Buttons;

public class Brick extends Thread {

	public boolean run = true;
	BrickButtonsListener object;

	public void addBrickButtonsListener(BrickButtonsListener object) {
		this.object = object;
		start();
	}
	
	@Override
	public void run() {
		while(run) {
			BrickButtons.waitFoAnyEvent();
			if (BrickButtons.isPressed(Buttons.UP)) {
				object.onPress(Buttons.UP);
				object.onUpPress();
			}
			else if (BrickButtons.isReleased(Buttons.UP)) {
				object.onRelease(Buttons.UP);
				object.onUpRelease();
				object.onBump(Buttons.UP);
				object.onUpBump();
			}
			else if (BrickButtons.isPressed(Buttons.DOWN)) {
				object.onPress(Buttons.DOWN);
				object.onDownPress();
			}
			else if (BrickButtons.isReleased(Buttons.DOWN)) {
				object.onRelease(Buttons.DOWN);
				object.onDownRelease();
				object.onBump(Buttons.DOWN);
				object.onDownBump();
			}
			else if (BrickButtons.isPressed(Buttons.LEFT)) {
				object.onPress(Buttons.LEFT);
				object.onLeftPress();
			}
			else if (BrickButtons.isReleased(Buttons.LEFT)) {
				object.onRelease(Buttons.LEFT);
				object.onLeftRelease();
				object.onBump(Buttons.LEFT);
				object.onLeftBump();
			}
			else if (BrickButtons.isPressed(Buttons.RIGHT)) {
				object.onPress(Buttons.RIGHT);
				object.onRightPress();
			}
			else if (BrickButtons.isReleased(Buttons.RIGHT)) {
				object.onRelease(Buttons.RIGHT);
				object.onRightRelease();
				object.onBump(Buttons.RIGHT);
				object.onRightBump();
			}
			else if (BrickButtons.isPressed(Buttons.CENTER)) {
				object.onPress(Buttons.CENTER);
				object.onCenterPress();
			}
			else if (BrickButtons.isReleased(Buttons.CENTER)) {
				object.onRelease(Buttons.CENTER);
				object.onCenterRelease();
				object.onBump(Buttons.CENTER);
				object.onCenterBump();
			}
			else if (BrickButtons.isPressed(Buttons.ESCAPE)) {
				object.onPress(Buttons.ESCAPE);
				object.onEscapePress();
			}
			else if (BrickButtons.isReleased(Buttons.ESCAPE)) {
				object.onRelease(Buttons.ESCAPE);
				object.onEscapeRelease();
				object.onBump(Buttons.ESCAPE);
				object.onEscapeBump();
			}
		}
	}
	
}
