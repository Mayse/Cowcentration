
package cowcentration.ui;

import cowcentration.gamelogic.Game;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author miikas
 */
class GraphicGame implements Runnable{

            private JFrame frame;
            private Game game;
    
    GraphicGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Cowcentration");

        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    }

    private void createComponents(Container container) {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        container.setLayout(layout);
        for (int i = 0; i < game.getCards().size(); i++) {
           JLabel card = new JLabel("card");
            container.add(card);
            JButton button = new JButton("choose");
            button.addActionListener(new CardChooser(this.game, i, card));
            container.add(button);
        }
        
        
    }
    }
    

