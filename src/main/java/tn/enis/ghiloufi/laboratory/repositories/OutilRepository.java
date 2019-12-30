package tn.enis.ghiloufi.laboratory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.enis.ghiloufi.laboratory.entities.Outil;

@RestResource(path="outils")
public interface OutilRepository extends JpaRepository<Outil, Long> {

}
