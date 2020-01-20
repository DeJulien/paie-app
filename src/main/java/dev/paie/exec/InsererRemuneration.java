package dev.paie.exec;

import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
public class InsererRemuneration implements Runnable{

	
	private RemunerationEmployeRepository remunerationEmployeRepository;
	private GradeRepository gradeRepository;
	private ProfilRemunerationRepository profilRemunerationRepository;
	private EntrepriseRepository entrepriseRepository;
	
	public InsererRemuneration(RemunerationEmployeRepository remunerationEmployeRepository,GradeRepository gradeRepository, ProfilRemunerationRepository profilRemunerationRepository,EntrepriseRepository entrepriseRepository) {
		super();
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.gradeRepository = gradeRepository;
		this.profilRemunerationRepository= profilRemunerationRepository;
		this.entrepriseRepository = entrepriseRepository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		List<Grade> grade= gradeRepository.findAll();
		List<ProfilRemuneration> profilRemuneration= profilRemunerationRepository.findAll();
		List<Entreprise> entreprise= entrepriseRepository.findAll();
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		remunerationEmploye.setMatricule("test01");
		/*remunerationEmploye.setEntreprise();
		remunerationEmploye.setProfilRemuneration();
		remunerationEmploye.setGrade();*/
		remunerationEmploye.setId(1);
		
		this.remunerationEmployeRepository.save(remunerationEmploye);
		

		
	}

}
