package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/**
 * Represents a Crash Cymbal positioned on the left side.
 */
public class CrashCymbalLeft implements DrawingObject {
    private double x;
    private double y;
    private double scale_x;
    private double scale_y;
    
    /**
     * Constructs a CrashCymbalLeft with default scaling.
     */
    public CrashCymbalLeft() {
        scale_x = 1.0;
        scale_y = 1.0;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Center position adjusted for an 800x600 canvas
        x = 500;
        y = 145;
        
        x = x / scale_x;
        y = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Base cymbal circles: {radius, stroke, color}
        Object[][] RSC = {
            {114, 0, Colors.BRONZE_LIGHT},
            {10,  0, Color.BLACK}
        };
        
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(x, y, (int) RSC[i][0], (int) RSC[i][1], (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // Create concentric rings
        int rings = 7;
        double radius = 35;
        float stroke = 3;
        
        for (int i = 0; i < rings; i++) {
            Circle ring = new Circle(x, y, radius, stroke, Colors.BRONZE_SHADOW);
            ring.draw(g2d);
            radius += 10;
        }
        
        g2d.setTransform(reset);
    }
    
    /**
     * Incrementally rescales the crash cymbal.
     */
    public void rescale() {
        scale_x += 0.02;
        scale_y += 0.02;
    }
}
