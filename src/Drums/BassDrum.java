package Drums;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import Shapes.Colors;
import Shapes.Rectangle;
import Shapes.DrawingObject;
import Shapes.ObjectSpec;

public class BassDrum implements DrawingObject {
	
	//double x, y;
	double x;
	double y;
	double scale_x; 
	double scale_y;

	public BassDrum() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		
		// Center x and y as is capability of Circle class.		
		x = 800/2;
		y = 150;
		
//		x = (int) Math.round(x/scale_x);
//		y = (int) Math.round(y/scale_y);
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		// Create base drum case		
		// XY_WHSC = X, Y, Width, Height, Stroke, Color
//		Object[][] XY_WHSC = {{x, y, 300, 240, 0, Color.BLACK}, 			   // base drum case
//							  {x-(150/2), y+10, 150, 230, 0, Color.DARK_GRAY}, // lighted side
//							  {x, 30, 310, 20, 0, Colors.SILVER}, 			   // edge linings
//							  {x, 270, 310, 20, 0, Colors.SILVER},
//							  {x, 150, 50, 30, 0, Colors.SILVER}, 			   // mid-belt
//		};
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
		       // new ObjectSpec(x, y, radius, -, stroke, color)
		objectspecs.add(new ObjectSpec(x, y, 300, 240, 0, Color.BLACK));				// base drum case
		objectspecs.add(new ObjectSpec(x-(150/2), y+10, 150, 230, 0, Color.DARK_GRAY));	// lighted side
		objectspecs.add(new ObjectSpec(x, 30,  310, 20, 0, Colors.SILVER));				// edge linings
		objectspecs.add(new ObjectSpec(x, 270, 310, 20, 0, Colors.SILVER));
		objectspecs.add(new ObjectSpec(x, 150, 50,  30, 0, Colors.SILVER));				// mid-holder
		
//		for (int i = 0; i < XY_WHSC.length; i++) {
//
//			Rectangle rectangle = new Rectangle( (int) XY_WHSC[i][0],
//												 (int) XY_WHSC[i][1], 
//												 (int) XY_WHSC[i][2], 
//												 (int) XY_WHSC[i][3], 
//												 (int) XY_WHSC[i][4],
//												 (Color) XY_WHSC[i][5]);
//			rectangle.draw(g2d);
//		}
		
		for (int i = 0; i < objectspecs.size(); i++ ) {
			
			Rectangle rectangle = new Rectangle( objectspecs.get(i).x,
												 objectspecs.get(i).y,
												 objectspecs.get(i).width,
												 objectspecs.get(i).height,
												 objectspecs.get(i).stroke,
												 objectspecs.get(i).color 
			);			
			
			rectangle.draw(g2d);
		}
		
		Line2D.Double line = new Line2D.Double(x, 35, x, 55);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.draw(line);
		
		g2d.setTransform(reset);
		
	}
	
	public void rescale() {
		
		scale_x = 1.02;
		scale_y = 1.02;
	}
}