package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;
import Shapes.ObjectSpec;
import Shapes.Rectangle;

public class RideCymbal implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Ellipse2D.Double cymbal;
	
	//ArrayList<Circle> cymbalplate;

	public RideCymbal() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		x = 712;
		y = 340;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create base cymbal circle. */
		cymbal = new Ellipse2D.Double(x - 135, y - 135, 135*2, 135*2);
		g2d.setColor(Colors.BRONZE_DARK);
		g2d.fill(cymbal);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
        // new ObjectSpec(x, y, radius, -, stroke, color)
		objectspecs.add(new ObjectSpec(x, y, 10, 10, 0, Color.BLACK));
		
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
		
		/** Create concentric rings. */
		int rings = 8;
		double radius = 40;
		float stroke = 3;
		
		for (int i = 0; i < rings; i++) {
			
			Circle circle = new Circle(x, y, radius,
									   		 stroke,
									   		 Colors.BRONZE_FINE);
			circle.draw(g2d);
			
			radius += 10;
		}
		
		g2d.setTransform(reset);
	}
	
	public void upscale() {
		
		scale_x = 1.03;
		scale_y = 1.03;
		
	}
	
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	
	}
}


//package Cymbals;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.geom.AffineTransform;
//import java.awt.geom.Ellipse2D;
//import java.util.ArrayList;
//
//import Shapes.Circle;
//import Shapes.Colors;
//import Shapes.DetectableObject;
//import Shapes.DrawingObject;
//
///** Creates a RideCymbal object. 
// *  Defaulted to the mid right of the drumset, it includes 
// *  the basic bronze plate and stand. */
//public class RideCymbal implements DrawingObject {
//	
//	double x;
//	double y;
//	double scale_x; 
//	double scale_y;
//	
//	public Ellipse2D.Double cymbal;
//	
//	ArrayList<Circle> cymbalplate;
//
//	/** The RideCymbal constructor sets an initial scale of 1. */
//	public RideCymbal() {
//		
//		scale_x = 1.0;
//		scale_y = 1.0;
//		
//		cymbalplate = new ArrayList<Circle>();
//	}
//	
//	/** Draws the Ride Cymbal graphic. 
//	 *  Creates the bronze plate with bronze plate with color and circular rings. */
//	public void draw(Graphics2D g2d) {
//		
//		/** Center x and y as is capability of Circle class. */
//		x = 712;
//		y = 340;
//		
//		/** Calibrating x and y axis according to the scale set. */
//		x = x/scale_x;
//		y = y/scale_y;
//		
//		AffineTransform reset = g2d.getTransform();
//		g2d.scale(scale_x, scale_y);
//		
//		cymbal = new Ellipse2D.Double(x - 135, y - 135, 135*2, 135*2);
//		g2d.setColor(Colors.BRONZE_DARK);
//		g2d.fill(cymbal);
//		
////		cymbal = new Circle(x, y, 135, 0, Colors.BRONZE_DARK);
////		cymbal.draw(g2d);
//		
//		/** Create base cymbal circle. */
//		// cymbalplate.add(new Circle(X, Y, Radius, Stroke, Color));
//		//cymbalplate.add(new Circle(x, y, 135, 0, Colors.BRONZE_DARK)); 
//		cymbalplate.add(new Circle(x, y, 10,  0, Color.BLACK));
//		
////		Circle circle2 = new Circle(x, y, 10,  0, Color.BLACK);
////		circle2.draw(g2d);
////		
////		/** Create concentric rings. */
////		int number_of_rings = 8;
////		double radius = 40;
////		
////		for (int i = 0; i < number_of_rings; i++) {
////			// cymbalplate.add(new Circle(X, Y, Radius, Stroke, Color));
////			cymbalplate.add(new Circle(x, y, radius+=10, 3, Colors.BRONZE_FINE));
////		}
////		
//		/** Draw shape objects. */
//		for (int i = 0; i < cymbalplate.size(); i++) {
//			cymbalplate.get(i).draw(g2d);
//		}
//		
//		g2d.setTransform(reset);
//	}
//	
//	/** Magnifies the cymbal when it is hit. */
//	public void upscale() {
//		
//		scale_x = 1.02;
//		scale_y = 1.02;
//	}
//	
//	/** Restores the cymbal when it is released. */
//	public void downscale() {
//		
//		scale_x = 1;
//		scale_y = 1;
//	}
//}
