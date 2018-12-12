package FLL;

import EV3.BrickButtons;
import EV3.Display;
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
		
		GyroPID pid = new GyroPID(-1, 2, 0.001, 0.001);
		pid.setBaseSpeed(-250);
		BrickButtons.waitForAnyPress();
		pid.g.recalibrate();
		pid.startPID();
		Wait.time(2000);
		pid.stopPID();
		Display.resetScreen();
		WhiteLineAlignment.align(-100);
		Sound.beep();
		pid.g.reset();
		MoveTank.onForCent(100, 100, 380
				
				, true);
		pid.setTarget(12);
		pid.startPID();
		Wait.time(1800);
		pid.stopPID();
		Sound.beep();
		WhiteLineAlignment.align(-100);
		BlackLineAlignment.align(-100);

	}

}
