package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.util.ArrayList;

import Shapes.*;

/** Creates a Floor Tom object. 
 *  Defaulted to the front right of the drumset, it includes 
 *  the basic drum circle with lugs and pegs. */
public class FloorTom implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape drum;

	/** The FloorTom constructor sets an initial scale of 1. */
	public FloorTom() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	/** Draws the Floor Tom graphic. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 560;
		y = 405;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create drum circle. */
		drum = new Ellipse2D.Double(x - 111, y - 111, 111*2, 111*2);
		g2d.setColor(Color.WHITE);
		g2d.fill(drum);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
		//objectspecs.add(new ObjectSpec(x, y, 110, 110, 0, Color.WHITE));
		objectspecs.add(new ObjectSpec(x, y, 60 , 60, 0, Color.LIGHT_GRAY));
		objectspecs.add(new ObjectSpec(x, y, 114, 114, 8, Color.LIGHT_GRAY));
		
		/** Add circular pegs around the hoop. */
		int number_of_pegs = 10;
		double angle = 360/number_of_pegs;
		int radius = 114;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			objectspecs.add(new ObjectSpec(x + c_x, y - c_y, 2, 2, 0, Color.WHITE));
		}
		
		/** Add circular lugs also. */
		int number_of_lugs = 3;
		angle = 360/number_of_lugs;
		radius = 115;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			objectspecs.add(new ObjectSpec(x + c_x, y - c_y, 5, 5, 5, Color.LIGHT_GRAY));
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
