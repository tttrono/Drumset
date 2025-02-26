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
    private BassDrum bass;
    private FloorTom floortom;
    private RideCymbal ride;
    private CrashCymbalRight crashcymbalright;
    
    // New instruments:
    private SnareDrum snare;
    private HighTom highTom;
    private HiHat hiHat;
    private CrashCymbalLeft crashcymballeft;
    private Chair chair;
    
    private ArrayList<DrawingObject> parts;
    
    public SceneCanvas() {
        parts = new ArrayList<DrawingObject>();
        
        // Existing instruments
        carpet = new DrumCarpet();
        bass = new BassDrum();
        floortom = new FloorTom();
        ride = new RideCymbal();
        crashcymbalright = new CrashCymbalRight();
        
        // New instruments
        snare = new SnareDrum();
        highTom = new HighTom();
        hiHat = new HiHat();
        crashcymballeft = new CrashCymbalLeft();
        chair = new Chair();
        
        // Add instruments in desired drawing order (background first, then foreground)
        parts.add(carpet);
        parts.add(bass);
        parts.add(floortom);
        parts.add(ride);
        parts.add(crashcymbalright);
        parts.add(snare);
        parts.add(highTom);
        parts.add(hiHat);
        parts.add(crashcymballeft);
        parts.add(chair);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
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
    
    public FloorTom getFloorTom() {
        return floortom;
    }
    
    public CrashCymbalRight getCrashCymbal() {
        return crashcymbalright;
    }
    
    public RideCymbal getRideCymbal() {
        return ride;
    }
    
    public SnareDrum getSnareDrum() {
        return snare;
    }
    
    public HighTom getHighTom() {
        return highTom;
    }
    
    public HiHat getHiHat() {
        return hiHat;
    }
    
    public CrashCymbalLeft getCrashCymbalLeft() {
        return crashcymballeft;
    }
    
    public Chair getChair() {
        return chair;
    }
}
