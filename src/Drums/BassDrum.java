package Drums;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Shapes.*;

/** Creates a bass drum object. 
 * Defaulted in the middle of the drumset, it includes 
 * the bass drum body and a kick pedal. */
public class BassDrum implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;
	
	public Shape drum;
	public Shape pedal, subpedal;

	/** The BassDrum constructor sets an initial scale of 1. 
	 *  Initializes the drum body and kick pedal. */
	public BassDrum() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	/** Draws the bass drum graphic plus pedal. */
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of Rectangle class. */	
		x = 800/2;
		y = 150;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create bass drum pedal. */
		ArrayList<DrawingObject> full_pedals = new ArrayList<DrawingObject>();
		
		full_pedals.add(new RoundRectangle(x, 310, 38, 50, 0, 0, 0, Color.DARK_GRAY));		// head
		full_pedals.add(new RoundRectangle(x, 285, 50, 25, 10, 10, 0, Color.BLACK));		// toe
		full_pedals.add(new RoundRectangle(x, 400, 25, 25, 10, 10, 0, Color.DARK_GRAY));	// heel
		full_pedals.add(new RoundRectangle(x, 400, 20, 20, 10, 10, 0, Color.BLACK));		// heel overlay
		full_pedals.add(new IsoscelesTrapezoid(x, 360, 38, 25, 60, 0, Color.DARK_GRAY));	// heel mid
		full_pedals.add(new Line(x, 280, x, 290, 6, Colors.SILVER));
		full_pedals.add(new CenteredLine(x, 387, 25, 0, 1, Color.BLACK));
		full_pedals.add(new IsoscelesTrapezoid(x, 369, 22, 19, 3, 0, Color.BLACK));
		full_pedals.add(new IsoscelesTrapezoid(x, 359, 24, 21, 3, 0, Color.BLACK));
		
		for (DrawingObject part : full_pedals) {
			part.draw(g2d);
		}
		
		/** Create drum body. */
		ArrayList<DrawingObject> bassdrum = new ArrayList<DrawingObject>();
		
		bassdrum.add(new Rectangle(x, y,  300, 250, 0, Color.BLACK));				// base drum
		bassdrum.add(new Rectangle(x-(150/2), y, 150, 230, 0, Color.DARK_GRAY));	// lighted side
		bassdrum.add(new Rectangle(x, 30,  310, 20, 0, Colors.SILVER));				// edge linings
		bassdrum.add(new Rectangle(x, 270, 310, 20, 0, Colors.SILVER));
		bassdrum.add(new Rectangle(x, 150, 50,  30, 0, Colors.SILVER));				// mid-holder
		
		for (DrawingObject part : bassdrum) {
			part.draw(g2d);
		}
		
		/** Create drum lugs and tuning pegs. */
		ArrayList<DrawingObject> lugsandpegs = new ArrayList<DrawingObject>();
		
		Integer[][][] y1y2_pairs 	= {{{35,60}, {60,70}}, {{240,265}, {230,240}}};
		Integer[] x_distances 		= {-125, -75, 0, 75, 125};
 		
		for (Integer[][] y1y2_pair : y1y2_pairs ) { 
			for (Integer distance : x_distances) {
				lugsandpegs.add(new Line(x+distance, y1y2_pair[0][0], x+distance, y1y2_pair[0][1], 3, Color.LIGHT_GRAY));
				lugsandpegs.add(new Line(x+distance, y1y2_pair[1][0], x+distance, y1y2_pair[1][1], 9, Color.LIGHT_GRAY));
			}
		}
		
		for (DrawingObject part : lugsandpegs) {
			part.draw(g2d);
		}
		
		/** Creating detection areas. */
		drum = new Rectangle2D.Double(x - 300/2, y - 240/2, 300, 250);					
		g2d.setColor(Colors.INVISIBLE);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(drum);
		
		pedal = new Rectangle2D.Double(x-38/2, 280, 38, 70);
		g2d.setColor(Colors.INVISIBLE);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(pedal);	
		
		subpedal = new Rectangle2D.Double(x-25/2, 280, 25, 134);
		g2d.setColor(Colors.INVISIBLE);
		g2d.setStroke(new BasicStroke(1));
		g2d.draw(subpedal);
		
		g2d.setTransform(reset);
		
	}
		
	/** Magnifies the bass drum when it is kicked. */
	public void upscale() {
		
		scale_x = 1.02;
		scale_y = 1.02;
	}
	
	/** Restores the bass drum when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}
