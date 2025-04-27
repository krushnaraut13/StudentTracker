package controller;

import service.StudentService;
import model.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setEmail(email);

            StudentService service = new StudentService();
            service.updateStudent(s);

            response.sendRedirect("viewstudents");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
