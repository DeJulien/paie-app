package dev.paie.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;


import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

//@Controller
public class InsererGrade implements Runnable {
	
	private GradeRepository gradeRepository;
	
	public InsererGrade(GradeRepository gradeRepository) {
		super();
		this.gradeRepository= gradeRepository;
	}
	
	
	@Override
	public void run() {
		
		BigDecimal num1= new BigDecimal(150);
		BigDecimal num2= new BigDecimal(10);
		
		Grade grade = new Grade();
		grade.setCode("GRADE_D");
		grade.setNbHeuresBase(num1);
		grade.setTauxBase(num2);
		grade.setId(4);
		
		this.gradeRepository.save(grade);
		
	}

}
