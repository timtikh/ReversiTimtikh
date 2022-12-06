import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    static Scanner scanner = new Scanner(System.in);

    /// проверить и почистить ввод.
    public static int readPlayersCell(Cell[] cells) {
        boolean flag = true;
        while (flag) {
            System.out.println("Choose the correct cell above:");
            int cellNumber = scanner.nextInt();
            for (int i = 0; i < cells.length; i++) {
                if (cells[i] != null) {
                    if (cells[i].getValue().equals("0" + cellNumber) || cells[i].getValue().equals("" + cellNumber)) {
                        flag = false;
                        return cellNumber;
                    }
                }
            }
        }
        return 0;
    }

}
