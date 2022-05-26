package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.itis.semesterwork2.dto.request.AddStudentsForm;
import ru.itis.semesterwork2.dto.request.DeleteStudentsForm;
import ru.itis.semesterwork2.dto.request.AddTaskRequest;
import ru.itis.semesterwork2.dto.request.DeleteTaskRequest;
import ru.itis.semesterwork2.dto.response.StudentResponse;
import ru.itis.semesterwork2.exceptions.AccessException;
import ru.itis.semesterwork2.exceptions.NoSuchEmailException;
import ru.itis.semesterwork2.exceptions.StudentException;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.StudentsService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/teaching")
public class TeacherController {
    private final StudentsService studentsService;

    @GetMapping("/myStudents")
    public ModelAndView getStudentsPage(Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myStudents");
        mv.addObject("students", studentsService.getStudents(((AccountUserDetails) authentication.getPrincipal()).getUser()));
        return mv;
    }

    @GetMapping("/myStudents/edit")
    public ModelAndView getStudentsEditPage(Authentication authentication, ModelMap map) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editStudents");
        try {
            mv.addObject("students", studentsService.getStudents(((AccountUserDetails) authentication.getPrincipal()).getUser()));
            map.put("addStudentsForm", new AddStudentsForm());
            map.put("deleteStudentsForm", new DeleteStudentsForm());
        } catch (AccessException e) {
            mv.setViewName("myStudents");
            mv.addObject("message", e.getMessage());
        }
        return mv;
    }

    @PostMapping("/myStudents/delete")
    public ModelAndView deleteStudents(Authentication authentication,
                                       @Valid @ModelAttribute("deleteStudentsForm") DeleteStudentsForm form,
                                       BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("editStudents");
            mv.addObject("students", studentsService.getStudents(((AccountUserDetails) authentication.getPrincipal()).getUser()));
            return mv;
        }
        try {
            mv.addObject("students", studentsService.deleteStudents(
                    ((AccountUserDetails) authentication.getPrincipal()).getUser(), form));
            mv.setViewName("redirect:/teaching/myStudents");
        } catch (NoSuchEmailException e) {
            mv.setViewName("editStudents");
            mv.addObject("messageForDelete", e.getMessage());
        }
        return mv;
    }

    @PostMapping("/myStudents/add")
    public ModelAndView addStudents(Authentication authentication,
                                    @Valid @ModelAttribute("addStudentsForm") AddStudentsForm form,
                                    BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("editStudents");
            mv.addObject("students", studentsService.getStudents(((AccountUserDetails) authentication.getPrincipal()).getUser()));
            return mv;
        }
        try {
            mv.addObject("students", studentsService.addStudents(
                    ((AccountUserDetails) authentication.getPrincipal()).getUser(), form));
            mv.setViewName("redirect:/teaching/myStudents");
        } catch (NoSuchEmailException | StudentException e) {
            mv.setViewName("editStudents");
            mv.addObject("messageForAdd", e.getMessage());
        }
        return mv;
    }

    @GetMapping("/tasks")
    public ModelAndView getTasksPage(Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teacherTasks");
        mv.addObject("tasks", studentsService.getTeacherTasks(((AccountUserDetails) authentication.getPrincipal()).getUser()));
        return mv;
    }

    @GetMapping("/tasks/edit")
    public ModelAndView getEditTasksPage(Authentication authentication, ModelMap modelMap) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editTasks");
        mv.addObject("tasks", studentsService.getTeacherTasks(((AccountUserDetails) authentication.getPrincipal()).getUser()));
        modelMap.put("addTaskForm", new AddTaskRequest());
        modelMap.put("deleteTaskForm", new DeleteTaskRequest());
        return mv;
    }

    @PostMapping("/tasks/add")
    public ModelAndView addTask(Authentication authentication,
                                @Valid @ModelAttribute("addTaskForm") AddTaskRequest addTaskRequest,
                                BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if(result.hasErrors()){
            mv.setViewName("editTasks");
            mv.addObject("tasks", studentsService.getTeacherTasks(((AccountUserDetails) authentication.getPrincipal()).getUser()));
            return mv;
        }
        mv.setViewName("redirect:/teaching/tasks");
        mv.addObject("tasks", studentsService.addTask(
                ((AccountUserDetails) authentication.getPrincipal()).getUser(), addTaskRequest));
        return mv;
    }

    @PostMapping("/tasks/delete")
    public ModelAndView deleteTask(Authentication authentication,
                                   @Valid @ModelAttribute("deleteTaskForm") DeleteTaskRequest deleteTaskRequest,
                                   BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if(result.hasErrors()){
            mv.setViewName("editTasks");
            mv.addObject("tasks", studentsService.getTeacherTasks(((AccountUserDetails) authentication.getPrincipal()).getUser()));
            return mv;
        }
        mv.setViewName("redirect:/teaching/tasks");
        mv.addObject("tasks", studentsService.deleteTask(
                ((AccountUserDetails) authentication.getPrincipal()).getUser(), deleteTaskRequest));
        return mv;
    }

}
