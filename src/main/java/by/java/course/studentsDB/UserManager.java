package by.java.course.studentsDB;

import by.java.course.studentsDB.dao.StudentDao;
import by.java.course.studentsDB.model.Student;

import java.io.InputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserManager {

    private InputStream inputStream;

    private PrintStream outputStream;

    private StudentDao studentDao;


    public UserManager(InputStream inputStream, PrintStream outputStream, StudentDao studentDao) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.studentDao = studentDao;
    }

    public void showInstructions() {
        outputStream.println("Welcome to Students DB");
        outputStream.println("1. List all students.");
        outputStream.println("2. Enter new student.");
        outputStream.println("3. Delete all students");
        outputStream.println("4. Quit program.");
    }

    public void runProgram() throws SQLException, InterruptedException {
        Scanner scanner = new Scanner(inputStream);
        while(true) {
            int num = scanner.nextInt();
            switch (num) {
                case 1 -> {
                    List<Student> studentList = studentDao.findAll();
                    studentList.forEach(outputStream::println);
                }
                case 2 -> {
                    Scanner in = new Scanner(this.inputStream);
                    Student student = new Student();
                    System.out.println("Enter your name.");
                    String name = in.nextLine();
                    student.setName(name);
                    System.out.println("Enter your age.");
                    int age = in.nextInt();
                    in.nextLine();
                    student.setAge(age);
                    System.out.println("Enter your university");
                    String university = in.nextLine();
                    student.setUniversity(university);
                    studentDao.create(student);
                    outputStream.println("Student added.");
                }
                case 3 -> {
                    studentDao.removeAll();
                    outputStream.println("StudentsDB is clear!");
                }
                case 4 -> {
                    System.exit(0);
                }
            }
        }
    }
}
