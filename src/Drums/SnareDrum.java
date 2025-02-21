package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Shapes.*;

public class SnareDrum {

	public SnareDrum(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		double x = 500;
		double y = 420;
		
		//AffineTransform reset = g2d.getTransform();
		//g2d.scale(2, 2);
		
		// Create base drum circle
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{110, 0, Color.WHITE}, 
				  		  {60,  0, Color.LIGHT_GRAY},	
						  {114, 8, Color.LIGHT_GRAY} 
		};
		
		for (int i = 0; i < RSC.length; i++) {
			//CircleO circle = new CircleO(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, 
									   (int) RSC[i][0], 
									   (int) RSC[i][1], 
									   (Color) RSC[i][2]);
			circle.draw(g2d);
		}
		
		//g2d.setTransform(reset);
	}
}
