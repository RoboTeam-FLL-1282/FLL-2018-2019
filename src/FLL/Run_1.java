package FLL;

import EV3.BrickButtons;
import EV3.Display;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Wait;
import Motion.Aligner;
import Motion.BlackLineAlignment;
import Motion.GyroPID;
import Motion.Sides;
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
		MoveTank.onForCent(200, 200, 320, true);
		pid.setTarget(26);
		
		// Move straight (target = T shaped line)
		pid.startPID();
		Wait.time(2500);
		pid.stopPID();
		
		MoveTank.onForCent(200, 200, 50, true);
		
		pid.startPID();
		Wait.time(700);
		pid.stopPID();
		
		// Find white line and align
		BlackLineAlignment.align(-100);
		
		// Notify of arrival and then turn ?
		Sound.beep();
		MoveTank.onForDegrees(-100, -100, 300, true);
//		pid.g.reset();
//		
//		pid.setTarget(-10);
//		pid.startPID();
//		Wait.time(500);
//		pid.stopPID();
//		
//		BlackLineAlignment.findBlackLine(Sides.LEFT, -100);
//		Sound.beep();
		
	}

}
