package com.passo.repository;

import com.passo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GazdalkodasRRepository extends JpaRepository<GazdalkodasRModel, Integer> {

    Optional<GazdalkodasRModel> findGazdalkodasRModelByFeladatok(String feladatok);

    List<GazdalkodasRModel> findAllByGazdasagid(Integer gazdasagid);
}