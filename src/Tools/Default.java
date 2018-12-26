package Tools;

import EV3.Display;
import EV3.MoveTank;
import EV3.Ports;
import Motion.Aligner;

public abstract class Default {

	/**
	 * Runs default settings, should only be used once at the start
	 * of the program.
	 */
	public static void settings() {
		Display.setScreen();
		MoveTank.setMainMotors(Ports.A, Ports.D);
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
	}
	
}
