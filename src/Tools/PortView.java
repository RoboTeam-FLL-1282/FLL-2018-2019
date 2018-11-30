package Tools;

import EV3.BrickButtons;
import EV3.Buttons;
import EV3.ColorSensor;
import EV3.GyroSensor;
import EV3.Ports;
import EV3.UltraSonicSensor;
import EV3.Wait;

public class PortView implements Runnable{
	
	static boolean run = true;
	
	static UltraSonicSensor u = new UltraSonicSensor(Ports.S1);
	static ColorSensor c1 = new ColorSensor(Ports.S2);
	static GyroSensor g = new GyroSensor(Ports.S3);
	static ColorSensor c2 = new ColorSensor(Ports.S4);
	
	public static void main(String[] args) {
		
		c1.setReflectedLightMode();
		c2.setReflectedLightMode();
		
		Thread t = new Thread(new PortView());
		t.start();
		
		BrickButtons.waitForPress(Buttons.ESCAPE);
		
		run = false;
	}
	
	@Override
	public void run() {
		while(run) {
			Alert.view("1. US", u.distance());
			Alert.view("2. Color", c1.reflectedLight());
			Alert.view("3. Gyro", g.angle());
			Alert.view("4. Color", c2.reflectedLight());
			Wait.time(100);
		}
	}
	
}
