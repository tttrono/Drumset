package Shapes;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;

/**
 * Represents a cross shape composed of two intersecting lines.
 */
public class Cross implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private float stroke;
    private Color color;
    private double rotation; // rotation in degrees
    
    /**
     * Constructs a Cross with the specified center, arm half-length, stroke thickness, and color.
     *
     * @param x the center x-coordinate
     * @param y the center y-coordinate
     * @param size half-length of each arm of the cross
     * @param stroke stroke thickness
     * @param color color of the cross
     */
    public Cross(double x, double y, double size, float stroke, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.stroke = stroke;
        this.color = color;
        this.rotation = 0;
    }
    
    /**
     * Sets the rotation angle of the cross.
     *
     * @param rotationDegrees rotation in degrees
     */
    public void setRotation(double rotationDegrees) {
        this.rotation = rotationDegrees;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform original = g2d.getTransform();
        g2d.translate(x, y);
        g2d.rotate(Math.toRadians(rotation));
        
        // Draw horizontal line
        Line horizontal = new Line(-size, 0, size, 0, stroke, color);
        horizontal.draw(g2d);
        
        // Draw vertical line
        Line vertical = new Line(0, -size, 0, size, stroke, color);
        vertical.draw(g2d);
        
        g2d.setTransform(original);
    }
}
