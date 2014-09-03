package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Setup for drawing a gamescreen consisting of cards and buttons with actionlisteners
 * 
 */
class GraphicGame implements Runnable {

    private JFrame frame;
    private final GraphicGameLogic game;

    GraphicGame(GraphicGameLogic game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Cowcentration");

        frame.setPreferredSize(new Dimension(1400, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        container.setLayout(layout);
        Container cardspace = new JPanel(layout);
        
        JLabel currentPlayer = new JLabel();
        currentPlayer.setText(game.getCurrentPlayer().getName());
        
        for (int i = 0; i < game.getCards().size(); i++) {
            JPanel cardButtonPair = new JPanel();
            cardButtonPair.setLayout(new BorderLayout());
            ImageIcon icon = new ImageIcon("resources/Card_back_06.jpg");
            JLabel card = new JLabel(icon);
            cardButtonPair.add(card, BorderLayout.CENTER);
            JButton button = new JButton("choose");
            this.game.getGcards().get(i).setButton(button);
            button.addActionListener(new CardChooser(this.game, i, card, button, currentPlayer));
            cardButtonPair.add(button, BorderLayout.SOUTH);
            container.add(cardButtonPair);

        }
        
        
        container.add(cardspace);
        container.add(currentPlayer);
    }

}
