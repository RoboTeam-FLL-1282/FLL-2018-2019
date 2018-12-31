package FLL;
import EV3.*;
import Motion.GyroPID;
import Navigation.Traveler;
import Tools.Default;
public class test{
	
	public static void main(String[] args) {

		Default.settings();
		
//		GyroPID pid = new GyroPID(0, 1, 1, 1);
//				
//		BrickButtons.waitForAnyPress();
//		
//		pid.startPID();
//		BrickButtons.waitForAnyPress();
////		pid.stopPID();	
//		
		Traveler t = new Traveler();
		t.setRobotDetails(13.45, 8.2);

		t.turnInSpot(90, -100);
	
	
	}
}

	
