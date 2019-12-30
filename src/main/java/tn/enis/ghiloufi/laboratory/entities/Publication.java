package tn.enis.ghiloufi.laboratory.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
public class Publication implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//article de journal/ manifestation/chapitre de livre/livre/poster
	private String type;
	@Temporal(TemporalType.DATE)
	private Date dateApparition;
	private String lien;
	private String sourcePdf;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Membre> auteurs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateApparition() {
		return dateApparition;
	}
	public void setDateApparition(Date dateApparition) {
		this.dateApparition = dateApparition;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getSourcePdf() {
		return sourcePdf;
	}
	public void setSourcePdf(String sourcePdf) {
		this.sourcePdf = sourcePdf;
	}
	public Collection<Membre> getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(Collection<Membre> auteurs) {
		this.auteurs = auteurs;
	}
	public Publication(String type, Date dateApparition, String lien, String sourcePdf) {
		super();
		this.type = type;
		this.dateApparition = dateApparition;
		this.lien = lien;
		this.sourcePdf = sourcePdf;
	}
	public Publication() {
		super();
	}
	

}
