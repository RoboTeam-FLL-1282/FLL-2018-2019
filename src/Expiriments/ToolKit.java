package Expiriments;

import EV3.BrickButtons;
import EV3.Buttons;

public class ToolKit implements Runnable{

	static Main main = new Main();
	
	public static void main(String[] args) {
		Thread t = new Thread(new ToolKit());
		t.start();
		main.init();
		main.onStart();
		main.onExit();
	}

	@Override
	public void run() {
		BrickButtons.waitForPress(Buttons.ESCAPE);
		main.onExit();
		System.exit(0);
	}
	
}
