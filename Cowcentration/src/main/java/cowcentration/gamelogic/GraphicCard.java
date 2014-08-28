package cowcentration.gamelogic;

import javax.swing.JButton;

public class GraphicCard extends Card {

    private JButton button;

    public GraphicCard(int id, String text) {
        super(id, text);
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

}
