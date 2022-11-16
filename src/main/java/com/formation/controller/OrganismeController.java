package com.formation.controller;

import java.util.List;

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

import com.formation.entities.Formateur;
import com.formation.entities.Formation;
import com.formation.entities.Organisme;
import com.formation.repository.OrganismeRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrganismeController {
	//private static final Logger logger = LogManager.getLogger(OrganismeController.class);
	@Autowired
	OrganismeRepository Organismev;
	
	
	@RequestMapping(value="/organismes", method = RequestMethod.GET)
	public List<Organisme> getAllOrganisme() {
		List<Organisme> pro = Organismev.findAll();

        return pro;
	    
	}
	
	@GetMapping("/Organisme/{id}")
	public Organisme getOrganismeById(@PathVariable(value = "id") Long Id) {
	    return Organismev.findById(Id).orElseThrow(null);
	          
	}
	
	//pour ajouter un organisme
	@RequestMapping(value="/addOrganisme", method = RequestMethod.POST)
		public Organisme createOrganisme(@Valid @RequestBody Organisme organisme) {
		    return Organismev.save(organisme);
		}
		
	//delete Organisme by IdOrganisme
		@RequestMapping(value="/DeleteOrganisme/{IdOrganisme}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteOrganisme(@PathVariable(value = "IdOrganisme") Long IdOrganisme) {
		    Organisme organisme = Organismev.findById(IdOrganisme).orElseThrow(null) ;
		    		//-> new ResourceNotFoundException("Organisme", "IdOrganisme", IdOrganisme));

		   //OrganismeRepository.deleteByOrganisme(IdOrganisme);
		    Organismev.delete(organisme);

		    return ResponseEntity.ok().build();
		}
		//update Organisme
		//@PreAuthorize("hasRole('ADMIN')")
		@RequestMapping(value="/updateOrganisme/{IdOrganisme}", method = RequestMethod.PUT)
		public Organisme updateOrganisme(@PathVariable(value = "IdOrganisme") Long IdOrganisme,
		                                        @Valid @RequestBody Organisme OrganismeDetails) {

		    Organisme organisme = Organismev.findById(IdOrganisme).orElseThrow(null);
		    
		   
		  
		    organisme.setLibelle(OrganismeDetails.getLibelle());
		    
		    Organisme updatedOrganisme= Organismev.save(organisme);
		    return updatedOrganisme;
		}
}
