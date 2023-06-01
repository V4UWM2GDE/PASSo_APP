package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeruletRepository extends JpaRepository<TeruletModel, Integer> {

    Optional<TeruletModel> findTeruletModelByTeruletneve(String teruletneve);

}