package Tools;

import EV3.Display;
import EV3.MediumMotor;
import EV3.Ports;
import lejos.hardware.Button;

public class MotorControl {

	static int speed = 1000;
	static MediumMotor b = new MediumMotor(Ports.B);
	static MediumMotor c = new MediumMotor(Ports.C);
	
	public static void main(String[] args) {
		Display.setScreen();
		speed();
		
		setSpeed();
		
		c.close();
		b.close();	
	}
	
	public static void control() {
		Display.setScreen();
		Display.text("        B+    ", 0, 10);
		Display.text("        |    ", 0, 30);
		Display.text("C-   -- * --   C+", 0, 50);
		Display.text("        |    ", 0, 70);
		Display.text("        B-    ", 0, 90);

		boolean end = false;
		boolean back = false;
		while(!end && !back) {
			Button.waitForAnyEvent();
			while (Button.DOWN.isDown()) {
				b.on(speed*-1);
			}
			while (Button.UP.isDown()) {
				b.on(speed);
			}
			while (Button.LEFT.isDown()) {
				c.on(speed*-1);
			}
			while (Button.RIGHT.isDown()) {
				c.on(speed);
			}
			if(Button.ENTER.isDown()) {
				end = true;
			}
			if(Button.ESCAPE.isDown()) {
				back = true;
			}
			b.off();
			c.off();
		}
		if(back)
		setSpeed();
	}
	
	public static void setSpeed() {
		boolean next = false;
		while(!next) {
			speed();
			Button.waitForAnyEvent();
			if(Button.DOWN.isDown()) {
				speed -= 60;
				speed();
			}
			else if (Button.UP.isDown()) {
				speed += 60;
				speed();
			}
			else if(Button.ENTER.isDown()) {
				next = true;
			}
		}
		control();
	}
	
	public static void speed() {
		Display.resetScreen();
		Display.text("speed: " + speed, 50, 50);
	}

}
