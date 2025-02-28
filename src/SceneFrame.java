import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Sets up the main frame and GUI controls.
 */
public class SceneFrame {
    
    private JFrame frame;
    private JButton controls;
    private JButton drumroll;
    private SceneCanvas canvas;
    
    public SceneFrame() {
        frame = new JFrame();
        controls = new JButton("Show controls");
        drumroll = new JButton("Drum roll");
        canvas = new SceneCanvas();
        canvas.setPreferredSize(new Dimension(800, 600));
    }
    
    public void setUpGUI() {
        Container contentPane = frame.getContentPane();
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(controls);
        buttons.add(drumroll);
        
        contentPane.add(canvas, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.SOUTH);
        
        frame.setTitle("Midterm Project - Tibayan - Trono");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void setupButtonListeners() {
        // Show Controls button
        controls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(frame, 
                    "Controls:\n- Press 'D' for Drum roll\n- Use mouse for instrument selection\n- Etc.",
                    "Controls",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Drum Roll button: toggle rescale on multiple instruments
        drumroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.getRideCymbal().rescale();
                canvas.getCrashCymbal().rescale();
                canvas.getBassDrum().rescale();
                canvas.getFloorTom().rescale();
                canvas.repaint();
            }
        });
    }
}
