import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    static Scanner scanner = new Scanner(System.in);

    public static int readPlayersCell(Cell[] cells) {
        int cellNumber = scanner.nextInt();
        if (cellNumber < 0 || cellNumber > 63) {
            System.out.println("Wrong cell number!");
            return -1;
        }
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != null) {
                if (cells[i].getValue().equals("0" + cellNumber) || cells[i].getValue().equals("" + cellNumber)) {
                    return cellNumber;
                }
            }
        }
        System.out.println("Wrong cell number!");
        return -1;
    }

}
