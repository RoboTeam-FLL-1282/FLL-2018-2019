package FLL;
import EV3.*;
import Motion.Aligner;
import Motion.Colors;
import Motion.GyroPID;
import Motion.WhiteLineAlignment;
import Navigation.Traveler;
import Tools.Alert;
import Tools.Default;
public class test{
	
	public static void main(String[] args) {

		Default.settings();
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		WhiteLineAlignment.align(-100);
		
	}
}

	
