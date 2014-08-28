package cowcentration.gamelogic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CardChooserLogic {

    private final int i;
    private final GraphicGameLogic game;
    private final JLabel card;
    private final JButton button;
    private final JLabel currentPlayer;

    public CardChooserLogic(JLabel card, GraphicGameLogic game, JButton button, int i, JLabel currentPlayer) {
        this.card = card;
        this.game = game;
        this.button = button;
        this.i = i;
        this.currentPlayer = currentPlayer;
    }

    public void hideAllCards() {
        this.game.getTurnState().getLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().getSecondLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().setCardsVisible(0);
    }

    public void revealOneCard() {
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setIndexOfLastCard(i);
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.game.getTurnState().setCardsVisible(1);
        this.game.getTurnState().getLastButton().setEnabled(false);
    }

    public void revealSecondCard() {
        this.game.getTurnState().setSecondLastCard(this.game.getTurnState().getLastCard());
        this.game.getTurnState().setSecondLastButton(this.game.getTurnState().getLastButton());
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setCardsVisible(2);
    }

    public boolean twoCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 2;
    }

    public boolean noCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 0;
    }

    public boolean oneCardIsVisible() {
        return this.game.getTurnState().getCardsVisible() == 1;
    }

    public boolean cardsAreAPair() {
        return this.game.getGcards().get(i).getId() == this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).getId();
    }

    public void markCardsFound() {
        this.game.getGcards().get(i).remove();
        this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).remove();
        this.button.setText("found");
        this.game.getTurnState().getSecondLastButton().setText("found");
        this.game.getTurnState().setCardsVisible(0);
        this.game.getTurnState().getLastButton().setEnabled(false);
        this.game.getTurnState().getSecondLastButton().setEnabled(false);
    }

    public void enableSelectionButtons() {
        this.game.getTurnState().getLastButton().setEnabled(true);
        this.game.getTurnState().getSecondLastButton().setEnabled(true);
    }

    public void updateCurrentPlayerText() {
                this.currentPlayer.setText(game.getCurrentPlayer().getName());
    }
}
