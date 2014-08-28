package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class GraphicEndScreen implements Runnable {

    private JFrame frame;
    private final GraphicGameLogic game;

    public GraphicEndScreen(GraphicGameLogic game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Game over");

        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        for (String row : this.game.getScoreboard()) {
            container.add(new JLabel(row));
        }
    }

}
