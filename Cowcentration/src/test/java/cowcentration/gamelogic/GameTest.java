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
    public void testMakeEmptyGame(){
         Game emptyGame;
            List players = new ArrayList();
            
        int cardPairAmount = 0;
         emptyGame = new Game(players, cardPairAmount);
        
        assertNotNull(emptyGame);
        
    
    }
    
    @Test
    public void testCardComparing(){
        List players = new ArrayList();
        players.add("name");
        Game game = new Game(players, 2);
        assertTrue(game.compareCards(0, 1));
        
    }
    
    @Test
    public void testCardRemoval(){
        List players = new ArrayList();
        players.add("name");
        Game game = new Game(players, 2);
        assertTrue(!game.getCards().get(0).getRemoved());
        game.removeCard(0);
        assertTrue(game.getCards().get(0).getRemoved());
    }
    
    @Test
    public void testPlayerRotation(){
        List players = new ArrayList();
        players.add("name1");
        players.add("name2");
        Game game = new Game(players, 2);
        assertTrue(game.getCurrentPlayer().getName().equals("name1"));
        game.nextPlayer();
        assertTrue(game.getCurrentPlayer().getName().equals("name2"));
        game.nextPlayer();
        assertTrue(game.getCurrentPlayer().getName().equals("name1"));

    }
    
    @Test
    public void testPointsGetAdded(){
        List players = new ArrayList();
        players.add("name1");
        players.add("name2");
        Game game = new Game(players, 2);
        assertTrue(game.getCurrentPlayer().getPoints()==0);
        game.addPoint();
        game.nextPlayer();
        game.addPoint();
        game.addPoint();
        game.nextPlayer();
        assertTrue(game.getCurrentPlayer().getPoints()==1);
        game.nextPlayer();
        assertTrue(game.getCurrentPlayer().getPoints()==2);
    }
            
    @Test
    public void testGameEndRecognized(){
        List players = new ArrayList();
        players.add("name1");
        players.add("name2");
        Game game = new Game(players, 2);
        assertFalse(game.isGameOver());
        game.removeCard(0);
        assertFalse(game.isGameOver());
        game.removeCard(1);
        assertFalse(game.isGameOver());
        game.removeCard(2);
        assertFalse(game.isGameOver());
        game.removeCard(3);
        assertTrue(game.isGameOver());
}
    
    @Test
    public void testCardAvailability(){
        List players = new ArrayList();
        players.add("name1");
        players.add("name2");
        Game game = new Game(players, 2);
        assertTrue(game.getAvailableCardIndexes().size()==game.getCards().size());
        game.removeCard(0);
        game.removeCard(1);
        assertTrue(game.getAvailableCardIndexes().size()==game.getCards().size()-2);

    }
}
