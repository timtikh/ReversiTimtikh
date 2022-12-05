import java.util.Scanner;

public class Printer {
    // void method start game
    public static void startGame() {
        System.out.println("Welcome to Reversi game!");
        Data.CreateField();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your opponent: 1 - computer, 2 - human");
        int opponent = scanner.nextInt();
        if (opponent == 1) {
            Data.GameWithComputer = true;
        } else if (opponent == 2) {
            Data.GameWithComputer = false;
        } else {
            System.out.println("Wrong opponent!");
            System.exit(0);
        }
        if (Data.GameWithComputer) {
            System.out.println("Choose your color: 1 - white(OO), 2 - black(XX)");
            int color = scanner.nextInt();
            if (color == 1) {
                Data.PlayerisWhite = true;
            } else if (color == 2) {
                Data.PlayerisWhite = false;
            } else {
                System.out.println("Wrong color!");
                System.exit(0);
            }
        } else {
            Data.PlayerisWhite = false;
        }
        System.out.println("Game started!");

    }

    // void method print field from data class
    public static void printField() {
        System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            System.out.print(" ");
            for (int j = 0; j < 8; j++) {
                System.out.print(Data.field[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }

    public static void printAvailableCells(boolean isWhite, Cell[] cells) {
        if (isWhite) {
            System.out.println("Your color is white(OO)");
        } else {
            System.out.println("Your color is black(XX)");
        }
        System.out.println("\nAvailable cells:");
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != null) {
                System.out.print(cells[i].getValue() + " ");
            }
        }
        System.out.println();
    }

    // print score
    public static void printScore() {
        int[] score = FieldManager.CountBlackAndWhite(Data.field);
        System.out.println("\nBlack: " + score[0] + " White: " + score[1]);

    }

    public static void printGameOver() {
        System.out.println("Game over!");
        int[] score = FieldManager.CountBlackAndWhite(Data.field);
        if (score[0] > score[1]) {
            System.out.println("Black won!");
        } else if (score[0] < score[1]) {
            System.out.println("White won!");
        } else {
            System.out.println("Draw!");
        }
        return;
    }
}
