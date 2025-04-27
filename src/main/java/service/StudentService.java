package service;

import dao.StudentDAO;
import model.Student;
import java.util.List;

public class StudentService {
    StudentDAO dao = new StudentDAO();

    public void addStudent(String name, String email) throws Exception {
        if(name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
            dao.saveStudent(name, email);
        }
    }

    public List<Student> getAllStudents() throws Exception {
        return dao.getAllStudents();
    }

    public Student getStudentById(int id) throws Exception {
        return dao.getStudentById(id);
    }

    public void updateStudent(Student s) throws Exception {
        dao.updateStudent(s);
    }

    public void deleteStudent(int id) throws Exception {
        dao.deleteStudent(id);
    }
}
