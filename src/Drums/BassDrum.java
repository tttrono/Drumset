package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Shapes.Colors;
import Shapes.Rectangle;
import Shapes.DrawingObject;
import Shapes.ObjectSpec;

/** Creates a bass drum object. 
 * Defaulted in the middle of the drumset, it includes 
 * the bass drum body and a kick pedal. */
public class BassDrum implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Rectangle2D.Double drum;

	/** The BassDrum constructor sets an initial scale of 1. 
	 *  Initializes the drum body and kick pedal. */
	public BassDrum() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	/** Draws the bass drum object plus pedal. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Circle class. */	
		x = 800/2;
		y = 150;
		
		/** Calibrate x and y axis according to the scale set. */
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create drum body. */
		drum = new Rectangle2D.Double(x - 300/2, y - 240/2, 300, 240);					// base drum case
		g2d.setColor(Color.BLACK);
		g2d.fill(drum);
		
		ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
			         // new ObjectSpec(x, y, radius, -, stroke, color)
		objectspecs.add(new ObjectSpec(x-(150/2), y+10, 150, 230, 0, Color.DARK_GRAY));	// lighted side
		objectspecs.add(new ObjectSpec(x, 30,  310, 20, 0, Colors.SILVER));				// edge linings
		objectspecs.add(new ObjectSpec(x, 270, 310, 20, 0, Colors.SILVER));
		objectspecs.add(new ObjectSpec(x, 150, 50,  30, 0, Colors.SILVER));				// mid-holder
		
		/** Draw the shape objects. */
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
		
		// TO-DO: lugs and pegs
		// TO-DO: pedal
		
//		/** Create drum lugs and tuning pegs. */
//		//lugsandpegs.add(new Line2D.Double(X1, Y1, X2, Y2));
//		lugsandpegs.add(new Line2D.Double(x, 35, x, 55));
//		
//		for (int i = 0; i < lugsandpegs.size(); i++ ) {
//			g2d.setStroke(new BasicStroke(5));
//			g2d.setColor(Color.LIGHT_GRAY);
//			g2d.draw(lugsandpegs.get(i));
//			
//			//lugsandpegs.get(i).draw(g2d);
//		}
		
		g2d.setTransform(reset);
		
	}
	
	/** Magnifies the bass drum when it is kicked. */
	public void upscale() {
		
		scale_x = 1.03;
		scale_y = 1.03;
	}
	
	/** Restores the bass drum when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}