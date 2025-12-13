package entity;

import validator.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Exam {
    private int id;
    private String name;
    private Date date;
    private float examTime;
    private String unitTime;
    private String format;
    private int status;

    public Exam() {
    }

    public Exam(int id, String name, Date date, float examTime, String unitTime, String format, int status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.examTime = examTime;
        this.unitTime = unitTime;
        this.format = format;
        this.status = status;
    }

    private static final Map<Integer, String> statusMap = Map.of(
            0, "Đã thi",
            1, "Đang thi",
            2, "Chưa thi",
            3, "Hủy thi"
    );

    public String getStatusName() {
        return statusMap.getOrDefault(this.status, "Không xác định");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getExamTime() {
        return examTime;
    }

    public void setExamTime(float examTime) {
        this.examTime = examTime;
    }

    public String getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(String unitTime) {
        this.unitTime = unitTime;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.name = Validator.getSting(scanner, "Mời nhập tên kỳ thi");
        System.out.println("Mời nhập ngày thi(dd-MM-yyyy): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = dateFormat.parse(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Sai định dạng ngày tháng");
        }
        this.examTime = Validator.getFloat(scanner, "Mời nhập thời gian thi");
        this.unitTime = Validator.getSting(scanner, "Mời nhập đơn vị thời gian");
        this.format = Validator.getSting(scanner, "Mời nhập hình thức thi");
        this.status = Validator.getInt(scanner, "Mời nhập trạng thái kỳ thi(0 - Đã thi, 1 - Đang thi, 2 - Chưa thi, 3 - Hủy thi)");
    }

    @Override
    public String toString() {
        return
                "status: " + getStatusName() +
                ", format: " + format +
                ", unitTime: " + unitTime +
                ", examTime: " + examTime +
                ", date=" + date +
                ", name: " + name +
                ", id: " + id;
    }
}
