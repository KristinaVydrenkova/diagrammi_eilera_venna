package ru.itis.semesterwork2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.semesterwork2.dto.request.ChangePasswordForm;
import ru.itis.semesterwork2.dto.request.EditProfileFormRequest;
import ru.itis.semesterwork2.exceptions.BadPasswordException;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.security.details.AccountUserDetails;
import ru.itis.semesterwork2.services.ProfileService;
import ru.itis.semesterwork2.services.SignUpService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    @GetMapping
    public ModelAndView getProfilePage(Authentication authentication){
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",profileService.getProfilePage(user));
        mv.setViewName("profile");
        return mv;
    }
    @GetMapping("/edit")
    public ModelAndView getEditProfilePage(Authentication authentication, ModelMap modelMap){
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",profileService.getEditProfileForm(user));
        mv.setViewName("editProfile");
        modelMap.put("editProfileForm", new EditProfileFormRequest());
        return mv;
    }
    @PostMapping("/edit")
    public ModelAndView editProfile(@Valid @ModelAttribute("editProfileForm") EditProfileFormRequest form, BindingResult result, Authentication authentication){
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()){
            mv.setViewName("editProfile");
            return mv;
        }
        AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        mv.addObject("user",profileService.editProfile(form,user));
        mv.setViewName("redirect:/profile");
        return mv;
    }

    @GetMapping("/changePassword")
    public String getChangePasswordPage(ModelMap map){
        map.put("changePasswordForm", new ChangePasswordForm());
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public void changePassword(@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm form, BindingResult result, Authentication authentication,
                                       HttpServletResponse response) throws IOException {
        String message = null;
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if(result.hasErrors()){
            message = "Неверно введены данные";
            response.getWriter().write(message);
        }else {
            AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
            User user = userDetails.getUser();
            ModelAndView mv = new ModelAndView();
            try {
                message = profileService.changePassword(form, user);
            } catch (BadPasswordException e) {
                message = e.getMessage();
            }
            response.getWriter().write(message);
        }
    }
}
