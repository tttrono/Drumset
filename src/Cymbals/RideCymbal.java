package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.util.ArrayList;

import Shapes.*;

public class RideCymbal implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape cymbal;
	
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
		objectspecs.add(new ObjectSpec(x, y, 3, 3, 0, Color.WHITE));
		
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
		
		CenteredLine stand = new CenteredLine(x, y, 24, 60, 4, Color.WHITE);
		stand.draw(g2d);
		
		g2d.setTransform(reset);
	}
	
	public void upscale() {
		
		scale_x = 1.02;
		scale_y = 1.02;
		
	}
	
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	
	}
}
