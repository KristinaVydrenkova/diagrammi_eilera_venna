package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.StudentsService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/studying")
public class StudentController {
    private final StudentsService studentsService;
    @GetMapping("/tasks")
    public ModelAndView getTasksPage(Authentication authentication){
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentTasks");
        mv.addObject("tasks", studentsService.getStudentTasks(user));
        return mv;
    }

    @GetMapping("/points")
    public ModelAndView getPointsPage(Authentication authentication){
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myPoints");
        mv.addObject("points", studentsService.getStudentPoints(user));
        return mv;
    }
}
