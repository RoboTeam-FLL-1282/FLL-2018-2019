package Navigation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeadReckoning extends GUI implements MouseListener, MouseMotionListener{

	// Members:
	int width = 30;
	int height = 38;
	int x = 100;
	int y = 100;
	double theta = Math.toRadians(0);

	double vr = 0;
	double vl = 10;

	int time = 100;

	int index = 0;

	Rectangle rect = new Rectangle();
	AffineTransform transform = new AffineTransform();
	Shape rotatedRect;

	LinkedList<Double> angles = new LinkedList<>();

	boolean onDrag = false;
	
	boolean setRobotPosition = true;

	// Fields:
	JTextField setTheta = new JTextField("0");
	Label thetaLabel = new Label("θ:");
	JTextField setX = new JTextField("0");
	Label xLabel = new Label("X:");
	JTextField setY = new JTextField("0");
	Label yLabel = new Label("Y:");
	JButton done = new JButton("Done");

	JButton moveRobot = new JButton("Simulate");


	public DeadReckoning() {

		super(false);

		frame.setVisible(true);

		setSize(frame.getWidth(), frame.getHeight());

		// Set fields:
		thetaLabel.setBounds(5, intoOrbit.getHeight(this) + 20, 15, 20);
		thetaLabel.setBackground(Color.LIGHT_GRAY);

		xLabel.setBounds(55, intoOrbit.getHeight(this) + 20, 15, 20);
		xLabel.setBackground(Color.LIGHT_GRAY);

		yLabel.setBounds(105, intoOrbit.getHeight(this) + 20, 15, 20);
		yLabel.setBackground(Color.LIGHT_GRAY);

		setTheta.setBounds(20, intoOrbit.getHeight(this) + 15, 30, 30);
		setX.setBounds(70, intoOrbit.getHeight(this) + 15, 30, 30);
		setY.setBounds(120, intoOrbit.getHeight(this) + 15, 30, 30);

		done.setBounds(250, intoOrbit.getHeight(this) + 15, 80, 30);

		moveRobot.setBounds(20, intoOrbit.getHeight(this) + 15, 80, 30);

		thetaLabel.setVisible(true);
		xLabel.setVisible(true);
		yLabel.setVisible(true);

		setTheta.setVisible(true);
		setX.setVisible(true);
		setY.setVisible(true);
		done.setVisible(true);

		moveRobot.setVisible(false);

		// Set theta fields listeners
		setTheta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theta = Math.toRadians(Integer.parseInt(setTheta.getText()));
				repaint();
			}
		});

		setX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				x = (int)getRealPoint(Integer.parseInt(setX.getText()), Integer.parseInt(setY.getText())).x - width/2;
				rect.x = x;
				repaint();
			}
		});

		setY.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				y = (int)getRealPoint(Integer.parseInt(setX.getText()), Integer.parseInt(setY.getText())).y - height/2;
				rect.y = y;
				repaint();
			}
		});

		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTheta.setVisible(false);
				setX.setVisible(false);
				setY.setVisible(false);
				thetaLabel.setVisible(false);
				xLabel.setVisible(false);
				yLabel.setVisible(false);
				done.setVisible(false);

				moveRobot.setVisible(true);

				createStartPoints(x + width/2, y + height/2);
				repaint();
				setRobotPosition = false;
			}
		});

		moveRobot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Thread() {
					public void run() {
						moveVirtualRobot();
					}
				}.start();
			}
		});

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		frame.add(this);

		// Add fields:
		add(thetaLabel);
		add(xLabel);
		add(yLabel);

		add(setTheta);
		add(setX);
		add(setY);
		add(done);

		add(moveRobot);

		setTheta.setBackground(Color.LIGHT_GRAY);
		setX.setBackground(Color.LIGHT_GRAY);
		setY.setBackground(Color.LIGHT_GRAY);

		done.setBackground(Color.LIGHT_GRAY);

		moveRobot.setBackground(Color.LIGHT_GRAY);

		rect.setBounds(x, y, width, height);

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
		x = (int)(s*Math.cos(theta) + x);
		y = (int)(s*Math.sin(theta) + y);
	}

	public void repaintComponents() {
		for(int i = 0; i<getComponentCount(); i++) {
			if(getComponent(i).isVisible()) {
				getComponent(i).repaint();
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setStroke(new BasicStroke(1));

		g2d.setColor(Color.DARK_GRAY);
		drawRotatedShape(g2d, rect, theta, (float)x, (float)y);

		g2d.setColor(Color.red);

		g2d.fillOval(x + width/2 - 5, y + height/2 - 5, 10, 10);

		setX.setText((int)getAdaptedPoint(x, y).x + width/2 + "");
		setY.setText((int)getAdaptedPoint(x, y).y - height/2 + "");

		repaintComponents();

	}

	public static void main(String[] args) {
		new DeadReckoning();
	}

	private Point getAdaptedPoint(int realX, int realY) {
		return new Point(realX, intoOrbit.getHeight(this)-realY);
	}

	private Point getRealPoint(int adaptedX, int adaptedY) {
		return new Point(adaptedX, Math.abs(adaptedY-intoOrbit.getHeight(this)));
	}

	public  void loadAdaptedAngles() {

		angles = new LinkedList<>();

		for(int i = 0; i<splinePoints.size()-1; i++) {
			Point first = getAdaptedPoint((int)splinePoints.get(i).x, (int)splinePoints.get(i).y);
			Point second = getAdaptedPoint((int)splinePoints.get(i+1).x, (int)splinePoints.get(i+1).y);
			angles.add(Math.atan((second.x - first.x)/(second.y - first.y)));
		}

	}

	public void loadRealAngles() {

		angles = new LinkedList<>();

		for(int i = 0; i<splinePoints.size()-1; i++) {
			Point first = new Point((int)splinePoints.get(i).x, (int)splinePoints.get(i).y);
			Point second = new Point((int)splinePoints.get(i+1).x, (int)splinePoints.get(i+1).y);
			angles.add(Math.atan2(second.x - first.x, second.y - first.y));
		}

	}

	public void moveVirtualRobot() {

		simulates = true;
		loadRealAngles();

		for(int i = 0; i<angles.size()-1; i++) {
			x = (int)splinePoints.get(i).x - width/2;
			y = (int)splinePoints.get(i).y - height/2;
			rect.x = x;
			rect.y = y;
			theta = angles.get(i+1);
			System.out.println(theta);
			repaint();
			wait(10);
		}

		x = (int)splinePoints.get(splinePoints.size()-1).x - width/2;
		y = (int)splinePoints.get(splinePoints.size()-1).y - height/2;
		rect.x = x;
		rect.y = y;
		repaint();
		
		simulates = false;

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
				rect.setLocation(e.getX() - width/2, e.getY() - height/2);
				x = e.getX() - width/2;
				y = e.getY() - height/2;
			}

			if (rect.y+ height >= intoOrbit.getHeight(this)) {
				rect.y = intoOrbit.getHeight(this)-height;
				y = intoOrbit.getHeight(this)-height;
			}

			if (rect.y <= 0) {
				rect.y = 0;
				y = 0;
			}

			if (rect.x + width >= intoOrbit.getWidth(this)) {
				rect.x = intoOrbit.getWidth(this)-width;
				x = intoOrbit.getWidth(this)-width;
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
