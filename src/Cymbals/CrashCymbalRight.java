package Cymbals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import Shapes.*;

/** 
 * Creates a CrashCymbalRight object. 
 * Defaulted to the upper right of the drumset, it includes 
 * the basic bronze plate and stand.
 */
public class CrashCymbalRight implements DrawingObject {
    
    private double x;
    private double y;
    private double scale_x; 
    private double scale_y;
    
    private ArrayList<Circle> cymbalplate;

    /** 
     * The CrashCymbalRight constructor sets an initial scale and position.
     */
    public CrashCymbalRight() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 670;
        y = 145;
        
        cymbalplate = new ArrayList<Circle>();
    }
    
    /**
     * Sets a new position for the cymbal.
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
     * Draws the Crash Cymbal graphic. 
     * Creates the bronze plate with color and circular rings.
     */
    public void draw(Graphics2D g2d) {
        // Use current x and y values; adjust for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Clear previous circles to avoid accumulation.
        cymbalplate.clear();
        
        // Create base cymbal circles.
        cymbalplate.add(new Circle(drawX, drawY, 114, 0, Colors.BRONZE_LIGHT)); 
        cymbalplate.add(new Circle(drawX, drawY, 10,  0, Color.BLACK));
        
        // Create concentric rings.
        int number_of_rings = 7;
        double radius = 10;
        for (int i = 0; i < number_of_rings; i++) {
            radius += 10;
            cymbalplate.add(new Circle(drawX, drawY, radius, 3, Colors.BRONZE_SHADOW));
        }
        
        // Draw shape objects.
        for (Circle circle : cymbalplate) {			
            circle.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /** Magnifies the cymbal when it is hit. */
    public void upscale() {
        scale_x = 1.02;
        scale_y = 1.02;
    }
    
    /** Restores the cymbal when it is released. */
    public void downscale() {
        scale_x = 1;
        scale_y = 1;
    }
}
