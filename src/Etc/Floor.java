package Etc;
import java.awt.*;
import java.awt.geom.*;

public class Floor {
	
	public Floor(Graphics2D g2d) {
		
		Rectangle2D.Double fl = new Rectangle2D.Double(0,0,1281,658);
		g2d.setColor(Color.GRAY);
		g2d.fill(fl);
		
	}
	
}
