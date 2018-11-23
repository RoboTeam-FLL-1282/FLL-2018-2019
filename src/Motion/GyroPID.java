package Motion;
import EV3.*;
public class GyroPID extends PID implements Runnable{
	
	GyroSensor g = new GyroSensor(Ports.S3);
	
	/**
	 * Uses the Gyro sensor to move the robot with the PID calculations.
	 */
	@Override
	public void run() {
		while(run) {
			double turn = calculateTurn(g.angle());
			double leftSpeed  = baseSpeed + turn;
			double rightSpeed = baseSpeed - turn;
			display(turn, leftSpeed, rightSpeed); // Not necessary 
			MoveTank.on((int)leftSpeed, (int)rightSpeed);
			Wait.time((int)(time*1000));
		}
	}
	
	// For debugging...
	private void display(double turn, double leftSpeed, double rightSpeed) {
		Display.resetScreen();
		Display.text("Turn: " + turn, 0, 10);
		Display.text("Left: " + leftSpeed, 0, 50);
		Display.text("Right: " + rightSpeed, 0, 90);
	}
	
}
