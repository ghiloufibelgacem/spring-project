package tn.enis.ghiloufi.laboratory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.enis.ghiloufi.laboratory.entities.Etudiant;

@RestResource(path="etudiants")
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
