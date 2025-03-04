import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import Cymbals.*;
import Drums.*;
import Etc.*;
import Shapes.DrawingObject;

/**
 * The SceneCanvas aggregates all drawing objects (instruments) and renders them.
 */
public class SceneCanvas extends JComponent {
    
    private DrumCarpet carpet;
    
    /** Drum objects */
    private BassDrum bass;
    private SnareDrum snare;
    private FloorTom floortom;
    private HighTom hightom;
    private MidTom midtom;
    
    /** Cymbal objects */
    private HiHat hihat;
    private RideCymbal ride;
    private CrashCymbalLeft crashcymballeft;
    private CrashCymbalRight crashcymbalright;
    
    private Chair chair;
    
    private ArrayList<DrawingObject> parts;
    
    public SceneCanvas() {
        parts = new ArrayList<DrawingObject>();
        
        carpet = new DrumCarpet();
        
        /** Drum objects */
        bass = new BassDrum();
        snare = new SnareDrum();
        floortom = new FloorTom();
        hightom = new HighTom();
        midtom = new MidTom();
        
        /** Cymbal objects */
        hihat = new HiHat();
        ride = new RideCymbal();
        crashcymbalright = new CrashCymbalRight();
        crashcymballeft = new CrashCymbalLeft();
        
        chair = new Chair();
        
        // Add instruments in desired drawing order (background first, then foreground)
        parts.add(carpet);
        parts.add(bass);
        //parts.add(snare);
        parts.add(floortom);
        //parts.add(hightom);
        parts.add(midtom);       
        //parts.add(hihat);
        parts.add(ride);
        //parts.add(crashcymballeft);
        parts.add(crashcymbalright);
        //parts.add(chair);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clears the background
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        
        for (DrawingObject part : parts) {
            part.draw(g2d);
        }
    }
    
    // Getter methods for instrument objects (if needed)
    public BassDrum getBassDrum() {
        return bass;
    }
    
    public SnareDrum getSnareDrum() {
        return snare;
    }
    
    public FloorTom getFloorTom() {
        return floortom;
    }
    
    public HighTom getHighTom() {
        return hightom;
    }
    
    public MidTom getMidTom() {
        return midtom;
    }
    
    public HiHat getHiHat() {
        return hihat;
    }
    
    public RideCymbal getRideCymbal() {
        return ride;
    }
    
    public CrashCymbalLeft getCrashCymbalLeft() {
        return crashcymballeft;
    }
    
    public CrashCymbalRight getCrashCymbalRight() {
        return crashcymbalright;
    }
}
