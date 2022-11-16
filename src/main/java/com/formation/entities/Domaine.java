package com.formation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Domaine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="DomaineId")
	private Long IdDomaine;
	private String Libelle;
	
	@JsonIgnore
	@OneToMany(mappedBy="dom",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Formation> F= new HashSet<Formation>();
	
	public Domaine() {
		
		// TODO Auto-generated constructor stub
	}
	public Domaine(Long idDomaine, String libelle) {
		super();
		IdDomaine = idDomaine;
		Libelle = libelle;
	}
	public Long getIdDomaine() {
		return IdDomaine;
	}
	public void setIdDomaine(Long idDomaine) {
		IdDomaine = idDomaine;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Domaine save(@Valid Domaine domaine) {
		return null;
	}
	public Object findById(Long domaine) {
		// TODO Auto-generated method stub
		return null;
	}
	public void delete(Domaine domaine) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Domaine [IdDomaine=" + IdDomaine + ", Libelle=" + Libelle + ", F=" + F + "]";
	}
	
	
	


	
	
}
