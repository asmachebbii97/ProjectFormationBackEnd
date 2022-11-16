package models;

import com.formation.entities.TypeFormation;

public class FormationModel {

	private Long IdFormation;
	private String Titre;
	private int annee;
	private int Nb_session;
	private int Duree;
	private float Budget;
	private TypeFormation typeF;
	private DomaineModel domaine;
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
	public DomaineModel getDomaine() {
		return domaine;
	}
	public void setDomaine(DomaineModel domaine) {
		this.domaine = domaine;
	}
}
