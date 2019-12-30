package tn.enis.ghiloufi.laboratory.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class EnseignantChercheur extends Membre implements Serializable {
	private String etablissement;
	private String grade;

	@JsonIgnore
	@OneToMany(mappedBy = "encadrant")
	private Collection<Etudiant> etudiants;

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public EnseignantChercheur() {
		super();
	}

	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv, String photo,
			String email, String password) {
		super(cin, nom, prenom, dateNaissance, cv, photo, email, password);
	}

}
