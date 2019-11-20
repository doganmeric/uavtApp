package uavtApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		countryList.forEach(country->{
			if(country.getRegionId().equals(id))
				countryList.remove(country);
		});
		return countryList;
	}
	@GetMapping("/country/{id}")
	public List<Location> getCountryLocations(@PathVariable String id){
		
		List<Location> locationList = locationService.getLocationsAsList();
		
		locationList.forEach(location->{
			if(location.getLocationId().equals(id))
				locationList.remove(location);
		});
		return locationList;
	}
	
	@GetMapping("/location/{id}")
	public Location getLocationDetails(@PathVariable String id){
		//Region tempReg=regionService.getRegion(id);
		
		return locationService.getLocation(id);
	}

}
