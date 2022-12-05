public class CellManager {
    public static Cell[] CheckCells(Cell[][] field, boolean isWhite) {
        Cell[] AvailableCells = new Cell[64];
        Cell[] EnemyCells = new Cell[64];

        EnemyCells = GetEnemyCells(field, isWhite);
        AvailableCells = GetAvailableCells(field, EnemyCells, isWhite);
        return AvailableCells;
    }

    private static Cell[] GetAvailableCells(Cell[][] field, Cell[] NearEnemyCells, boolean isWhite) {
        Cell[] cells = new Cell[64];
        int counter = 0;
        // if cell is not null
        for (int i = 0; i < NearEnemyCells.length; i++) {
            if (NearEnemyCells[i] != null) {
                if (CheckAvailableCell(field, NearEnemyCells[i], isWhite)) {
                    cells[counter] = NearEnemyCells[i];
                    counter++;
                }
            }
        }
        return cells;
    }

    private static boolean CheckAvailableCell(Cell[][] field, Cell Position, boolean isWhite) {
        int x = Position.getX();
        int y = Position.getY();
        boolean isAvailable = false;
        // check all directions

        for (Direction direction : Position.getEnemyDirection()) {
            switch (direction) {
                case N:
                    isAvailable = CheckUpCells(field, x, y, isWhite);
                    break;
                case S:
                    isAvailable = CheckDownCells(field, x, y, isWhite);
                    break;
                case W:
                    isAvailable = CheckLeftCells(field, x, y, isWhite);
                    break;
                case E:
                    isAvailable = CheckRightCells(field, x, y, isWhite);
                    break;
                case NE:
                    isAvailable = CheckUpRightCells(field, x, y, isWhite);
                    break;
                case NW:
                    isAvailable = CheckUpLeftCells(field, x, y, isWhite);
                    break;
                case SE:
                    isAvailable = CheckDownRightCells(field, x, y, isWhite);
                    break;
                case SW:
                    isAvailable = CheckDownLeftCells(field, x, y, isWhite);
                    break;
            }
            if (isAvailable) {
                return true;
            }
        }
        // check all directions and return true if there is available cell
        return false;
    }

    private static boolean CheckIfRowAvailable(int whiteCounter, int blackCounter, boolean isWhite) {
        boolean result = false;
        if (isWhite) {
            if (blackCounter > 0 && whiteCounter > 0) {
                result = true;
            }
        } else {
            if (whiteCounter > 0 && blackCounter > 0) {
                result = true;
            }
        }
        return result;
    }

    private static boolean CheckUpCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        // check left side
        for (int i = x - 1; i >= 0; i--) {
            if (field[i][y].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][y].getValue().equals("OO")) {
                whiteCounter++;
            } else {
                break;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    private static boolean CheckDownCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        // check right side
        for (int i = x + 1; i < 8; i++) {
            if (field[i][y].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][y].getValue().equals("OO")) {
                whiteCounter++;
            } else {
                break;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    // check vertical cells method
    private static boolean CheckLeftCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        // check up side
        for (int i = y - 1; i >= 0; i--) {
            if (field[x][i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[x][i].getValue().equals("OO")) {
                whiteCounter++;
            } else {
                break;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    private static boolean CheckRightCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        // check down side
        for (int i = y + 1; i < 8; i++) {
            if (field[x][i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[x][i].getValue().equals("OO")) {
                whiteCounter++;
            } else {
                break;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    //check diagonal cells method
    private static boolean CheckDownRightCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        for (int i = x + 1; i < 8; i++) {
            if (field[i][i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][i].getValue().equals("OO")) {
                whiteCounter++;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    private static boolean CheckUpLeftCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        for (int i = x - 1; i >= 0; i--) {
            if (field[i][i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][i].getValue().equals("OO")) {
                whiteCounter++;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }


    private static boolean CheckUpRightCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        for (int i = x - 1; i >= 0; i--) {
            if (field[i][7 - i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][7 - i].getValue().equals("OO")) {
                whiteCounter++;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    private static boolean CheckDownLeftCells(Cell[][] field, int x, int y, boolean isWhite) {
        int blackCounter = 0;
        int whiteCounter = 0;
        boolean result = false;
        for (int i = x + 1; i < 8; i++) {
            if (field[i][7 - i].getValue().equals("XX")) {
                blackCounter++;
            } else if (field[i][7 - i].getValue().equals("OO")) {
                whiteCounter++;
            }
        }
        result = CheckIfRowAvailable(whiteCounter, blackCounter, isWhite);
        return result;
    }

    private static Cell[] GetEnemyCells(Cell[][] field, boolean isWhite) {
        Cell[] cells = new Cell[64];
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!field[i][j].getValue().equals("OO") && !field[i][j].getValue().equals("XX")) {
                    if (CheckEnemyDirection(field, i, j, isWhite)) {
                        cells[counter] = Data.field[i][j];
                        counter++;
                    }
                }
            }
        }
        return cells;
    }

    private static boolean CheckEnemyDirection(Cell[][] field, int x, int y, boolean isWhite) {
        boolean result = false;
        field[x][y].cleanEnemyDirection();
        if (x > 0 && y > 0) {
            if (field[x - 1][y - 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.NW);
            } else if (field[x - 1][y - 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.NW);
            }
        }
        if (x > 0) {
            if (field[x - 1][y].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.N);
            } else if (field[x - 1][y].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.N);
            }
        }
        if (x > 0 && y < 7) {
            if (field[x - 1][y + 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.NE);
            } else if (field[x - 1][y + 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.NE);
            }
        }
        if (y > 0) {
            if (field[x][y - 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.W);
            } else if (field[x][y - 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.W);
            }
        }
        if (y < 7) {
            if (field[x][y + 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.E);
            } else if (field[x][y + 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.E);
            }
        }
        if (x < 7 && y > 0) {
            if (field[x + 1][y - 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.SW);
            } else if (field[x + 1][y - 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.SW);
            }
        }
        if (x < 7) {
            if (field[x + 1][y].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.S);
            } else if (field[x + 1][y].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.S);
            }
        }
        if (x < 7 && y < 7) {
            if (field[x + 1][y + 1].getValue().equals("OO") && !isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.SE);
            } else if (field[x + 1][y + 1].getValue().equals("XX") && isWhite) {
                result = true;
                field[x][y].addEnemyDirection(Direction.SE);
            }
        }
        return result;
    }
    public static int[] CellNumberToCell(int choosedCell) {
        int[] cell = new int[2];
        cell[0] = (choosedCell-1) / 8;
        cell[1] = (choosedCell-1) % 8;
        return cell;
    }
}