package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.model.Solution;


/**
 *
 * @author Tomek
 */
@WebServlet(name = "UserSolutionsServlet", urlPatterns = {"/userSolutions"})
public class UserSolutionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id;
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

            id = Integer.parseInt(request.getParameter("id"));
            SolutionDAO solutionDAO = new SolutionDAO();
            List<Solution> userSolutions = solutionDAO.findAllByUsersId(id);
            request.setAttribute("userSolutions", userSolutions);
        }

        request.getRequestDispatcher("userSolutions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
