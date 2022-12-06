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
        while (!Data.GameOver) {
            Printer.printField();
            Printer.printScore();
            Cell[] cells = CellManager.CheckCells(Data.field, Data.PlayerisWhite);
            Printer.printAvailableCells(Data.PlayerisWhite, cells);
            if (Data.PlayerisWhite) {
                // player turn
            } else {
                // computer turn
            }
        }
    }

    private void RunGameWithHuman() {
        while (!Data.GameOver) {
            Printer.printField();
            Printer.printScore();
            Cell[] cells = CellManager.CheckCells(Data.field, Data.PlayerisWhite);
            if (cells.length == 0) {
                Data.GameOver = true;
                Printer.printGameOver();
                return;
            }
            Printer.printAvailableCells(Data.PlayerisWhite, cells);
            // read user input choose one of cells variants
            int choosedCell = Reader.readPlayersCell(cells);
            FieldManager.ChangeCells(Data.field, choosedCell, Data.PlayerisWhite);
            Printer.printField();
            Printer.printScore();
            cells = CellManager.CheckCells(Data.field, !Data.PlayerisWhite);
            if (cells.length == 0) {
                Data.GameOver = true;
                Printer.printGameOver();
                return;
            }
            Printer.printAvailableCells(!Data.PlayerisWhite, cells);
            choosedCell = Reader.readPlayersCell(cells);
            FieldManager.ChangeCells(Data.field, choosedCell, !Data.PlayerisWhite);
        }
    }
}
