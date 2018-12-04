package Motion;
public class PID {
	
	// Members:
	double baseSpeed = 250;
	
	double time = 0.35; // The time to wait between each calculation.
	
	double target; // PID target.
	
	// Constants:
	double kp;
	double ki;
	double kd;
	
	// PID variables:
	double reset;
	double lastReset = 0;
	double error;
	double lastError = 0;
	
	/**
	 * @param target - The PID target
	 */
	public void setTarget(double target) {
		this.target = target;
	}
	
	/**
	 * @param kp - P constant
	 * @param ki - I constant
	 * @param kd - D constant
	 */
	public void setConstants(double kp, double ki, double kd) {
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}

	/**
	 * @param baseSpeed - The base speed that the robot drives with (degrees per second).
	 */
	public void setBaseSpeed(double baseSpeed) {
		this.baseSpeed = baseSpeed;
	}
	
	/**
	 * @param seconds - The time to wait between each calculation.
	 */
	public void setTime(double seconds) {
		this.time = seconds;
	}
	
	/**
	 * Calculates the PID error by the current sensor value and the target value.
	 * @param currentValue - Current sensor value.
	 * @return - PID error.
	 */
	private double calculateError(double currentValue) {
		return target - currentValue;
	}
	
	/**
	 * Calculates the Reset value for the Integral summation.
	 * @return - A new Reset value.
	 */
	private double caculateReset() {
		return (ki/time)*error + lastReset;
	}
	
	/**
	 * @return - The proportional function.
	 */
	private double P() {
		return kp*error;
	}
	
	/**
	 * @return - Updated integral summation.
	 */
	private double I() {
		return ki*error + reset;
	}
	
	/**
	 * @return - The derivative calculation. 
	 */
	private double D() {
		return kd*error + (kd/time)*(error-lastError);
	}
	
	/**
	 * @param currentValue - Current sensor value.
	 * @return - The turn value for each motor.
	 */
	public double calculateTurn(double currentValue) {
		error = calculateError(currentValue);
		reset = caculateReset();
		double turn = P() + I() + D();
		lastReset = reset;
		lastError = error;
		return turn;
	}
}
