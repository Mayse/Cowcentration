package cowcentration.gamelogic;

public class Player {

    private final String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Increment player score by one
     */
    public void addPoint() {
        this.points = this.points + 1;
    }

    @Override
    public String toString() {
        return name;
    }

}
