package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;

/**
 * Represents a Hi-Hat cymbal set composed of two overlapping cymbals.
 */
public class HiHat implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x;
    private double scale_y;
    
    /**
     * Constructs a HiHat with default scaling and an initial position.
     */
    public HiHat() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set initial position only once.
        x = 300;
        y = 150;
    }
    
    /**
     * Sets a new position for the hi-hat.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Optional getters if needed.
     */
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Use the current x and y values and adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Define cymbal layers for the top hi-hat cymbal
        Object[][] topCymbal = {
            {30, 0, Colors.SILVER},
            {25, 2, Colors.BRONZE_LIGHT}
        };
        
        // Define cymbal layers for the bottom hi-hat cymbal
        Object[][] bottomCymbal = {
            {30, 0, Colors.SILVER},
            {25, 2, Colors.BRONZE_LIGHT}
        };
        
        // Draw the top hi-hat cymbal with a slight upward offset
        for (int i = 0; i < topCymbal.length; i++) {
            Circle circle = new Circle(drawX, drawY - 3, (int) topCymbal[i][0], (int) topCymbal[i][1], (Color) topCymbal[i][2]);
            circle.draw(g2d);
        }
        
        // Draw the bottom hi-hat cymbal with a slight downward offset
        for (int i = 0; i < bottomCymbal.length; i++) {
            Circle circle = new Circle(drawX, drawY + 3, (int) bottomCymbal[i][0], (int) bottomCymbal[i][1], (Color) bottomCymbal[i][2]);
            circle.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /**
     * Toggles the hi-hat's scale between normal (1.0) and a slightly larger scale (1.02).
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

    /**
     * Restores the hi-hat to its original scale.
     */
    public void downscale() {
        scale_x = 1.0;
        scale_y = 1.0;
    }
}