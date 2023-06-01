package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KulturaRepository extends JpaRepository<KulturaModel, Integer> {

    Optional<KulturaModel> findKulturaModelByKulturaneve(String kulturaneve);

}