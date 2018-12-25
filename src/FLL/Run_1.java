package FLL;

import EV3.Wait;
import Motion.GyroPID;
import Navigation.SpecialFunctions;
import Tools.Default;

public class Run_1 {

	public static void main(String[] args) {

		// Width: 15 c"m
		// Height: 18.4 c"m
		// Diameter: 8.2 c"m

		Default.settings();
				
		GyroPID pid = SpecialFunctions.navigateToOpsiteSection();
			
		pid.g.reset();
		pid.setTarget(90);
		
		pid.startPID();
		Wait.time(2000);
		pid.stopPID();
		
		
		pid.closePID();

	}

}
