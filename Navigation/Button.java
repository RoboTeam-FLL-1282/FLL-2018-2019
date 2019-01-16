package Navigation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Button extends JPanel implements MouseListener, MouseMotionListener {

	ButtonListener buttonListener;
	String text;

	boolean visible = true;
	JPanel container;
	Rectangle rect;
	Color background = Color.DARK_GRAY;
	Color savedBackground = background;
	Color onMouseOverBackgroundColor;
	Color onMouseOverTextColor;
	Color onMouseOverBorderColor;

	Color textColor = new Color(255, 255, 255);
	Color savedTextColor = textColor;
	Font font = new Font("Arial", Font.BOLD, 20);
	Color borderColor;
	Color savedBorderColor = borderColor;
	float thickness = 1;

	boolean brighter = false;

	public static boolean buttonPressed = false;

	/**
	 * @param name - Button's identifier
	 * @param text - Button's label
	 * @param buttonListener - Implements ButtonListener
	 * @param container - JPanel container
	 */
	public Button(String text, ButtonListener buttonListener, JPanel container) {
		this.text = text;
		this.buttonListener = buttonListener;
		this.container = container;
		container.addMouseListener(this);
		container.addMouseMotionListener(this);
	}

	/**
	 * @param name - Button's identifier
	 * @param text - Button's label
	 * @param buttonListener - Implements ButtonListener
	 * @param container - JPanel container
	 * @param rect - Button's bounds
	 */
	public Button(String text, ButtonListener buttonListener, JPanel container, Rectangle rect) {
		this.text = text;
		this.buttonListener = buttonListener;
		this.container = container;
		container.addMouseListener(this);
		container.addMouseMotionListener(this);
		this.rect = rect;
	}

	/**
	 * @param visible - Is the robot showing or not
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @param text - Button's label
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param buttonListener - Implements ButtonListener
	 */
	public void setButtonListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}

	/**
	 * @param container - JPanel container
	 */
	public void setContainer(JPanel container) {
		container.addMouseListener(this);
		container.addMouseMotionListener(this);
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.rect = new Rectangle(x, y, width, height);
	}

	/**
	 * @param color - Background color
	 */
	public void setBackground(Color color) {
		this.background = color;
	}

	/**
	 * @param color - Text color
	 */
	public void setTextColor(Color color) {
		this.textColor = color;
	}

	/**
	 * @param font - Text font
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * The color that the button's background will change to when mouse is over it.
	 * By default, the button's background will get brighter.
	 * @param color
	 */
	public void setOnMouseOverBackgroundColor(Color color) {
		this.onMouseOverBackgroundColor = color;
	}

	/**
	 * The color that the button's text will change to when mouse is over it.
	 * @param color
	 */
	public void setOnMouseOverTextColor(Color color) {
		this.onMouseOverTextColor = color;
	}

	/**
	 * The color that the button's border will change to when mouse is over it.
	 * @param color
	 */
	public void setOnMouseOverBorderColor(Color color) {
		this.onMouseOverBorderColor = color;
	}

	/**
	 * Set a border for the button.
	 * @param color
	 */
	public void setBorder(Color color, float thickness) {
		this.borderColor = color;
		this.thickness = thickness;
	}

	/**
	 * Repaints the button, should be called after every JPanel repaint.
	 * @param g - Paint's Graphics object.
	 */
	public void repaint(Graphics g) {
		repaint((Graphics2D)g);
	}

	/**
	 * Repaints the button, should be called after every JPanel repaint.
	 * @param g - Paint's Graphics2D object.
	 */
	public void repaint(Graphics2D g2d) {

		if(visible) {
			g2d.setColor(background);
			g2d.fill(rect);

			g2d.setFont(font);
			g2d.setColor(textColor);

			FontMetrics fm = g2d.getFontMetrics();
			Rectangle2D r = fm.getStringBounds(text, g2d);

			int x = (rect.width - (int) r.getWidth()) / 2 + rect.x;
			int y = (rect.height - (int) r.getHeight()) / 2 + fm.getAscent() + rect.y;

			g2d.drawString(text, x, y);

			if(borderColor != null) {
				g2d.setColor(borderColor);
				g2d.setStroke(new BasicStroke(thickness));
				g2d.draw(rect);
			}
		}

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

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(rect.intersects(new Rectangle(e.getX(), e.getY(), 1, 1))) {
			buttonListener.onButtonPressed(this);
			buttonPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(buttonPressed) {
			buttonListener.onButtonReleased(this);
		}
		buttonPressed = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(rect.intersects(new Rectangle(e.getX(), e.getY(), 1, 1))) {
			if(!brighter) {
				savedBackground = background;
				savedTextColor = textColor;
				savedBorderColor = borderColor;
				for(int i = 0; i<1; i++)
					background = background.brighter();
				if(onMouseOverBackgroundColor != null)
					background = onMouseOverBackgroundColor;
				if(onMouseOverTextColor != null)
					textColor = onMouseOverTextColor;
				if(onMouseOverBorderColor != null)
					borderColor = onMouseOverBorderColor;
				container.repaint();
				brighter = true;
			}
		}
		else {
			if(brighter) {
				background = savedBackground;
				textColor = savedTextColor;
				borderColor = savedBorderColor;
				brighter = false;
				container.repaint();
			}
		}
	}

}
