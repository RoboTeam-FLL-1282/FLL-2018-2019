package FLL;

import EV3.BrickButtons;
import EV3.MoveTank;
import EV3.Sound;
import EV3.Wait;
import Motion.BlackLineAlignment;
import Motion.GyroPID;
import Motion.LineAlignment;
import Motion.WhiteLineAlignment;
import Navigation.SpecialFunctions;
import Navigation.Traveler;
import Tools.Default;

public class Run_1 {

	public static void main(String[] args) {
		
		// Width: 15 c"m
		// Height: 18.4 c"m
		// Diameter: 8.2 c"m

		//I commented your code because I to run a simple program and I don't know how to create a new one.z\\\\\\\\\\\\\\\\\ Excuse me.
		Default.settings();      								  
		
		GyroPID pid = SpecialFunctions.navigateToOpsiteSection();	    
		
//		MoveTank.onForCent(-100, -100, 150, true);
//
		Traveler t = new Traveler(0, 0, 12, 8.2);
//		
//		t.turnInSpot(95, -100);
//		
//		Sound.beep(100);
//		BlackLineAlignment.align(-100);
		
		MoveTank.onForCent(-100, -100, 300, true);
		
		BlackLineAlignment.align(100);
		
		MoveTank.onForCent(100, 100, 160, true);
		
		t.turnInSpot(145, -100);
		
		pid.setTarget(pid.g.angle());
		pid.setBaseSpeed(250);
		pid.startPID();
		Wait.time(5000);
		pid.stopPID();
		
		pid.setBaseSpeed(-250);
		pid.setTarget(pid.g.angle() - 8);
		pid.startPID();
		Wait.time(3000);
		pid.stopPID();
		LineAlignment.align(-100);
		
//		Sound.beep(100);
//		MoveTank.onForCent(-100, -100, 600, true);
//		
//		pid.closePID();
//		
//		Sound.beep(100);
//
//		// Move backwards - ready for next part!
//		MoveTank.onForCent(50, 50, 300, true);
//		Sound.beep(100);

		pid.closePID();
	}

}
