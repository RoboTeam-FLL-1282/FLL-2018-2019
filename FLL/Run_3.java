package FLL;

import EV3.BrickButtons;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Sound;
import EV3.Wait;
import Motion.Aligner;
import Motion.GyroPID;
import Motion.LineAlignment;
import Motion.Sides;
import Motion.WhiteLineAlignment;
import Navigation.SpecialFunctions;
import Navigation.Traveler;
import Tools.Default;

public class Run_3 {

	public static void main(String[] args) {
		
		Default.settings();
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(0.85);
//	
//		GyroPID pid = new GyroPID(0, 1, 0.001, 0.001);
//		pid.setBaseSpeed(-250);
		SpecialFunctions.smiley();
		Sound.beep(100);
		BrickButtons.waitForAnyPress();
		SpecialFunctions.smileyOff();
//	
//		pid.g.recalibrate();
//		pid.startPID();
//		Wait.time(1000);
//		pid.stopPID();
		
		MoveTank.onForCent(-250, -250, 300, true);
		WhiteLineAlignment.align(-150);
		MoveTank.onForCent(-150, -150, 50, true);
		
		
		
	}
	
}
