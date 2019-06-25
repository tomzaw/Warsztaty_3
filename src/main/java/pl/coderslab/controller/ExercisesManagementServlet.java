package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.model.Exercise;

/**
 *
 * @author Tomek
 */
@WebServlet(name = "ExercisesManagementServlet", urlPatterns = {"/exercisesManagement"})
public class ExercisesManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ExerciseDAO exerciseDAO = new ExerciseDAO();
        List<Exercise> exercises = exerciseDAO.findAll();
        request.setAttribute("exercises", exercises);

        request.getRequestDispatcher("exercisesManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {

            String action = request.getParameter("action");

            if (action.equals("add")) {

                if (request.getParameter("title") != null && !request.getParameter("title").isEmpty()
                        && request.getParameter("description") != null && !request.getParameter("description").isEmpty()) {

                    String title = request.getParameter("title");
                    String description = request.getParameter("description");

                    ExerciseDAO exerciseDAO = new ExerciseDAO();
                    exerciseDAO.create(new Exercise(title, description));
                }

            } else if (action.equals("edit")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()
                        && request.getParameter("title") != null && !request.getParameter("title").isEmpty()
                        && request.getParameter("description") != null && !request.getParameter("description").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");

                    ExerciseDAO exerciseDAO = new ExerciseDAO();
                    Exercise exercise = new Exercise(title, description);
                    exercise.setId(id);
                    exerciseDAO.update(exercise);
                }

            } else if (action.equals("delete")) {

                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

                    Integer id = Integer.parseInt(request.getParameter("id"));

                    ExerciseDAO exerciseDAO = new ExerciseDAO();
                    Exercise exercise = new Exercise();
                    exercise.setId(id);
                    exerciseDAO.delete(exercise);
                }
            }
        }

        doGet(request, response);
    }
}
