package dev.paie.exec;

import java.util.List;

import org.springframework.stereotype.Controller;


import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

//@Controller
public class ListerCotisations implements Runnable {

	private CotisationRepository cotisationRepository;
	
	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository=cotisationRepository;
	}
	
	
	public void run() {
		List<Cotisation> listCotisation= cotisationRepository.findAll();
		
		for(Cotisation cotisation : listCotisation)
		{
			System.out.println(cotisation.getCode()+" "+cotisation.getLibelle()+" "+cotisation.getTauxSalarial()+" "+cotisation.getTauxPatronal());
		}
	}

}
