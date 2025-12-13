package business;

import connection.ConnectionDB;
import entity.Exam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamBusiness {
    public List<Exam> findAllExam() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Exam> listExam = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_All_Exams()}");
            ResultSet rs = callSt.executeQuery();
            listExam = new ArrayList<Exam>();
            while (rs.next()) {
                Exam exam = new Exam();
                exam.setId(rs.getInt("exam_id"));
                exam.setName(rs.getString("exam_name"));
                exam.setDate(rs.getDate("exam_date"));
                exam.setExamTime(rs.getFloat("exam_Time"));
                exam.setUnitTime(rs.getString("unit_Time"));
                exam.setFormat(rs.getString("exam_format"));
                exam.setStatus(rs.getInt("status"));
                listExam.add(exam);
            }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                ConnectionDB.closeConnection(conn, callSt);
            }
        return listExam;
        }

        public boolean createExam(Exam exam) {
            Connection conn = null;
            CallableStatement callSt = null;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call add_Exam(?,?,?,?,?,?)}");
                callSt.setString(1, exam.getName());
                callSt.setDate(2, new java.sql.Date(exam.getDate().getTime()));
                callSt.setFloat(3, exam.getExamTime());
                callSt.setString(4, exam.getUnitTime());
                callSt.setString(5, exam.getFormat());
                callSt.setInt(6, exam.getStatus());
                callSt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return false;
        }
        public  static Exam findById(int id){
            Connection conn = null;
            CallableStatement callSt = null;
            Exam exam = null;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call find_Exam_By_Id(?)}");
                callSt.setInt(1, id);
                ResultSet rs = callSt.executeQuery();
                if (rs.next()) {
                    exam = new Exam();
                    exam.setId(rs.getInt("exam_id"));
                    exam.setName(rs.getString("exam_name"));
                    exam.setDate(rs.getDate("exam_date"));
                    exam.setExamTime(rs.getFloat("exam_Time"));
                    exam.setUnitTime(rs.getString("unit_Time"));
                    exam.setFormat(rs.getString("exam_format"));
                    exam.setStatus(rs.getInt("status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return exam;
        }
        public boolean updateExam(Exam exam) {
            Connection conn = null;
            CallableStatement callSt = null;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call update_Exam(?,?,?,?,?,?,?)}");
                callSt.setInt(1, exam.getId());
                callSt.setString(2, exam.getName());
                callSt.setDate(3, new java.sql.Date(exam.getDate().getTime()));
                callSt.setFloat(4, exam.getExamTime());
                callSt.setString(5, exam.getUnitTime());
                callSt.setString(6, exam.getFormat());
                callSt.setInt(7, exam.getStatus());
                callSt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return false;
        }
        public boolean deleteExam(int id) {
            Connection conn = null;
            CallableStatement callSt = null;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call delete_Exam(?)}");
                callSt.setInt(1, id);

                callSt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return false;
        }
        public  static List<Exam> searchByName(String name){
            Connection conn = null;
            CallableStatement callSt = null;
            List<Exam> listExam = null;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call find_Exams_By_Name(?)}");
                callSt.setString(1, name);
                ResultSet rs = callSt.executeQuery();
                listExam = new ArrayList<Exam>();
                while (rs.next()) {
                    Exam exam = new Exam();
                    exam.setId(rs.getInt("exam_id"));
                    exam.setName(rs.getString("exam_name"));
                    exam.setDate(rs.getDate("exam_date"));
                    exam.setExamTime(rs.getFloat("exam_Time"));
                    exam.setUnitTime(rs.getString("unit_Time"));
                    exam.setFormat(rs.getString("exam_format"));
                    exam.setStatus(rs.getInt("status"));
                    listExam.add(exam);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return listExam;
        }
    }
