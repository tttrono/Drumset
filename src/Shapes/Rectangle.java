package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/** 
 * The Rectangle class is a modification of Rectangle2D.Double.
 * It accepts center point coordinates and renders the rectangle from a given width and height.
 */
public class Rectangle implements DrawingObject {

    private double x;
    private double y;
    private double width;
    private double height;
    
    private float stroke;
    private Color color;	

    public Rectangle(double x, double y, double w, double h, float s, Color c) {
        this.x = x;
        this.y = y;
        width = w;
        height = h;
        stroke = s;
        color = c;
    }
    
    /**
     * Sets a new center position for the rectangle.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Returns the current center x position.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the current center y position.
     */
    public double getY() {
        return y;
    }
    
    // Optional: setters and getters for width, height, stroke, and color.
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setStroke(float stroke) {
        this.stroke = stroke;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Save the original transform.
        AffineTransform reset = g2d.getTransform();
        
        // Translate so that (x, y) is the center of the rectangle.
        g2d.translate(x - (width / 2), y - (height / 2));
        
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(color);
        
        if (stroke != 0) {
            g2d.setStroke(new BasicStroke(stroke));
            g2d.draw(rect);
        } else {
            g2d.fill(rect);
        }
        
        // Restore the original transform.
        g2d.setTransform(reset);
    }
}
