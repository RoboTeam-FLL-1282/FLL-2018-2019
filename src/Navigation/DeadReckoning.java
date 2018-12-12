package Navigation;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeadReckoning extends GUI implements MouseListener, MouseMotionListener{

	// Members:
	double width = 70;
	double height = 50;
	double x = 100;
	double y = 100;
	double theta = Math.toRadians(0);

	double vr = 0;
	double vl = 10;

	int time = 100;

	int index = 0;

	Rectangle rect = new Rectangle();
	AffineTransform transform = new AffineTransform();
	Shape rotatedRect;

	boolean onStart = true;

	boolean onDrag = false;

	boolean setRobotPosition = true;

	// Fields:
	JButton changeTheta = new JButton("Change");
	JTextField setTheta = new JTextField("0");
	JButton done = new JButton("Done");

	public DeadReckoning() {
		
		super(false);

		setSize(frame.getWidth(), frame.getHeight());

		// Set fields:
		changeTheta.setBounds(93, intoOrbit.getHeight(this) + 15, 80, 30);
		done.setBounds(176, intoOrbit.getHeight(this) + 15, 80, 30);
		setTheta.setBounds(20, intoOrbit.getHeight(this) + 15, 70, 30);
		setTheta.setVisible(true);
		changeTheta.setVisible(true);
		done.setVisible(true);

		// Set theta fields listeners
		changeTheta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theta = Math.toRadians(Integer.parseInt(setTheta.getText()));
				repaint();
			}
		});
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setRobotPosition = false;
				setTheta.setVisible(false);
				changeTheta.setVisible(false);
				done.setVisible(false);
				createStartPoints((int)x + (int)width/2, (int)y + (int)height/2);
				repaint();
			}
		});

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		frame.add(this);

		// Add fields:
		add(setTheta);
		add(changeTheta);
		add(done);

		rect.setBounds((int)x, (int)y, (int)width, (int)height);
		repaint();
	}

	public void drawRotatedShape(final Graphics2D g2, final Shape shape,
			final double angle,
			final float x, final float y) {

		final AffineTransform saved = g2.getTransform();
		final AffineTransform rotate = AffineTransform.getRotateInstance(
				angle, x+width/2, y+height/2);
		g2.transform(rotate);
		g2.fill(shape);
		g2.setColor(Color.BLACK);
		g2.draw(shape);
		g2.setTransform(saved);

	}

	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = GUI.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		}
		catch(Exception e){
			System.out.println("error: " + e.getMessage());
		}
		return tempImage;
	}

	public void calculatePosition() {
		double s = (vr+vl)/2;
		theta = (vr-vl)/width + theta;
		x = s*Math.cos(theta) + x;
		y = s*Math.sin(theta) + y;
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.DARK_GRAY);
		drawRotatedShape(g2d, rect, theta, (float)x, (float)y);

		g2d.setColor(Color.red);

		g2d.fillOval((int)x + (int)width/2 - 5, (int)y + (int)height/2 - 5, 10, 10);

		if (!onStart) {
			changeTheta.repaint();
			setTheta.repaint();
			done.repaint();
		}

		onStart = false;
	}

	public static void main(String[] args) {
		new DeadReckoning();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (!setRobotPosition)
			super.mousePressed(e);

		else {
			if (new Rectangle(e.getX(), e.getY(), 1, 1).intersects(rect)) {
				onDrag = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!setRobotPosition)
			super.mouseReleased(e);

		else
			onDrag = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (!setRobotPosition) {
			super.mouseDragged(e);
		}
		else {
			if (onDrag) {
				rect.setLocation((int)(e.getX() - width/2), (int)(e.getY() - height/2));
				x = e.getX() - width/2;
				y = e.getY() - height/2;
			}

			if (rect.y + height >= intoOrbit.getHeight(this)) {
				rect.y = intoOrbit.getHeight(this)-(int)height;
				y = intoOrbit.getHeight(this)-(int)height;
			}

			if (rect.y <= 0) {
				rect.y = 0;
				y = 0;
			}

			if (rect.x + width >= intoOrbit.getWidth(this)) {
				rect.x = intoOrbit.getWidth(this)-(int)width;
				x = intoOrbit.getWidth(this)-(int)width;
			}

			if (rect.x <= 0) {
				rect.x = 0;
				x = 0;
			}
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
