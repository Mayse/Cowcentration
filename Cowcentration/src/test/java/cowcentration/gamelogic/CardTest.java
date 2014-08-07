
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
public class CardTest {
    
    public CardTest() {
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
        Card card = new Card(15, "test content");
        assertTrue(card.getId()==15);
        assertTrue(card.getText().equals("test content"));
        assertFalse(card.getRemoved());
    }
    
    public void testRemoval(){
        Card card = new Card(99, "text");
        card.remove();
        assertTrue(card.getRemoved());
    }
}
