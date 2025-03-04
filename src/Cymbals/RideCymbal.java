package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.Colors;
import Shapes.DrawingObject;
import Shapes.ObjectSpec;

/** 
 * Creates a RideCymbal object. 
 * Defaulted to the mid right of the drumset, it includes 
 * the basic bronze plate and stand.
 */
public class RideCymbal implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x; 
    private double scale_y;
    
    public Ellipse2D.Double cymbal;
    
    /**
     * The RideCymbal constructor sets an initial scale of 1 and position.
     */
    public RideCymbal() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 712;
        y = 340;
    }
    
    /**
     * Sets a new position for the ride cymbal.
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
    
    /** 
     * Draws the Ride Cymbal graphic. 
     * Creates the bronze plate with color and circular rings.
     */
    public void draw(Graphics2D g2d) {
        // Use current x and y values and adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Create base cymbal circle.
        cymbal = new Ellipse2D.Double(drawX - 135, drawY - 135, 135 * 2, 135 * 2);
        g2d.setColor(Colors.BRONZE_DARK);
        g2d.fill(cymbal);
        
        ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
        // new ObjectSpec(x, y, radius, width, stroke, color)
        objectspecs.add(new ObjectSpec(drawX, drawY, 10, 10, 0, Color.BLACK));
        
        // Draw the shape objects.
        for (ObjectSpec spec : objectspecs) {
            Circle circle = new Circle(spec.x, spec.y, spec.width, spec.stroke, spec.color);
            circle.draw(g2d);
        }
        
        // Create concentric rings.
        int rings = 8;
        double radius = 40;
        float stroke = 3;
        
        for (int i = 0; i < rings; i++) {
            Circle circle = new Circle(drawX, drawY, radius, stroke, Colors.BRONZE_FINE);
            circle.draw(g2d);
            radius += 10;
        }
        
        g2d.setTransform(reset);
    }
    
    /** 
     * Magnifies the cymbal when it is hit.
     */
    public void upscale() {
        scale_x = 1.02;
        scale_y = 1.02;
    }
    
    /** 
     * Restores the cymbal when it is released.
     */
    public void downscale() {
        scale_x = 1;
        scale_y = 1;
    }
}
