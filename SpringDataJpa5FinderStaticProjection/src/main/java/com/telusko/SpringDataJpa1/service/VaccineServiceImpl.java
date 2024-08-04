package com.telusko.SpringDataJpa1.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.telusko.SpringDataJpa1.dao.IVaccineRepo;
import com.telusko.SpringDataJpa1.dao.Vaccine;

@Service
public class VaccineServiceImpl implements IVaccineService 
{

	@Autowired
	private IVaccineRepo repo;

	@Override
	public List<Vaccine> fetchByCost(Integer cost) {
		List<Vaccine> vaccines= repo.findByCost(cost);
		System.out.println(vaccines);
		return vaccines;
		
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String companyName) {
		
	//	return repo.findByVaccineCompany(companyName);
	//	return repo.findByVaccineCompanyIs(companyName);
		return repo.findByVaccineCompanyEquals(companyName);
	}

	@Override
	public List<Vaccine> fetchByCostLessThan(Integer cost) {
		
		return repo.findByCostLessThan(cost);
	}

	@Override
	public List<Vaccine> fetchByCostBetween(Integer startingCost, Integer endingCost) {
		// TODO Auto-generated method stub
		return repo.findByCostBetween(startingCost, endingCost);
	}

	@Override
	public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> vaccines,Integer startingCost, Integer endingCost) {
		// TODO Auto-generated method stub
		return repo.findByVaccineNameInAndCostBetween(vaccines, startingCost, endingCost);
	}

	

}
