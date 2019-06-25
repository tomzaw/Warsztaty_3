package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.model.User;

/**
 *
 * @author Tomek
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id;
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

            id = Integer.parseInt(request.getParameter("id"));
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findById(id);
            request.setAttribute("user", user);
        }

        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
