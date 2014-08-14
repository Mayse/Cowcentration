
package cowcentration.ui;

import cowcentration.gamelogic.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

class CardChooser implements ActionListener{
    
    private int i;
    private Game game;
    private JLabel card;

    public CardChooser() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    CardChooser(Game game, int i, JLabel card) {
        this.card = card;
        this.game = game;
        this.i = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.card.setText(this.game.getCardText(i));
    }
    
}
