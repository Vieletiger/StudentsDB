package by.java.course.studentsDB.dao;

import by.java.course.studentsDB.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection connection;
    private Statement statement;
    private String sql;

    public StudentDao() throws SQLException, ClassNotFoundException {
        // Registering JDBC_DRIVER
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        Class.forName(JDBC_DRIVER);
        // Connecting to DB
        String DATABASE_URL = "jdbc:mysql://localhost/STUDENTS";
        String USER = "root";
        String PASSWORD = "pass";
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        statement = connection.createStatement();
        sql = "SELECT * from STUDENTS";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Student student = new Student();
            student.setName(resultSet.getString("NAME"));
            student.setAge(resultSet.getInt("AGE"));
            student.setUniversity(resultSet.getString("UNI"));
            // put student into list
            students.add(student);
        }
        resultSet.close();
        statement.close();
        return students;
    }

    public Student create(Student student) throws SQLException {
        // insert student
        statement = connection.createStatement();// enter name, enter age, enter university
        sql = "INSERT INTO STUDENTS (NAME, AGE, UNI) VALUES ('" + student.getName() + "'," + student.getAge() + ",'" + student.getUniversity() + "')";
        statement.executeUpdate(sql);
        statement.close();
        return student;
    }

    public void removeAll() throws SQLException {
        // remove all students
        statement = connection.createStatement();
        sql = "DELETE FROM STUDENTS";
        statement.executeUpdate(sql);
        statement.close();
    }
}
