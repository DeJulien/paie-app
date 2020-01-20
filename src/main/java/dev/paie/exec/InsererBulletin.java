package dev.paie.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;

@Controller
public class InsererBulletin implements Runnable{

	private RemunerationEmployeRepository remunerationEmployeRepository;
	private BulletinSalaireRepository bulletinSalaireRepository;
	private PeriodeRepository periodeRepository;
	
	
	public InsererBulletin(BulletinSalaireRepository bulletinSalaireRepository,RemunerationEmployeRepository remunerationEmployeRepository,PeriodeRepository periodeRepository) {
		super();
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.periodeRepository= periodeRepository;
	}



	@Override
	public void run() {
		BigDecimal num1= new BigDecimal(150);
		
		RemunerationEmploye re = new RemunerationEmploye();
        List<RemunerationEmploye> remunerationEmploye= this.remunerationEmployeRepository.findAll();
        for(RemunerationEmploye temps : remunerationEmploye)
		{
			if(temps.getId()==1)
			{
				re=temps;
			}
			
		}
        
        Periode perio = new Periode();
        List<Periode> periode= this.periodeRepository.findAll();
        for(Periode temps : periode)
		{
			if(temps.getId()==1)
			{
				perio=temps;
			}
			
		}
		
		
		BulletinSalaire bulletinSalaire = new BulletinSalaire();
		bulletinSalaire.setRemunerationEmploye(re);
		bulletinSalaire.setPeriode(perio);
		bulletinSalaire.setPrimeExceptionnelle(num1);
		bulletinSalaire.setId(1);
		
		this.bulletinSalaireRepository.save(bulletinSalaire);
		
	}

}
