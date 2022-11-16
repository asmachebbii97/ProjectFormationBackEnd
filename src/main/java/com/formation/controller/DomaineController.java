package com.formation.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.formation.entities.Domaine;
import com.formation.entities.Organisme;
import com.formation.entities.User;
import com.formation.repository.DomaineRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class DomaineController {
	private static final Logger logger = LogManager.getLogger(DomaineController.class);
	@Autowired
	DomaineRepository Domainev;
	
	@GetMapping("/Domaines")
	public List<Domaine> getAllDomaines() {
		List<Domaine> pro = Domainev.findAll();
		
        return pro;
	    
	}
	
	@GetMapping("/Domaine/{id}")
	public Domaine getDomaineById(@PathVariable(value = "id") Long Id) {
	    return Domainev.findById(Id).orElseThrow(null);
	          
	} 
	//("hasRole('ADMIN')")

		@PostMapping("/addDomaine")
		public Domaine createDomaine(@Valid @RequestBody Domaine Domaine) {
		    return Domainev.save(Domaine);
		}
		//delete domaine
		@RequestMapping(value="/DeleteDomaine/{IdDomaine}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteDomaine(@PathVariable(value = "IdDomaine") Long IdDomaine) {
		    Domaine domaine = Domainev.findById(IdDomaine).orElseThrow(null) ;
		    		//-> new ResourceNotFoundException("Organisme", "IdOrganisme", IdOrganisme));

		   //OrganismeRepository.deleteByOrganisme(IdOrganisme);
		    Domainev.delete(domaine);

		    return ResponseEntity.ok().build();
		}
	
	//@PutMapping("/UpdateDomaine/{id}")
		@RequestMapping(value="/UpdateDomaine/{IdDomaine}", method = RequestMethod.PUT)
		public Domaine UpdateDomaine(@PathVariable(value = "IdDomaine") Long IdDomaine,
		                                        @Valid @RequestBody Domaine DomaineDetails) {
			Domaine Domaine = Domainev.findById(IdDomaine).orElseThrow(null);
		    
			   
		    Domaine.setIdDomaine(DomaineDetails.getIdDomaine());
		    Domaine.setLibelle(DomaineDetails.getLibelle());
		   
		    
		    Domaine updatedDomaine= Domainev.save(Domaine);
		    return updatedDomaine;
		}
			
		
		
		
		
		
		
		
	
	
	        
}
