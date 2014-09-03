package cowcentration.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicStartMenu implements Runnable {

    private JFrame frame;
    private List jTextFields;

    @Override
    public void run() {
        frame = new JFrame("Cowcentration");
        frame.setPreferredSize(new Dimension(200, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout stackvertically = new BoxLayout(container, BoxLayout.Y_AXIS);
        FlowLayout row = new FlowLayout();

        container.setLayout(stackvertically);
        //static amount of players currently
        jTextFields = new ArrayList();
        JPanel player1 = addPlayer("Player 1");
        JPanel player2 = addPlayer("Player 2");
        JPanel player3 = addPlayer("Player 3");
        JPanel player4 = addPlayer("Player 4");

        JButton start = new JButton("Start game");

        start.addActionListener(new GameStarter(jTextFields, frame));

        container.add(player1);
        container.add(player2);
        container.add(player3);
        container.add(player4);

        container.add(start);

    }

    /**
     * Creates a new JPanel with a text field and a checkbox for making the player a computer opponent instead of human
     * @param name initial text in text field
     * @return 
     */
    private JPanel addPlayer(String name) {
        JTextField player = new JTextField(name);
        jTextFields.add(player);
        JCheckBox playerAi = new JCheckBox("computer");
        playerAi.setEnabled(false);//ai not yet implemented
        JPanel row = new JPanel();
        FlowLayout flow = new FlowLayout();

        row.setLayout(flow);
        row.add(player);
        row.add(playerAi);

        return row;
    }

}
