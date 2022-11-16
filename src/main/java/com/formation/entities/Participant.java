package com.formation.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formation.entities.TypeParticipant; 
import com.formation.entities.Pays; 

@Entity
public class Participant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="ParticipantId")
	private Long IdParticipant;
	private String Nom;
	private String Prenom;
	private String Email;
	private int Tlf;
	
	
	@ManyToOne
    private Pays pays;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Particicpant_session", joinColumns = {
           @JoinColumn(name = "id_participant") }, inverseJoinColumns = {
           @JoinColumn(name = "id_session") })
   private Set<Session_de_Formation> sessions;
   
    @ManyToOne
    private Profil p;
   
   

	private TypeParticipant typeP; 
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public Profil getP() {
		return p;
	}
	public void setP(Profil p) {
		this.p = p;
	}
	
	public Participant(Long idParticipant, String nom, String prenom, int idOrganisme,String email, int tlf,TypeParticipant type ) {
		super();
		IdParticipant = idParticipant;
		Nom = nom;
		Prenom = prenom;
	
		Email = email;
		Tlf = tlf;
		typeP=type; 
		
	}
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdParticipant() {
		return IdParticipant;
	}
	public void setIdParticipant(Long idParticipant) {
		IdParticipant = idParticipant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
		public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	public TypeParticipant getTypeP() {
		return typeP;
	}
	public void setTypeP(TypeParticipant typeP) {
		this.typeP = typeP;
	}
	public int getTlf() {
		return Tlf;
	}
	public void setTlf(int tlf) {
		Tlf = tlf;
	}
	public void setSessions(Set<Session_de_Formation> sessions) {
		this.sessions = sessions;
	}
	public Set<Session_de_Formation> getSessions() {
		return sessions;
	}
	
	
	
	
	



	
	
}
