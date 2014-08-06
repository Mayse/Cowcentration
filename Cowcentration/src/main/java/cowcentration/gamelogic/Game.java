
package cowcentration.gamelogic;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    private List<Player> players;
    private List<Card> cards;
    private Player currentPlayer;

    public Game(List<String> players, int cardPairAmount) {
        this.players = new ArrayList();
        if (!players.isEmpty()) {
            
        
        for (String player : players) {
            this.players.add(new Player(player));
        }        
        this.currentPlayer = this.players.get(0);
        }
        
        this.cards = new ArrayList<>();
        if (cardPairAmount>0) {
            
        
        for (int i = 0; i < cardPairAmount; i++) {
            this.cards.add(new Card(i, null));
            this.cards.add(new Card(i, null));
        }
        }
        
    }
    
    
    public boolean compareCards(int first, int second){
        if (cards.get(first).getRemoved()) {
            throw new IllegalArgumentException("card from first argument not in play");
        }
        if (cards.get(second).getRemoved()){
                        throw new IllegalArgumentException("card from second argument not in play");

        }
        if(first == second){
            throw new IllegalArgumentException("card being compared to itself");
        }
        
        try {
            if (this.cards.get(first).getId()==this.cards.get(second).getId()) {
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

    public boolean isGameOver() {
        for (Card card : cards) {
            if (!card.getRemoved()) {
                return false;
            }
        }
        return true;
    }

    public List<Card> getCards() {
        return cards;
    }
    
    public List<Integer> getAvailableCardIndexes(){
        List list = new ArrayList();
        int i = 0;
        for (Card card : this.cards) {
            if (!card.getRemoved()) {
                list.add(i);
            }
            i++;
        }
        return list;
    }
    
    public List<String> getScoreboard(){
        List scoreboard = new ArrayList();
        for (Player player : players) {
            String row = player.getName() + ": " + player.getPoints();
            scoreboard.add(row);
        }
        return scoreboard;
    }
            
}
