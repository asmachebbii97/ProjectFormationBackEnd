package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formation.entities.Domaine;
import com.formation.entities.Formateur;
import com.formation.entities.Formation;
import com.formation.entities.Organisme;
import com.formation.repository.FormateurRepository;
import com.formation.repository.OrganismeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FormateurController {
	private static final Logger logger = LogManager.getLogger(FormateurController.class);
	@Autowired
	FormateurRepository Formateurv;
	@Autowired
	OrganismeRepository organismeR;
	
	@RequestMapping(value="/formateur", method = RequestMethod.GET)
	public List<Formateur> getAllFormateurs() {
		List<Formateur> pro = Formateurv.findAll();

		
        return pro;
	    
	}
	
	@GetMapping("/formateur/{id}")
	public Formateur getFormateurById(@PathVariable(value = "id") Long Id) {
	    return Formateurv.findById(Id).orElseThrow(null);
	          
	}
	//pour ajouter un formateur
		@PostMapping("/addFormateur/{Organismeid}")
		public Formateur createFormateur(@PathVariable(value = "Organismeid") Long Id,@Valid @RequestBody Formateur formateurDetails) {
			
			
			   Formateur formateur=new Formateur();
			   Organisme organisme = organismeR.findById(Id).orElseThrow(null);
			   
			      
			 formateur.setOrganismes(organisme);
			 formateur.setNom(formateurDetails.getNom());   
			 formateur.setPrenom(formateurDetails.getPrenom());   
			 formateur.setEmail(formateurDetails.getEmail());   
			 formateur.setTlf(formateurDetails.getTlf());
			 formateur.setType(formateurDetails.getType());
		    return Formateurv.save(formateur);
		}
		
	//delete user by IdFormateur
		@DeleteMapping("/DeleteFormateur/{IdFormateur}")
			public ResponseEntity<?> deleteFormateur(@PathVariable(value = "IdFormateur") Long IdFormateur) {
			    Formateur formateur = Formateurv.findById(IdFormateur).orElseThrow(null);
		    		//-> new ResourceNotFoundException("Formateur", "IdFormateur", IdFormateur));

		   //FormateurRepository.deleteById(IdFormateur);
		    Formateurv.delete(formateur);

		    return ResponseEntity.ok().build();
		}
		//update Formateur
		@PutMapping("/FormateurId/{IdFormateur}")
		public Formateur updateFormateur(@PathVariable(value = "IdFormateur") Long IdFormateur,
		                                        @Valid @RequestBody Formateur formateurDetails) {

		    
		    
		    Formateur formateur = Formateurv.findById(IdFormateur).orElseThrow(null);
			
				 formateur.setNom(formateurDetails.getNom());   
				 formateur.setPrenom(formateurDetails.getPrenom());   
				 formateur.setEmail(formateurDetails.getEmail());   
				 formateur.setTlf(formateurDetails.getTlf());
				 formateur.setType(formateurDetails.getType());

		    Formateur updatedFormateur = Formateurv.save(formateur);
		    return updatedFormateur;
		}
		
}
