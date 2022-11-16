package com.formation.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.entities.Participant;
import com.formation.entities.Profil;
import com.formation.repository.ProfilRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProfilController {
	private static final Logger logger = LogManager.getLogger(ProfilController.class);
    @Autowired
	ProfilRepository Profilv;
	
	@RequestMapping(value="/Profils", method = RequestMethod.GET)
	public List<Profil> getAllProfil() {
		List<Profil> pro = Profilv.findAll();

        return pro;
	    
	}
	
	
	@GetMapping("/Profil/{id}")
	public Profil getProfilById(@PathVariable(value = "id") Long Id) {
	    return Profilv.findById(Id).orElseThrow(null);
	          
	}
	//pour ajouter un profil
		@PostMapping("/addProfil")
		public Profil createProfil(@Valid @RequestBody Profil profil) {
		    return Profilv.save(profil);
		}
		
	//delete Profil by IdProfil
		@DeleteMapping("/Profil/{IdProfil}")
		public ResponseEntity<?> deleteProfil(@PathVariable(value = "IdProfil") Long IdProfil) {
		    Profil profil = Profilv.findById(IdProfil).orElseThrow(null);
		    //-> new ResourceNotFoundException("Profil", "IdProfil", IdProfil));

		   //ProfilRepository.deleteById(IdProfil);
		    Profilv.delete(profil);

		    return ResponseEntity.ok().build();
		}
		//update Profil
		@PutMapping("/ProfilId/{id}")
		public Profil updateProfil(@PathVariable(value = "id") Long IdProfil,
		                                        @Valid @RequestBody Profil ProfilDetails) {

		    Profil profil = Profilv.findById(IdProfil).orElseThrow(null);
		    

		    profil.setLibelle(ProfilDetails.getLibelle());
		    
		    Profil updatedProfil= Profilv.save(profil);
		    return updatedProfil;
		}
}
