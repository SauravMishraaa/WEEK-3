package com.springmvc.pmvc.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springmvc.pmvc.beans.faculty;
import com.springmvc.pmvc.beans.course;

public class FacultyDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a faculty record
    public int save(faculty f) {
        String qry = "INSERT INTO faculty (id, name, email, pass, mob) VALUES (" +
                     f.getId() + ", '" + f.getName() + "', '" + f.getEmail() + "', '" +
                     f.getPassword() + "', '" + f.getMobile() + "')";
        return jdbcTemplate.update(qry);
    }

    // Validate faculty login
    public faculty validateLogin(String email, String pass) {
        String query = "SELECT * FROM faculty WHERE email = ? AND pass = ?";
        List<faculty> faculties = jdbcTemplate.query(query, new Object[]{email, pass}, (rs, rowNum) ->
            new faculty(rs.getInt("id"), rs.getString("name"), rs.getString("email"), 
                        rs.getString("pass"), rs.getString("mob"))
        );
        return faculties.isEmpty() ? null : faculties.get(0);
    }

    // Get assigned courses for a faculty
    public List<course> getAssignedCourses(int facultyId) {
        String query = "SELECT c.* FROM course c INNER JOIN faculty_course fc ON c.id = fc.course_id WHERE fc.faculty_id = ?";
        return jdbcTemplate.query(query, new Object[]{facultyId}, (rs, rowNum) -> 
            new course(rs.getInt("id"), rs.getString("name"), rs.getInt("duration"))
        );
    }
}
