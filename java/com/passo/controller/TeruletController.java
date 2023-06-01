package com.passo.controller;

import com.passo.model.TeruletModel;
import com.passo.service.GazdasagService;
import com.passo.service.TeruletService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeruletController {

    private final TeruletService teruletService;
    private final GazdasagService gazdasagService;
    private HttpServletResponse httpServletResponse;

    public TeruletController(TeruletService teruletService, GazdasagService gazdasagService) {
        this.teruletService = teruletService;
        this.gazdasagService = gazdasagService;
    }

    @GetMapping("/terulet_regisztracio")
    public String createTerulet(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("allgazdasag", gazdasagService.getAllGazdasag());
        model.addAttribute("t_terulet", new TeruletModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "terulet_regisztracio";
    }


    @PostMapping("/terulet_regisztracio")
    public String addTerulet(Model model, TeruletModel teruletModel){
        TeruletModel registeredTerulet = teruletService.registerTerulet(teruletModel.getTeruletneve(), teruletModel.getTeruletgis(), teruletModel.getGazdasagid());
        return registeredTerulet == null ? "error_page_exists" : "terulet_reg_siker";

    }




}
