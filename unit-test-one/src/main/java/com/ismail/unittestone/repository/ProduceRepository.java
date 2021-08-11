package com.ismail.unittestone.repository;

import com.ismail.unittestone.model.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepository extends JpaRepository<Produce,Long> {
    Produce findByName(String name);
}
