package uavtApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uavtApp.Dao.LocationDAO;
import uavtApp.entity.Location;

@Service
public class LocationServiceImp implements LocationService {
	
	@Autowired
	LocationDAO locationDAO;
	
	@Override
	@Transactional
	public List<Location> getLocationsAsList() {
		
		return locationDAO.getLocationsAsList();
	}

	@Override
	@Transactional
	public Location getLocation(String id) {
		
		return locationDAO.getLocation(id);
	}

}
