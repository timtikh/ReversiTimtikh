public class ArtificialPlayer {
    // choose cell to win reversi
    public static void MakeTurn(Cell[][] field, boolean PlayerIsWhite) {
        Cell[] cells = CellManager.CheckCells(field, !PlayerIsWhite);
        if (CellManager.cellArrayIsNull(cells)) {
            // print that there is no available cells for computer
            System.out.println("There is no available cells for computer - turn goes to player.");
            return;
        }
        Cell bestTurn = chooseBestTurn(field, cells, !PlayerIsWhite);

        FieldManager.ChangeCells(field, Integer.parseInt(bestTurn.getValue()), !PlayerIsWhite);
    }

    private static Cell chooseBestTurn(Cell[][] field, Cell[] cells, boolean PlayerIsWhite) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != null) {
                int temp = turnScore(field, Integer.parseInt(cells[i].getValue()), PlayerIsWhite);
                if (temp > max) {
                    max = temp;
                    maxIndex = i;
                }
            }
        }
        return cells[maxIndex];
    }

    private static int turnScore(Cell[][] field, int cellNumber, boolean PlayerIsWhite) {
        int res = 0;
        Cell[][] tempField = new Cell[8][8];
        tempField = Data.copyField();
        FieldManager.ChangeCells(tempField, cellNumber, PlayerIsWhite);
        int[] allScore = FieldManager.CountBlackAndWhite(tempField);
        if (PlayerIsWhite) {
            res = allScore[0];
        } else {
            res = allScore[1];
        }
        return res;
    }
}
