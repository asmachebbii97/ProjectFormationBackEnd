package com.formation.entities;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Session_de_Formation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="SessionId")
	private Long IdSession;
	private String Lieu;
	private Date Date_Debut;
	private Date Date_Fin;
	private int nb_participant;
	
	//@JsonIgnore
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Session_Formation", joinColumns = 
           @JoinColumn(name = "Id_Session" , referencedColumnName = "SessionId" ) , inverseJoinColumns = 
           @JoinColumn(name = "id_Formation", referencedColumnName = "IdFormation")  )
	@JsonIgnore
   private Set<Formation> formations;
	
	
	@ManyToMany(mappedBy = "sessions")
    private Set<Participant> participant ;

	//@JsonIgnore
    @ManyToOne
    private Formateur formateur;
	
	//@JsonIgnore
    @ManyToOne
    private Organisme org;
	public Session_de_Formation(Long idSession, String lieu,Date date_Debut, Date date_Fin, int nb_participant) {
		super();
		IdSession = idSession;
		Lieu = lieu;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
		this.nb_participant = nb_participant;
	}
	public Session_de_Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSession() {
		return IdSession;
	}
	
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public Date getDate_Debut() {
		return Date_Debut;
	}
	public void setDate_Debut(Date date_Debut) {
		Date_Debut = date_Debut;
	}
	public Date getDate_Fin() {
		return Date_Fin;
	}
	public void setDate_Fin(Date date_Fin) {
		Date_Fin = date_Fin;
	}
	public int getNb_participant() {
		return nb_participant;
	}
	public void setNb_participant(int nb_participant) {
		this.nb_participant = nb_participant;
	}
	public void setIdSession(Long idSession) {
		IdSession = idSession;
	}
	
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Organisme getOrg() {
		return org;
	}
	public void setOrg(Organisme org) {
		this.org = org;
	}
	public Set<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	public Set<Formation> getFormations() {
		return formations;
	}
	
	
	public void addSession(Formation forma) {
		formations.add(forma);
        forma.getSession_de_Formations().add(this); 
    }


	
}
