package Motion;
import EV3.*;
public class test {

	static double[] k = {1, 1, 1};
	static String[] ks = {"kp", "ki", "kp"};
	static int index = 0;

	public static void main(String[] args) {

		Display.setScreen();
		setK();

		GyroPID pid  = new GyroPID(0, k[0], k[1], k[2]);
		pid.startPID();
		Wait.time(20000);
		pid.stopPID();

	}


	public static void setK(){
		Display.resetScreen();
		Display.text(ks[index] + k[index], 0, 0);
		BrickButtons.waitForAnyPress();
		if(BrickButtons.isPressed(Buttons.UP)) {
			k[index] += 0.01;
			Display.text(ks[index] + " = "+k[index], 0, 0);
		}
		else if(BrickButtons.isPressed(Buttons.DOWN)){
			k[index] -= 0.01;
			Display.text(ks[index] + " = "+k[index], 0, 0);
		}
		else if(BrickButtons.isPressed(Buttons.CENTER))
		{
			index++;
			if(index == 3) {
				index = 0;
			}
			else
				setK();
		}

	}
}