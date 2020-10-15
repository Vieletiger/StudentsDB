package by.java.course.studentsDB;

import by.java.course.studentsDB.dao.StudentDao;
import java.sql.*;

public class StudentsDbApplication {

    private static StudentDao studentDao;

    static {
        try {
            studentDao = new StudentDao();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        UserManager userManager = new UserManager(System.in, System.out, new StudentDao());
        userManager.showInstructions();
        userManager.runProgram();
    }
}
