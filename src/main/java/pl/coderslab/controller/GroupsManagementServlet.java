package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.GroupDAO;
import pl.coderslab.model.Group;

/**
 *
 * @author Tomek
 */
@WebServlet(name = "GroupsManagementServlet", urlPatterns = {"/groupsManagement"})
public class GroupsManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GroupDAO groupDAO = new GroupDAO();
        List<Group> groups = groupDAO.findAll();
        request.setAttribute("groups", groups);

        request.getRequestDispatcher("groupsManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {

            String action = request.getParameter("action");

            if (action.equals("add")) {

                if (request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {

                    String name = request.getParameter("name");

                    GroupDAO groupDAO = new GroupDAO();
                    groupDAO.create(new Group(name));

                }

            } else if (action.equals("edit")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()
                        && request.getParameter("name") != null && !request.getParameter("name").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");

                    GroupDAO groupDAO = new GroupDAO();
                    Group group = new Group(name);
                    group.setId(id);
                    groupDAO.update(group);
                }

            } else if (action.equals("delete")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));

                    GroupDAO groupDAO = new GroupDAO();
                    Group group = new Group();
                    group.setId(id);
                    groupDAO.delete(group);
                }
            }
        }

        doGet(request, response);
    }
}
