package Motion;

import EV3.MoveTank;
import EV3.Wait;

public class Accelerator {

	/**
	 * Accelerates to a desired speed, in a desired time.
	 * @param duration - Total duration time in seconds.
	 * @param startSpeed - The starting speed.
	 * @param endSpeed - The desired speed.
	 * @param brakeAtEnd - If true, motors will stop at the end of the acceleration.
	 */
	public static void accelerate(double duration, double startSpeed, double endSpeed, boolean brakeAtEnd) {
		
		double change = duration/(endSpeed - startSpeed);
		int loops = (int)((endSpeed - startSpeed)/change);
		int wait = (int)(duration/loops*1000);
		
		double speed = (int)startSpeed;
		
		for(int i = 0; i<loops; i++) {
			MoveTank.on((int)speed, (int)speed);
			speed += change;
			Wait.time(wait);
		}
		
		if(brakeAtEnd)
			MoveTank.off();
	}
	
	/**
	 * Accelerates to a desired speed, in a desired time.
	 * @param duration - Total duration time in seconds.
	 * @param endSpeed - The desired speed.
	 * @param brakeAtEnd - If true, motors will stop at the end of the acceleration.
	 */
	public static void accelerate(double duration, double endSpeed, boolean brakeAtEnd) {
		
		double change = duration/(endSpeed);
		int loops = (int)(endSpeed/change);
		int wait = (int)(duration/loops*1000);
		
		double speed = 0;
				
		for(int i = 0; i<loops; i++) {
			MoveTank.on((int)speed, (int)speed);
			speed += change;
			Wait.time(wait);
		}
		
		if(brakeAtEnd)
			MoveTank.off();
	}
	
}
