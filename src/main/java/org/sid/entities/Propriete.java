package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Propriete implements Serializable   {
	@Id @GeneratedValue
	private long id;
	private String prop;
	private String statut;
	private String dom;
	public Propriete() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Propriete(long id, String prop, String statut, String dom) {
		super();
		this.id = id;
		this.prop = prop;
		this.statut = statut;
		this.dom = dom;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}


}
