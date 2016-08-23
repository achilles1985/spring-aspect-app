package com.example.aspect.repository;

import com.example.aspect.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipwrecksRepository extends JpaRepository<Shipwreck, Long> {

}
