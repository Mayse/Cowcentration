package cowcentration.gamelogic;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GraphicCard extends Card {

    private JButton button;
    private Icon picture;

    public GraphicCard(int id, String text) {
        super(id, text);
        this.picture = new ImageIcon("resources/cow" + id + ".jpg");
    }

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
