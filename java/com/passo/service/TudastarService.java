package com.passo.service;

import com.passo.model.TudastarModel;
import com.passo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TudastarService {

    private final TudastarRepository tudastarRepository;

    public TudastarService(TudastarRepository tudastarRepository) {
        this.tudastarRepository = tudastarRepository;
    }

    public TudastarModel registerTudastar(String tudastartipus, String tudastarcime, String tudastarreszl){
        if (tudastartipus == null || tudastarcime == null || tudastarreszl == null) {
            return null;
        } else {
            if(tudastarRepository.findTudastarModelByTudastarcime(tudastarcime).isPresent()){
                System.out.println("Már létező tudástár cím!");
                return null;
            }
            TudastarModel tudastarModel = new TudastarModel();
            tudastarModel.setTudastartipus(tudastartipus);
            tudastarModel.setTudastarcime(tudastarcime);
            tudastarModel.setTudastarreszl(tudastarreszl);
            return tudastarRepository.save(tudastarModel);
        }
    }

    public List<TudastarModel> getAllTudastar() {
        return tudastarRepository.findAll();
    }

    public Optional<TudastarModel> findById(Integer id) {
        return tudastarRepository.findById(id);
    }

    public void deleteById(Integer id) {
        tudastarRepository.deleteById(id);
    }

}