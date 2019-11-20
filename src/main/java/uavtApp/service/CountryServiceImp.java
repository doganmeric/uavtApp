package uavtApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uavtApp.Dao.CountryDAO;
import uavtApp.entity.Country;

@Service
public class CountryServiceImp implements CountryService {
	
	@Autowired
	CountryDAO countryDAO;
	
	@Override
	@Transactional
	public List<Country> getCountriesAsList() {
		
		return countryDAO.getCountriesAsList();
	}

	@Override
	@Transactional
	public Country getCountry(String id) {
		
		return countryDAO.getCountry(id);
	}

}
