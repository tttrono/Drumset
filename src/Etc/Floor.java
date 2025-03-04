package Etc;

import java.awt.*;
import java.awt.geom.*;
import Shapes.DrawingObject;

public class Floor implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;
    
    /**
     * Constructs a Floor with default position and dimensions.
     */
    public Floor() {
        // Default floor covers the entire canvas
        x = 0;
        y = 0;
        width = 1281;
        height = 658;
        color = Color.GRAY;
    }
    
    /**
     * Sets a new position for the floor.
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
        Rectangle2D.Double floorRect = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(floorRect);
    }
}
