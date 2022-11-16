package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.formation.entities.Pays;

import com.formation.repository.PaysRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PaysController {
	private static final Logger logger = LogManager.getLogger(ProfilController.class);
    @Autowired
    PaysRepository paysr;
    
    @RequestMapping(value="/Pays", method = RequestMethod.GET)
	public List<Pays> getAllProfil() {
		List<Pays> pro = paysr.findAll();

        return pro;
	    
	}
	
	
	@GetMapping("/Pays/{id}")
	public Pays getPaysById(@PathVariable(value = "id") Long Id) {
	    return paysr.findById(Id).orElseThrow(null);
	          
	}
	//pour ajouter un pays
		@PostMapping("/addPays")
		public Pays createPays(@Valid @RequestBody Pays pays) {
		    return paysr.save(pays);
		}
		
	//delete Profil by IdProfil
		@DeleteMapping("/Pays/{IdPays}")
		public ResponseEntity<?> deleteProfil(@PathVariable(value = "IdPays") Long IdPays) {
		    Pays pays = paysr.findById(IdPays).orElseThrow(null);
		    //-> new ResourceNotFoundException("Profil", "IdProfil", IdProfil));
		   //ProfilRepository.deleteById(IdProfil);
		    paysr.delete(pays);

		    return ResponseEntity.ok().build();
		}
		
		//update Profil
		@PutMapping("/PaysId/{id}")
		public  Pays updateProfil(@PathVariable(value = "id") Long IdPays,
		                                        @Valid @RequestBody Pays PaysDetails) {

			 Pays pays= paysr.findById(IdPays).orElseThrow(null);
		    

			 pays.setLibele(PaysDetails.getLibele());
		    Pays updatedPays= paysr.save(pays);
		    return updatedPays;
		}
}
