package Motion;

import EV3.MoveTank;

public class Unique {

	/**
	 * Converts right color value with special bias.
	 * @param rightValue
	 * @param color
	 * @return
	 */
	public static double colorConvertor(double rightValue, Colors color) {
		if(color == Colors.WHITE) {
			return rightValue+0.0875;
		}
		
		else {
			return rightValue+0.0375;
		}
	}	
	
	public static void alignOnBigAngle(int speed, Sides side) {
		BlackLineAlignment.find(side, speed);
		MoveTank.onForDegrees(0, 100, 200, true);
		LineAlignment.align(side, speed);
	}
}
