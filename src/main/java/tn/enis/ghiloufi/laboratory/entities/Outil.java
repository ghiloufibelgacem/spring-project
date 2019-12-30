package tn.enis.ghiloufi.laboratory.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@SuppressWarnings("serial")
@Entity
public class Outil implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String source;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonIgnore
	@ManyToMany
	private Collection<Membre> developpeurs;
	
	public Collection<Membre> getDeveloppeurs() {
		return developpeurs;
	}
	public void setDeveloppeurs(Collection<Membre> developpeurs) {
		this.developpeurs = developpeurs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Outil(String nom, String source, Date date) {
		super();
		this.nom = nom;
		this.source = source;
		this.date = date;
	}
	public Outil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
