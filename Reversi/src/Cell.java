import java.util.ArrayList;
import java.util.List;

enum Direction {
    N, S, W, E, NE, NW, SE, SW
};

public class Cell {
    private int x;
    private int y;
    private String value;

    private List<Direction> EnemyDirections;

    public Cell(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
        EnemyDirections = new ArrayList<Direction>();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // get EnemyDirection
    public List<Direction> getEnemyDirection() {
        return EnemyDirections;
    }

    // set EnemyDirection
    public void addEnemyDirection(Direction enemyDirection) {
        if (EnemyDirections.contains(enemyDirection)) {
            return;
        }
        EnemyDirections.add(enemyDirection);
    }

    public void cleanEnemyDirection() {
        EnemyDirections = new ArrayList<Direction>();
    }
}
