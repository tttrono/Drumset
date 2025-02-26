package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/**
 * Represents a Ride Cymbal.
 */
public class RideCymbal implements DrawingObject {
    
    double x;
    double y;
    double scale_x; 
    double scale_y;

    public RideCymbal() {
        scale_x = 1.0;
        scale_y = 1.0;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Set center coordinates
        x = 712;
        y = 340;
        
        x = x / scale_x;
        y = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Base cymbal circles: {radius, stroke, color}
        Object[][] RSC = { {135, 0, Colors.BRONZE_DARK}, 
                           {10,  0, Color.BLACK} };
        
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(x, y, (int) RSC[i][0], 
                                        (int) RSC[i][1], 
                                        (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // Concentric rings
        int rings = 8;
        double radius = 40;
        float stroke = 3;
        for (int i = 0; i < rings; i++) {
            Circle circle = new Circle(x, y, radius, stroke, Colors.BRONZE_FINE);
            circle.draw(g2d);
            radius += 10;
        }
        
        g2d.setTransform(reset);
    }
    
    // Removed @Override because rescale() is not declared in the DrawingObject interface
    public void rescale() {
        // Toggle between normal (1.0) and a slightly larger scale (1.02)
        if (scale_x > 1.0) {
            scale_x = 1.0;
            scale_y = 1.0;
        } else {
            scale_x = 1.02;
            scale_y = 1.02;
        }
    }
}
