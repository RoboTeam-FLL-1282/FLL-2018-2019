package Navigation;

import EV3.BrickButtons;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Sound;
import EV3.Wait;
import Motion.Accelerator;
import Motion.Aligner;
import Motion.GyroPID;
import Motion.LineAlignment;
import Motion.WhiteLineAlignment;

public class SpecialFunctions {

	public static GyroPID navigateToOpsiteSection() {
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(0.85);
		GyroPID pid = new GyroPID(-1, 1, 0.001, 0.001);
		pid.setBaseSpeed(-250);
		Sound.beep(100);
		BrickButtons.waitForAnyPress();
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
		MoveTank.onForCent(200, 200, 520, true);
		pid.setTarget(16);

		// Move straight (target = T shaped line)
		pid.startPID();
		Wait.time(3600);
		pid.stopPID();

		MoveTank.onForCent(100, 100, 10, true);
		
		LineAlignment.align(-100);
				
		return pid;
	}
	
}
