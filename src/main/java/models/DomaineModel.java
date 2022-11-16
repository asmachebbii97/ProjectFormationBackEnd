package models;

public class DomaineModel {
	private Long IdDomaine;
	private String Libelle;
	
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
	public DomaineModel(Long idDomaine, String libelle) {
		super();
		IdDomaine = idDomaine;
		Libelle = libelle;
	}

}

