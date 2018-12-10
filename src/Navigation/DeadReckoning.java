package Navigation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeadReckoning extends JPanel{

	// Members:
	double width = 70;
	double height = 50;
	double x = 100;
	double y = 100;
	double theta = Math.toRadians(0);
	
	double vr = 0;
	double vl = 10;

	Rectangle rect = new Rectangle();
	AffineTransform transform = new AffineTransform();
	Shape rotatedRect;

	public DeadReckoning() {
		JFrame frame = new JFrame("Dead Reckoning");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		rect.setBounds((int)x, (int)y, (int)width, (int)height);
		
	}

	public void drawRotatedShape(final Graphics2D g2, final Shape shape,
			final double angle,
			final float x, final float y) {

		final AffineTransform saved = g2.getTransform();
		final AffineTransform rotate = AffineTransform.getRotateInstance(
				angle, x+width/2, y+height/2);
		g2.transform(rotate);
		g2.fill(shape);
		g2.setTransform(saved);

	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		double s = (vr+vl)/2;
		theta = (vr-vl)/width + theta;
		x = s*Math.cos(theta) + x;
		y = s*Math.sin(theta) + y;
		
		System.out.println("x: " + x + " y: " +  y + " t: " + theta);
		
		rect.setBounds((int)x, (int)y, (int)width, (int)height);
		
		drawRotatedShape(g2d, rect, theta, (float)x, (float)y);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		repaint();
	}

	public static void main(String[] args) {
		new DeadReckoning();
	}

}
