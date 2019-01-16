package FLL;

import javax.activation.MailcapCommandMap;

import EV3.BrickButtons;
import EV3.MediumMotor;
import EV3.MoveTank;
import EV3.Ports;
import EV3.Sound;
import EV3.Wait;
import Motion.Accelerator;
import Motion.Aligner;
import Motion.BlackLineAlignment;
import Motion.GyroPID;
import Motion.LineAlignment;
import Motion.Sides;
import Motion.WhiteLineAlignment;
import Navigation.SpecialFunctions;
import Navigation.Traveler;
import Tools.Default;

public class Run_4 {

	public static void main(String[] args) {
		
		//I commented your code because I to run a simple program and I don't know how to create a new one.z\\\\\\\\\\\\\\\\\ Excuse me.
				Default.settings();      								  
				
				GyroPID pid = SpecialFunctions.navigateToOpsiteSection();	    
				
				//MediumMotor b =  new MediumMotor(Ports.B);
				
//				MoveTank.onForCent(-100, -100, 150, true);
		//
				Traveler t = new Traveler(0, 0, 12, 8.2);
//				
//				t.turnInSpot(95, -100);
//				
//				Sound.beep(100);
//				BlackLineAlignment.align(-100);
				
				MoveTank.onForCent(-100, -100, 300, true);

				//b.onForDegrees(500, 200, true);
				
				//b.onForDegrees(-500, 200, true);
				
				BlackLineAlignment.align(100);
				
				MoveTank.onForCent(100, 100, 160, true);
				
				t.turnInSpot(50, -100);
				
				MoveTank.onForCent(200, 200, 700, true);
				Wait.time(200);
				MoveTank.onForCent(-200, -200, 700, true);
				
				t.turnInSpot(50, 100);
				
				MoveTank.onForCent(-200, -200, 300, true);
				
				BlackLineAlignment.align(100);
				
				MoveTank.onForCent(100, 100, 160, true);
				
				t.turnInSpot(145, -100);
				
				pid.setTarget(pid.g.angle());
				pid.setBaseSpeed(250);
				pid.startPID();
				Wait.time(4700);
				pid.stopPID();
				
				Wait.time(200);
				
				pid.setBaseSpeed(-500);
				pid.setTarget(pid.g.angle() + 0.5); 
				pid.startPID();
				Wait.time(3300);
				pid.stopPID();
				
				t.turnInSpot(30, 100);
				
				MoveTank.onForCent(-500, -500, 1600, true);
				

				pid.closePID();
		
	}
	
}
