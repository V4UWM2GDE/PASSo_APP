package com.passo.service;

import com.passo.model.KulturaModel;
import com.passo.model.TeruletModel;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KulturaService {

    private final KulturaRepository kulturaRepository;

    public KulturaService(KulturaRepository kulturaRepository) {
        this.kulturaRepository = kulturaRepository;
    }

    public KulturaModel registerKultura(String kulturaneve, Integer teruletid, Integer novenyvtervreszlid){
        if (kulturaneve == null || teruletid == null || novenyvtervreszlid == null) {
            return null;
        } else {
            if(kulturaRepository.findKulturaModelByKulturaneve(kulturaneve).isPresent()){
                System.out.println("Már létező kultúra!");
                return null;
            }
            KulturaModel kulturaModel = new KulturaModel();
            kulturaModel.setKulturaneve(kulturaneve);
            kulturaModel.setTeruletid(teruletid);
            kulturaModel.setNovenyvtervreszlid(novenyvtervreszlid);
            return kulturaRepository.save(kulturaModel);
        }
    }
    public List<KulturaModel> getAllKultura() {
        return kulturaRepository.findAll();
    }
}