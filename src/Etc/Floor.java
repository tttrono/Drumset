package Etc;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import Shapes.Colors;

public class Floor {
	
	public Floor(Graphics2D g2d) {
		
		Rectangle2D.Double fl = new Rectangle2D.Double(0,0,1281,658);
		g2d.setColor(Colors.INVISIBLE);
		g2d.fill(fl);
		
	}
	
}
