package cowcentration.ui;

import cowcentration.gamelogic.GraphicGameLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

class CardChooser implements ActionListener {

    private int i;
    private GraphicGameLogic game;
    private JLabel card;
    private JButton button;

    CardChooser(GraphicGameLogic game, int i, JLabel card, JButton button) {
        this.card = card;
        this.game = game;
        this.button = button;
        this.i = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //if two cards are visible hide both
        if (this.game.getTurnState().getCardsVisible()==2) {
            this.game.getTurnState().getLastCard().setText("card");
            this.game.getTurnState().getSecondLastCard().setText("card");
            this.game.getTurnState().setCardsVisible(0);
        }
        
        //if one card visible reveal second and compare the two
        
        //if no cards visible reveal one
        if (this.game.getTurnState().getCardsVisible() == 0) {
            this.card.setText(this.game.getCardText(i));
            this.game.getTurnState().setIndexOfLastCard(i);
            this.game.getTurnState().setLastCard(card);
            this.game.getTurnState().setLastButton(button);
            this.game.getTurnState().setCardsVisible(1);
            this.game.getTurnState().getLastButton().setEnabled(false);
        }
        else if (this.game.getTurnState().getCardsVisible() == 1) {
            //reveal second card
            this.game.getTurnState().setSecondLastCard(this.game.getTurnState().getLastCard());
            this.game.getTurnState().setSecondLastButton(this.game.getTurnState().getLastButton());
            this.game.getTurnState().setLastCard(card);
            this.game.getTurnState().setLastButton(button);
            this.card.setText(this.game.getCardText(i));
            this.game.getTurnState().setCardsVisible(2);
            //compare them
            if (this.game.getCards().get(i).getId() == this.game.getCards().get(this.game.getTurnState().getIndexOfLastCard()).getId()) {
                //if match remove both cards from play and give point
                this.game.getCards().get(i).remove();
                this.game.getCards().get(this.game.getTurnState().getIndexOfLastCard()).remove();
                this.card.setText("found");
                this.game.getTurnState().getSecondLastCard().setText("found");
                this.game.getTurnState().setCardsVisible(0);
                this.game.addPoint();
                this.game.getTurnState().getLastButton().setEnabled(false);
                this.game.getTurnState().getSecondLastButton().setEnabled(false);
                if (this.game.isGameOver()) {
                    //end game if necessary
                }
            }
            //if not match move current player to next
            else {
                this.game.getTurnState().getLastButton().setEnabled(true);
                this.game.getTurnState().getSecondLastButton().setEnabled(true);
                this.game.nextPlayer();
            }
            
            
        }
        
        
        
        
        }
        
        
    }


