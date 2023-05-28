package com.passo.service;

import com.passo.model.GazdasagModel;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class GazdasagService {

    private final GazdasagRepository gazdasagRepository;

    public GazdasagService(GazdasagRepository gazdasagRepository) {
        this.gazdasagRepository = gazdasagRepository;
    }

    public GazdasagModel registerGazdasag(String gazdasagneve, String gazdasagcime, String gazdasaghrsz, Integer novenyvtervid){
        if (gazdasagneve == null || gazdasagcime == null || gazdasaghrsz == null || novenyvtervid == null) {
            return null;
        } else {
            if(gazdasagRepository.findGazdasagModelByGazdasagneve(gazdasagneve).isPresent()){
                System.out.println("Már létező gazdaság!");
                return null;
            }
            GazdasagModel gazdasagModel = new GazdasagModel();
            gazdasagModel.setGazdasagneve(gazdasagneve);
            gazdasagModel.setGazdasagcime(gazdasagcime);
            gazdasagModel.setGazdasaghrsz(gazdasaghrsz);
            gazdasagModel.setNovenyvtervid(novenyvtervid);
            return gazdasagRepository.save(gazdasagModel);
        }
    }
/*
    public GazdasagModel save(GazdasagModel std) {
        return gazdasagRepository.save(std);
    }
 */



}