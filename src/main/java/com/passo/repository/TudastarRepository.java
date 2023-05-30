package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TudastarRepository extends JpaRepository<TudastarModel, Integer> {

    Optional<TudastarModel> findTudastarModelByTudastarcime(String tudastarcime);

}