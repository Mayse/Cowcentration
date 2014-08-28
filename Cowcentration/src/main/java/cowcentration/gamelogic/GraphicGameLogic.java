package cowcentration.gamelogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicGameLogic extends Game {

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

    public void shuffleGcards() {
        Collections.shuffle(this.gcards);
    }
    
    @Override
    public boolean isGameOver(){
for (Card card : gcards) {
            if (!card.getRemoved()) {
                return false;
            }
        }
        return true;    }

}
