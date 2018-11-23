package Navigation;

import EV3.MoveTank;

public class CoordinatesNavigation {

	/**
	 * Turns in spot according to a specific angle.
	 * @param wheelDiameter
	 * @param trackWidth
	 * @param angle
	 * @param speed
	 */
	public void turnInSpot(double wheelDiameter, double trackWidth, double angle, int speed) {
		double angleToTurn = trackWidth * angle / wheelDiameter;
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
	public void moveOnBoard(double x, double y, double currX, double currY, int speed) {

		double angle = Math.toDegrees(Math.atan((x-currX) / (y-currY)));
		turnInSpot(0, 0, angle, speed);

		double distance = Math.sqrt(Math.pow(x-currX, 2) + Math.pow(y-currY, 2));
		MoveTank.onForCent(speed, speed, distance, true);
	}
}
