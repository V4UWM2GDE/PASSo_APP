package com.passo.service;

import com.passo.model.*;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GazdalkodasService {

    private final GazdalkodasRRepository gazdalkodasRRepository;

    public GazdalkodasService(GazdalkodasRRepository gazdalkodasRRepository) {
        this.gazdalkodasRRepository = gazdalkodasRRepository;
    }

    public GazdalkodasRModel registerGazdalkodas(Integer gazdasagid, Integer novenyvtervid, String feladatok, String feladatstatus){
        if (gazdasagid == null || novenyvtervid == null || feladatok == null || feladatstatus == null) {
            return null;
        } else {
            if(gazdalkodasRRepository.findGazdalkodasRModelByFeladatok(feladatok).isPresent()){
                System.out.println("Már létező bejegyzés!");
                return null;
            }
            GazdalkodasRModel gazdalkodasRModel = new GazdalkodasRModel();
            gazdalkodasRModel.setGazdasagid(gazdasagid);
            gazdalkodasRModel.setNovenyvtervid(novenyvtervid);
            gazdalkodasRModel.setFeladatok(feladatok);
            gazdalkodasRModel.setFeladatstatus(feladatstatus);
            return gazdalkodasRRepository.save(gazdalkodasRModel);
        }
    }

    public List<GazdalkodasRModel> getAllGazdalkodas() {
        return gazdalkodasRRepository.findAll();
    }

    public Optional<GazdalkodasRModel> findById(Integer id) {
        return gazdalkodasRRepository.findById(id);
    }

    public List<GazdalkodasRModel> findAllByGazdasagid(Integer gazdasagid) {return gazdalkodasRRepository.findAllByGazdasagid(gazdasagid);}
}