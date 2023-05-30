package com.passo.controller;

import com.passo.model.*;
import com.passo.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NovenyController {

    private final NovenyService novenyService;
    private final NovenyReszletekService novenyReszletekService;
    private HttpServletResponse httpServletResponse;

    public NovenyController(NovenyService novenyService, NovenyReszletekService novenyReszletekService) {
        this.novenyService = novenyService;
        this.novenyReszletekService = novenyReszletekService;
    }

    @GetMapping("/novvterv_regisztracio")
    public String createNovvterv(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("t_novv_terv", new NovenyvTervModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "novvterv_regisztracio";
    }

    @PostMapping("/novvterv_regisztracio")
    public String addNovvterv(Model model, NovenyvTervModel novenyvtervModel){
        NovenyvTervModel registeredNovenyvterv = novenyService.registerNovenyvterv(novenyvtervModel.getBejegyzescime(), novenyvtervModel.getBejegyzestipusa());
        return registeredNovenyvterv == null ? "error_page_exists" : "novvterv_reg_siker";

    }




    @GetMapping("/novvterv_reszl_regisztracio")
    public String createNovvtervReszl(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("novvtervList", novenyService.getAllNovenyvterv());
        model.addAttribute("t_novv_reszl", new NovenyvReszletekModel());
        httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "novvterv_reszl_regisztracio";
    }


    @PostMapping("/novvterv_reszl_regisztracio")
    public String addNovvtervReszl(Model model, NovenyvReszletekModel novenyvReszletekModel){
        NovenyvReszletekModel registeredNovenyvtervreszlet = novenyReszletekService.registerNovenyvtervreszl(novenyvReszletekModel.getNovenyvtervid(), novenyvReszletekModel.getReszlbejegyzestipusa(), novenyvReszletekModel.getReszlbejegyzescime(), novenyvReszletekModel.getReszlbejegyzesreszl());
        return registeredNovenyvtervreszlet == null ? "error_page_exists" : "novvterv_reszl_reg_siker";

    }


}
