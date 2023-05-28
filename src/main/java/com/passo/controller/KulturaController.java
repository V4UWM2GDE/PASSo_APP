package com.passo.controller;

import com.passo.model.*;
import com.passo.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KulturaController {

    private final KulturaService kulturaService;
    private HttpServletResponse httpServletResponse;

    public KulturaController(KulturaService kulturaService) {
        this.kulturaService = kulturaService;
    }

    @GetMapping("/kultura_regisztracio")
    public String createKultura(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("t_kultura", new KulturaModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "kultura_regisztracio";
    }


    @PostMapping("/kultura_regisztracio")
    public String addKultura(Model model, KulturaModel kulturaModel){
        KulturaModel registeredKultura = kulturaService.registerKultura(kulturaModel.getKulturaneve(), kulturaModel.getTeruletid(), kulturaModel.getNovenyvtervreszlid());
        return registeredKultura == null ? "error_page_exists" : "kultura_reg_siker";

    }




}