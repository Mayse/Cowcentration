
package gamelogic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miikas
 */
public class Game {
    
    private List<Player> players;
    private List<Card> cards;
    private Player currentPlayer;

    public Game(List<String> players, int cards) {
        this.players = new ArrayList();
        for (String player : players) {
            this.players.add(new Player(player));
        }
        this.cards = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            this.cards.add(new Card(i, null));
            this.cards.add(new Card(i, null));
        }
        
        
        this.currentPlayer = this.players.get(0);
    }
    
    
    public boolean compareCards(int first, int second){
        if (cards.get(first).getRemoved()||cards.get(second).getRemoved()) {
            throw new IllegalArgumentException("one or both cards not in play");
        }
        if(first == second){
            throw new IllegalArgumentException("card being compared to itself");
        }
        try {
            if (cards.get(first).getId() == cards.get(second).getId()) {
                return true;
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
        
        return false;
    }
    
    public void removeCard(int i){
        this.cards.get(i).remove();
    }
    
    public void nextPlayer(){
        int indexOfCurrentPlayer;
        int i = 0;
        for (Player player : players) {
            if (player == this.currentPlayer) {
                indexOfCurrentPlayer = i;
                break;
            }
            i++;
        }
        try {
            this.currentPlayer = players.get(i+1);
        } catch (Exception e) {
            this.currentPlayer = players.get(0);
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    public void addPoint(){
        this.currentPlayer.addPoint();
    }

    public boolean gameOver() {
        for (Card card : cards) {
            if (!card.getRemoved()) {
                return false;
            }
        }
        return true;
    }
    
    
            
}
