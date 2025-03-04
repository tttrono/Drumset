package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Shapes.Colors;
import Shapes.Rectangle;
import Shapes.DrawingObject;
import Shapes.ObjectSpec;

/** 
 * Creates a bass drum object. 
 * Defaulted in the middle of the drumset, it includes 
 * the bass drum body and a kick pedal.
 */
public class BassDrum implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x; 
    private double scale_y;
    
    public Rectangle2D.Double drum;

    /** 
     * The BassDrum constructor sets an initial scale of 1 and an initial position.
     * Initializes the drum body and kick pedal.
     */
    public BassDrum() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 800 / 2;
        y = 150;
    }
    
    /**
     * Sets a new position for the bass drum.
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
     * Draws the bass drum object plus pedal.
     */
    public void draw(Graphics2D g2d) {
        // Use the current x and y values and adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        /** Create drum body. */
        drum = new Rectangle2D.Double(drawX - 300 / 2, drawY - 240 / 2, 300, 240);  // base drum case
        g2d.setColor(Color.BLACK);
        g2d.fill(drum);
        
        ArrayList<ObjectSpec> objectspecs = new ArrayList<ObjectSpec>();
        // new ObjectSpec(x, y, radius, width, stroke, color)
        objectspecs.add(new ObjectSpec(drawX - (150 / 2), drawY + 10, 150, 230, 0, Color.DARK_GRAY)); // lighted side
        objectspecs.add(new ObjectSpec(drawX, 30, 310, 20, 0, Colors.SILVER));                // edge linings
        objectspecs.add(new ObjectSpec(drawX, 270, 310, 20, 0, Colors.SILVER));
        objectspecs.add(new ObjectSpec(drawX, 150, 50, 30, 0, Colors.SILVER));                // mid-holder
        
        /** Draw the shape objects. */
        for (ObjectSpec spec : objectspecs) {
            Rectangle rectangle = new Rectangle(spec.x, spec.y, spec.width, spec.height, spec.stroke, spec.color);
            rectangle.draw(g2d);
        }
        
        // TO-DO: lugs, pegs, and pedal
        
        g2d.setTransform(reset);
    }
    
    /** 
     * Magnifies the bass drum when it is kicked.
     */
    public void upscale() {
        scale_x = 1.03;
        scale_y = 1.03;
    }
    
    /** 
     * Restores the bass drum when it is released.
     */
    public void downscale() {
        scale_x = 1;
        scale_y = 1;
    }
}