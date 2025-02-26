package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.*;

public class BassDrum implements DrawingObject {
    
    double x;
    double y;
    double scale_x; 
    double scale_y;

    public BassDrum() {
        scale_x = 1.0;
        scale_y = 1.0;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Set center position
        x = 400;
        y = 300;
        
        x = x / scale_x;
        y = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Create base drum case
        Object[][] specs = {
            {x, y, 300, 240, 0, Color.BLACK}, 
            {x - (150 / 2), y + 10, 150, 230, 0, Color.DARK_GRAY},
            {x, 30, 310, 20, 0, Colors.SILVER},
            {x, 270, 310, 20, 0, Colors.SILVER},
            {x, 150, 50, 30, 0, Colors.SILVER}
        };

        for (Object[] spec : specs) {
            Rectangle rect = new Rectangle(
                (double) spec[0], (double) spec[1], 
                (double) spec[2], (double) spec[3], 
                (float) spec[4], (Color) spec[5]
            );
            rect.draw(g2d);
        }

        g2d.setTransform(reset);
    }

    /**
     * Toggles between normal size (1.0) and a slightly larger size (1.02).
     */
    public void rescale() {
        if (scale_x > 1.0) {
            scale_x = 1.0;
            scale_y = 1.0;
        } else {
            scale_x = 1.02;
            scale_y = 1.02;
        }
    }
}
