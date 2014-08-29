
package cowcentration.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GraphicPlayerAmountSelection implements Runnable{
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("How many players?");

        frame.setPreferredSize(new Dimension(200, 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    }

    private void createComponents(Container container) {
        JTextField players = new JTextField(2);
        JButton button = new JButton("continue");
        button.addActionListener(new ContinueButtonListener(players, frame));
        
        container.add(players,BorderLayout.WEST);
        container.add(button,BorderLayout.EAST);
        
    }

    

    
    
}
