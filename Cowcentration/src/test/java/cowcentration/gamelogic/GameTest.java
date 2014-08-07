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
        
        //normal comparison with known pair and not pair
        assertTrue(game.compareCards(0, 1));
        assertFalse(game.compareCards(0, 2));
        
        try {
            game.compareCards(1, 1);
            fail("no comparing to self!");
        } catch (Exception e) {
        }
        
        //trying to compare removed cards
        game.removeCard(1);        
        try {
            game.compareCards(0, 1);
            fail("card of first parameter should be removed");
            game.compareCards(1, 0);
            fail("card of second parameter should be removed");
        } catch (Exception e) {
        }
        
        //going out of bounds
        try {
            game.compareCards(99, 256);
            fail("compared cards with index outside deck");
        } catch (Exception e) {
        }
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
        
        //checking sizes correct before and after removal
        assertTrue(game.getAvailableCardIndexes().size()==game.getCards().size());
        game.removeCard(0);
        game.removeCard(1);
        assertTrue(game.getAvailableCardIndexes().size()==game.getCards().size()-2);

    }
    
    @Test
    public void testScoreboard(){
        List players = new ArrayList();
        players.add("name1");
        players.add("name2");
        Game game = new Game(players, 2);
        
        game.addPoint();
        List scoreboard = game.getScoreboard();
        assertTrue(scoreboard.get(0).equals("name1: 1"));
        assertTrue(scoreboard.get(1).equals("name2: 0"));
    }
}
