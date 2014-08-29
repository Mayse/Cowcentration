
package cowcentration.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;



class ContinueButtonListener implements ActionListener {
    
    JTextField players;
    JFrame frame;

    public ContinueButtonListener(JTextField players, JFrame frame) {
        this.players = players;
        this.frame = frame;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        new GraphicStartMenu(players.getText()).run();
        frame.setVisible(false);
    }
    
}
