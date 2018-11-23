package Expiriments;

import EV3.Controller;
import EV3.Ports;
import lejos.hardware.port.Port;

public interface Expiriments {

	default void init() {
		Controller.setRobotDetails(6.24, 10, Ports.A, Ports.D);
	}
	
	default void setRobotDetails(double wheelDiameter, double trackWidth, Port leftWheelPort, Port rightWheelPort) {
		Controller.setRobotDetails(wheelDiameter, trackWidth,leftWheelPort, rightWheelPort);
	}
	
	public void onStart();
	
	public void onExit();	
	
}
