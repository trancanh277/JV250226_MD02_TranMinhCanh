import java.util.List;
import java.util.Scanner;

public class studentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo ngày đăng ký");
            System.out.println("7. Thoát");
            int choice = Validator.getInt(scanner, "Mời nhập vào lựa chọn");
            switch (choice){
                case 1:
                    displayStudent();
                    break;
                case 2:
                    createStudent(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Mời nhập từ 1-7");
            }
        }while (true);
    }
    public static void displayStudent(){
        List<Student> listStudent = StudentBusiness.findAllStudent();
        listStudent.forEach(System.out::println);
    }
    public static void createStudent(Scanner scanner){
        Student student = new Student();
        student.inputData(scanner);
        boolean result = StudentBusiness.createstudent(student);
        if(result){
            System.out.println("Thêm mới sinh viên thành công");
        } else {
            System.err.println("Thêm mới thất bại");
        }
    }

}
