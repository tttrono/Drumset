package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.util.ArrayList;

import Shapes.*;

/** Creates a CrashCymbalRight object. 
 *  Defaulted to the upper right of the drumset, it includes 
 *  the basic bronze plate and stand. */
public class CrashCymbalRight implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape cymbal;
	
	ArrayList<Circle> cymbalplate;

	/** The CrashCymbal constructor sets an initial scale of 1. */
	public CrashCymbalRight() {
		
		scale_x = 1.0;
		scale_y = 1.0;
		
		cymbalplate = new ArrayList<Circle>();
	}
	
	/** Draws the Crash Cymbal graphic. 
	 * 	Creates the bronze plate with color and circular rings. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 670;
		y = 145;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create base cymbal circle. */
		
		cymbal = new Ellipse2D.Double(x-114, y-114, 114*2, 114*2);
		g2d.setColor(Colors.BRONZE_LIGHT);
		g2d.fill(cymbal);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
		objectspecs.add(new ObjectSpec(x, y, 10, 10, 0, Color.BLACK));
		objectspecs.add(new ObjectSpec(x, y, 3, 3, 0, Color.WHITE));
		
		/** Create concentric rings. */
		int number_of_rings = 7;
		double radius = 10;
		
		for (int i = 0; i < number_of_rings; i++) {
			// cymbalplate.add(new Circle(X, Y, Radius, Stroke, Color));
			objectspecs.add(new ObjectSpec(x, y, radius+=10, radius, 3, Colors.BRONZE_SHADOW));
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
		
		CenteredLine stand = new CenteredLine(x, y, 24, 45, 4, Color.WHITE);
		stand.draw(g2d);
		
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
