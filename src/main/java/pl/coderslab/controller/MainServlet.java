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
@WebServlet(name = "MainServlet", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int solutionsNumber = Integer.parseInt(request.getServletContext().getInitParameter(("number-solutions")));

        SolutionDAO solutionDAO = new SolutionDAO();
        List<Solution> solutions = solutionDAO.findAll(solutionsNumber);
        request.setAttribute("solutions", solutions);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
