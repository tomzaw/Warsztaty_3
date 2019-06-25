package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "UsersManagementServlet", urlPatterns = {"/usersManagement"})
public class UsersManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findAll();
        request.setAttribute("users", users);

        request.getRequestDispatcher("usersManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {

            String action = request.getParameter("action");

            if (action.equals("add")) {

                if (request.getParameter("username") != null && !request.getParameter("username").isEmpty()
                        && request.getParameter("email") != null && !request.getParameter("email").isEmpty()
                        && request.getParameter("password") != null && !request.getParameter("password").isEmpty()
                        && request.getParameter("groupId") != null && !request.getParameter("groupId").isEmpty()) {

                    String username = request.getParameter("username");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    int groupId = Integer.parseInt(request.getParameter("groupId"));

                    UserDAO userDAO = new UserDAO();
                    userDAO.create(new User(username, email, password, groupId));
                }

            } else if (action.equals("edit")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()
                        && request.getParameter("username") != null && !request.getParameter("username").isEmpty()
                        && request.getParameter("email") != null && !request.getParameter("email").isEmpty()
                        && request.getParameter("password") != null && !request.getParameter("password").isEmpty()
                        && request.getParameter("groupId") != null && !request.getParameter("groupId").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));
                    String username = request.getParameter("username");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    int groupId = Integer.parseInt(request.getParameter("groupId"));

                    UserDAO userDAO = new UserDAO();
                    User user = new User(username, email, password, groupId);
                    user.setId(id);
                    userDAO.update(user);
                }

            } else if (action.equals("delete")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));

                    UserDAO userDAO = new UserDAO();
                    User user = new User();
                    user.setId(id);
                    userDAO.delete(user);
                }
            }
        }

        doGet(request, response);
    }
}
