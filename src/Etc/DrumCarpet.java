package Etc;

import java.awt.Color;
import java.awt.Graphics2D;
import Shapes.*;

/**
 * Represents the drum carpet with a series of concentric rings.
 */
public class DrumCarpet implements DrawingObject {
    
    private double x;
    private double y;
    
    /**
     * Constructs a DrumCarpet with an initial center position.
     */
    public DrumCarpet() {
        // Set the initial center for an 800x600 canvas.
        x = 800 / 2;
        y = 600 / 2;
    }
    
    /**
     * Sets a new position for the drum carpet.
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
    
    @Override
    public void draw(Graphics2D g2d) {
        // RSC = {radius, stroke, color}
        Object[][] RSC = {
            // {326, 4, Colors.GOLD},
            {326, 0, Colors.RED_BLOOD},
            // {305, 5, Colors.PANTONE},
            {305, 0, Colors.CREAM},
            {295, 0, Colors.RED_BLOOD},
            {285, 0, Colors.RED_BLOOD},
            {275, 0, Colors.RED_BLOOD},
            {215, 0, Colors.RED_BLOOD},
            {200, 0, Colors.RED_BLOOD}
        };
        
        // Draw the carpet's rings.
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(x, y, (int) RSC[i][0], (int) RSC[i][1], (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // (Optional design elements can be added here.)
    }
}
