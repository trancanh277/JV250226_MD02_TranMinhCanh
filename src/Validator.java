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
    public static LocalDate getDate(Scanner scanner, String suggest){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            String input = getSting(scanner, suggest);
            try {
                return LocalDate.parse(input, formatter);
            }catch (Exception e){
                System.err.println("Mời nhập định dạng ngày ");
            }
        }while (true);
    }

}
