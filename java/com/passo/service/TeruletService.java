package com.passo.service;

import com.passo.model.TeruletModel;
import com.passo.model.TudastarModel;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeruletService {

    private final TeruletRepository teruletRepository;

    public TeruletService(TeruletRepository teruletRepository) {
        this.teruletRepository = teruletRepository;
    }

    public TeruletModel registerTerulet(String teruletneve, String teruletgis, Integer gazdasagid){
        if (teruletneve == null || teruletgis == null || gazdasagid == null) {
            return null;
        } else {
            if(teruletRepository.findTeruletModelByTeruletneve(teruletneve).isPresent()){
                System.out.println("Már létező terület!");
                return null;
            }
            TeruletModel teruletModel = new TeruletModel();
            teruletModel.setTeruletneve(teruletneve);
            teruletModel.setTeruletgis(teruletgis);
            teruletModel.setGazdasagid(gazdasagid);
            return teruletRepository.save(teruletModel);
        }
    }

    public List<TeruletModel> getAllTerulet() {
        return teruletRepository.findAll();
    }
}