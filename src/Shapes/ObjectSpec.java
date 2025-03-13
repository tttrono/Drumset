package Shapes;

import java.awt.Color;

/** ObjectSpec is an object created to contain object specifications.
 *  It has constructors of various fields, whether an object would need multiple
 *  and more fields for its properties. */
public class ObjectSpec {

	public double x;
	public double y;
	
	public double width;
	public double height;
	
	public double radius;
	
	public double length_1;
	public double length_2;
	
	public float stroke;
	public Color color;
	
	public ObjectSpec(double x, double y, double w, double h, float s, Color c) {
		
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		
		stroke = s;
		color = c;
	}
	
	public ObjectSpec(double x, double y, double r, float s, Color c) {
		
		this.x = x;
		this.y = y;
		radius = r;
		
		stroke = s;
		color = c;
	}
	
	public ObjectSpec(double x, double y, double l_1, double l_2, double h, float s, Color c) {
		
		this.x = x;
		this.y = y;

		length_1 = l_1;
		length_2 = l_2;
		height = h;
		
		stroke = s;
		color = c;
	}

}
