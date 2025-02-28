package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import Shapes.*;

public class FloorTom implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Ellipse2D.Double drum;

	public FloorTom() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		x = 560;
		y = 405;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		drum = new Ellipse2D.Double(x - 110, y - 110, 110*2, 110*2);
		g2d.setColor(Color.WHITE);
		g2d.fill(drum);
		
		// Create base drum circle
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {//{110, 0, Color.WHITE}, 
				  		  {60,  0, Color.LIGHT_GRAY},	
						  {114, 8, Color.LIGHT_GRAY} 
		};
		
//		ArrayList<ObjectSpec> specs = new ArrayList<ObjectSpec>();
//		   // new ObjectSpec(x, y, radius, -, stroke, color)
//		specs.add(new ObjectSpec(x, y, 110, 0, 0, Color.WHITE));
//		specs.add(new ObjectSpec(x, y, 60 , 0, 0, Color.LIGHT_GRAY));
//		specs.add(new ObjectSpec(x, y, 114, 0, 0, Color.LIGHT_GRAY));
		
		for (int i = 0; i < RSC.length; i++) {
			//Circle circle = new Circle(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, (int) RSC[i][0], 
									   		 (int) RSC[i][1], 
									   		 (Color) RSC[i][2]);
			circle.draw(g2d);
		}
		
		// Add circular pegs
		int pegs_num = 10;
		float angle = 360/pegs_num;
		int radius = 114;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			Circle c = new Circle(x + c_x, y - c_y, 2, 0, Color.WHITE);
			c.draw(g2d);
		}
		
		// Add hoop handles
		int handles_num = 3;
		angle = 360/handles_num;
		radius = 116;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			Circle c = new Circle(x + c_x, y - c_y, 5, 5, Color.LIGHT_GRAY);
			c.draw(g2d);
		}
		
		g2d.setTransform(reset);
	}
	
	/** Magnifies the drum when it is hit. */
	public void upscale() {
		
		scale_x = 1.03;
		scale_y = 1.03;
	}
	
	/** Restores the drum when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}


//package Drums;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.geom.AffineTransform;
//import java.util.ArrayList;
//
//import Shapes.Circle;
//import Shapes.DrawingObject;
//
///** Creates a floor tom object. 
// *  Defaulted to the front right of the drumset, it includes 
// *  the basic drum circle with lugs and pegs. */
//public class FloorTom implements DrawingObject {
//	
//	double x;
//	double y;
//	double scale_x; 
//	double scale_y;
//	
//	ArrayList<Circle> drumbody;
//	ArrayList<Circle> lugsandpegs;
//
//	/** The FloorTom constructor sets an initial scale of 1. 
//	 *  Initializes the drum body, plus lugs and pegs. */
//	public FloorTom() {
//		
//		scale_x = 1.0;
//		scale_y = 1.0;
//		
//		drumbody = new ArrayList<Circle>();
//		lugsandpegs = new ArrayList<Circle>();
//	}
//	
//	/** Draws the Floor Tom graphic. */
//	public void draw(Graphics2D g2d) {
//		
//		/** Center x and y as is capability of Circle class. */
//		x = 560;
//		y = 405;
//		
//		/** Calibrating x and y axis according to the scale set. */
//		x = x/scale_x;
//		y = y/scale_y;
//		
//		AffineTransform reset = g2d.getTransform();
//		g2d.scale(scale_x, scale_y);
//		
//		/** Create drum circle. */
//		//drumbody.add(new Circle(X, Y, Radius, Stroke, Color)
//		drumbody.add(new Circle(x, y, 110, 0, Color.WHITE)); 
//		drumbody.add(new Circle(x, y, 60,  0, Color.LIGHT_GRAY));
//		drumbody.add(new Circle(x, y, 114, 8, Color.LIGHT_GRAY));
//		
//		for (int i = 0; i < drumbody.size(); i++ ) {
//			drumbody.get(i).draw(g2d);
//		}
//		
//		/** Add circular pegs around the hoop. */
//		int number_of_pegs = 10;
//		double angle = 360/number_of_pegs;
//		double radius = 114;
//		
//		for (int theta = 0; theta <= 360; theta += angle ) {
//			double c_x = radius*Math.cos(Math.toRadians(theta));
//			double c_y = radius*Math.sin(Math.toRadians(theta)); 
//			
//			// lugsandpegs.add(new Circle(X + c_x, Y - c_y, Radius, Stroke, Color));
//			lugsandpegs.add(new Circle(x + c_x, y - c_y, 2, 0, Color.WHITE));
//		}
//		
//		/** Add circular lugs also. */
//		int number_of_lugs = 3;
//		angle = 360/number_of_lugs;
//		radius = 116;
//		
//		for (int theta = 0; theta <= 360; theta += angle ) {
//			double c_x = radius*Math.cos(Math.toRadians(theta));
//			double c_y = radius*Math.sin(Math.toRadians(theta)); 
//			
//			// lugsandpegs.add(new Circle(X + c_x, Y - c_y, Radius, Stroke, Color));
//			lugsandpegs.add(new Circle(x + c_x, y - c_y, 5, 5, Color.LIGHT_GRAY));
//		}
//		
//		/** Draw shape objects. */
//		for (int i = 0; i < lugsandpegs.size(); i++ ) {
//			lugsandpegs.get(i).draw(g2d);
//		}
//		
//		g2d.setTransform(reset);
//	}
//	
//	/** Magnifies the drum when it is hit. */
//	public void upscale() {
//		
//		scale_x = 1.02;
//		scale_y = 1.02;
//	}
//	
//	/** Restores the drum when it is released. */
//	public void downscale() {
//		
//		scale_x = 1;
//		scale_y = 1;
//	}
//}