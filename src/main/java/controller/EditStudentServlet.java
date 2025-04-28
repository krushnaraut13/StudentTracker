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

@WebServlet("/editstudent")
public class EditStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            
            StudentService service = new StudentService();
            Student student = service.getStudentById(id);
            
            request.setAttribute("student1", student);
            RequestDispatcher rd = request.getRequestDispatcher("editStudent.jsp");
            rd.forward(request, response);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
