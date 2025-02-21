package com.springmvc.pmvc.controllers;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.springmvc.pmvc.beans.faculty;
import com.springmvc.pmvc.beans.course;
import com.springmvc.pmvc.dao.FacultyDao;

@Controller
public class FacultyController {
    @Autowired
    private FacultyDao facultyDao;

    @RequestMapping("/faculty-login")    
    public String showLoginForm(Model m) {
        m.addAttribute("command", new faculty());  
        return "faculty-login";
    }
    
    @RequestMapping(value = "/validate-login", method = RequestMethod.POST)    
    public String validateLogin(@ModelAttribute("faculty") faculty faculty, Model m) {
        faculty loggedInFaculty = facultyDao.validateLogin(faculty.getEmail(), faculty.getPassword());
        
        if (loggedInFaculty != null) {
            List<course> courses = facultyDao.getAssignedCourses(loggedInFaculty.getId());
            m.addAttribute("list", courses);
            return "faculty";
        }
        
        return "redirect:/login";
    }
}
