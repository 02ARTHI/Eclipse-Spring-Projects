package com.telusko.SpringDataJpa1.service;

import java.util.Collection;
import java.util.List;

import com.telusko.SpringDataJpa1.dao.Vaccine;

public interface IVaccineService 
{
	public List<Vaccine> fetchByCost(Integer cost);
	public List<Vaccine> fetchByVaccineCompany(String companyName);
	public List<Vaccine> fetchByCostLessThan(Integer cost);
	public List<Vaccine> fetchByCostBetween(Integer startingCost, Integer endingCost);
	public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> vaccines,Integer startingCost, Integer endingCost);
}
