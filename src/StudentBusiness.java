import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {
    public static List<Student> findAllStudent(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student}");
            ResultSet rs = callSt.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("student_Id"));
                student.setStudentName(rs.getString("full_Name"));
                student.setEmail(rs.getString("email"));
                student.setPhoneNumber(rs.getString("phone_Number"));
                student.setRegisterDate(rs.getDate("register_Date"));
                student.setStatus(Boolean.parseBoolean("status"));
                listStudent.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudent;
    }
    public static boolean createstudent(Student student){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?,?,?)}");
            callSt.setString(1, student.getStudentName());
            callSt.setString(2, student.getEmail());
            callSt.setString(3,student.getPhoneNumber());
            callSt.setDate(4, new java.sql.Date(student.getRegisterDate().getTime()));
            callSt.setBoolean(5, student.getStatus());
            callSt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    public static  boolean updateStudent(Student student){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?,?,?)}");
            callSt.setInt(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setString(3, student.getEmail());
            callSt.setString(4,student.getPhoneNumber());
            callSt.setDate(5, new java.sql.Date(student.getRegisterDate().getTime()));
            callSt.setBoolean(6, student.getStatus());
            callSt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

}
