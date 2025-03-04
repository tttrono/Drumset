import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Cymbals.*;
import Drums.*;

public class SceneFrame implements MouseListener, KeyListener {
    
    private JFrame frame;
    SceneCanvas canvas;

    BassDrum bass;
    SnareDrum snare;
    FloorTom floortom;
    HighTom hightom;
    MidTom midtom;
    
    /** Cymbal objects */
    HiHat hihat;
    RideCymbal ride;
    CrashCymbalLeft crashcymballeft;
    CrashCymbalRight crashcymbalright;
    
    public SceneFrame() {
        frame = new JFrame();
        
        canvas = new SceneCanvas();
        canvas.setPreferredSize(new Dimension(800, 600));
        
        /** Drum objects */
        bass = canvas.getBassDrum();
        snare = canvas.getSnareDrum();
        floortom = canvas.getFloorTom();
        hightom = canvas.getHighTom();
        midtom = canvas.getMidTom();
        
        /** Cymbal objects */
        hihat = canvas.getHiHat();
        ride = canvas.getRideCymbal();
        crashcymbalright = canvas.getCrashCymbalRight();
        crashcymballeft = canvas.getCrashCymbalLeft();
    }
    
    public void setUpGUI() {
        Container contentPane = frame.getContentPane();
        contentPane.add(canvas, BorderLayout.CENTER);
        
        frame.setTitle("Midterm Project - Tibayan - Trono");
        
        canvas.addMouseListener(this);
        // Enable key events on the canvas
        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
        canvas.addKeyListener(this);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
    
    // MouseListener methods
    
    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        
        if (ride.cymbal.contains(p)) {
            ride.upscale();
            canvas.repaint();
        }
        
        if (bass.drum.contains(p)) {
            bass.upscale();
            canvas.repaint();
        }
        
        if (floortom.drum.contains(p) && !ride.cymbal.contains(p)) {
            floortom.upscale();
            canvas.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point p = e.getPoint();
        
        if (bass.drum.contains(p)) {
            bass.downscale();
            canvas.repaint();
        }
        
        if (floortom.drum.contains(p) && !ride.cymbal.contains(p)) {
            floortom.downscale();
            canvas.repaint();
        }
        
        if (ride.cymbal.contains(p)) {
            ride.downscale();
            canvas.repaint();
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    
    // KeyListener methods to update instrument positions
    // Arrow keys move all instruments by 5 pixels in the pressed direction.
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int dx = 0, dy = 0;
        int moveAmount = 5;
        switch (key) {
            case KeyEvent.VK_LEFT:
                dx = -moveAmount;
                break;
            case KeyEvent.VK_RIGHT:
                dx = moveAmount;
                break;
            case KeyEvent.VK_UP:
                dy = -moveAmount;
                break;
            case KeyEvent.VK_DOWN:
                dy = moveAmount;
                break;
        }
        if (dx != 0 || dy != 0) {
            // Update drum positions
            bass.setPosition(bass.getX() + dx, bass.getY() + dy);
            snare.setPosition(snare.getX() + dx, snare.getY() + dy);
            floortom.setPosition(floortom.getX() + dx, floortom.getY() + dy);
            hightom.setPosition(hightom.getX() + dx, hightom.getY() + dy);
            midtom.setPosition(midtom.getX() + dx, midtom.getY() + dy);
            // Update cymbal positions
            hihat.setPosition(hihat.getX() + dx, hihat.getY() + dy);
            ride.setPosition(ride.getX() + dx, ride.getY() + dy);
            crashcymballeft.setPosition(crashcymballeft.getX() + dx, crashcymballeft.getY() + dy);
            crashcymbalright.setPosition(crashcymbalright.getX() + dx, crashcymbalright.getY() + dy);
            canvas.repaint();
        }
    }
    
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
