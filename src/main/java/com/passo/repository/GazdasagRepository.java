package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GazdasagRepository extends JpaRepository<GazdasagModel, Integer> {

    Optional<GazdasagModel> findGazdasagModelByGazdasagneve(String gazdasagneve);

}