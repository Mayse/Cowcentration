
package cowcentration.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class GraphicUi implements Runnable{

        private JFrame frame;
        private List jTextFields;

    @Override
    public void run() {
 frame = new JFrame("Cowcentration");
        frame.setPreferredSize(new Dimension(200, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        //staattinen pelaajamäärä tällä hetkellä
    JTextField player1 = new JTextField("Player 1");
    JTextField player2 = new JTextField("Player 2");
    JTextField player3 = new JTextField("Player 3");
    JTextField player4 = new JTextField("Player 4");
    
    JButton start = new JButton("Start game");
    jTextFields = new ArrayList();
    jTextFields.add(player1);
    jTextFields.add(player2);
    jTextFields.add(player3);
    jTextFields.add(player4);
    start.addActionListener(new GameStarter(jTextFields, frame));

    container.add(player1);
    container.add(player2);
    container.add(player3);
    container.add(player4);
    container.add(start);


    }
    
}
