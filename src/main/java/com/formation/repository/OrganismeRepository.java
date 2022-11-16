package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Organisme;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme,Long> {

}
