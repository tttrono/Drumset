package Etc;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.*;

public class DrumCarpet {

	public DrumCarpet(Graphics2D g2d) {
		
		// Center x and y as capability of Circle class
		double x = 1281/2;
		double y = 658/2;
		
		// Color Gold = new Color(122,110,62);
		// RSC = Radius, Stroke, Color
		Object[][] RSC = {{326,	4, Colors.GOLD}, 
						  {305,	5, Colors.GOLD}, 
						  {295,	7, Colors.GOLD}
		};
			
		for (int i = 0; i < RSC.length; i++) {
			//Circle circle = new CircleO(x,y,radius,stroke,color);
			Circle circle = new Circle(x, y, 
									   (int) RSC[i][0], 
									   (int) RSC[i][1], 
									   (Color) RSC[i][2]);
			circle.draw(g2d);	
		}
	}
}
