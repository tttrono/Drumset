package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.AffineTransform;

/**
 * Represents a line with specified start and end points.
 * Provides a method to rotate the line about its midpoint.
 */
public class Line implements DrawingObject {
    private double x1, y1, x2, y2;
    private float stroke;
    private Color color;
    
    /**
     * Constructs a Line object with given endpoints, stroke thickness, and color.
     *
     * @param x1 starting x-coordinate
     * @param y1 starting y-coordinate
     * @param x2 ending x-coordinate
     * @param y2 ending y-coordinate
     * @param stroke stroke thickness
     * @param color line color
     */
    public Line(double x1, double y1, double x2, double y2, float stroke, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform original = g2d.getTransform();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(stroke));
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(line);
        g2d.setTransform(original);
    }
    
    /**
     * Rotates the line about its midpoint by the specified angle in degrees.
     *
     * @param angleDegrees the angle to rotate in degrees
     */
    public void rotate(double angleDegrees) {
        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;
        double angleRadians = Math.toRadians(angleDegrees);
        double cos = Math.cos(angleRadians);
        double sin = Math.sin(angleRadians);
        
        // Rotate first endpoint
        double dx = x1 - midX;
        double dy = y1 - midY;
        double newX1 = midX + dx * cos - dy * sin;
        double newY1 = midY + dx * sin + dy * cos;
        
        // Rotate second endpoint
        dx = x2 - midX;
        dy = y2 - midY;
        double newX2 = midX + dx * cos - dy * sin;
        double newY2 = midY + dx * sin + dy * cos;
        
        x1 = newX1;
        y1 = newY1;
        x2 = newX2;
        y2 = newY2;
    }
    
    // Optional: Getter methods for dynamic repositioning.
    public double getX1() {
        return x1;
    }
    
    public double getY1() {
        return y1;
    }
    
    public double getX2() {
        return x2;
    }
    
    public double getY2() {
        return y2;
    }
    
    // Optional: Setter methods for dynamic repositioning.
    public void setX1(double x1) {
        this.x1 = x1;
    }
    
    public void setY1(double y1) {
        this.y1 = y1;
    }
    
    public void setX2(double x2) {
        this.x2 = x2;
    }
    
    public void setY2(double y2) {
        this.y2 = y2;
    }
}
