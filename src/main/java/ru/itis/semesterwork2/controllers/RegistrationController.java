package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semesterwork2.dto.request.SignInForm;
import ru.itis.semesterwork2.dto.request.SignUpForm;
import ru.itis.semesterwork2.exceptions.BadPasswordException;
import ru.itis.semesterwork2.exceptions.InvalidEmailException;
import ru.itis.semesterwork2.exceptions.NoSuchEmailException;
import ru.itis.semesterwork2.exceptions.OccupiedEmailException;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.SignUpService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final SignUpService signUpService;

    @GetMapping("/signIn")
    public String getSignInPage(Authentication authentication, ModelMap modelMap) {
        if (authentication != null) {
            return "redirect:/";
        }
        modelMap.put("signInForm", new SignUpForm());
        return "signin";
    }

    @PostMapping("/signIn")
    public ModelAndView signIn(@Valid @ModelAttribute("signInForm")SignInForm form, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if(result.hasErrors()){
            mv.setViewName("signin");
            return mv;
        }
        try {
            mv.addObject("user", signUpService.signIn(form));
            mv.setViewName("redirect:/profile");
        }catch (NoSuchEmailException e){
            mv.setViewName("signin");
            mv.addObject("message",e.getMessage());
        }
        return mv;
    }

    @GetMapping("/signUp")
    public String getSignUpPage(Authentication authentication, ModelMap modelMap) {
        if (authentication != null) {
            return "redirect:/";
        }
        modelMap.put("signUpForm", new SignUpForm());
        return "signup";
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(@Valid @ModelAttribute("signUpForm") SignUpForm form, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if(result.hasErrors()){
            mv.setViewName("signup");
            return mv;
        }
        String message = null;
        try {
            mv.addObject("user", signUpService.signUp(form));
            mv.setViewName("redirect:/profile");
            return mv;
        } catch (OccupiedEmailException|BadPasswordException|InvalidEmailException e) {
            message = e.getMessage();
        }
        mv.addObject("message", message);
        mv.setViewName("signup");
        return mv;
    }

    @GetMapping("/signout")
    public String signOut(Authentication authentication) {
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        signUpService.signOut(user);
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "redirect:/";
    }


}
