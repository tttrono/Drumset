package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import Shapes.Colors;
import Shapes.Rectangle;

public class BassDrum {
	
	//double x

	public BassDrum(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.		
		int x = 640;
		int y = 150;
		
		//AffineTransform reset = g2d.getTransform();
		//g2d.scale(2, 2);
		
		// Create base drum case		
		// WHSC = X, Y, Width, Height, Stroke, Color
		Object[][] XY_WHSC = {{x, y, 300, 240, 0, Color.BLACK}, 			   // base drum case
							  {x-(150/2), y+10, 150, 230, 0, Color.DARK_GRAY}, // lighted side
							  {x, 30, 310, 20, 0, Colors.SILVER}, 			   // edge linings
							  {x, 270, 310, 20, 0, Colors.SILVER},
							  {x, 150, 50, 30, 0, Colors.SILVER}, 			   // mid-belt
		};
		
		for (int i = 0; i < XY_WHSC.length; i++) {

			Rectangle rectangle = new Rectangle( (int) XY_WHSC[i][0],
												 (int) XY_WHSC[i][1], 
												 (int) XY_WHSC[i][2], 
												 (int) XY_WHSC[i][3], 
												 (int) XY_WHSC[i][4],
												 (Color) XY_WHSC[i][5]);
			rectangle.draw(g2d);
		}
		
		//g2d.setTransform(reset);
		
	}
	
	void rescale() {
		
	}

}
