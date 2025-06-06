package Etc;

import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Shapes.Colors;
import Shapes.DrawingObject;

public class Floor implements DrawingObject {
	
	BufferedImage backgroundImage = null;
	
	public Floor() {
		try {
			backgroundImage = ImageIO.read(new File("./Etc/Images/Wooden-flooring.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d) {
		Rectangle2D.Double floor = new Rectangle2D.Double(0,0,800,600);
		
		if (backgroundImage != null) {
			g2d.drawImage(backgroundImage, 0, 0, (int) floor.getWidth(), (int) floor.getHeight(), null);
		}
	}
}
