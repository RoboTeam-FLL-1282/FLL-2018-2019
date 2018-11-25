package Navigation;

import EV3.Controller;
import EV3.MoveTank;

public class Traveler {
	
	double currentX;
	double currentY;
	
	/**
	 * @param startX - The beginning X position. 
	 * @param startY - The beginning Y position.
	 */
	public Traveler(double startX, double startY) {
		currentX = startX;
		currentY = startY;
	}

	/**
	 * Turns in spot according to a specific angle.
	 * @param wheelDiameter
	 * @param trackWidth
	 * @param angle
	 * @param speed
	 */
	public static void turnInSpot(double angle, int speed) {
		double angleToTurn = Controller.getTrackWidth() * angle / Controller.getWheelDiameter();
		MoveTank.onForDegrees(-1*speed, speed, (int)angleToTurn, true);
	}
	
	/**
	 * Navigates to a specific x and y coordinates. 
	 * @param x
	 * @param y
	 * @param currX
	 * @param currY
	 * @param speed
	 */
	public void moveOnBoard(double x, double y, int speed) {

		double angle = Math.toDegrees(Math.atan((x-currentX) / (y-currentY)));
		turnInSpot(angle, speed);

		double distance = Math.sqrt(Math.pow(x-currentX, 2) + Math.pow(y-currentY, 2));
		MoveTank.onForCent(speed, speed, distance, true);
		
		currentX = x;
		currentY = y;
	}
}
