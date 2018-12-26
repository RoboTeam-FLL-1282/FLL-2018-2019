package FLL;

import EV3.MoveTank;
import EV3.Sound;
import Motion.GyroPID;
import Navigation.SpecialFunctions;
import Navigation.Traveler;
import Tools.Default;

public class Run_1 {

	public static void main(String[] args) {

		// Width: 15 c"m
		// Height: 18.4 c"m
		// Diameter: 8.2 c"m

		Default.settings();
				
		GyroPID pid = SpecialFunctions.navigateToOpsiteSection();
					
		Sound.beep(100);
		MoveTank.onForCent(-100, -100, 20, true);

		Traveler t = new Traveler(0, 0, 15, 8);
		
		Sound.beep(100);
		t.turnInSpot(100, -100);
		
		Sound.beep(100);
		MoveTank.onForCent(-100, -100, 300, true);
		
		pid.closePID();

	}

}
