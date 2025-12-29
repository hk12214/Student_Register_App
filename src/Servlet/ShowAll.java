package Servlet;

import DAO.StudentDao;
import model.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {

    private StudentDao studentDao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<Student> students = studentDao.getAllStudents();
            req.setAttribute("students", students);
            req.getRequestDispatcher("ShowAll.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
