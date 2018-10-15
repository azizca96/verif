package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Projet implements Serializable {
	@Id @GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)	
	private Date dateDebut;
	@Temporal(TemporalType.DATE)	
	private Date dateFin;
	private String titre;
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projet( Date dateDebut, Date dateFin, String titre) {
		super();
		//this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.titre = titre;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}
