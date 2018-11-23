package EV3;
import EV3Library.Gyro;
import lejos.hardware.port.Port;

public class GyroSensor { // Done!

	Gyro gs;
	
	public GyroSensor(Port port) {
		gs = new Gyro(port);
	}
	
	public double angle() {
		return gs.getAngle();
	}
	
	public double rate() {
		return gs.getAngularVelocity();
	}
	
	public void reset() {
		gs.reset();
	}
	
	public void recalibrate() {
		gs.resetGyro();
	}
	
	public void close() {
		gs.close();
	}
}
