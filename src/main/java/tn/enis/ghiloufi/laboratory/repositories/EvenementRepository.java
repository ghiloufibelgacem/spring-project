package tn.enis.ghiloufi.laboratory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.enis.ghiloufi.laboratory.entities.Evenement;

@RestResource(path="evenements")
public interface EvenementRepository extends JpaRepository<Evenement,Long> {

}
