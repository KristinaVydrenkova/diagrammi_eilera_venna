package ru.itis.semesterwork2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping
    public String getMainPage(){
        return "main";
    }

    @GetMapping(value = "/videos")
    public String getVideosPage(){
        return "videos";
    }

    @GetMapping(value = "/tasks")
    public String getTasksPage(){
        return "tasks";
    }

    @GetMapping(value = "/book")
    public String getBookPage(){
        return "book";
    }

    @GetMapping(value = "/aboutUs")
    public String getAboutUsPage(){
        return "aboutUs";
    }

}
