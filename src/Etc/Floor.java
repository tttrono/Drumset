package Etc;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import Shapes.Colors;
import Shapes.DrawingObject;

public class Floor implements DrawingObject {
	
	public Floor() {
		
	}
	
	public void draw(Graphics2D g2d) {
		Rectangle2D.Double floor = new Rectangle2D.Double(0,0,800,600);
		//g2d.setColor(Colors.RED_BLOOD);
		g2d.setColor(Colors.INVISIBLE);
		g2d.fill(floor);
	}
	
}
