package Shapes;

import java.awt.Color;

public class ObjectSpec {
    private double x;
    private double y;
    private double width;
    private double height;
    private float stroke;
    private Color color;
    
    public ObjectSpec(double x, double y, double width, double height, float stroke, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stroke = stroke;
        this.color = color;
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public float getStroke() {
        return stroke;
    }
    
    public Color getColor() {
        return color;
    }
    
    // Setters
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setStroke(float stroke) {
        this.stroke = stroke;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
}
