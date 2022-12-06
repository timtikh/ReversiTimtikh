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

    private static void updateCells(Cell[][] field, int x, int y, boolean playerisWhite) {

        List<Direction> directionsToCheck = field[x][y].getEnemyDirection();
        for (Direction direction : directionsToCheck) {
            switch (direction) {
                case N:
                    if (checkIfDirectionCorrect(field, x, y, -1, 0, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, -1, 0, playerisWhite);
                    }
                    break;
                case NE:
                    if (checkIfDirectionCorrect(field, x, y, -1, 1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, -1, 1, playerisWhite);
                    }
                    break;
                case E:
                    if (checkIfDirectionCorrect(field, x, y, 0, 1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, 0, 1, playerisWhite);
                    }
                    break;
                case SE:
                    if (checkIfDirectionCorrect(field, x, y, 1, 1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, 1, 1, playerisWhite);
                    }
                    break;
                case S:
                    if (checkIfDirectionCorrect(field, x, y, 1, 0, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, 1, 0, playerisWhite);
                    }
                    break;
                case SW:
                    if (checkIfDirectionCorrect(field, x, y, 1, -1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, 1, -1, playerisWhite);
                    }
                    break;
                case W:
                    if (checkIfDirectionCorrect(field, x, y, 0, -1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, 0, -1, playerisWhite);
                    }
                    break;
                case NW:
                    if (checkIfDirectionCorrect(field, x, y, -1, -1, playerisWhite)) {
                        changeCellsOnDirection(field, x, y, -1, -1, playerisWhite);
                    }
                    break;
            }

        }
    }

    static boolean checkIfDirectionCorrect(Cell[][] field, int x, int y, int xParam, int yParam,
            boolean playerisWhite) {
        int i = x + xParam;
        int j = y + yParam;
        if (playerisWhite) {
            while (i > 0 && i < 7 && j > 0 && j < 7 && field[i][j].getValue().equals("XX")) {
                i += xParam;
                j += yParam;
            }
            if (field[i][j].getValue().equals("OO")) {
                return true;
            }
        } else {
            while (i > 0 && i < 7 && j > 0 && j < 7 && field[i][j].getValue().equals("OO")) {
                i += xParam;
                j += yParam;
            }
            if (field[i][j].getValue().equals("XX")) {
                return true;
            }
        }
        return false;
    }

    private static void changeCellsOnDirection(Cell[][] field, int x, int y, int xParam, int yParam,
            boolean playerisWhite) {
        int i = x + xParam;
        int j = y + yParam;
        if (playerisWhite) {
            while (i > 0 && i < 7 && j > 0 && j < 7 && field[i][j].getValue().equals("XX")) {
                field[i][j].setValue("OO");
                i += xParam;
                j += yParam;
            }
        } else {
            while (i > 0 && i < 7 && j > 0 && j < 7 && field[i][j].getValue().equals("OO")) {
                field[i][j].setValue("XX");
                i += xParam;
                j += yParam;
            }
        }
    }
}