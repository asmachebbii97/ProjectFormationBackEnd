package models;

import java.util.Date;

public class SessiondeFormationModel {
	
	private Long IdSession;
	private String Lieu;
	private Date Date_Debut;
	private Date Date_Fin;
	private int nb_participant;
	public SessiondeFormationModel(Long idSession, String lieu, Date date_Debut, Date date_Fin, int nb_participant) {
		super();
		IdSession = idSession;
		Lieu = lieu;
		Date_Debut = date_Debut;
		Date_Fin = date_Fin;
		this.nb_participant = nb_participant;
	}
	
	

}
