package com.passo.service;

import com.passo.model.*;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovenyReszletekService {

    private final NovenyReszletekRepository novenyReszletekRepository;

    public NovenyReszletekService(NovenyReszletekRepository novenyReszletekRepository) {
        this.novenyReszletekRepository = novenyReszletekRepository;
    }

    public NovenyvReszletekModel registerNovenyvtervreszl(Integer novenyvtervid, String reszlbejegyzestipusa, String reszlbejegyzescime, String reszlbejegyzesreszl){
        if (novenyvtervid == null || reszlbejegyzestipusa == null || reszlbejegyzescime == null || reszlbejegyzesreszl == null) {
            return null;
        } else {
            if(novenyReszletekRepository.findNovenyvReszletekModelByReszlbejegyzescime(reszlbejegyzescime).isPresent()){
                System.out.println("Már létező bejegyzés!");
                return null;
            }
            NovenyvReszletekModel novenyvReszletekModel = new NovenyvReszletekModel();
            novenyvReszletekModel.setNovenyvtervid(novenyvtervid);
            novenyvReszletekModel.setReszlbejegyzestipusa(reszlbejegyzestipusa);
            novenyvReszletekModel.setReszlbejegyzescime(reszlbejegyzescime);
            novenyvReszletekModel.setReszlbejegyzesreszl(reszlbejegyzesreszl);
            return novenyReszletekRepository.save(novenyvReszletekModel);
        }
    }

    public List<NovenyvReszletekModel> getAllNovenyvtervreszl() {
        return novenyReszletekRepository.findAll();
    }

    public Optional<NovenyvReszletekModel> findById(Integer id) {
        return novenyReszletekRepository.findById(id);
    }


}