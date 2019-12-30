package tn.enis.ghiloufi.laboratory.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String cv;
	private String photo;
	private String email;
	private String password;

	// Relations
	@JsonIgnore
	@ManyToMany
	private Collection<Role> roles;

	@JsonIgnore
	@ManyToMany(mappedBy = "auteurs")
	private Collection<Publication> pubs;

	@JsonIgnore
	@ManyToMany(mappedBy = "organisateurs")
	private Collection<Evenement> evts;

	@JsonIgnore
	@ManyToMany(mappedBy = "developpeurs")
	private Collection<Outil> outils;

	public Collection<Evenement> getEvts() {
		return evts;
	}

	public void setEvts(Collection<Evenement> evts) {
		this.evts = evts;
	}

	public Collection<Outil> getOutils() {
		return outils;
	}

	public void setOutils(Collection<Outil> outils) {
		this.outils = outils;
	}

	public Collection<Publication> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<Publication> pubs) {
		this.pubs = pubs;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Membre() {
		super();
	}

	public Membre(String cin, String nom, String prenom, Date dateNaissance, String cv, String photo, String email,
			String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cv = cv;
		this.photo = photo;
		this.email = email;
		this.password = password;
	}

}
