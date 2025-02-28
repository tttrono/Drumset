package Etc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import Shapes.DrawingObject;

/**
 * Represents a simple black rounded chair.
 */
public class Chair implements DrawingObject {
    private double x;
    private double y;
    private double width;
    private double height;
    private double arcWidth;
    private double arcHeight;
    
    /**
     * Constructs a Chair with default dimensions and position.
     */
    public Chair() {
        // Position adjusted for an 800x600 canvas
        x = 700;
        y = 400;
        width = 50;
        height = 50;
        arcWidth = 20;
        arcHeight = 20;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        RoundRectangle2D.Double chair = new RoundRectangle2D.Double(x - width / 2, y - height / 2, width, height, arcWidth, arcHeight);
        g2d.fill(chair);
    }
}
