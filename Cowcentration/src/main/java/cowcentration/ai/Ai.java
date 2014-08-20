
package cowcentration.ai;
import cowcentration.gamelogic.Card;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ai {
    
    private List<Memory> memories;
    private final int difficulty;

    /**
     * Constructor for new ai object
     * @param difficulty size of ai memory in terms of card history
     */
    public Ai(int difficulty) {
        this.difficulty = difficulty;
        this.memories = new ArrayList<>(difficulty);
    }
    
    /**
     * Add a card to memory, if memory is full a random old card will be
     * discarded
     * @param i index of card in Game class being memorized
     * @param card card being added to memory
     */
    public void memorize(int i, Card card){
        //if memory full, forget a card
        if (this.memories.size()>=this.difficulty) {
            this.memories.remove(new Random().nextInt(this.memories.size()));
        }
        //memorize new card
       this.memories.add(new Memory(i, card));
    }

    /**
     * search memory for a copy of card being given as parameter
     * @param card card being searched from memory
     * @return index of card if found, else -1 is returned as failure
     */
    public int remember(Card card){
        for (Memory memory : memories) {
            if (card.getId()==memory.getCard().getId()) {
                return memory.getLocation();
            }
        }
        return -1;
    }
    
    /**
     * selects a new card randomly from available selections not already in memory
     * @param availableIndexes list of legal card selections
     * @return index to new random selection
     */
    public int guess(ArrayList<Integer> availableIndexes){
        //go through available indexes and remove them if they are in memory
        Iterator<Integer> indexIterator = availableIndexes.iterator();
        while (indexIterator.hasNext()) {
            int i = indexIterator.next();
            for (Memory memory : this.memories) {
                if (memory.getLocation()==i) {
                    indexIterator.remove();
                    break;
                }
            }
        }
        int guess = availableIndexes.get(new Random().nextInt(availableIndexes.size()));
        return guess;
    }
}

