import java.awt.*;
import javax.swing.*;

import Cymbals.*;
import Drums.*;
import Etc.*;

public class SceneCanvas extends JComponent {
	
	private int width;
	private int height;
	
	public SceneCanvas(int w, int h) {
		width = w;
		height = h;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		
		//Floor floor = new Floor(g2d);
		DrumCarpet carpet = new DrumCarpet(g2d);
		
		BassDrum bass = new BassDrum(g2d);
		SnareDrum snare = new SnareDrum(g2d);
		
		Cymbal cymbal = new Cymbal(g2d);
		RideCymbal ride = new RideCymbal(g2d);
		
		//Chair chair = new Chair(x,y,w,h);
		
	}
}
