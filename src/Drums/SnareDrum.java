package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.Circle;
import Shapes.DrawingObject;

/**
 * Represents a Snare Drum, designed similarly to the Floor Tom but smaller in size.
 */
public class SnareDrum implements DrawingObject {
    private double x;
    private double y;
    private double scale_x;
    private double scale_y;
    
    /**
     * Constructs a SnareDrum with default scaling and an initial position.
     */
    public SnareDrum() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 200;
        y = 400;
    }
    
    /**
     * Sets a new position for the snare drum.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Gets the current x position.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the current y position.
     */
    public double getY() {
        return y;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Use the current x and y values, adjusted for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Base drum circles: {radius, stroke, color}
        Object[][] RSC = {
            {80, 0, Color.WHITE},
            {40, 0, Color.LIGHT_GRAY},
            {84, 4, Color.DARK_GRAY}
        };
        
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(drawX, drawY, (int) RSC[i][0], (int) RSC[i][1], (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // Draw circular pegs around the drum
        int pegs_num = 8;
        float angle = 360.0f / pegs_num;
        int radius = 84;
        for (int theta = 0; theta < 360; theta += angle) {
            double c_x = radius * Math.cos(Math.toRadians(theta));
            double c_y = radius * Math.sin(Math.toRadians(theta));
            Circle peg = new Circle(drawX + c_x, drawY - c_y, 2, 0, Color.BLACK);
            peg.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /**
     * Incrementally rescales the snare drum.
     */
    public void rescale() {
        scale_x += 0.02;
        scale_y += 0.02;
    }
    
    /**
     * Restores the snare drum to its original scale.
     */
    public void downscale() {
        scale_x = 1.0;
        scale_y = 1.0;
    }
}
