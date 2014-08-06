package cowcentration.gamelogic;


import cowcentration.gamelogic.Game;
import cowcentration.gamelogic.Game;
import cowcentration.gamelogic.Game;
import java.util.ArrayList;
import java.util.List;
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
public class GameTest {
    
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void makeEmptyGame(){
         Game emptyGame;
            List players = new ArrayList();
            
        int cardPairAmount = 0;
         emptyGame = new Game(players, cardPairAmount);
        
        assertNotNull(emptyGame);
        
    
    }
    
    @Test
    public void cardComparing(){
        
    }
            
}
