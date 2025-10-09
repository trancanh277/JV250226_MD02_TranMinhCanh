import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private  int studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private Date registerDate;
    private Boolean status;

    public Student() {
    }

    public Student(int studentId, String studentName, String email, String phoneNumber, Date registerDate, Boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void inputData(Scanner scanner){
        this.studentName = Validator.getSting(scanner, "Nhập vào tên sinh viên");
        this.email  = Validator.getSting(scanner, "Nhập vào email");
        this.phoneNumber = Validator.getSting(scanner, "Nhập vào số điện thoại");
        System.out.println("Nhập vào ngày đăng kí");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.registerDate = format.parse(scanner.nextLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.status = Boolean.valueOf(scanner.nextLine());
    }

    @Override
    public String toString() {
        return
                "studentId: " + studentId +
                ", studentName='" + studentName  +
                ", email: '" + email  +
                ", phoneNumber: " + phoneNumber +
                ", registerDate: " + registerDate +
                ", status: " + status;
    }
}

