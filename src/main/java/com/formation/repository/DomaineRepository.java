package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine,Long> {

	

	

	

}
