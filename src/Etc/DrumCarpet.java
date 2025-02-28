package Etc;

import java.awt.Color;
import java.awt.Graphics2D;

import Shapes.*;

public class DrumCarpet implements DrawingObject {
	
	double x;
	double y;
	
	public DrumCarpet() {
		// Center x and y as capability of Circle class
		//x = 1281/2;
		//y = 658/2;
		
		x = 800/2;
		y = 600/2;
		
	}
	
	public void draw(Graphics2D g2d) {
		
		// RSC = Radius, Stroke, Color
//		Object[][] RSC = {//{326,	4, Colors.GOLD}, 
//						  {326,	0, Colors.CREAM},
//				  		  //{305,	5, Colors.GOLD}, 
//				  		  {305,	0, Colors.BROWN}, 
//				  		  //{295,	7, Colors.GOLD},
//				  		  {295,	0, Colors.RED_BLOOD}
//		};
		
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
//		int circles_num = 36;
//		float angle = 360/circles_num;
//		//int radius = 315;
//		int radius = 290;
//		
//		for (int theta = 0; theta <= 360; theta += angle ) {
//			double c_x = radius*Math.cos(Math.toRadians(theta));
//			double c_y = radius*Math.sin(Math.toRadians(theta)); 
//			
//			Circle c = new Circle(x + c_x, y - c_y, 4, 0, Color.BLACK);
//			c.draw(g2d);
//		}
	}
}