package com.formation.controller;

import java.util.List;
import java.util.Set;

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

import com.formation.entities.Formation;
import com.formation.entities.Session_de_Formation;
import com.formation.entities.TypeFormation;
import com.formation.entities.User;
import com.formation.repository.FormationRepository;
import com.formation.repository.DomaineRepository;

import com.formation.entities.Domaine;
import com.formation.entities.Formateur;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FormationController {
	private static final Logger logger = LogManager.getLogger(FormationController.class);
	@Autowired
	FormationRepository Formationv;
	@Autowired
	DomaineRepository Domainev;
	
	
	@RequestMapping(value="/formation", method = RequestMethod.GET)
	public List<Formation> getAllformation() {
		List<Formation> pro = Formationv.findAll();
      
        return pro;
	    
	}
	
	
	@RequestMapping(value="/formationById/{eid}", method = RequestMethod.GET)
	public Formation getformationById(@PathVariable(value = "eid") Long Id) {
		Formation formation = Formationv.findById(Id).orElseThrow(null);

        return formation;
	    
	}
	
	
	@GetMapping("/FormationSession/{id}")
	public Set<Session_de_Formation> getFormationSession(@PathVariable(value = "id") Long Id) {
		Formation forma = Formationv.findById(Id).orElseThrow(null);
		return forma.getSession_de_Formations(); 
	          
	}
	
	

	
	
	
	//pour ajouter une formation
	    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
		@PostMapping("/addFormation/{Domaineid}")
		public Formation createFormation(@PathVariable(value = "Domaineid") Long Id, @Valid @RequestBody Formation formationDetails) {

		    
		       Formation me=new Formation();
			   Domaine domaine = Domainev.findById(Id).orElseThrow(null);
			   
			      
				  me.setDom(domaine);
			      me.setTitre(formationDetails.getTitre());
			      me.setAnnee(formationDetails.getAnnee());
			      me.setNb_session(formationDetails.getNb_session());
			      me.setDuree(formationDetails.getDuree());
			      me.setBudget(formationDetails.getBudget());
			      me.setTypeF(formationDetails.getTypeF());
			      
			      
			   return Formationv.save(me);
			
		

		}
		
	//delete Formation by IdFormation
		@DeleteMapping("/Formation/{IdFormation}")
		public ResponseEntity<?> deleteFormation(@PathVariable(value = "IdFormation") Long IdFormation) {
		    Formation Formation = Formationv.findById(IdFormation).orElseThrow(null);
		    		//-> new ResourceNotFoundException("Formation", "IdFormation", IdFormation));

		   //FormateurRepository.deleteById(IdFormation);
		    Formationv.delete(Formation);

		    return ResponseEntity.ok().build();
		}
		//update Formation
		@PutMapping("/FormationId/{IdFormation}")
		public Formation updateFormation(@PathVariable(value = "IdFormation") Long IdFormation,
                @Valid @RequestBody Formation FormationDetails) {

               Formation Formation = Formationv.findById(IdFormation).orElseThrow(null);


               Formation.setIdFormation(FormationDetails.getIdFormation());
Formation.setTitre(FormationDetails.getTitre());

Formation.setAnnee(FormationDetails.getAnnee());
Formation.setNb_session(FormationDetails.getNb_session());
Formation.setDuree(FormationDetails.getDuree());
Formation.setBudget(FormationDetails.getBudget());
Formation.setTypeF(FormationDetails.getTypeF());
Formation.setDom(FormationDetails.getDom());

Formation updatedFormation = Formationv.save(Formation);
return updatedFormation;
}
		
}
