public class GameManager {
    public void StartNewGame() {
        Printer.startGame();
        if (Data.PlayerisWhite && Data.GameWithComputer) {
            ArtificialPlayer.MakeTurn(Data.field, Data.PlayerisWhite);
            RunGameWithComputer();
        } else if (!Data.PlayerisWhite && Data.GameWithComputer) {
            RunGameWithComputer();
        } else if (!Data.GameWithComputer) {
            RunGameWithHuman();
        }
    }

    private void RunGameWithComputer() {
        int choosedCell;
        while (!Data.GameOver) {
            Printer.printField();
            Printer.printScore();
            Cell[] cells = CellManager.CheckCells(Data.field, Data.PlayerisWhite);
            if (CellManager.cellArrayIsNull(cells)
                    && CellManager.cellArrayIsNull(CellManager.CheckCells(Data.field, !Data.PlayerisWhite))) {
                Data.GameOver = true;
                Printer.printGameOver();
                return;
            } else if (CellManager.cellArrayIsNull(cells)) {
                Printer.printNoAvailableCells(Data.PlayerisWhite);
                continue;
            } else {
                Printer.printAvailableCells(Data.PlayerisWhite, cells);
                // read user input choose one of cells variants
                choosedCell = Reader.readPlayersCell(cells);
                FieldManager.ChangeCells(Data.field, choosedCell, Data.PlayerisWhite);
            }
            ArtificialPlayer.MakeTurn(Data.field, Data.PlayerisWhite);
        }
    }

    private void RunGameWithHuman() {
        int choosedCell;
        while (!Data.GameOver) {
            Printer.printField();
            Printer.printScore();
            Cell[] cells = CellManager.CheckCells(Data.field, Data.PlayerisWhite);
            if (CellManager.cellArrayIsNull(cells)
                    && CellManager.cellArrayIsNull(CellManager.CheckCells(Data.field, !Data.PlayerisWhite))) {
                Data.GameOver = true;
                Printer.printGameOver();
                return;
            } else if (CellManager.cellArrayIsNull(cells)) {
                Printer.printNoAvailableCells(Data.PlayerisWhite);
                continue;
            } else {
                Printer.printAvailableCells(Data.PlayerisWhite, cells);
                // read user input choose one of cells variants
                choosedCell = Reader.readPlayersCell(cells);
                FieldManager.ChangeCells(Data.field, choosedCell, Data.PlayerisWhite);
            }
            Printer.printField();
            Printer.printScore();
            cells = CellManager.CheckCells(Data.field, !Data.PlayerisWhite);
            boolean cellEnemyArrayIsNull = CellManager
                    .cellArrayIsNull(CellManager.CheckCells(Data.field, Data.PlayerisWhite));
            if (CellManager
                    .cellArrayIsNull(cells) && cellEnemyArrayIsNull) {
                Data.GameOver = true;
                Printer.printGameOver();
                return;
            } else if (CellManager.cellArrayIsNull(cells)) {
                Printer.printNoAvailableCells(!Data.PlayerisWhite);
                continue;
            } else {
                Printer.printAvailableCells(!Data.PlayerisWhite, cells);
                choosedCell = Reader.readPlayersCell(cells);
                FieldManager.ChangeCells(Data.field, choosedCell, !Data.PlayerisWhite);
            }
        }
    }

}
