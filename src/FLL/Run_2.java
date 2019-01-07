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

public class Run_2 {

	public static void main(String[] args) {
		
		Default.settings();
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(0.85);
		GyroPID pid = new GyroPID(0, 1, 0.001, 0.001);
		pid.setBaseSpeed(-70);
		SpecialFunctions.smiley();
		Sound.beep(100);
		BrickButtons.waitForAnyPress();
		SpecialFunctions.smileyOff();
		pid.g.recalibrate();
		pid.startPID();
		for(int i = -70; i>-250; i--) {
			pid.setBaseSpeed(i);
			Wait.time(5);
		}
		Wait.time(2000);
		pid.stopPID();
		WhiteLineAlignment.find(Sides.RIGHT, -150);
		Traveler t = new Traveler(0, 0, 12, 8.2);
		t.turnInSpot(90, -100);
		MoveTank.onForDegrees(400, 400, 500, true);
		WhiteLineAlignment.find(Sides.LEFT, -150);
		
	}
	
}
