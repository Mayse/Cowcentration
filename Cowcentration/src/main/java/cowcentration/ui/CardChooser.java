package cowcentration.ui;

import cowcentration.gamelogic.CardChooserLogic;
import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

class CardChooser implements ActionListener {

    private final int i;
    private final GraphicGameLogic game;
    private final JLabel card;
    private final JButton button;
    private final JLabel currentPlayer;
    private final CardChooserLogic logic;

    CardChooser(GraphicGameLogic game, int i, JLabel card, JButton button, JLabel currentPlayer) {
        this.card = card;
        this.game = game;
        this.button = button;
        this.i = i;
        this.currentPlayer = currentPlayer;
        this.logic = new CardChooserLogic(card, game, button, i, currentPlayer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (logic.twoCardsAreVisible()) {
            logic.hideAllCards();
        }
        if (logic.noCardsAreVisible()) {
            logic.revealOneCard();
        } else if (logic.oneCardIsVisible()) {
            logic.revealSecondCard();
            if (logic.cardsAreAPair()) {
                logic.markCardsFound();
                this.game.addPoint();

                if (this.game.isOver()) {
                    GraphicEndScreen end = new GraphicEndScreen(this.game);
                    end.run();
                }
            }
            else {
                logic.enableSelectionButtons();
                this.game.nextPlayer();
                logic.updateCurrentPlayerText();
            }

        }

    }

    

}
