package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.util.ArrayList;

import Shapes.*;

/** Creates a CrashCymbalLeft object. 
 *  Defaulted to the upper left of the drumset, it includes 
 *  the basic bronze plate and stand. */
public class CrashCymbalLeft implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape cymbal;
	
	ArrayList<Circle> cymbalplate;

	/** The CrashCymbal constructor sets an initial scale of 1. */
	public CrashCymbalLeft() {
		
		scale_x = 1.0;
		scale_y = 1.0;
		
		cymbalplate = new ArrayList<Circle>();
	}
	
	/** Draws the Crash Cymbal graphic. 
	 * 	Creates the bronze plate with color and circular rings. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 150;
		y = 145;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create base cymbal circle. */
		int span = 105;
		cymbal = new Ellipse2D.Double(x-span, y-span, span*2, span*2);
		g2d.setColor(Colors.BRONZE_LIGHT);
		g2d.fill(cymbal);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
		objectspecs.add(new ObjectSpec(x, y, 10, 10, 0, Color.BLACK));
		objectspecs.add(new ObjectSpec(x, y, 3, 3, 0, Color.WHITE));
		
		/** Create concentric rings. */
		int number_of_rings = 8;
		double radius = 10;
		
		for (int i = 0; i < number_of_rings; i++) {
			// cymbalplate.add(new Circle(X, Y, Radius, Stroke, Color));
			objectspecs.add(new ObjectSpec(x, y, radius+=9, radius, 2, Colors.BRONZE_SHADOW));
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
		
		CenteredLine stand = new CenteredLine(x, y, 24, 85, 4, Color.WHITE);
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
