package Drums;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/** Creates a High Tom drum object. 
 *  Defaulted to the top left of the drumset, it includes 
 *  the basic drum body with lugs and pegs. */
public class HighTom implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Ellipse2D.Double drum;
	public Ellipse2D.Double body;
	
	/** The HighTom constructor sets an initial scale of 1. 
	 *  Initializes the drum body, plus lugs and pegs. */
	public HighTom() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	/** Draws the High Tom graphic. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */
		x = 310;
		y = 183;
		
		/** Calibrating x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create drum body and front circle. */
		ArrayList<DrawingObject> hightomdrum = new ArrayList<DrawingObject>();
		hightomdrum.add(new Circle(x-8, y-32, 80, 7, Color.LIGHT_GRAY));		// lower hoop	
		hightomdrum.add(new Circle(x-8, y-32, 79, 0, Color.DARK_GRAY));			// drum body
		hightomdrum.add(new Circle(x, 	y, 	  81, 0, Color.WHITE));				// front circle
		hightomdrum.add(new Circle(x,	y,    37, 0, Color.LIGHT_GRAY));	
		hightomdrum.add(new Circle(x, 	y, 	  84, 7, Color.LIGHT_GRAY));		// upper hoop
		
		/** Add circular pegs around the hoop. */
		int number_of_pegs = 10;
		double angle = 360/number_of_pegs;
		double radius = 84;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			hightomdrum.add(new Circle(x + c_x, y - c_y, 2, 0, Color.WHITE));
		}
		
		/** Add circular lugs also. */
		int number_of_handles = 3;
		angle = 360/number_of_handles;
		radius = 84;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			hightomdrum.add(new Circle(x + c_x, y - c_y, 5, 3, Color.LIGHT_GRAY));
		}
		
		/** Draw the shape objects. */
		for (DrawingObject part : hightomdrum) {
			part.draw(g2d);
		}
		
		drum = new Ellipse2D.Double(x-84, y-84, 84*2, 84*2);
		g2d.setStroke(new BasicStroke(7));
		g2d.setColor(Colors.INVISIBLE);
		g2d.draw(drum);
		
		body = new Ellipse2D.Double((x-8)-84, (y-32)-80, 80*2, 80*2);
		g2d.setStroke(new BasicStroke(7));
		g2d.setColor(Colors.INVISIBLE);
		g2d.draw(body);
		
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
