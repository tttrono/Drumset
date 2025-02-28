import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Cymbals.*;
import Drums.*;

public class SceneFrame implements MouseListener {
	
	private JFrame frame;
	//private JButton controls;
	//private JButton drumroll;
	
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
		
		//controls = new JButton("Show controls");
		//drumroll = new JButton("Drum roll");
		
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
		
//		JPanel buttons = new JPanel();
//		buttons.setLayout(new GridLayout(1,2));
//		buttons.add(controls);
//		buttons.add(drumroll);
		
		contentPane.add(canvas, BorderLayout.CENTER);
		//contentPane.add(buttons, BorderLayout.SOUTH);
		
		frame.setTitle("Midterm Project - Tibayan - Trono");
		
		canvas.addMouseListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	
//	public void setupButtonListeners() {
//
//		ActionListener buttonListener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent ae) {
//				Object o = ae.getSource();
//				
//				if (o == controls) { 
//					//System.out.println("Press B for Bass");
//					//System.out.println("Press S for Snare");
//					
//				} else if (o == drumroll) {
//					//Play animation for drumplay
//				}
//				
//				canvas.repaint();
//			}
//		};
//		
//		controls.addActionListener(buttonListener);
//		drumroll.addActionListener(buttonListener);
//		
//	}

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
		
//		if (midtom.drum.contains(p) && !ride.cymbal.contains(p)) {
//			midtom.downscale();
//			canvas.repaint();
//		}
		
		if (ride.cymbal.contains(p)) {
			ride.downscale();
			canvas.repaint();
		}
		
//		if (crashcymbalright.cymbal.contains(p)) {
//			crashcymbalright.downscale();
//			canvas.repaint();
//		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}