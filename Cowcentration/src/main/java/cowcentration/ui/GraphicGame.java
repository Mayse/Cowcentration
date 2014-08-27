
package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author miikas
 */
class GraphicGame implements Runnable{

            private JFrame frame;
            private GraphicGameLogic game;
    
    GraphicGame(GraphicGameLogic game) {
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
            JPanel cell = new JPanel();
            cell.setLayout(new BorderLayout());
           JLabel card = new JLabel("card");
            cell.add(card, BorderLayout.CENTER);
            JButton button = new JButton("choose");
            this.game.getGcards().get(i).setButton(button);
            button.addActionListener(new CardChooser(this.game, i, card, button));
            cell.add(button, BorderLayout.SOUTH);            
            container.add(cell);
            
        }
        
        
    }
    }
    

