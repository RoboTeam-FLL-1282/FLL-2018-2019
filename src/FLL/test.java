package FLL;
import EV3.*;
import Motion.Aligner;
import Motion.Colors;
import Motion.GyroPID;
import Navigation.Traveler;
import Tools.Alert;
import Tools.Default;
public class test{
	
	public static void main(String[] args) {

//		Default.settings();
		
//		GyroPID pid = new GyroPID(0, 1, 1, 1);
//				
//		BrickButtons.waitForAnyPress();
//		
//		pid.startPID();
//		BrickButtons.waitForAnyPress();
////		pid.stopPID();	
//		
//		Traveler t = new Traveler();
//		t.setRobotDetails(13.45, 8.2);

//		..turnInSpot(90, -100);
	
		Default.settings();
		
		Aligner.setSensorsPorts(Ports.S2, Ports.S4);
		
		while(BrickButtons.isReleased(Buttons.CENTER)) {
			Alert.deleteAll();
			Alert.view("left-black", Aligner.getLeftSensorValue(Colors.BLACK));
			Alert.view("right-black", Aligner.getRightSensorValue(Colors.BLACK));
			Wait.time(50);
		}
		
		Wait.time(1000);
		
		while(BrickButtons.isReleased(Buttons.CENTER)) {
			Alert.deleteAll();
			Alert.view("left-white", Aligner.getLeftSensorValue(Colors.WHITE));
			Alert.view("right-white", Aligner.getRightSensorValue(Colors.WHITE));
			Wait.time(50);
		}
	
	}
}

	
