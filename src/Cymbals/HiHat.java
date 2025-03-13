package Cymbals;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.util.ArrayList;

import Shapes.*;

/** Creates a HiHat object. 
 *  Defaulted to the front left of the drumset, it includes 
 *  the basic bronze plate and stand. */
public class HiHat implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape cymbal;
	public Shape pedal, subpedal;
	
	ArrayList<Circle> cymbalplate;

	/** The HiHat constructor sets an initial scale of 1. */
	public HiHat() {
		
		scale_x = 1.0;
		scale_y = 1.0;
		
		cymbalplate = new ArrayList<Circle>();
	}
	
	/** Draws the Crash Cymbal graphic. 
	 * 	Creates the bronze plate with color and circular rings. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 105;
		y = 355;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		g2d.rotate(Math.toRadians(-28),x,y);
		int z = 85;
		
		/** Create hihat pedal. */
		ArrayList<DrawingObject> full_pedals = new ArrayList<DrawingObject>();
		full_pedals.add(new RoundRectangle(x, 310+z, 38, 50, 0, 0, 0, Color.DARK_GRAY));	// head
		full_pedals.add(new RoundRectangle(x, 285+z, 50, 25, 10, 10, 0, Color.BLACK));		// toe
		full_pedals.add(new RoundRectangle(x, 400+z, 25, 25, 10, 10, 0, Color.DARK_GRAY));	// heel
		full_pedals.add(new RoundRectangle(x, 400+z, 20, 20, 10, 10, 0, Color.BLACK));		// heel overlay
		full_pedals.add(new IsoscelesTrapezoid(x, 360+z, 38, 25, 60, 0, Color.DARK_GRAY));	// heel mid
		//full_pedals.add(new Line(x, 280+z, x, 290, 6, Colors.SILVER));
		full_pedals.add(new CenteredLine(x, 387+z, 25, 0, 1, Color.BLACK));
		full_pedals.add(new IsoscelesTrapezoid(x, 369+z, 22, 19, 3, 0, Color.BLACK));
		full_pedals.add(new IsoscelesTrapezoid(x, 359+z, 24, 21, 3, 0, Color.BLACK));
		
		for (DrawingObject part : full_pedals) {
			part.draw(g2d);
		}
		
		/** Create hihat cymbal circle. */
		int span = 95;
		cymbal = new Ellipse2D.Double(x-span, y-span, span*2, span*2);
		g2d.setColor(Colors.BRONZE_LIGHT);
		g2d.fill(cymbal);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
		objectspecs.add(new ObjectSpec(x, y, 10, 10, 0, Color.LIGHT_GRAY));
		objectspecs.add(new ObjectSpec(x, y, 3, 3, 0, Color.LIGHT_GRAY));
		
		/** Create concentric rings. */
		int number_of_rings = 8;
		double radius = 10;
		
		for (int i = 0; i < number_of_rings; i++) {
			// cymbalplate.add(new Circle(X, Y, Radius, Stroke, Color));
			objectspecs.add(new ObjectSpec(x, y, radius+=8, radius, 2, Colors.BRONZE_SHADOW));
		}
		
		/** Draw the shape objects. */
		for (int i = 0; i < objectspecs.size(); i++ ) {
			
			Circle circle = new Circle( objectspecs.get(i).x,
												 objectspecs.get(i).y,
												 objectspecs.get(i).width,
												 objectspecs.get(i).stroke,
												 objectspecs.get(i).color 
			);			
			
			circle.draw(g2d);
		}
		
		CenteredLine stand = new CenteredLine(x, y, 26, 45, 4, Color.LIGHT_GRAY);
		stand.draw(g2d);
		
		pedal = new Rectangle2D.Double(x-38/2, 280+z, 38, 70);
		g2d.setColor(Colors.INVISIBLE);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(pedal);	
		
		subpedal = new Rectangle2D.Double(x-25/2, 280+z, 25, 134);
		g2d.setColor(Colors.INVISIBLE);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(subpedal);
		
		g2d.setTransform(reset);
	}
	
	/** Magnifies the cymbal when it is hit. */
	public void upscale() {
		
		scale_x = 1.03;
		scale_y = 1.03;
	}
	
	/** Restores the cymbal when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}
