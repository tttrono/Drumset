package Drums;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

import Shapes.*;

/** Creates a beater object for the bass drum. 
 * Defaulted in the middlemost of the drumset, 
 * it is a cushion object hitting the bass drum from the kick pedal. */
public class Beater implements DrawingObject {
	
	double x;
	double y;
	double scale_x; 
	double scale_y;

	/** The Beater constructor sets an initial scale of 1. 
	 *  Initializes the beater on the kick pedal. */
	public Beater() {
		
		scale_x = 1.0;
		scale_y = 1.0;
	}
	
	public void draw(Graphics2D g2d) {
		
		/** Center x and y as is capability of RoundedRectangle class. */	
		x = 800/2;
		y = 299;
		
		x = x/scale_x;
		y = y/scale_y;
		
		AffineTransform reset = g2d.getTransform();
		g2d.scale(scale_x, scale_y);
		
		/** Create drum beater. */
		RoundRectangle beater = new RoundRectangle(x, y, 32, 24, 19, 19, 0, Color.WHITE);
		beater.draw(g2d);
		
		Ellipse beater_core = new Ellipse(x, y+5, 15, 10, 0, Colors.SILVER);
		beater_core.draw(g2d);
		
		g2d.setTransform(reset);
		
	}
		
	/** Magnifies the beater when it is kicked. */
	public void upscale() {
		
		scale_x = 1.12;
		scale_y = 1.12;
	}
	
	/** Restores the beater when it is released. */
	public void downscale() {
		
		scale_x = 1;
		scale_y = 1;
	}
}
