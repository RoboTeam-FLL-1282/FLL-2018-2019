package FLL;

import EV3.BrickButtons;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Wait;
import Motion.Aligner;
import Motion.BlackLineAlignment;
import Motion.GyroPID;
import Motion.WhiteLineAlignment;
import Tools.Default;
import lejos.hardware.Sound;

public class Run_1 {

	public static void main(String[] args) {

		// Width: 15 c"m
		// Height: 18.4 c"m
		// Diameter: 8.2 c"m

		Default.settings();



		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(0.85);
		GyroPID pid = new GyroPID(-1, 1, 0.001, 0.001);
		pid.setBaseSpeed(-250);
		Sound.beep();
		BrickButtons.waitForAnyPress();
		pid.g.recalibrate();

		// Move robot
		pid.startPID();
		Wait.time(1300);
		pid.stopPID();

		// Align on white line and then turn x degrees
		//		Display.resetScreen();
		WhiteLineAlignment.align(-100);
		Sound.beep();
		pid.g.reset();
		MoveTank.onForCent(200, 200, 400, true);
		pid.setTarget(29);

		// Move straight (target = T shaped line)
		pid.startPID();
		Wait.time(2500);
		pid.stopPID();

//		MoveTank.onForCent(200, 200, 100, true);

		//		pid.setTarget(5);
		//		pid.startPID();
		//		Wait.time(200);
		//		pid.stopPID();

		// Find white line and align
		WhiteLineAlignment.align(-100);
		BlackLineAlignment.align(-100);
		WhiteLineAlignment.align(-100);
		MoveTank.onForCent(100, 100, 50, true);
		WhiteLineAlignment.align(-100);
		Sound.beep();
		pid.setTarget(90);
		pid.setBaseSpeed(100);
		pid.startPID();
		Wait.time(2000);
		pid.stopPID();

	}

}
