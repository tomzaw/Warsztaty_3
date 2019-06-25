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
@WebServlet(name = "ShowGroupsServlet", urlPatterns = {"/showGroups"})
public class ShowGroupsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GroupDAO groupDAO = new GroupDAO();
        List<Group> groups = groupDAO.findAll();
        request.setAttribute("groups", groups);

        request.getRequestDispatcher("groups.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
