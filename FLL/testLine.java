package FLL;

import EV3.BrickButtons;
import EV3.Ports;
import Motion.Aligner;
import Motion.BlackLineAlignment;
import Motion.WhiteLineAlignment;
import Tools.Default;

public class testLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double whiteValue = 0.9;
		double blackValue = 0.08;
		
		Default.settings();
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		Aligner.setWhiteValue(whiteValue);
		Aligner.setBlackValue(blackValue);
		BrickButtons.waitForAnyPress();
		WhiteLineAlignment.align(100);
		BlackLineAlignment.align(100);
	}

}
