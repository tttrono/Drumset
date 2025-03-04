package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import Shapes.*;

/**
 * Represents a Floor Tom drum.
 */
public class FloorTom implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x; 
    private double scale_y;
    
    public Ellipse2D.Double drum;
    
    /**
     * Constructs a FloorTom with default scaling and initial position.
     */
    public FloorTom() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 560;
        y = 405;
    }
    
    /**
     * Sets a new position for the FloorTom.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Returns the current x position.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the current y position.
     */
    public double getY() {
        return y;
    }
    
    /**
     * Draws the FloorTom drum.
     */
    public void draw(Graphics2D g2d) {
        // Use the current x and y values and adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Draw the main drum body.
        drum = new Ellipse2D.Double(drawX - 110, drawY - 110, 110 * 2, 110 * 2);
        g2d.setColor(Color.WHITE);
        g2d.fill(drum);
        
        // Base drum circles (RSC = {radius, stroke, color})
        Object[][] RSC = {
            {110, 0, Color.WHITE}, 
            {60,  0, Color.LIGHT_GRAY},    
            {114, 8, Color.LIGHT_GRAY}
        };
        
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(drawX, drawY, (int) RSC[i][0], (int) RSC[i][1], (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // Add circular pegs.
        int pegs_num = 10;
        float angle = 360 / pegs_num;
        int radius = 114;
        
        for (int theta = 0; theta <= 360; theta += angle) {
            double c_x = radius * Math.cos(Math.toRadians(theta));
            double c_y = radius * Math.sin(Math.toRadians(theta));
            
            Circle c = new Circle(drawX + c_x, drawY - c_y, 2, 0, Color.WHITE);
            c.draw(g2d);
        }
        
        // Add hoop handles.
        int handles_num = 3;
        angle = 360 / handles_num;
        radius = 116;
        
        for (int theta = 0; theta <= 360; theta += angle) {
            double c_x = radius * Math.cos(Math.toRadians(theta));
            double c_y = radius * Math.sin(Math.toRadians(theta));
            
            Circle c = new Circle(drawX + c_x, drawY - c_y, 5, 5, Color.LIGHT_GRAY);
            c.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /**
     * Magnifies the drum when it is hit.
     */
    public void upscale() {
        scale_x = 1.03;
        scale_y = 1.03;
    }
    
    /**
     * Restores the drum when it is released.
     */
    public void downscale() {
        scale_x = 1;
        scale_y = 1;
    }
}
