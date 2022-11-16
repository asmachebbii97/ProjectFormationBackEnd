package com.formation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entities.Profil;


@Repository
public interface ProfilRepository extends JpaRepository<Profil,Long>{

}