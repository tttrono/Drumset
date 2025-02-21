package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.*;

public class Cymbal {

	public Cymbal(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.
		double x = 300;
		double y = 400;
		
		// Create base cymbal circle
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{114, 0, Colors.BRONZE_LIGHT}, 
						  {10,  0, Color.BLACK}};
		
		for (int i = 0; i < RSC.length; i++) {
			//circle = new CircleO(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, 
									   (int) RSC[i][0], 
									   (int) RSC[i][1], 
									   (Color) RSC[i][2]);
			circle.draw(g2d);
		}
		
		// Create concentric rings
		int rings = 7;
		double radius = 35;
		float stroke = 3;
		
		for (int i = 0; i < rings; i++) {
			Circle circle = new Circle(x, y, 
									   radius, 
									   stroke, 
									   Colors.BRONZE_SHADOW);
			circle.draw(g2d);
			
			radius += 10;
		}
	}
}
