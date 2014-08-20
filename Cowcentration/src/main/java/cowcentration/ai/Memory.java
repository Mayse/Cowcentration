
package cowcentration.ai;

import cowcentration.gamelogic.Card;

class Memory {
    
    private final int location;
    private final Card card;

    public Memory(int location, Card card) {
        this.location = location;
        this.card = card;
    }

    public int getLocation() {
        return location;
    }

    public Card getCard() {
        return card;
    }
    
    
    
}
