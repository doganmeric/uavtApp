package uavtApp.service;

import java.util.List;

import uavtApp.entity.Country;

public interface CountryService {
	public List<Country> getCountriesAsList();
	public Country getCountry(String id);
}
