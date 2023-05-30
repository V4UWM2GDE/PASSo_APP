package com.passo.controller;

import com.passo.model.*;
import com.passo.service.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TudastarController {

    private final TudastarService tudastarService;
    private HttpServletResponse httpServletResponse;

    public TudastarController(TudastarService tudastarService) {
        this.tudastarService = tudastarService;
    }

    @GetMapping("/tudastar_regisztracio")
    public String createTudastar(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("t_tudastar", new TudastarModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "tudastar_regisztracio";
    }


    @PostMapping("/tudastar_regisztracio")
    public String addTudastar(Model model, TudastarModel tudastarModel){
        TudastarModel registeredTudastar = tudastarService.registerTudastar(tudastarModel.getTudastartipus(), tudastarModel.getTudastarcime(), tudastarModel.getTudastarreszl());
        return registeredTudastar == null ? "error_tudastar_exists" : "tudastar_reg_siker";

    }

    @GetMapping("/tudastar_bongeszo")
    public String index(Model model) {
        model.addAttribute("t_tudastar", tudastarService.getAllTudastar());
        return "tudastar_bongeszo";
    }

    @GetMapping("/reszletezes/{id}")
    public String reszletezes(@PathVariable Integer id, Model model) {
        tudastarService.findById(id).ifPresent(t_tudastar -> model.addAttribute("t_tudastar", t_tudastar));
        return "tudastar_cikk";
    }

    @GetMapping("/torles/{id}")
    public String index(@PathVariable Integer id) {
        tudastarService.deleteById(id);
        return "sikeres_adatkezeles";
    }

    @GetMapping("/szerkesztes/{id}")
    public String index(@PathVariable Integer id, Model model) {
        model.addAttribute("t_tudastar", tudastarService.findById(id));
        return "tudastar_frissites";
    }

}