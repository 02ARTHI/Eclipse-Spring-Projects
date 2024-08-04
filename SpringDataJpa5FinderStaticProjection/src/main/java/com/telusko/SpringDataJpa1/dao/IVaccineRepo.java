package com.telusko.SpringDataJpa1.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
  //findByProperty
	public List<Vaccine> findByCost(Integer cost);
	
	public List<Vaccine> findByVaccineCompany(String companyName);
	
	//findByPropertykeywords
	public List<Vaccine> findByVaccineCompanyIs(String companyName);
	public List<Vaccine> findByVaccineCompanyEquals(String companyName);
	
	public List<Vaccine> findByCostLessThan(Integer cost);
	public List<Vaccine> findByCostBetween(Integer startingCost, Integer endingCost);
	public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> vaccines, Integer startingCost, Integer endingCost);
}
