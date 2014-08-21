
package cowcentration.ui;

import cowcentration.gamelogic.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author miikas
 */
class GameStarter implements ActionListener{
    
    private List<JTextField> jTextFields;
    private JFrame frame;

    public GameStarter() {
    }

    GameStarter(List jTextFields, JFrame frame) {
        this.jTextFields = jTextFields;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List players = new ArrayList();
        for (JTextField field : jTextFields) {
            players.add(field.getText());
        }
        Game game =new Game(players, 8);
        game.shuffleCards();
        game.shufflePlayers();
        GraphicGame graphicGame = new GraphicGame(game);
        frame.setVisible(false);
        graphicGame.run();
    }
    
}
