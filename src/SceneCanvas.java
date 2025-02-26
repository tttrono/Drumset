
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
	private MidTom midtom;
	private FloorTom floortom;
	
	private RideCymbal ride;
	//private CrashCymbal crashcymballeft;
	private CrashCymbalRight crashcymbalright;

	//private Chair chair;
	
	private ArrayList<DrawingObject> parts;
	
	public SceneCanvas() {
		
		parts = new ArrayList<DrawingObject>();
		
		carpet = new DrumCarpet();
		bass = new BassDrum();
		midtom = new MidTom();
		floortom = new FloorTom();
		
		ride = new RideCymbal();
		crashcymbalright = new CrashCymbalRight();
		
		parts.add(carpet);
		parts.add(bass);
		parts.add(midtom);		
		parts.add(floortom);
		parts.add(ride);
		//parts.add(crashcymballeft);
		parts.add(crashcymbalright);

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
	
	public MidTom getMidTom() {
		return midtom;
	}
	
	public FloorTom getFloorTom() {
		return floortom;
	}
	
	public CrashCymbalRight getCrashCymbal() {
		return crashcymbalright;
	}
	
	public RideCymbal getRideCymbal() {
		return ride;
	}
	
}
