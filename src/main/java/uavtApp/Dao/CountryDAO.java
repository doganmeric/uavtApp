package uavtApp.Dao;

import java.util.List;

import uavtApp.entity.Country;




public interface CountryDAO {
	public List<Country> getCountriesAsList();
	public Country getCountry(String id);
}
