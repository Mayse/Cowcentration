package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

class CardChooser implements ActionListener {

    private final int i;
    private final GraphicGameLogic game;
    private final JLabel card;
    private final JButton button;
    private final JLabel currentPlayer;

    CardChooser(GraphicGameLogic game, int i, JLabel card, JButton button, JLabel currentPlayer) {
        this.card = card;
        this.game = game;
        this.button = button;
        this.i = i;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (twoCardsAreVisible()) {
            hideAllCards();
        }
        if (noCardsAreVisible()) {
            revealOneCard();
        } else if (oneCardIsVisible()) {
            revealSecondCard();
            if (cardsAreAPair()) {
                markCardsFound();
                this.game.addPoint();

                if (this.game.isOver()) {
                    GraphicEndScreen end = new GraphicEndScreen(this.game);
                    end.run();
                }
            }
            else {
                enableSelectionButtons();
                this.game.nextPlayer();
                updateCurrentPlayerText();
            }

        }

    }

    private void hideAllCards() {
        this.game.getTurnState().getLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().getSecondLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().setCardsVisible(0);
    }

    private void revealOneCard() {
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setIndexOfLastCard(i);
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.game.getTurnState().setCardsVisible(1);
        this.game.getTurnState().getLastButton().setEnabled(false);
    }

    private void revealSecondCard() {
        this.game.getTurnState().setSecondLastCard(this.game.getTurnState().getLastCard());
        this.game.getTurnState().setSecondLastButton(this.game.getTurnState().getLastButton());
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setCardsVisible(2);
    }

    private boolean twoCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 2;
    }

    private boolean noCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 0;
    }

    private boolean oneCardIsVisible() {
        return this.game.getTurnState().getCardsVisible() == 1;
    }

    private boolean cardsAreAPair() {
        return this.game.getGcards().get(i).getId() == this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).getId();
    }

    private void markCardsFound() {
        this.game.getGcards().get(i).remove();
        this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).remove();
        this.button.setText("found");
        this.game.getTurnState().getSecondLastButton().setText("found");
        this.game.getTurnState().setCardsVisible(0);
        this.game.getTurnState().getLastButton().setEnabled(false);
        this.game.getTurnState().getSecondLastButton().setEnabled(false);
    }

    private void enableSelectionButtons() {
        this.game.getTurnState().getLastButton().setEnabled(true);
        this.game.getTurnState().getSecondLastButton().setEnabled(true);
    }

    private void updateCurrentPlayerText() {
                this.currentPlayer.setText(game.getCurrentPlayer().getName());
    }

}
