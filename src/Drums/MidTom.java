package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Shapes.Circle;
import Shapes.DrawingObject;

/** Draws a High Tom Drum object from a given centerpoint. 
 *  Ideally should be drawn on top of a bass drum. */
public class MidTom implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;

	/** Accepts x and y coordinates of the centerpoint. 
	 * The default scale is 1.0 */
	public MidTom() {
		
		scale_x = 1.0;
		scale_y = 1.0;
		
	}
	
public void draw(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		x = 513;
		y = 183;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		Circle circle_ring = new Circle(x+10, y-35, 92, 8, Color.LIGHT_GRAY);
		circle_ring.draw(g2d);
		Circle circle_body = new Circle(x+10, y-35, 91, 0, Color.DARK_GRAY);
		circle_body.draw(g2d);
		
		// Create base drum circle
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{93, 0, Color.WHITE}, 
				  		  {47,  0, Color.LIGHT_GRAY},	
						  {96, 8, Color.LIGHT_GRAY} 
		};
		
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
		int radius = 96;
		
		for (int theta = 0; theta <= 360; theta += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(theta));
			double c_y = radius*Math.sin(Math.toRadians(theta)); 
			
			Circle c = new Circle(x + c_x, y - c_y, 2, 0, Color.WHITE);
			c.draw(g2d);
		}
		
		// Add hoop handles
//		int handles_num = 3;
//		angle = 360/handles_num;
//		radius = 96;
//		
//		for (int theta = 0; theta <= 360; theta += angle ) {
//			double c_x = radius*Math.cos(Math.toRadians(theta));
//			double c_y = radius*Math.sin(Math.toRadians(theta)); 
//			
//			Circle c = new Circle(x + c_x, y - c_y, 5, 5, Color.LIGHT_GRAY);
//			c.draw(g2d);
//		}
		
		g2d.setTransform(reset);
	}
	
	public void rescale() {
		
		//scale_x = 1.02;
		//scale_y = 1.02;
		
		// testing
		scale_x += 0.02;
		scale_y += 0.02;
	}

}
