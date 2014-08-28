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

        //if two cards are visible hide both
        if (this.game.getTurnState().getCardsVisible() == 2) {
            this.game.getTurnState().getLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
            this.game.getTurnState().getSecondLastCard().setIcon(new ImageIcon("resources/Card_back_06.jpg"));
            this.game.getTurnState().setCardsVisible(0);
        }

        //if one card visible reveal second and compare the two
        //if no cards visible reveal one
        if (this.game.getTurnState().getCardsVisible() == 0) {

            this.card.setIcon(this.game.getGcards().get(i).getPicture());
            this.game.getTurnState().setIndexOfLastCard(i);
            this.game.getTurnState().setLastCard(card);
            this.game.getTurnState().setLastButton(button);
            this.game.getTurnState().setCardsVisible(1);
            this.game.getTurnState().getLastButton().setEnabled(false);
        } else if (this.game.getTurnState().getCardsVisible() == 1) {
            //reveal second card
            this.game.getTurnState().setSecondLastCard(this.game.getTurnState().getLastCard());
            this.game.getTurnState().setSecondLastButton(this.game.getTurnState().getLastButton());
            this.game.getTurnState().setLastCard(card);
            this.game.getTurnState().setLastButton(button);
            this.card.setIcon(this.game.getGcards().get(i).getPicture());
            this.game.getTurnState().setCardsVisible(2);
            //compare them
            if (this.game.getGcards().get(i).getId() == this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).getId()) {
                //if match remove both cards from play and give point
                this.game.getGcards().get(i).remove();
                this.game.getGcards().get(this.game.getTurnState().getIndexOfLastCard()).remove();
                this.button.setText("found");
                this.game.getTurnState().getSecondLastButton().setText("found");
                this.game.getTurnState().setCardsVisible(0);
                this.game.addPoint();
                this.game.getTurnState().getLastButton().setEnabled(false);
                this.game.getTurnState().getSecondLastButton().setEnabled(false);
                if (this.game.isGameOver()) {
                    //end game if necessary
                    GraphicEndScreen end = new GraphicEndScreen(this.game);
                    end.run();
                }
            } //if not match move current player to next
            else {
                this.game.getTurnState().getLastButton().setEnabled(true);
                this.game.getTurnState().getSecondLastButton().setEnabled(true);
                this.game.nextPlayer();
                this.currentPlayer.setText(game.getCurrentPlayer().getName());
            }

        }

    }

}
