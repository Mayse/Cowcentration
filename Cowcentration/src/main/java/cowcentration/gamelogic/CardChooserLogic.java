package cowcentration.gamelogic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Card choosing logic for graphical games card button pairs
 * 
 */
public class CardChooserLogic {

    private final int i;
    private final GraphicGameLogic game;
    private final JLabel card;
    private final JButton button;
    private final JLabel currentPlayer;

    /**
     * @param card JLabel that holds this pairs card image or back
     * @param game game logic for corresponding graphical game
     * @param button Jbutton that allows choosing the corresponding card
     * @param i index of card in the game logic gcard list
     * @param currentPlayer reference to JLabel displaying the players name whose turn it is
     */
    public CardChooserLogic(JLabel card, GraphicGameLogic game, JButton button, int i, JLabel currentPlayer) {
        this.card = card;
        this.game = game;
        this.button = button;
        this.i = i;
        this.currentPlayer = currentPlayer;
    }

    /**
     * sets last and second last cards in turnstate to cardbacks and turnstate visible cards to zero.
     */
    public void hideAllCards() {
        this.game.getTurnState().getLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().getSecondLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
        this.game.getTurnState().setCardsVisible(0);
    }

    /**
     * Changes the card icon to an image corresponding this GraphicCard, updates turnstate variables to signify that one card is visible and disables the JButton.
     */
    public void revealOneCard() {
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setIndexOfLastCard(i);
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.game.getTurnState().setCardsVisible(1);
        this.game.getTurnState().getLastButton().setEnabled(false);
    }

    /**
     * Updates turnstate variables to reflect two cards being visible, Changes the card icon to an image corresponding this GraphicCard. 
     */
    public void revealSecondCard() {
        this.game.getTurnState().setSecondLastCard(this.game.getTurnState().getLastCard());
        this.game.getTurnState().setSecondLastButton(this.game.getTurnState().getLastButton());
        this.game.getTurnState().setLastCard(card);
        this.game.getTurnState().setLastButton(button);
        this.card.setIcon(this.game.getGcards().get(i).getPicture());
        this.game.getTurnState().setCardsVisible(2);
    }

    /**
     * 
     * @return true if turnstate signals two cards visible 
     */
    public boolean twoCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 2;
    }

    /**
     * 
     * @return true if turnstate signals no cards visible
     */
    public boolean noCardsAreVisible() {
        return this.game.getTurnState().getCardsVisible() == 0;
    }

    /**
     * 
     * @return true if turnstate signals one card visible 
     */
    public boolean oneCardIsVisible() {
        return this.game.getTurnState().getCardsVisible() == 1;
    }

    /**
     * 
     * @return true if compared cards are a pair (id is identical) 
     */
    public boolean cardsAreAPair() {
        return this.game.getGcards().get(i).getId() == this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).getId();
    }

    /**
     * marks this cardchoosers and previous cards state as removed, sets button texts to found and ensures both JButtons are disabled.
     */
    public void markCardsFound() {
        this.game.getGcards().get(i).remove();
        this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).remove();
        this.button.setText("found");
        this.game.getTurnState().getSecondLastButton().setText("found");
        this.game.getTurnState().setCardsVisible(0);
        this.game.getTurnState().getLastButton().setEnabled(false);
        this.game.getTurnState().getSecondLastButton().setEnabled(false);
    }

    /**
     * Ensures both JButtons stored in turnstate variables for last and second last are enabled.
     */
    public void enableSelectionButtons() {
        this.game.getTurnState().getLastButton().setEnabled(true);
        this.game.getTurnState().getSecondLastButton().setEnabled(true);
    }

    /**
     * Updates the JLabel for current player to current player as set in game logic.
     */
    public void updateCurrentPlayerText() {
                this.currentPlayer.setText(game.getCurrentPlayer().getName());
    }
}
