package Etc;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/** Draws drum carpet object. 
 *  The drummer needs a carpet underneath the drumset 
 *  so the bass drum so it doesn't slide afar. */
public class DrumCarpet implements DrawingObject {
	
	double x;
	double y;
	
	public DrumCarpet() {
		
		x = 800/2;
		y = 600/2;
		
	}
	
	public void draw(Graphics2D g2d) {
		
		Object[][] RSC = {//{326,	4, Colors.GOLD}, 
				  {326,	0, Colors.RED_BLOOD},
		  		  //{305,	5, Colors.PANTONE}, 
		  		  {305,	0, Colors.CREAM}, 
		  		  {295,	0, Colors.RED_BLOOD},
		  		  {285,	0, Colors.RED_BLOOD}, 
		  		  {275,	0, Colors.RED_BLOOD},
		  		  {215,	0, Colors.RED_BLOOD},
		  		  {200,	0, Colors.RED_BLOOD}
};
		
		/** Draw gold rings */
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
