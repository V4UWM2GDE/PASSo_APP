package com.passo.controller;

import com.passo.model.GazdasagModel;
import com.passo.service.GazdasagService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GazdasagController {

    private final GazdasagService gazdasagService;
    private HttpServletResponse httpServletResponse;

    public GazdasagController(GazdasagService gazdasagService) {
        this.gazdasagService = gazdasagService;
    }

    @GetMapping("/gazdasag_regisztracio")
    public String createGazdasag(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("t_gazd", new GazdasagModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "gazdasag_regisztracio";
    }

    @PostMapping("/gazdasag_regisztracio")
    public String addGazdasag(Model model, GazdasagModel gazdasagModel){
        GazdasagModel registeredGazdasag = gazdasagService.registerGazdasag(gazdasagModel.getGazdasagneve(), gazdasagModel.getGazdasagcime(), gazdasagModel.getGazdasaghrsz(), gazdasagModel.getNovenyvtervid());
        return registeredGazdasag == null ? "error_page_exists" : "gazdasag_reg_siker";

    }




}