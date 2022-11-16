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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.formation.entities.TypeFormation;

import models.SessiondeFormationModel;

@Entity
public class Formation  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="IdFormation")
	private Long IdFormation;
	private String Titre;
	private int annee;
	private int Nb_session;
	private int Duree;
	private float Budget;
	private TypeFormation typeF;
	//@JsonIgnore
    @ManyToOne
    private Domaine dom;
    
 
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "formations", cascade =  {CascadeType.ALL})
    private Set<Session_de_Formation> session_de_Formations ;
	
	public Formation(Long idFormation, String titre,  int annee, int nb_session, int duree,
			 float budget,TypeFormation type, Domaine domaine) {
		super();
		this.IdFormation = idFormation;
		this.Titre = titre;
		this.annee = annee;
		this.Nb_session = nb_session;
		this.Duree = duree;
		this.Budget = budget;
		this.typeF=type;
		this.dom=domaine;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdFormation() {
		return IdFormation;
	}
	public void setIdFormation(Long idFormation) {
		IdFormation = idFormation;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNb_session() {
		return Nb_session;
	}
	public void setNb_session(int nb_session) {
		Nb_session = nb_session;
	}
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int duree) {
		Duree = duree;
	}
	
	public float getBudget() {
		return Budget;
	}
	public void setBudget(float budget) {
		Budget = budget;
	}
	public TypeFormation getTypeF() {
		return typeF;
	}
	public void setTypeF(TypeFormation typeF) {
		this.typeF = typeF;
	}
	public Domaine getDom() {
		return dom;
	}
	public void setDom(Domaine dom) {
		this.dom = dom;
	}
	
	
	
	public Set<Session_de_Formation> getSession_de_Formations() {
		return session_de_Formations;
	}
	public void setSession_de_Formations(Set<Session_de_Formation> session_de_Formations) {
		this.session_de_Formations = session_de_Formations;
	}
	@Override
	public String toString() {
		return "Formation [IdFormation=" + IdFormation + ", Titre=" + Titre + ", annee=" + annee + ", Nb_session="
				+ Nb_session + ", Duree=" + Duree + ", Budget=" + Budget + ", typeF=" + typeF + ", dom=" + dom + "]";
	}
	
	
	

	
	
}
