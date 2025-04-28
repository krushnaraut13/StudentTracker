package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO {
    private Connection getConnection() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb1?useSSL=false", "root", "2024");
    }

    public void saveStudent(String name, String email) throws Exception {
        Connection con = getConnection();
        String sql = "INSERT INTO student(name, email) VALUES(?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            list.add(s);
        }
        return list;
    }

    public Student getStudentById(int id) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            return s;
        }
        return null;
    }

    public void updateStudent(Student s) throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE student SET name=?, email=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setInt(3, s.getId());
        ps.executeUpdate();
    }

    public void deleteStudent(int id) throws Exception {
        boolean rowDeleted = false;
        Connection con = getConnection();
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rowDeleted = ps.executeUpdate() > 0;
        ps.executeUpdate();
    }
}
