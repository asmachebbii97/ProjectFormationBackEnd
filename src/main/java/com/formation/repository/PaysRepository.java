package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Pays;


@Repository
public interface PaysRepository extends JpaRepository<Pays,Long>{

}
