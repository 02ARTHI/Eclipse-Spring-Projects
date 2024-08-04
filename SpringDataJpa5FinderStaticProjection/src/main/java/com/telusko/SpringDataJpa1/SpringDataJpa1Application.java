package com.telusko.SpringDataJpa1;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.SpringDataJpa1.service.VaccineServiceImpl;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa1Application.class, args);
		VaccineServiceImpl service = container.getBean(VaccineServiceImpl.class);
		
	service.fetchByCost(1).forEach(v->System.out.println(v));
		
	//service.fetchByVaccineCompany("Astrazenca").forEach(v->System.out.println(v));
	//	service.fetchByCostLessThan(5000).forEach(v->System.out.println(v));
	//	service.fetchByCostBetween(500, 1500).forEach(v->System.out.println(v));
//		Collection<String> vaccines=new HashSet<>();
//		vaccines.add("CovidShield");
//		vaccines.add("Sputnik");
//		service.fetchByVaccineNameInAndCostBetween(vaccines, 500, 1500).forEach(v->System.out.println(v));
	}

}
