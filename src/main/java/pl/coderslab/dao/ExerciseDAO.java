package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.Exercise;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class ExerciseDAO {

    public void create(Exercise exercise) {

        try (Connection con = DbUtil.getCon()) {

            if (exercise.getId() == 0) {

                String sql = "INSERT INTO exercise(title, description) VALUES(?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, exercise.getTitle());
                stmt.setString(2, exercise.getDescription());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    exercise.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Exercise exercise) {

        try (Connection con = DbUtil.getCon()) {

            if (exercise.getId() == 0) {

                String sql = "INSERT INTO exercise(title, description) VALUES(?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, exercise.getTitle());
                stmt.setString(2, exercise.getDescription());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    exercise.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE exercise SET title=?, description=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, exercise.getTitle());
                stmt.setString(2, exercise.getDescription());
                stmt.setInt(3, exercise.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Exercise exercise) {

        try (Connection con = DbUtil.getCon()) {

            if (exercise.getId() != 0) {

                String sql = "DELETE FROM exercise WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, exercise.getId());
                stmt.executeUpdate();
                exercise.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Exercise> findAll() {

        List<Exercise> exercises = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM exercise";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Exercise exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setTitle(rs.getString("title"));
                exercise.setDescription(rs.getString("description"));
                exercises.add(exercise);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return exercises;
    }

    public Exercise findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM exercise WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Exercise exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setTitle(rs.getString("title"));
                exercise.setDescription(rs.getString("description"));
                return exercise;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
    
    //Not finished.
    public List<Exercise> findAllUnsolvedByUserId(long usersId) {

        List<Exercise> exercises = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT exercise.id, exercise.title, exercise.description FROM exercise left join solution on exercise.id=exercise_id WHERE users_id!=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, usersId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Exercise exercise = new Exercise();
                exercise.setId(rs.getInt("id"));
                exercise.setTitle(rs.getString("title"));
                exercise.setDescription(rs.getString("description"));
                exercises.add(exercise);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return exercises;
    }
}
