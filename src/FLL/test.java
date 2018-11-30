package FLL;
import EV3.*;
import Motion.PID;
import Motion.Types;
public class test {

	public static void main(String[] args) {
		
		Display.setScreen();

		MoveTank.setMainMotors(Ports.A, Ports.D);
		
		PID pid = new PID(0, 1, 1, 1);
				
		BrickButtons.waitForAnyPress();
		
		pid.startPID(Types.GyroMode);
		BrickButtons.waitForAnyPress();
		pid.stopPID();		
		
	}
	
	
// 	package FLL;
// import EV3.*;
// import Motion.PID;
// import Motion.Types;
// public class test {
	
// 	static double[] k = {1, 1, 1};
// 	static String[] ks = {"kp", "ki", "kp"};
// 	static int index = 0;
	
// 	public static void main(String[] args) {
		
// 		Display.setScreen();
// 		setK();
		
// 		PID pid  = new PID(0, k[0], k[1], k[2]);
// 		pid.startPID(Types.GyroMode);
// 		Wait.time(20000);
// 		pid.stopPID();
		
// 	}
	
	
// 	public static void setK(){
// 		Display.resetScreen();
// 		Display.text(ks[index] + k[index], 0, 0);
// 		BrickButtons.waitForAnyPress();
// 		if(BrickButtons.isPressed(Buttons.UP)) {
// 			k[index] += 0.01;
// 			Display.text(ks[index] + " = "+k[index], 0, 0);
// 		}
// 		else if(BrickButtons.isPressed(Buttons.DOWN)){
// 			k[index] -= 0.01;
// 			Display.text(ks[index] + " = "+k[index], 0, 0);
// 		}
// 		else if(BrickButtons.isPressed(Buttons.CENTER))
// 		{
// 			index++;
// 			if(index == 3) {
// 				index = 0;
// 			}
// 			else
// 			setK();
// 		}
		
// 	}
	
}

	
