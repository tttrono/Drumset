package Etc;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/** Draws a drum carpet object. 
 *  The drummer needs a carpet underneath his drumset 
 *  so the bass drum doesn't slide away when kicking. */
public class DrumCarpet implements DrawingObject {
	
	double x;
	double y;
	
	ArrayList<DrawingObject> carpet;
	
	public DrumCarpet() {
		
		x = 800/2;
		y = 600/2;
		
	}
	
	/** Draws the carpet ring and base red color. */
	public void draw(Graphics2D g2d) {
		
		carpet = new ArrayList<DrawingObject>();
		
//		carpet.add(new Circle(x, y, 326, 4, Colors.GOLD));
		carpet.add(new Circle(x, y, 326, 0, Colors.RED_BLOOD));
		carpet.add(new Circle(x, y, 305, 5, Colors.PANTONE));
		carpet.add(new Circle(x, y, 305, 0, Colors.CREAM));
		carpet.add(new Circle(x, y, 295, 0, Colors.RED_BLOOD));
//		carpet.add(new Circle(x, y, 285, 0, Colors.RED_BLOOD));
//		carpet.add(new Circle(x, y, 275, 0, Colors.RED_BLOOD));
//		carpet.add(new Circle(x, y, 215, 0, Colors.RED_BLOOD));
//		carpet.add(new Circle(x, y, 200, 0, Colors.RED_BLOOD));
		
		for (DrawingObject circle : carpet) {
			circle.draw(g2d);
		}
	}
}
