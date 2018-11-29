package FLL;

import EV3.BrickButtons;
import EV3.Buttons;
import EV3.ColorSensor;
import EV3.Ports;
import Tools.Alert;
import Motion.BlackLineAlignment;

public class testLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColorSensor sens = new ColorSensor(Ports.S3);
		sens.setReflectedLightMode();
		
		while(!BrickButtons.isPressed(Buttons.CENTER)) {
			Alert.notify("value: "+sens.reflectedLight());	
		}
		double blackValue = sens.reflectedLight();
		
		
//		BlackLineAlignment align = new BlackLineAlignment();
//		align.setBlackValue(blackValue);
//		
//		align.align(360, Ports.A, Ports.D);
	}

}
