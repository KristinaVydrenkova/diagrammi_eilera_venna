package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.semesterwork2.dto.request.CheburashkaTestForm;
import ru.itis.semesterwork2.dto.request.EntryTestForm;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.TestCheckService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tests")
public class TestController {
    private final TestCheckService testCheckService;

    @GetMapping
    public String getTestsPage(){
        return "tests";
    }
    @GetMapping("/entryTest")
    public String getEntryTestPage(){
        return "entryTest";
    }

    @PostMapping("/entryTest")
    public void checkEntryTest(EntryTestForm form, Authentication authentication, HttpServletResponse response) throws IOException {
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        String message = testCheckService.checkEntryTest(form,user);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
    }
    @GetMapping("/cheburashka")
    public String getCheburashkaTestPage(){
        return "cheburashkaTest";
    }

    @PostMapping("/cheburashka")
    public void checkCheburashkaTest(CheburashkaTestForm form, Authentication authentication, HttpServletResponse response) throws IOException {
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        String message = testCheckService.checkCheburashkaTest(form,user);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(message);
    }

}
