
package cowcentration.gamelogic;

public class Card {
    
    private final int id;
    private final String text;
    private boolean removed;

    /**
     * New card for game
     * @param id comparison id to find card pair
     * @param text description of card for player
     */
    
    public Card(int id, String text) {
        this.id = id;
        this.text = text;
        this.removed = false;
    }
    
    /** 
     * mark card as removed from play
     */
    public void remove(){
        this.removed = true;
    }
    
    public boolean getRemoved(){
        return this.removed;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    
    
    
}
