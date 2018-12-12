package Motion;
import EV3.*;
import Tools.Default;
public class test {

	static double[] k = {2, 0.001, 0.001};
	static String[] ks = {"kp", "ki", "kd"};
	static int index = 0;

	public static void main(String[] args) {

		Default.settings();
		Sound.beep(100);
		setK();

		GyroPID pid  = new GyroPID(0, k[0], k[1], k[2]);
		pid.g.recalibrate();
		pid.startPID();
		while(true) {
			BrickButtons.waitForAnyPress();
			if(BrickButtons.isPressed(Buttons.CENTER))
				pid.g.reset();
			else
				break;
		}
		pid.stopPID();

	}


	public static void setK(){
		Display.resetScreen();
		Display.text(ks[index] + " = "+k[index], 0, 0);
		BrickButtons.waitForAnyPress();
		if(BrickButtons.isPressed(Buttons.UP)) {
			k[index] += 0.1;
			setK();
		}
		else if(BrickButtons.isPressed(Buttons.DOWN)){
			k[index] -= 0.1;
			setK();
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