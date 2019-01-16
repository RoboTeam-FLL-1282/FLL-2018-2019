package Motion;

import EV3.MoveTank;

public class LineAlignment {

	public static void align(int speed) {

		int turnSpeed = speed-speed/2;

		Sides side = BlackLineAlignment.find(speed);

		turnToBlack(turnSpeed, side);

		side = WhiteLineAlignment.find(speed);

		turnToWhite(turnSpeed, side);
	}

	public static void align(Sides side, int speed) {

		int turnSpeed = speed-speed/2;

		BlackLineAlignment.find(side, speed);

		turnToBlack(turnSpeed, side);

		side = WhiteLineAlignment.find(speed);

		turnToWhite(turnSpeed, side);
	}


	public static void alignOnBlack(int speed) {


		int turnSpeed = speed-speed/2;

		Sides side = BlackLineAlignment.find(speed);

		turnToBlack(turnSpeed, side);


	}

	public static void alignOnWhite(int speed) {


		int turnSpeed = speed-speed/2;

		Sides side = WhiteLineAlignment.find(speed);

		turnToWhite(turnSpeed, side);


	}
	
	public static void turnToBlack(int turnSpeed, Sides side) {
		while(Aligner.getLeftSensorValue(Colors.BLACK) != Aligner.getRightSensorValue(Colors.BLACK) 
				|| precision(Aligner.rightSensor.reflectedLight(), 1) >= 0.6) {

			if(side == Sides.LEFT) {
				MoveTank.on(turnSpeed, -1*turnSpeed);
			}

			else {
				MoveTank.on(-1*turnSpeed, turnSpeed);
			}

		}

		MoveTank.off();
	}

	public static void turnToWhite(int turnSpeed, Sides side) {
		while(Aligner.getLeftSensorValue(Colors.WHITE) != Aligner.getRightSensorValue(Colors.WHITE) 
				/*|| precision(Aligner.rightSensor.reflectedLight(), 1) <= 0.5*/) {

			if(side == Sides.LEFT) {
				MoveTank.on(turnSpeed, -1*turnSpeed);
			}

			else {
				MoveTank.on(-1*turnSpeed, turnSpeed);
			}

		}

		MoveTank.off();
	}

	public static double precision(double number, int precision) {
		double mul = Math.pow(10, precision);
		return ((int)(number*mul))/mul;
	}

}
