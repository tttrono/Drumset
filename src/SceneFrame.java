import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Cymbals.*;
import Drums.*;

public class SceneFrame {
	
	private JFrame frame;
	private JButton controls;
	private JButton drumroll;
	//private int width;
	//private int height;
	
	SceneCanvas canvas;
	
	public SceneFrame() {
	//public SceneFrame(int w, int h) {
	
		frame = new JFrame();
		//width = w;
		//height = h;
		
		controls = new JButton("Show controls");
		drumroll = new JButton("Drum roll");
		
		canvas = new SceneCanvas();
		canvas.setPreferredSize(new Dimension(800, 600));
		//canvas.setPreferredSize(new Dimension(width, height));
	}
	
	public void setUpGUI() {
		
		Container contentPane = frame.getContentPane();
		
		//canvas.setPreferredSize(new Dimension(1281, 658));
		//canvas.setPreferredSize(new Dimension(800, 600));
		
		//FlowLayout flow = new FlowLayout();
		//cp.setLayout(flow);
		//frame.setLayout(flow);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));
		buttons.add(controls);
		buttons.add(drumroll);
		
		contentPane.add(canvas, BorderLayout.CENTER);
		contentPane.add(buttons, BorderLayout.SOUTH);
		
		//frame.setSize(width, height);
		frame.setTitle("Midterm Project - Tibayan - Trono");
		
		//frame.add(canvas);
		//cp.add(canvas);
		
		//cp.add(button_controls);
		//cp.add(button_drumroll);
		//frame.add(button_controls);
		//frame.add(button_drumroll);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void setupButtonListeners() {

		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				
				// testing
				BassDrum bass = canvas.getBassDrum();
				FloorTom floortom = canvas.getFloorTom();
				RideCymbal ride = canvas.getRideCymbal();
				CrashCymbalRight crashcymbal2 = canvas.getCrashCymbal();
				
				if (o == controls) { 
					//System.out.println("Press B for Bass");
					//System.out.println("Press S for Snare");
					//or mouse events instead 
					
				} else if (o == drumroll) {
					//Play animation for drumplay
					
					// testing 
					//bass.rescale();
					//floortom.rescale();
					//crashcymbalright.rescale();
					ride.rescale();
				}
				
				canvas.repaint();
			}
		};
		
		controls.addActionListener(buttonListener);
		drumroll.addActionListener(buttonListener);
		
	}
}
