package FLL;
import EV3.*;
import Motion.GyroPID;
public class test{
	
	public static void main(String[] args) {
		
		Display.setScreen();

		MoveTank.setMainMotors(Ports.A, Ports.D);
		
		GyroPID pid = new GyroPID(0, 1, 1, 1);
				
		BrickButtons.waitForAnyPress();
		
		pid.startPID();
		BrickButtons.waitForAnyPress();
		pid.stopPID();	
	
	}
}

	
