
package cowcentration.gamelogic;

class Card {
    
    private final int id;
    private final String text;
    private boolean removed;

    public Card(int id, String text) {
        this.id = id;
        this.text = text;
        this.removed = false;
    }
    
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
