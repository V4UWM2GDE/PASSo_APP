package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NovenyRepository extends JpaRepository<NovenyvTervModel, Integer> {

    Optional<NovenyvTervModel> findNovenyModelByBejegyzescime(String bejegyzescime);

}
