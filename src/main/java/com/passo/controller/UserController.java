package com.passo.controller;

import com.passo.model.UserModel;
import com.passo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    private HttpServletResponse httpServletResponse;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("loginRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "login_page";
    }

    @GetMapping("/login_reset")
    public String getLoginResetPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("tudastarRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "login_reset";
    }

    @PostMapping("/login_reset")
    public String login_reset(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "login_reset";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/alk_help")
    public String getAHPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("tudastarRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "alk_help";
    }

    @PostMapping("/alk_help")
    public String alk_help(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "alk_help";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/tudastar")
    public String getkhPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("tudastarRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "kh_page";
    }

    @PostMapping("/tudastar")
    public String tudastar(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "kh_page";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/tudastar_nvsz")
    public String getkh_nvszPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("tudastarRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "tudastar_nvsz";
    }

    @PostMapping("/tudastar_nvsz")
    public String tudastar_nvsz(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "tudastar_nvsz";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/gazdasag_overview")
    public String getGazdPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("gazdasagRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "gazdasag_overview";
    }

    @PostMapping("/gazdasag_overview")
    public String gazdasag_overview(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "gazdasag_overview";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/nyitooldal")
    public String getLandingPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("landingRequest", new UserModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "personal_page";
    }

    @PostMapping("/nyitooldal")
    public String nyitooldal(@ModelAttribute UserModel userModel, Model model){
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        } else {
            return "error_page";
        }
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("Regisztrációs kérelem: " + userModel);
        UserModel registeredUser = userService.registerUser(userModel.getLogin(), userModel.getPassword(), userModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model, HttpServletResponse httpServletResponse){
        System.out.println("Belépési kérelem: " + userModel);
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
            httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
            return "personal_page";
        } else {
            httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
            httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
            return "error_page";
        }

    }
}
