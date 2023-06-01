package com.passo.service;

import com.passo.model.*;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovenyService {

    private final NovenyRepository novenyRepository;

    public NovenyService(NovenyRepository novenyRepository) {
        this.novenyRepository = novenyRepository;
    }

    public NovenyvTervModel registerNovenyvterv(String bejegyzescime, String bejegyzestipusa){
        if (bejegyzescime == null || bejegyzestipusa == null) {
            return null;
        } else {
            if(novenyRepository.findNovenyModelByBejegyzescime(bejegyzescime).isPresent()){
                System.out.println("Már létező terv!");
                return null;
            }
            NovenyvTervModel novenyvtervModel = new NovenyvTervModel();
            novenyvtervModel.setBejegyzestipusa(bejegyzestipusa);
            novenyvtervModel.setBejegyzescime(bejegyzescime);
            return novenyRepository.save(novenyvtervModel);
        }
    }

    public List<NovenyvTervModel> getAllNovenyvterv() {
        return novenyRepository.findAll();
    }

    public Optional<NovenyvTervModel> findById(Integer id) {
        return novenyRepository.findById(id);
    }


}