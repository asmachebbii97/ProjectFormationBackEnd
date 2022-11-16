package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long>{

}
