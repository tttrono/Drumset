package Etc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.DrawingObject;

/** Creates a simple circular drum chair
 *  ideally cushioned for drumming. */
public class Chair implements DrawingObject{

	double x;
	double y;
	
	public Chair() {
		
	}

	public void draw(Graphics2D g2d) {
		
		x = 335;
		y = 550;
		
		ArrayList<Circle> chair = new ArrayList<Circle>();
		chair.add(new Circle(x, y, 60, 0, Color.BLACK));
		
		for (DrawingObject part: chair) {
			part.draw(g2d);
		}
	}
}
