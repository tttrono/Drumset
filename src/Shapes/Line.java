package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

/** The Line class is a modification of Line2D.Double class. 
 *  It takes an input of two end points plus
 *  a stroke value and Color. */
public class Line implements DrawingObject {

	private double x1;
	private double y1;
	private double x2;
	private double y2;
	
	private float stroke;
	private Color color;	

	/** Initiates the line object. */
	public Line(double x1, double y1, double x2, double y2, float s, Color c) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		stroke = s;
		color = c;
	}
	
	/** Draws the line object. */
	@Override
	public void draw(Graphics2D g2d) {
		
		Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
		
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(stroke));
		g2d.draw(line);
		
	}
}
