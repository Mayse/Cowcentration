
package cowcentration.ui;

import cowcentration.gamelogic.Game;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author miikas
 */
class GraphicGame implements Runnable{

            private JFrame frame;

    
    GraphicGame(Game game) {

    }

    @Override
    public void run() {
         frame = new JFrame("Cowcentration");

        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    }

    private void createComponents(Container contentPane) {
        JLabel card = new JLabel("cards goes here");
        
        contentPane.add(card);
        
    }
    }
    

