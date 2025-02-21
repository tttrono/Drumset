import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SceneFrame {
	
	private JFrame frame;
	private JButton button_controls;
	private JButton button_drumroll;
	private int width;
	private int height;
	
	public SceneFrame(int w, int h) {
		
		frame = new JFrame();
		width = w;
		height = h;
		
		button_controls = new JButton("Show controls");
		button_drumroll = new JButton("Drum roll");
		
	}
	
	public void setUpGUI() {
		
		//Container cp = frame.getContentPane();
		FlowLayout flow = new FlowLayout();
		//cp.setLayout(flow);
		//frame.setLayout(flow);
		
		frame.setSize(width, height);
		frame.setTitle("DrumSet - Midterm Project - Trono");
		
		SceneCanvas sc = new SceneCanvas(1281,658);
		frame.add(sc);
		//cp.add(sc);
		
		//cp.add(button_controls);
		//cp.add(button_drumroll);
		//frame.add(button_controls);
		//frame.add(button_drumroll);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
	}
	
	public void setupButtonListeners() {

		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				
				if (o == button_controls) { 
					//System.out.println("Press B for Bass");
					//System.out.println("Press S for Snare");
					
				} else if (o == button_drumroll) {
					//Play animation for drumroll
				}
				
			}
		};
		
		button_controls.addActionListener(buttonListener);
		button_drumroll.addActionListener(buttonListener);
		
	}
}
