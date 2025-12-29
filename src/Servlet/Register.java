package Servlet;

import DAO.StudentDao;
import model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Register")
public class Register extends HttpServlet {

    private StudentDao studentDao = new StudentDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String yearStr = req.getParameter("year");

        if (name == null || email == null || yearStr == null ||
            name.isEmpty() || email.isEmpty() || yearStr.isEmpty()) {
            resp.getWriter().println("Invalid input");
            return;
        }

        int year;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            resp.getWriter().println("Year must be a number");
            return;
        }

        try {
            if (studentDao.emailExists(email)) {
                resp.getWriter().println("Email already registered");
                return;
            }
            Student student = new Student(name, email, year);
            studentDao.insertStudent(student);
            resp.sendRedirect("ShowAll"); // after successful registration
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
