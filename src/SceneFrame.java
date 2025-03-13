import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

import Cymbals.*;
import Drums.*;

/** Creates the graphic user interface window for DrumSet.
 *  Implementing methods for keyboard and mouse interactions. */
public class SceneFrame implements MouseListener, KeyListener {
	
	private JFrame frame;
	
	SceneCanvas canvas;

	BassDrum bass;
	Beater beater;
	SnareDrum snare;
	
	HighTom hightom;
	MidTom midtom;
	FloorTom floortom;
	
	HiHat hihat;
	CrashCymbalLeft crashcymballeft;
	CrashCymbalRight crashcymbalright;
	RideCymbal ride;
	
	/** Initializes objects from canvas for action events. */
	public SceneFrame() {
	
		frame = new JFrame();
		
		canvas = new SceneCanvas();
		canvas.setPreferredSize(new Dimension(800, 600));
		
		bass 			 = canvas.getBassDrum();
		beater 			 = canvas.getBeater();
		snare			 = canvas.getSnareDrum();
		
		hightom			 = canvas.getHighTom();
		midtom 			 = canvas.getMidTom();
		floortom 		 = canvas.getFloorTom();
		
		hihat 			 = canvas.getHiHat();
		crashcymballeft  = canvas.getCrashCymbalLeft();
		crashcymbalright = canvas.getCrashCymbalRight();
		ride 			 = canvas.getRideCymbal();
	}
	
	/** Sets the focus on canvas ready for keyboard listeners. */
	public void setUpGUI() {
		
		Container contentPane = frame.getContentPane();

		contentPane.add(canvas);
		contentPane.add(canvas, BorderLayout.CENTER);
		
		frame.setTitle("Midterm - Drumset - Trono");
		
		canvas.addMouseListener(this);
		canvas.addKeyListener(this);
		
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
		
		this.showControls();
	}
	
	/** Plays the audio of the drum object selected.
	 *  A new thread is instantiated for a new audio stream per action. */
	public void play(String path) {
		
		new Thread(new Runnable() {
			Clip sound;
			
		    public void run() {
		    	try {
		    		sound = AudioSystem.getClip();
			        AudioInputStream audio = AudioSystem.getAudioInputStream(
			        		new File(path).getAbsoluteFile());
			        sound.open(audio);
			        
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		    	
		    	sound.start(); 
		    }
		  }).start();
	}

	/** Identifies the object selected for play.
	 *  Uses the Point class to determine the location for Shape objects. 
	 *  Conditions are set for overlapping objects to differentiate accordingly. 
	 *  Objects are upscaled in size once clicked and plays its respective sound. */
	@Override
	public void mousePressed(MouseEvent e) {

		Point p = e.getPoint();
		
		/** Drums */
		if ((bass.drum.contains(p) || bass.pedal.contains(p) || bass.subpedal.contains(p)) 
				&& !midtom.drum.contains(p) && !midtom.body.contains(p) 
				&& !hightom.drum.contains(p) && !hightom.body.contains(p)) { 
			
			play("./Audio/bass.wav");
			bass.upscale();
			beater.upscale();
			canvas.repaint();
		}
		
		if ((snare.drum.contains(p)) && ! hihat.cymbal.contains(p)) { 
			play("./Audio/snare_processed.wav");
			snare.upscale();
			canvas.repaint();
		}
		
		if (hightom.drum.contains(p) && !crashcymballeft.cymbal.contains(p)) {
			play("./Audio/tom_high.wav");
			hightom.upscale();
			canvas.repaint();
		}
		
		if (midtom.drum.contains(p) && !crashcymbalright.cymbal.contains(p)) {
			play("./Audio/tom_mid.wav");
			midtom.upscale();
			canvas.repaint();
		}
		
		if (floortom.drum.contains(p) && !ride.cymbal.contains(p)) {
			play("./Audio/tom_low.wav");
			floortom.upscale();
			canvas.repaint();
		}
		
		/** Cymbals*/
		if (hihat.cymbal.contains(p) || hihat.pedal.contains(p) || hihat.subpedal.contains(p)) {
			play("./Audio/hat_closed.wav");
			hihat.upscale();
			canvas.repaint();
		}
		
		if (crashcymballeft.cymbal.contains(p)) {
			play("./Audio/crash_1.wav");
			crashcymballeft.upscale();
			canvas.repaint();
		}
		
		if (crashcymbalright.cymbal.contains(p)) {
			play("./Audio/crash_2.wav");
			crashcymbalright.upscale();
			canvas.repaint();
		}
		
		if (ride.cymbal.contains(p) && !crashcymbalright.cymbal.contains(p)) {
			play("./Audio/ride_bell.wav");
			ride.upscale();
			canvas.repaint();
		}
		
	}

	/** Resets an object to its original scale after the mouse is released. */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		Point p = e.getPoint();
		
		/** Drums*/
		if ((bass.drum.contains(p) || bass.pedal.contains(p) || bass.subpedal.contains(p)) 
				&& !midtom.drum.contains(p) && !midtom.body.contains(p) 
				&& !hightom.drum.contains(p) && !hightom.body.contains(p)) { 
			bass.downscale();
			beater.downscale();
			canvas.repaint();
		}
		
		if ((snare.drum.contains(p)) && ! hihat.cymbal.contains(p)) { 
			snare.downscale();
			canvas.repaint();
		}
		
		if (hightom.drum.contains(p) && !crashcymballeft.cymbal.contains(p)) {
			hightom.downscale();
			canvas.repaint();
		}
		
		if (midtom.drum.contains(p) && !crashcymbalright.cymbal.contains(p)) {
			midtom.downscale();
			canvas.repaint();
		}
		
		if (floortom.drum.contains(p) && !ride.cymbal.contains(p)) {
			floortom.downscale();
			canvas.repaint();
		}
		
		/** Cymbals */	
		if (hihat.cymbal.contains(p) || hihat.pedal.contains(p) || hihat.subpedal.contains(p)) {
			hihat.downscale();
			canvas.repaint();
		}
		
		if (crashcymballeft.cymbal.contains(p)) {
			crashcymballeft.downscale();
			canvas.repaint();
		}
		
		if (crashcymbalright.cymbal.contains(p)) {
			crashcymbalright.downscale();
			canvas.repaint();
		}
		if (ride.cymbal.contains(p) && !crashcymbalright.cymbal.contains(p)) {
			ride.downscale();
			canvas.repaint();
		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	/** Displays on the command line prompt: 
	 * all keyboard controls from left to right, 
	 * top to bottom of the drumset. */
	public void showControls() {
		
		System.out.println("\n| Press Q for crash (left)" + "\t| Press T for high tom" + "\t| Press U for mid tom" + "\t| Press P for crash cymbal (right)");
		System.out.println("| Press A for hihat cymbal" + "\t| Press F for snare" + "\t| Press J for floor tom" + "\t| Press L for ride cymbal");
		System.out.println("| Press SPACEBAR or B for bass \n");
	}
	
	/** Keyboard controls for the drumset.
	 *  Each part of the instrument is represented 
	 *  by a designated character on the keyboard. */
	@Override
    public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
			/** Drums */
			case (KeyEvent.VK_B):			// Press SPACEBAR or B for Bass
			case (KeyEvent.VK_SPACE): 		
				play("./Audio/bass.wav");
				bass.upscale();
				beater.upscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_F:				// Press F for snare
				play("./Audio/snare_processed.wav");
				snare.upscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_T: 			// Press T for High Tom
				play("./Audio/tom_high.wav");
				hightom.upscale();
				canvas.repaint();
				break;
					
			case KeyEvent.VK_U:				// Press U for Mid Tom
				play("./Audio/tom_mid.wav");
				midtom.upscale();
				canvas.repaint();
				break;
			
			case KeyEvent.VK_J: 			// Press J for Floor Tom
				play("./Audio/tom_low.wav");
				floortom.upscale();
				canvas.repaint();
				break;
				
			/** Cymbals */
			case KeyEvent.VK_A:				// Press A for HiHat
				play("./Audio/hat_closed.wav");
				hihat.upscale();
				canvas.repaint();
				break;	
				
			case KeyEvent.VK_Q:				// Press Q for Crash Cymbal Left
				play("./Audio/crash_1.wav");
				crashcymballeft.upscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_P:				// Press P for Crash Cymbal Right
				play("./Audio/crash_2.wav");
				crashcymbalright.upscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_L:				// Press L for Ride Cymbal
				play("./Audio/ride_bell.wav");
				ride.upscale();
				canvas.repaint();
				break;
						
		}
	}
	
	@Override
    public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
			/** Drums */
			case (KeyEvent.VK_B):			// Press SPACEBAR or B for Bass
			case KeyEvent.VK_SPACE: 		
				bass.downscale();
				beater.downscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_F:				// Press F for snare
				snare.downscale();
				canvas.repaint();
				break;
			
			case KeyEvent.VK_T: 			// Press T for High Tom
				hightom.downscale();
				canvas.repaint();
				break;	
					
			case KeyEvent.VK_U:				// Press U for Mid Tom
				midtom.downscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_J: 			// Press J for Floor Tom
				floortom.downscale();
				canvas.repaint();
				break;
					
			/** Cymbals */
			case KeyEvent.VK_A:				// Press A for HiHat
				hihat.downscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_Q:				// Press Q for Crash Cymbal Left
				crashcymballeft.downscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_P:				// Press P for Crash Cymbal Right
				crashcymbalright.downscale();
				canvas.repaint();
				break;
				
			case KeyEvent.VK_L:				// Press L for Ride Cymbal
				ride.downscale();
				canvas.repaint();
				break;
			
		}
		
	}
	
    public void keyTyped(KeyEvent e) {}
			
}