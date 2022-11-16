package com.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formation.entities.Session_de_Formation;

@Repository
public interface Session_de_FormationRepository extends JpaRepository<Session_de_Formation,Long>{

}
