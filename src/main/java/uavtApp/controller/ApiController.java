package uavtApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import uavtApp.entity.Country;
import uavtApp.entity.Location;
import uavtApp.entity.Region;
import uavtApp.service.CountryService;
import uavtApp.service.LocationService;
import uavtApp.service.RegionService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	RegionService regionService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	CountryService countryService;
	
	
	@GetMapping("/regions")
	public List<Region> getRegions(){
		
		return regionService.getRegionsAsList();
	}
	@GetMapping("/countries")
	public List<Country> getCountries(){
		
		return countryService.getCountriesAsList();
	}
	@GetMapping("locations")
	public List<Location> getLocations(){
		
		return locationService.getLocationsAsList();
	}
	
	@GetMapping("/region/{id}")
	public List<Country> getRegionCountries(@PathVariable String id){
		//Region tempReg=regionService.getRegion(id);
		List<Country> countryList = countryService.getCountriesAsList();
		List<Country> tempList = new ArrayList<Country>();
		countryList.forEach(country->{
			if(country.getRegionId().equals(id))
				tempList.add(country);
		});
		if(tempList.size()==0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Doesn't have any Countries");
		return tempList;
	}
	@GetMapping("/country/{id}")
	public List<Location> getCountryLocations(@PathVariable String id){
		
		String upperId=id.toUpperCase(Locale.ROOT);
		
		List<Location> locationList = locationService.getLocationsAsList();
		List<Location> tempList = new ArrayList<Location>();
		locationList.forEach(location->{
			
			if(location.getCountryId().equals(upperId))
				tempList.add(location);
		});
		if(tempList.size()==0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Doesn't have any location");
		return tempList;
	}
	
	@GetMapping("/location/{id}")
	public Location getLocationDetails(@PathVariable String id){
		//Region tempReg=regionService.getRegion(id);
		
		return locationService.getLocation(id);
	}

}
