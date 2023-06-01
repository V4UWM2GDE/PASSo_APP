package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NovenyReszletekRepository extends JpaRepository<NovenyvReszletekModel, Integer> {

    Optional<NovenyvReszletekModel> findNovenyvReszletekModelByReszlbejegyzescime(String reszlbejegyzescime);

}