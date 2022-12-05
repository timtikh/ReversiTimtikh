import java.util.List;

public class FieldManager {
    // count black and whites
    public static int[] CountBlackAndWhite(Cell[][] field) {
        int[] result = new int[2];
        int black = 0;
        int white = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i][j].getValue().equals("XX")) {
                    black++;
                } else if (field[i][j].getValue().equals("OO")) {
                    white++;
                }
            }
        }
        result[0] = black;
        result[1] = white;
        return result;
    }

    public static void ChangeCells(Cell[][] field, int choosedCell, boolean playerisWhite) {
        int[] cell = CellManager.CellNumberToCell(choosedCell);
        int i = cell[0];
        int j = cell[1];
        if (playerisWhite) {
            field[i][j].setValue("OO");
        } else {
            field[i][j].setValue("XX");
        }
        updateCells(field, i, j, playerisWhite);
    }

    private static void updateCells(Cell[][] field, int i, int j, boolean playerisWhite) {

        if (playerisWhite) {
            List<Direction> directionsToCheck = field[i][j].getEnemyDirection();

        } else {

        }
    }
}


