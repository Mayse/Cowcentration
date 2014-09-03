package cowcentration.gamelogic;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Extension of the Card class used for graphical games, extended fuctionality is the constructor setting an Icon for corresponding id from resources and a getter for said Icon resource.
 * 
 */
public class GraphicCard extends Card {

    private JButton button;
    private Icon picture;

    /**
     * 
     * @param id integer used to compare card and select image resource
     * @param text 
     */
    public GraphicCard(int id, String text) {
        super(id, text);
        this.picture = new ImageIcon("resources/cow" + id + ".jpg");
    }

    /**
     * @deprecated 
     * @param id
     * @param text
     * @param button 
     */
    public GraphicCard(int id, String text, JButton button) {
        super(id, text);
        this.button = button;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Icon getPicture() {
        return picture;
    }
    
    

}
