package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;

class GameStarter implements ActionListener {

    private List<JTextField> jTextFields;
    private JFrame frame;

    public GameStarter() {
    }

    /**
     * ActionListener for start menu to handle game start.
     * @param jTextFields field for player names
     * @param frame start menu frame
     */
    GameStarter(List jTextFields, JFrame frame) {
        this.jTextFields = jTextFields;
        this.frame = frame;
    }

    /**
     * Hides the start menu and starts a new game using GraphicGame class.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        List players = new ArrayList();
        for (JTextField field : jTextFields) {
            players.add(field.getText());
        }
        GraphicGameLogic game = new GraphicGameLogic(players, 8);
        game.shuffleGcards();
        game.shufflePlayers();
        GraphicGame graphicGame = new GraphicGame(game);
        frame.setVisible(false);
        graphicGame.run();
    }

}
