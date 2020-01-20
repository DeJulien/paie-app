package dev.paie.exec;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

//@Controller
public class InsererProfil implements Runnable{
	
	private ProfilRemunerationRepository profilRemunerationRepository;

	public InsererProfil(ProfilRemunerationRepository profilRemunerationRepository) {
		super();
		this.profilRemunerationRepository = profilRemunerationRepository;
		
	}

	@Override
	public void run() {
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		profilRemuneration.setId(4);
		profilRemuneration.setCode("Invite");
		//profilRemuneration.setCotisations();
		//profilRemuneration.setAvantages();
		
		this.profilRemunerationRepository.save(profilRemuneration);
		
	}

}
