
package cowcentration.gamelogic;

import javax.swing.JLabel;

/**
 * Class for turn management in graphical ui 
 */
public class TurnState {

    private int cardsVisible;
    private int indexOfLastCard;
    private JLabel lastCard; 
    private JLabel secondLastCard;

    public TurnState() {
        this.cardsVisible = 0;
        
    }

    public int getCardsVisible() {
        return cardsVisible;
    }

    public void setCardsVisible(int cardsVisible) {
        this.cardsVisible = cardsVisible;
    }

    public int getIndexOfLastCard() {
        return indexOfLastCard;
    }

    public void setIndexOfLastCard(int indexOfLastCard) {
        this.indexOfLastCard = indexOfLastCard;
    }

    public JLabel getLastCard() {
        return lastCard;
    }

    public void setLastCard(JLabel lastCard) {
        this.lastCard = lastCard;
    }

    public JLabel getSecondLastCard() {
        return secondLastCard;
    }

    public void setSecondLastCard(JLabel secondLastCard) {
        this.secondLastCard = secondLastCard;
    }
    
    
    
}
