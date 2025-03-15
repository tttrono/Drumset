import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;

import Cymbals.*;
import Drums.*;
import Etc.*;
import Shapes.DrawingObject;

/** This the drawing canvas for all graphic objects. 
 *  All parts of the drumset – drums and cymbals –
 *  are layed over the drum carpet. */
public class SceneCanvas extends JComponent {
	
	private DrumCarpet carpet;
	private BassDrum bass;
	private Beater beater;
	
	private SnareDrum snare;
	private HighTom hightom;
	private MidTom midtom;
	private FloorTom floortom;
	
	private HiHat hihat;
	private CrashCymbalLeft crashcymballeft;
	private CrashCymbalRight crashcymbalright;
	private RideCymbal ride;

	private Chair chair;
	private Floor floor;
	
	private ArrayList<DrawingObject> parts;
	
	/** Initializes all drawing parts, to be drawn by paintComponent.*/
	public SceneCanvas() {
		
		parts = new ArrayList<DrawingObject>();
		
		floor 	 = new Floor();
		carpet 	 = new DrumCarpet();
		bass 	 = new BassDrum();
		beater 	 = new Beater();
		
		snare 	 = new SnareDrum();
		hightom  = new HighTom();
		midtom 	 = new MidTom();
		floortom = new FloorTom();
		
		hihat 			 = new HiHat();
		crashcymballeft  = new CrashCymbalLeft();
		crashcymbalright = new CrashCymbalRight();
		ride 			 = new RideCymbal();
		
		chair			 = new Chair();
		
		//parts.add(floor);
		
		parts.add(carpet);
		parts.add(bass);
		parts.add(beater);
		
		parts.add(snare);
		parts.add(hightom);	
		parts.add(midtom);		
		parts.add(floortom);
		
		parts.add(hihat);
		parts.add(ride);
		parts.add(crashcymballeft);
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
	
	public Beater getBeater() {
		return beater;
	}
	
	public SnareDrum getSnareDrum() {
		return snare;
	}
	
	public HighTom getHighTom() {
		return hightom;
	}
	
	public MidTom getMidTom() {
		return midtom;
	}
	
	public FloorTom getFloorTom() {
		return floortom;
	}
	
	public HiHat getHiHat() {
		return hihat;
	}
	
	public CrashCymbalLeft getCrashCymbalLeft() {
		return crashcymballeft;
	}
	
	public CrashCymbalRight getCrashCymbalRight() {
		return crashcymbalright;
	}
	
	public RideCymbal getRideCymbal() {
		return ride;
	}
	
}
