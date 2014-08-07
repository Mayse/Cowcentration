
package cowcentration.gamelogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miikas
 */
public class PlayerTest {
    
    public PlayerTest() {
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
    public void testConstructor(){
        Player player = new Player("name");
        assertTrue(player.getName().equals("name")&&player.toString().equals("name"));
        
        assertTrue(player.getPoints()==0);
    }
    
    @Test
    public void testIncrementPoints(){
        Player player = new Player("player");
        player.addPoint();
        player.addPoint();
        assertTrue(player.getPoints()==2);
        player.setPoints(15);
        assertTrue(player.getPoints()==15);
    }
}
