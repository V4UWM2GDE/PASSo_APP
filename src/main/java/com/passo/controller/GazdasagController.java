package com.passo.controller;

import com.passo.model.*;
import com.passo.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GazdasagController {

    private final GazdasagService gazdasagService;

    private final TeruletService teruletService;

    private final KulturaService kulturaService;

    private final NovenyService novenyService;
    private final GazdalkodasService gazdalkodasService;

    private HttpServletResponse httpServletResponse;

    public GazdasagController(GazdasagService gazdasagService, TeruletService teruletService, KulturaService kulturaService, NovenyService novenyService, GazdalkodasService gazdalkodasService) {
        this.gazdasagService = gazdasagService;
        this.teruletService = teruletService;
        this.kulturaService = kulturaService;
        this.novenyService = novenyService;
        this.gazdalkodasService = gazdalkodasService;
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

    @GetMapping("/gazdasag_overview")
    public String index(Model model) {
        model.addAttribute("t_gazd", gazdasagService.getAllGazdasag());
        model.addAttribute("t_terulet", teruletService.getAllTerulet());
        model.addAttribute("t_kultura", kulturaService.getAllKultura());
        return "gazdasag_overview";
    }

    @PostMapping("/gazdalkodas_feladatok")
    public String addGazdasagfeladatok(Model model, GazdalkodasRModel gazdalkodasRModel){
        GazdalkodasRModel registeredGazdalkodas = gazdalkodasService.registerGazdalkodas(gazdalkodasRModel.getGazdasagid(), gazdalkodasRModel.getNovenyvtervid(), gazdalkodasRModel.getFeladatok(), gazdalkodasRModel.getFeladatstatus());
        return registeredGazdalkodas == null ? "error_page_exists" : "gazdalkodas_feladatok_reg_siker";

    }


    @GetMapping("/gazdalkodas_feladatok")
    public String indexfeladatok(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("novvtervList", novenyService.getAllNovenyvterv());
        model.addAttribute("gazdasagList", gazdasagService.getAllGazdasag());
        model.addAttribute("t_gazd_reszl", new GazdalkodasRModel());
        // httpServletResponse.setHeader("X-Frame-Options", "SAMEORIGIN"); // SERULEKENYSEG JAV
        // httpServletResponse.setHeader("Content-Security-Policy", " frame-ancestors 'self'"); // SERULEKENYSEG JAV2
        return "gazdalkodas_feladatok";
    }

    @GetMapping("/gazd_feladatok_reszl/{id}")
    public String reszletezese(@PathVariable Integer id, Model model) {
        model.addAttribute("feladatList", gazdalkodasService.findAllByGazdasagid(id));
        return "feladat_reszletek";
    }

}