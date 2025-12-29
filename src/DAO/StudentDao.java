package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDao {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // MySQL 5.1.x driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "root");
    }

    public boolean emailExists(String email) throws SQLException {
        String sql = "SELECT * FROM students WHERE email=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getYear());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setYear(rs.getInt("year"));
                list.add(s);
            }
        }
        return list;
    }
}
