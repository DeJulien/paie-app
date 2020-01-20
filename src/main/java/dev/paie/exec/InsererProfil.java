package dev.paie.exec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;


import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.ProfilRemunerationRepository;

//@Controller
public class InsererProfil implements Runnable{
	
	private ProfilRemunerationRepository profilRemunerationRepository;
	private CotisationRepository cotisationRepository;

	public InsererProfil(ProfilRemunerationRepository profilRemunerationRepository, CotisationRepository cotisationRepository) {
		super();
		this.profilRemunerationRepository = profilRemunerationRepository;
		this.cotisationRepository = cotisationRepository;
		
	}

	@Override
	public void run() {
		List<Cotisation> cotisations=cotisationRepository.findAll();
		List<Cotisation> cotisationsAjout= new ArrayList();
		
		for(Cotisation coti : cotisations)
		{
			if(coti.getId()==1)
			{
				cotisationsAjout.add(coti);
			}
			
		}
		
		//List<Avantage> avantages;
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		profilRemuneration.setId(4);
		profilRemuneration.setCode("Invite");
		profilRemuneration.setCotisations(cotisationsAjout);
		//profilRemuneration.setAvantages();
		
		this.profilRemunerationRepository.save(profilRemuneration);
		
	}

}
