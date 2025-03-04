package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import Shapes.Circle;
import Shapes.DrawingObject;

/** 
 * Creates a Mid Tom drum object. 
 * Defaulted to the top right of the drumset, it includes 
 * the basic drum body with lugs and pegs.
 */
public class MidTom implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x; 
    private double scale_y;
    
    private ArrayList<Circle> drumbody;
    private ArrayList<Circle> lugsandpegs;

    /**
     * The MidTom constructor sets an initial scale of 1, an initial position,
     * and initializes the lists for drum body and lugs/pegs.
     */
    public MidTom() {
        scale_x = 1.0;
        scale_y = 1.0;
        x = 513;
        y = 183;
        drumbody = new ArrayList<Circle>();
        lugsandpegs = new ArrayList<Circle>();
    }
    
    /**
     * Sets a new position for the Mid Tom drum.
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
     * Draws the Mid Tom graphic.
     */
    public void draw(Graphics2D g2d) {
        // Use the current x and y values and adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Clear the lists to prevent accumulation on each repaint.
        drumbody.clear();
        lugsandpegs.clear();
        
        // Create drum body and front circle.
        drumbody.add(new Circle(drawX + 10, drawY - 35, 92, 8, Color.LIGHT_GRAY));   // lower hoop
        drumbody.add(new Circle(drawX + 10, drawY - 35, 91, 0, Color.DARK_GRAY));      // drum body
        drumbody.add(new Circle(drawX, drawY, 93, 0, Color.WHITE));                   // front circle
        drumbody.add(new Circle(drawX, drawY, 47, 0, Color.LIGHT_GRAY));
        drumbody.add(new Circle(drawX, drawY, 96, 8, Color.LIGHT_GRAY));              // upper hoop
        
        // Draw the drum body shapes.
        for (Circle circle : drumbody) {
            circle.draw(g2d);
        }
        
        // Add circular pegs around the hoop.
        int number_of_pegs = 10;
        double angle = 360.0 / number_of_pegs;
        double radius = 96;
        
        for (double theta = 0; theta <= 360; theta += angle) {
            double c_x = radius * Math.cos(Math.toRadians(theta));
            double c_y = radius * Math.sin(Math.toRadians(theta)); 
            lugsandpegs.add(new Circle(drawX + c_x, drawY - c_y, 2, 0, Color.WHITE));
        }
        
        // Add circular lugs.
        int handles_num = 3;
        angle = 360.0 / handles_num;
        radius = 96;
        
        for (double theta = 0; theta <= 360; theta += angle) {
            double c_x = radius * Math.cos(Math.toRadians(theta));
            double c_y = radius * Math.sin(Math.toRadians(theta)); 
            lugsandpegs.add(new Circle(drawX + c_x, drawY - c_y, 5, 3, Color.LIGHT_GRAY));
        }
        
        // Draw the lugs and pegs.
        for (Circle circle : lugsandpegs) {
            circle.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /** 
     * Magnifies the drum when it is hit.
     */
    public void upscale() {
        scale_x = 1.02;
        scale_y = 1.02;
    }
    
    /** 
     * Restores the drum when it is released.
     */
    public void downscale() {
        scale_x = 1;
        scale_y = 1;
    }
}
