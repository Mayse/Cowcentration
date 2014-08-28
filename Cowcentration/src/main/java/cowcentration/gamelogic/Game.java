package cowcentration.gamelogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    List<Player> players;
    List<Card> cards;
    Player currentPlayer;
    TurnState turnState;

    /**
     * game logic core object for handling cards and players in the game
     *
     * @param players List containing names of players
     * @param cardPairAmount Integer of amount of cards to be generated for play
     */
    public Game(List<String> players, int cardPairAmount) {
        this.players = new ArrayList();
        if (!players.isEmpty()) {

            for (String player : players) {
                this.players.add(new Player(player));
            }
            this.currentPlayer = this.players.get(0);
        }

        this.cards = new ArrayList<>();
        if (cardPairAmount > 0) {

            for (int i = 0; i < cardPairAmount; i++) {
                String text = Integer.toString(i);
                this.cards.add(new Card(i, text));
                this.cards.add(new Card(i, text));
            }
        }

        this.turnState = new TurnState();

    }

    public void shufflePlayers() {
        Collections.shuffle(this.players);
    }

    public void shuffleCards() {
        Collections.shuffle(this.cards);
    }

    /**
     * compares two cards and returns true if pair is found
     *
     * @param first index of first card
     * @param second index of second card
     */
    public boolean compareCards(int first, int second) {
        if (cards.get(first).getRemoved()) {
            throw new IllegalArgumentException("card from first argument not in play");
        }
        if (cards.get(second).getRemoved()) {
            throw new IllegalArgumentException("card from second argument not in play");

        }
        if (first == second) {
            throw new IllegalArgumentException("card being compared to itself");
        }

        try {
            if (this.cards.get(first).getId() == this.cards.get(second).getId()) {
                return true;
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }

        return false;
    }

    /**
     * Mark a card removed from game, usually to signify a card has been found
     *
     * @param i index of card to be marked as removed
     */
    public void removeCard(int i) {
        this.cards.get(i).remove();
    }

    /**
     * set current player to be the next in line loops around once last player
     * is reached
     */
    public void nextPlayer() {
        int indexOfCurrentPlayer;
        int i = 0;
        for (Player player : this.players) {
            if (player == this.currentPlayer) {
                indexOfCurrentPlayer = i;
                break;
            }
            i++;
        }
        try {
            this.currentPlayer = players.get(i + 1);
        } catch (Exception e) {
            this.currentPlayer = players.get(0);
        }
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * add one point to current players score
     */
    public void addPoint() {
        this.currentPlayer.addPoint();
    }

    /**
     * checks the cards list to see if all cards have been found
     *
     * @return is true if all cards have been found and game is ready to end
     */
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

    public String getCardText(int i) {
        return this.cards.get(i).getText();
    }

    /**
     * fetches cards that have not yet been removed from game
     *
     * @return list of all cards not yet removed from game (legal selections for
     * compareCards() method
     */
    public List<Integer> getAvailableCardIndexes() {
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

    /**
     * fetches player names and scores
     *
     * @return concatenated elements containing player name and current score
     */
    public List<String> getScoreboard() {
        List scoreboard = new ArrayList();
        for (Player player : players) {
            String row = player.getName() + ": " + player.getPoints();
            scoreboard.add(row);
        }
        return scoreboard;
    }

    public TurnState getTurnState() {
        return turnState;
    }

}
