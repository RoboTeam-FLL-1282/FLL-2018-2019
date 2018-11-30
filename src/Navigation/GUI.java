package Navigation;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GUI extends JPanel implements MouseMotionListener, MouseListener{

	ArrayList<Point> points = new ArrayList<Point>();
	JFrame frame;
	HermiteSpline si;
	Image intoOrbit = getImage("intoOrbit.jpg");
	int m = 1;
	Polygon p = new Polygon();
	boolean dragged = false;
	int draggedOne = 0;
	int mouseX = 0;
	int mouseY = 0;
	
	Button save = new Button("save");
	
	LinkedList<Point> splinePoints = new LinkedList<>();

	public GUI() {
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		intoOrbit.getWidth(this);
		intoOrbit.getHeight(this);
		wait(1000);
		frame = new JFrame("Hermite Spline");
		frame.setSize(intoOrbit.getWidth(this)*m + 15, intoOrbit.getHeight(this)*m + 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i<3; i++) {
			points.add(new Point(0, intoOrbit.getHeight(this)*m));
		}
		save.setBounds(10, 583, 100, 50);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<splinePoints.size(); i++) {
					System.out.println(i + ".	" + splinePoints.get(i).x + ", " + splinePoints.get(i).y);
				}
			}
		});
		save.setVisible(true);
		frame.add(save);
		frame.add(this);
		repaint();
	}

	private double calculate_distance_between_points(Point point1, Point point2) {
		double deltaX = point2.x - point1.x;
		double deltaY = point2.y - point1.y;
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
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

	private void wait(int milliSeconds) {
		try {Thread.sleep(milliSeconds);} catch(Exception e) {}
	}

	@Override
	public void paint(Graphics g) {
		
		splinePoints = new LinkedList<>();

		p.reset();

		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.drawImage(intoOrbit, 0, 0, intoOrbit.getWidth(this)*m, intoOrbit.getHeight(this)*m, this);
		
		g2d.setStroke(new BasicStroke(4));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.red);
		for(int i = 3; i<points.size(); i++) {
			if(i>0)
				g2d.drawLine((int)points.get(i-1).x, (int)points.get(i-1).y, (int)points.get(i).x, (int)points.get(i).y);
		}
		
		g2d.setColor(Color.black);
		for(int i = 3; i<points.size(); i++) {
			g2d.fillOval((int)points.get(i).x-10, (int)points.get(i).y-10, 20, 20);
		}

		try {
			if(points.size() > 3) {
				si = new HermiteSpline(points);
				g2d.setColor(Color.green);

				for(double i = 0; i<=1; i+=0.0001) {
					p.addPoint((int)si.interpolate_X(i), (int)si.interpolate_Y(i));
					splinePoints.add(new Point(si.interpolate_X(i), si.interpolate_Y(i)));
				}
				g2d.setStroke(new BasicStroke(3));
				g2d.drawPolyline(p.xpoints, p.ypoints, p.npoints);
			}
		} catch(Exception e) {System.out.println(e.getMessage());}
	}

	public static void main(String[] args) {

		new GUI();

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

		for(int i = 0; i<points.size(); i++) {
			if(calculate_distance_between_points(new Point(e.getX(),  e.getY()), points.get(i)) <= 10) {
				if(SwingUtilities.isRightMouseButton(e)) {
					points.remove(i);
				}
				else {
					dragged = true;
					draggedOne = i;
				}
			}
		}

		if(!dragged && SwingUtilities.isLeftMouseButton(e))
			points.add(new Point(e.getX(), e.getY()));
		
		else if(mouseX == e.getX() && mouseY == e.getY()) {
			if(SwingUtilities.isLeftMouseButton(e))
				points.add(new Point(e.getX(), e.getY()));
		}

		repaint();

		mouseX = e.getX();
		mouseY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(dragged) {
			points.set(draggedOne, new Point(e.getX(), e.getY()));
			dragged = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if(dragged) {
			points.set(draggedOne, new Point(e.getX(), e.getY()));
		}

		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
