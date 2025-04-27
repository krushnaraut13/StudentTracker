package controller;

import dao.StudentDAO;
import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        StudentService service = new StudentService();
        try {
            service.addStudent(name, email);
            // ✅ Correct redirection
            response.sendRedirect("viewstudents"); 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add student. Please try again.");
        }
    }
}
