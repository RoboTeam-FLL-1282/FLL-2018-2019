package FLL;
import EV3.*;
import Motion.PID;
import Motion.Types;

public class test{
	
	public static void main(String[] args) {
		
		Display.setScreen();

		MoveTank.setMainMotors(Ports.A, Ports.D);
		
		PID pid = new PID(0, 1, 1, 1);
				
		BrickButtons.waitForAnyPress();
		
		pid.startPID(Types.GyroMode);
		BrickButtons.waitForAnyPress();
		pid.stopPID();	
	
	}
}

	
