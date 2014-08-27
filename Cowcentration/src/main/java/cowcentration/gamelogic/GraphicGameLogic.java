
package cowcentration.gamelogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author miikas
 */



public class GraphicGameLogic extends Game{
    
    private List<GraphicCard> gcards;

    public GraphicGameLogic(List<String> players, int cardPairAmount) {
        super(players, cardPairAmount);
        this.gcards = new ArrayList<>();
        for (Card card : this.cards) {
            this.gcards.add(new GraphicCard(card.getId(), card.getText()));
        }
    }

    public List<GraphicCard> getGcards() {
        return gcards;
    }

    public void setGcards(List<GraphicCard> gcards) {
        this.gcards = gcards;
    }
    
         
    
}
