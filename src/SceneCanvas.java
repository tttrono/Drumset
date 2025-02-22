
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;

import Cymbals.*;
import Drums.*;
import Etc.*;
import Shapes.DrawingObject;

public class SceneCanvas extends JComponent {
	
	private DrumCarpet carpet;
	private BassDrum bass;
	private FloorTom floortom;
	
	//private CrashCymbal crashcymbal1;
	private CrashCymbal crashcymbal2;
	private RideCymbal ride;
	//private Chair chair;
	
	private ArrayList<DrawingObject> parts;
	
	public SceneCanvas() {
		
		parts = new ArrayList<DrawingObject>();
		
		carpet = new DrumCarpet();
		bass = new BassDrum();
		floortom = new FloorTom();
		crashcymbal2 = new CrashCymbal();
		ride = new RideCymbal();
		
		parts.add(carpet);
		parts.add(bass);
		parts.add(floortom);
		//parts.add(crashcymbal1);
		parts.add(crashcymbal2);
		parts.add(ride);
		//parts.add(chair);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		
		for (DrawingObject part: parts) {
			part.draw(g2d);
		}
	}
	
	public BassDrum getBassDrum() {
		return bass;
	}
	
	public FloorTom getFloorTom() {
		return floortom;
	}
	
	public CrashCymbal getCrashCymbal() {
		return crashcymbal2;
	}
	
	public RideCymbal getRideCymbal() {
		return ride;
	}
	
}
