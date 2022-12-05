public class Data {
    // create Cell-structure matrice 8X8 filled with numbers 1 to 64
    public static Cell[][] field = new Cell[8][8];

    public static void CreateField() {
        int counter = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //if counter less than 10 add 0 to the beginning
                if (counter < 10) {
                    field[i][j] = new Cell(i, j, "0" + counter);
                } else {
                    field[i][j] = new Cell(i, j, "" + counter);
                }
                counter++;
            }
        }
        field[3][3].setValue("OO");
        field[3][4].setValue("XX");
        field[4][3].setValue("XX");
        field[4][4].setValue("OO");
    }

    public static boolean PlayerisWhite = true;
    public static boolean GameWithComputer = true;
    public static boolean GameOver = false;
}
