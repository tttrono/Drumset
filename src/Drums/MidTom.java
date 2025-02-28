package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.DrawingObject;

/** Creates a Mid Tom drum object. 
 *  Defaulted to the top right of the drumset, it includes 
 *  the basic drum body with lugs and pegs. */
public class MidTom implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	ArrayList<Circle> drumbody;
	ArrayList<Circle> lugsandpegs;

	/** The FloorTom constructor sets an initial scale of 1. 
	 *  Initializes the drum body, plus lugs and pegs. */
	public MidTom() {
		
		scale_x = 1.0;
		scale_y = 1.0;
		
		drumbody = new ArrayList<Circle>();
		lugsandpegs = new ArrayList<Circle>();
	}
	
	/** Draws the Mid Tom graphic. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 513;
		y = 183;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create drum body and front circle. */
		//drumbody.add(new Circle(X, Y, Radius, Stroke, Color)
		drumbody.add(new Circle(x+10, y-35, 92, 8, Color.LIGHT_GRAY));	// lower hoop
		drumbody.add(new Circle(x+10, y-35, 91, 0, Color.DARK_GRAY));	// drum body
		drumbody.add(new Circle(x, y, 93, 0, Color.WHITE));				// front circle
		drumbody.add(new Circle(x, y, 47, 0, Color.LIGHT_GRAY));
		drumbody.add(new Circle(x, y, 96, 8, Color.LIGHT_GRAY)); 		// upper hoop
		
		/** Draw shape objects. */
		for (int i = 0; i < drumbody.size(); i++ ) {
			drumbody.get(i).draw(g2d);
		}
		
		/** Add circular pegs around the hoop. */
		int number_of_pegs = 10;
		double angle = 360/number_of_pegs;
		double radius = 96;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			// lugsandpegs.add(new Circle(X + c_x, Y - c_y, Radius, Stroke, Color));
			lugsandpegs.add(new Circle(x + c_x, y - c_y, 2, 0, Color.WHITE));
		}
		
		/** Add circular lugs also. */
		int handles_num = 3;
		angle = 360/handles_num;
		radius = 96;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			// lugsandpegs.add(new Circle(X + c_x, Y - c_y, Radius, Stroke, Color));
			lugsandpegs.add(new Circle(x + c_x, y - c_y, 5, 3, Color.LIGHT_GRAY));
		}
		
		/** Draw shape objects. */
		for (int i = 0; i < lugsandpegs.size(); i++ ) {
			lugsandpegs.get(i).draw(g2d);
		}
		
		g2d.setTransform(reset);
	}
	
	/** Magnifies the drum when it is hit. */
	public void upscale() {
		
		scale_x = 1.02;
		scale_y = 1.02;
	}
	
	/** Restores the drum when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}
