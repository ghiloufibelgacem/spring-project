package tn.enis.ghiloufi.laboratory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import tn.enis.ghiloufi.laboratory.entities.EnseignantChercheur;
import tn.enis.ghiloufi.laboratory.entities.Etudiant;
import tn.enis.ghiloufi.laboratory.entities.Publication;
import tn.enis.ghiloufi.laboratory.entities.Membre;
import tn.enis.ghiloufi.laboratory.entities.Role;
import tn.enis.ghiloufi.laboratory.repositories.EnseignantRespository;
import tn.enis.ghiloufi.laboratory.repositories.EtudiantRepository;
import tn.enis.ghiloufi.laboratory.repositories.PublicationRepository;
import tn.enis.ghiloufi.laboratory.repositories.RoleRepository;

@SpringBootApplication
public class LappAppApplication implements CommandLineRunner {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private EnseignantRespository enseignantRespository;

	public static void main(String[] args) {
		SpringApplication.run(LappAppApplication.class, args);
	}

	@Bean // @Transactional
	InitializingBean setUpApplication(EtudiantRepository etudiantRepository,
			EnseignantRespository enseignantRespository, RoleRepository roleRepository,
			PublicationRepository publicationRepository) {
		return () -> {

			// 1- add two roles
			Role r1 = new Role("admin");
			Role r2 = new Role("user");
			Collection<Role> lst1 = new ArrayList<Role>();
			lst1.add(r1);
			Collection<Role> lst2 = new ArrayList<Role>();
			lst2.add(r2);
			roleRepository.save(r1);
			roleRepository.save(r2);
			// 2- add two professor
			EnseignantChercheur ens1 = new EnseignantChercheur("01752354", "Jmaiel", "Mohamed", new Date(), "", null,"jmaiel@enis.tn", "0000");
			ens1.setRoles(lst1);
			enseignantRespository.save(ens1);
			EnseignantChercheur ens2 = new EnseignantChercheur("01752354", "mariam", "lahami", new Date(), "", null,"lahami@enis.tn", "2222");
			ens1.setRoles(lst2);
			enseignantRespository.save(ens2);
			// 3- add two students
			Etudiant etd1 = new Etudiant("081705454", "ben fekih", "rim", new Date(), "", null, "rim@enis.rn", "11111",null, "test", "these");
			Etudiant etd2 = new Etudiant("885705454", "ben ahmed", "sana", new Date(), "", null, "sana@enis.rn","11111", null, "test", "mastere");
			Etudiant etd3 = new Etudiant("081454", "chaari", "rim", new Date(), "", null, "chaari@enis.rn", "11111",null, "test", "these");
			etd1.setRoles(lst2);
			etd2.setRoles(lst2);
			etd3.setRoles(lst2);
			etd1.setEncadrant(ens1);
			etd2.setEncadrant(ens2);
			etudiantRepository.save(etd1);
			etudiantRepository.save(etd2);
			etudiantRepository.save(etd3);
		};
	}

	@Override @Transactional // this function need to be execute in the same context
	public void run(String... args) throws Exception {
		// 1- add two roles
		Role r1 = new Role("admin");
		Role r2 = new Role("user");
		Collection<Role> lst1 = new ArrayList<Role>();
		lst1.add(r1);
		Collection<Role> lst2 = new ArrayList<Role>();
		lst2.add(r2);
		this.roleRepository.save(r1);
		this.roleRepository.save(r2);
		// 2- add two professor
		EnseignantChercheur ens1 = new EnseignantChercheur("01752354", "Jmaiel", "Mohamed", new Date(), "", null,"jmaiel@enis.tn", "0000");
		ens1.setRoles(lst1);
		this.enseignantRespository.save(ens1);
		EnseignantChercheur ens2 = new EnseignantChercheur("01752354", "mariam", "lahami", new Date(), "", null,"lahami@enis.tn", "2222");
		ens1.setRoles(lst2);
		this.enseignantRespository.save(ens2);
		// 3- add two students
		Etudiant etd1 = new Etudiant("081705454", "ben fekih", "rim", new Date(), "", null, "rim@enis.rn", "11111", null, "test", "these");
		Etudiant etd2 = new Etudiant("885705454", "ben ahmed", "sana", new Date(), "", null, "sana@enis.rn", "11111", null, "test", "mastere");
		Etudiant etd3 = new Etudiant("081454", "chaari", "rim", new Date(), "", null, "chaari@enis.rn", "11111", null,"test", "these");
		etd1.setRoles(lst2);
		etd2.setRoles(lst2);
		etd3.setRoles(lst2);
		etd1.setEncadrant(ens1);
		etd2.setEncadrant(ens2);
		this.etudiantRepository.save(etd1);
		this.etudiantRepository.save(etd2);
		this.etudiantRepository.save(etd3);
		// 4- add some publications
		Publication pubs = new Publication("poster", new Date(), "lien", "pdf");
		Collection<Membre> auteurs = new ArrayList<Membre>();
		auteurs.add(etd1);
		auteurs.add(ens1);
		auteurs.add(ens2);
		pubs.setAuteurs(auteurs);
		this.publicationRepository.save(pubs);
	}
}
