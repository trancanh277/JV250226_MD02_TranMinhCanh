package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {
    public static String getSting(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Không được để trống");
            }
            break;
        } while (true);
        return input;
    }

    public static Integer getInt(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                return Integer.parseInt(input);

            } catch (Exception e) {
                System.err.println("Mời nhập số nguyên");
            }

        } while (true);
    }
    public static Float getFloat(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = scanner.nextLine();
            try {
                return Float.parseFloat(input);

            } catch (Exception e) {
                System.err.println("Mời nhập số thực");
            }

        } while (true);
    }


}
