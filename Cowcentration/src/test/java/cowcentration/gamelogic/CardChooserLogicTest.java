
package cowcentration.gamelogic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author miikas
 */
public class CardChooserLogicTest {
    
    public CardChooserLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testHideCards(){
        JLabel card = new JLabel("cards text");
        List players = new ArrayList();
        players.add("player name");
        GraphicGameLogic game = new GraphicGameLogic(players, 2);
        JButton button = new JButton();
        int i = 1;
        JLabel currentplayer = new JLabel("playername goes here");
        
        CardChooserLogic logic = new CardChooserLogic(card, game, button, i, currentplayer);
        
        game.getTurnState().setCardsVisible(2);
        assertTrue(game.getTurnState().getCardsVisible()==2);
        
        game.getTurnState().setLastButton(button);
        game.getTurnState().setSecondLastButton(button);
        
        game.getTurnState().setLastCard(card);
        game.getTurnState().setSecondLastCard(card);
        
        logic.hideAllCards();
        
        assertTrue(game.getTurnState().getCardsVisible()==0);
    }
    
    @Test
    public void testRevealOneCard(){
        
    }
}
