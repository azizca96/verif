package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publication implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)	
	private Date datePublication;
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publication(long id, Date datePublication) {
		super();
		this.id = id;
		this.datePublication = datePublication;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	

}
