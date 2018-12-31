package Navigation;

import EV3.MoveTank;

public class Traveler {
	
	double currentX;
	double currentY;
	double TrackWidth = Double.NaN;
	double WheelDiameter = Double.NaN;
	
	public Traveler() {}
	
	/**
	 * @param startX - The beginning X position. 
	 * @param startY - The beginning Y position.
	 */
	public Traveler(double startX, double startY) {
		currentX = startX;
		currentY = startY;
	}
	
	/**
	 * 
	 * @param startX - The beginning X position. 
	 * @param startY - The beginning Y position.
	 * @param TrackWidth - The robot width.
	 * @param WheelDiameter - The wheel diameter.
	 */
	public Traveler(double startX, double startY, double TrackWidth, double WheelDiameter) {
		currentX = startX;
		currentY = startY;
		this.TrackWidth = TrackWidth;
		this.WheelDiameter = WheelDiameter;
	}

	/**
	 * @param TrackWidth - The robot width.
	 * @param WheelDiameter - The wheel diameter.
	 */
	public void setRobotDetails(double TrackWidth, double WheelDiameter) {
		this.TrackWidth = TrackWidth;
		this.WheelDiameter = WheelDiameter;
	}
	
	/**
	 * @param X - A x position.
	 * @param Y - A y position.
	 */
	public void setPosition(double X, double Y) {
		currentX = X;
		currentY = Y;
	}
	
	/**
	 * Turns in spot according to a specific angle.
	 * @param angle
	 * @param speed
	 */
	public void turnInSpot(double angle, float speed) {
		double angleToTurn = (TrackWidth * angle) / WheelDiameter;
//		System.out.println(angleToTurn);
		MoveTank.onForDegrees(-1*speed, speed, angleToTurn, true);
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
