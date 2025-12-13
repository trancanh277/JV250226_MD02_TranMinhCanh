package presentation;

import business.ExamBusiness;
import entity.Exam;
import validator.Validator;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ExamManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Danh sách các kỳ thi");
            System.out.println("2. Thêm mới một kỳ thi");
            System.out.println("3. Cập nhật kỳ thi");
            System.out.println("4. Hủy kỳ thi");
            System.out.println("5. Tìm kiếm đề thi theo tên");
            System.out.println("6. Thoát");
            int choice = Validator.getInt(scanner, "Mời nhập vào lựa chọn");
            switch (choice) {
                case 1:
                    displayExam();
                    break;
                case 2:
                    createExam(scanner);
                    break;
                case 3:
                    updateExam(scanner);
                    break;
                case 4:
                    deleteExam(scanner);
                    break;
                case 5:
                    searchByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Mời nhập từ 1-7");
            }
        } while (true);
    }

    public static void displayExam() {
        List<Exam> listExam = new ExamBusiness().findAllExam();
        listExam.forEach(exam -> System.out.println(exam));
    }

    public static void createExam(Scanner scanner) {
        Exam exam = new Exam();
        exam.inputData(scanner);
        boolean result = new ExamBusiness().createExam(exam);
        if (result) {
            System.out.println("Thêm mới kỳ thi thành công");
        } else {
            System.err.println("Thêm mới kỳ thi thất bại");
        }
    }

    public static void updateExam(Scanner scanner) {
        int id = Validator.getInt(scanner, "Mời nhập vào id kỳ thi cần cập nhật");
        Exam examUpdate = new ExamBusiness().findById(id);
        if (examUpdate == null) {
            System.err.println("Mã kỳ thi không tồn tại");
            return;
        }
        boolean continueUpdate = true;
        do {
            System.out.println("1. Cập nhật tên kỳ thi");
            System.out.println("2. Cập nhật ngày thi");
            System.out.println("3. Cập nhật thời gian thi");
            System.out.println("4. Cập nhật đơn vị thời gian");
            System.out.println("5. Cập nhật hình thức thi");
            System.out.println("6. Cập nhật trạng thái kỳ thi");
            System.out.println("7. Thoát");
            int choice = Validator.getInt(scanner, "Mời nhập vào lựa chọn");
            switch (choice) {
                case 1:
                    String name = Validator.getSting(scanner, "Mời nhập tên kỳ thi");
                    examUpdate.setName(name);
                    break;
                case 2:
                    System.out.println("Mời nhập ngày thi(dd-MM-yyyy): ");
                    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        examUpdate.setDate(dateFormat.parse(scanner.nextLine()));
                    } catch (Exception e) {
                        System.err.println("Sai định dạng ngày tháng");
                    }
                    break;
                case 3:
                    float examTime = Validator.getFloat(scanner, "Mời nhập thời gian thi");
                    examUpdate.setExamTime(examTime);
                    break;
                case 4:
                    String unitTime = Validator.getSting(scanner, "Mời nhập đơn vị thời gian");
                    examUpdate.setUnitTime(unitTime);
                    break;
                case 5:
                    String format = Validator.getSting(scanner, "Mời nhập hình thức thi");
                    examUpdate.setFormat(format);
                    break;
                case 6:
                    int status = Validator.getInt(scanner, "Mời nhập trạng thái kỳ thi");
                    examUpdate.setStatus(status);
                    break;
                case 7:
                    continueUpdate = false;
                    break;
                default:
                    System.err.println("Mời nhập từ 1-7");
            }
        } while (continueUpdate);
        boolean result = new ExamBusiness().updateExam(examUpdate);
        if (result) {
            System.out.println("Cập nhật kỳ thi thành công");
        } else {
            System.err.println("Cập nhật kỳ thi thất bại");

        }

    }
    public static void deleteExam(Scanner scanner) {
        int id = Validator.getInt(scanner, "Mời nhập vào id kỳ thi cần hủy");
        Exam examDelete = new ExamBusiness().findById(id);
        if (examDelete == null) {
            System.err.println("Mã kỳ thi không tồn tại");
            return;
        }
        if(examDelete.getStatus() == 0){
            System.err.println("Kỳ thi đã diễn ra, không thể hủy");
            return;
        }
        if (examDelete.getStatus() == 3) {

            System.err.println("Kỳ thi đã hủy trước đó");
            return;
        }
        System.out.println("Bạn có chắc chắn muốn hủy kỳ thi này không? (Y/N)");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Hủy kỳ thi đã được hủy bỏ");
            return;
        }
        boolean result = new ExamBusiness().deleteExam(id);
        if (result ) {
            System.out.println("Hủy kỳ thi thành công");
        } else {
            System.err.println("Hủy kỳ thi thất bại");
        }
    }
    public static void searchByName(Scanner scanner) {
        String name = Validator.getSting(scanner, "Mời nhập vào tên kỳ thi cần tìm kiếm");
        List<Exam> listExam = ExamBusiness.searchByName(name);
        if (listExam == null || listExam.isEmpty()) {
            System.err.println("Không tìm thấy kỳ thi nào");
            return;
        }
        listExam.forEach(exam -> System.out.println(exam));
    }
}
