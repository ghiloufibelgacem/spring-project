package tn.enis.ghiloufi.laboratory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.enis.ghiloufi.laboratory.entities.EnseignantChercheur;

@RestResource(path="enseignants")
public interface EnseignantRespository extends JpaRepository<EnseignantChercheur, Long> {

}
