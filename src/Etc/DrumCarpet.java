package Etc;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.*;

public class DrumCarpet implements DrawingObject {
	
	double x;
	double y;
	
	public DrumCarpet() {
		// Center x and y as capability of Circle class
		x = 1281/2;
		y = 658/2;
		
	}
	
	public void draw(Graphics2D g2d) {
		
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{326,	4, Colors.GOLD}, 
				  		  {305,	5, Colors.GOLD}, 
				  		  {295,	7, Colors.GOLD}
		};
		
		// Draw gold rings
		for (int i = 0; i < RSC.length; i++) {
			//Circle circle = new CircleO(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, 
									   (int) RSC[i][0], 
									   (int) RSC[i][1], 
									   (Color) RSC[i][2]);
			circle.draw(g2d);
			
		}
		
		// Draw designs around
		int circles_num = 36;
		float angle = 360/circles_num;
		int radius = 315;
		
		for (int a = 0; a <= 360; a += angle ) {
			double c_x = radius*Math.cos(Math.toRadians(a));
			double c_y = radius*Math.sin(Math.toRadians(a)); 
			
			Circle c = new Circle(x + c_x, y - c_y, 4, 0, Colors.RED_BLOOD);
			c.draw(g2d);
		}
	}
}
