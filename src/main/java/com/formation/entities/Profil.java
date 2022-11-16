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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Profil  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ProfilId")
	private Long IdProfil;
	private String Libelle;
	
	@JsonIgnore
	@OneToMany(mappedBy="p",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Participant> participant = new HashSet<Participant>();
	
	public Profil(Long idProfil, String libelle) {
		super();
		IdProfil = idProfil;
		Libelle = libelle;
	}
	public Profil() {

		// TODO Auto-generated constructor stub
	}
	public Long getIdProfil() {
		return IdProfil;
	}
	public void setIdProfil(Long idProfil) {
		IdProfil = idProfil;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Set<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	
	
	
}
