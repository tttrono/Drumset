package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/** 
 * The Square class is a modification of Rectangle2D.Double.
 * It accepts center point coordinates and renders a square of the given width.
 */
public class Square implements DrawingObject {

    private double x;
    private double y;
    private double width;
    
    private float stroke;
    private Color color;	
    
    private double rotation; // rotation in degrees

    public Square(double x, double y, double w, float s, Color c) {
        this.x = x;
        this.y = y;
        width = w;
        stroke = s;
        color = c;
        rotation = 0;
    }
    
    /**
     * Sets a new center position for the square.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Returns the current center x-coordinate.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the current center y-coordinate.
     */
    public double getY() {
        return y;
    }
    
    /**
     * Sets the rotation angle (in degrees) for the square.
     */
    public void setRotation(double rotationDegrees) {
        this.rotation = rotationDegrees;
    }
    
    /**
     * Returns the current rotation angle in degrees.
     */
    public double getRotation() {
        return rotation;
    }
    
    /**
     * Rotates the square by the given degrees.
     * This method increments the current rotation.
     */
    public void rotate(float degrees) {
        this.rotation += degrees;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Save the original transform.
        AffineTransform reset = g2d.getTransform();
        
        // Translate to the center, then rotate around the center,
        // and translate to position the top-left corner at (0,0)
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(rotation));
        g2d.translate(-width/2, -width/2);
        
        Rectangle2D.Double square = new Rectangle2D.Double(0, 0, width, width);
        g2d.setColor(color);
        
        if (stroke != 0) {
            g2d.setStroke(new BasicStroke(stroke));
            g2d.draw(square);
        } else {
            g2d.fill(square);
        }
        
        // Restore the original transform.
        g2d.setTransform(reset);
    }
}
