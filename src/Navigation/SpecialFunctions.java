package Navigation;

import EV3.BrickButtons;
import EV3.BrickLight;
import EV3.Display;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Sound;
import EV3.Wait;
import Motion.Accelerator;
import Motion.Aligner;
import Motion.GyroPID;
import Motion.LineAlignment;
import Motion.Sides;
import Motion.Unique;
import Motion.WhiteLineAlignment;

public class SpecialFunctions {

	static boolean smiley = true;
	
	public static void smiley() {
		new Thread() {
			@Override
			public void run() {
				while(smiley) {
					Display.resetScreen();
					BrickLight.on(1);
					Wait.time(500);
					BrickLight.on(0);
					Display.text("   **        **     ", 2, 15);
					Display.text("   **        **     ", 2, 30);
					Display.text("**      *       **  ", 2, 45);
					Display.text(" **            **   ", 2, 60);
					Display.text("  **************    ", 2, 75);
					Display.text("   ************     ", 2, 90);
					Wait.time(500);
				}
			}
		}.start();
	}
	
	public static void smileyOff() {
		smiley = false;
	}
	
	public static GyroPID navigateToOpsiteSection() {

		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(0.85);
		GyroPID pid = new GyroPID(-1, 1, 0.001, 0.001);
		pid.setBaseSpeed(-250);
		smiley();
		Sound.beep(100);
		BrickButtons.waitForAnyPress();
		smileyOff();
		pid.g.recalibrate();

		// Move robot
		Accelerator.accelerate(0.5, -100, -250, false);
		pid.startPID();
		Wait.time(400);
		pid.stopPID();

		// Align on white line and then turn x degrees
		//		Display.resetScreen();
		WhiteLineAlignment.align(-250);
		Sound.beep(100);
		pid.g.reset();
		MoveTank.onForCent(200, 200, 500, true);
		pid.setTarget(21);

		// Move straight (target = T shaped line)
		pid.startPID();
		Wait.time(2712);
		pid.stopPID();

		//MoveTank.onForCent(100, 100, 10, true);

//		LineAlignment.align(Sides.LEFT, -100);

		Unique.alignOnBigAngle(-100, Sides.LEFT);
		
		return pid;
	}

}
