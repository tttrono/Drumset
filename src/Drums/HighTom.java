package Drums;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import Shapes.Circle;
import Shapes.DrawingObject;

/**
 * Represents a High Tom drum.
 */
public class HighTom implements DrawingObject {
    private double x;
    private double y;
    private double scale_x;
    private double scale_y;
    
    /**
     * Constructs a HighTom drum with default scaling and initial position.
     */
    public HighTom() {
        scale_x = 1.0;
        scale_y = 1.0;
        // Set the initial position once.
        x = 600;
        y = 200;
    }
    
    /**
     * Sets a new position for the HighTom.
     */
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Gets the current x position.
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the current y position.
     */
    public double getY() {
        return y;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        // Use the current x and y values, adjusted for scaling.
        double drawX = x / scale_x;
        double drawY = y / scale_y;
        
        AffineTransform reset = g2d.getTransform();
        g2d.scale(scale_x, scale_y);
        
        // Base drum circles: {radius, stroke, color}
        Object[][] RSC = {
            {90, 0, Color.WHITE},
            {50, 0, Color.LIGHT_GRAY},
            {94, 4, Color.DARK_GRAY}
        };
        
        for (int i = 0; i < RSC.length; i++) {
            Circle circle = new Circle(drawX, drawY, (int) RSC[i][0], (int) RSC[i][1], (Color) RSC[i][2]);
            circle.draw(g2d);
        }
        
        // Draw circular pegs around the drum
        int pegs_num = 8;
        float angle = 360 / pegs_num;
        int pegRadius = 94;
        for (int theta = 0; theta < 360; theta += angle) {
            double c_x = pegRadius * Math.cos(Math.toRadians(theta));
            double c_y = pegRadius * Math.sin(Math.toRadians(theta));
            Circle peg = new Circle(drawX + c_x, drawY - c_y, 2, 0, Color.BLACK);
            peg.draw(g2d);
        }
        
        // Draw hoop handles (optional)
        int handles_num = 2;
        angle = 360 / handles_num;
        pegRadius = 96;
        for (int theta = 0; theta < 360; theta += angle) {
            double c_x = pegRadius * Math.cos(Math.toRadians(theta));
            double c_y = pegRadius * Math.sin(Math.toRadians(theta));
            Circle handle = new Circle(drawX + c_x, drawY - c_y, 4, 4, Color.LIGHT_GRAY);
            handle.draw(g2d);
        }
        
        g2d.setTransform(reset);
    }
    
    /**
     * Incrementally rescales the high tom drum.
     */
    public void rescale() {
        scale_x += 0.02;
        scale_y += 0.02;
    }
}
