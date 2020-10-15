package by.java.course.studentsDB;

import by.java.course.studentsDB.dao.StudentDao;
import by.java.course.studentsDB.model.Student;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.List;

public class TestStudentsDB extends TestCase {

        public void testStudent() throws SQLException, ClassNotFoundException {
            Student testStudent = new Student("Vasyaaa", 13, "BGU");
            StudentDao testStudentDao = new StudentDao();
            testStudentDao.create(testStudent);
            List<Student> testListOfStudents= testStudentDao.findAll();
            assertEquals(testListOfStudents.get(testListOfStudents.size() - 1).getName(), testStudent.getName());
            assertEquals(testListOfStudents.get(testListOfStudents.size() - 1).getAge(), testStudent.getAge());
            assertEquals(testListOfStudents.get(testListOfStudents.size() - 1).getUniversity(), testStudent.getUniversity());

            assertNotNull(testListOfStudents);

            testStudentDao.removeAll();
            testStudentDao.findAll();
            assertEquals(testListOfStudents.size(), 1);

        }
}
