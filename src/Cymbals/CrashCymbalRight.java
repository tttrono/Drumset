package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Shapes.*;

/** Creates a CrashCymbal object. 
 *  Generates from a center coordinate with x and y and creates circle rings with define colors. */
public class CrashCymbalRight implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;

	public CrashCymbalRight() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		x = 670;
		y = 145;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		// Create base cymbal circle
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{114, 0, Colors.BRONZE_LIGHT}, 
						  {10,  0, Color.BLACK}};
		
		for (int i = 0; i < RSC.length; i++) {
			//circle = new CircleO(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, (int) RSC[i][0], 
									   		 (int) RSC[i][1], 
									   		 (Color) RSC[i][2]);
			circle.draw(g2d);
		}
		
		// Create concentric rings
		int rings = 7;
		double radius = 35;
		float stroke = 3;
		
		for (int i = 0; i < rings; i++) {
			Circle circle = new Circle(x, y, radius, 
									   		 stroke, 
									   		 Colors.BRONZE_SHADOW);
			circle.draw(g2d);
			
			radius += 10;
		}
		
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
