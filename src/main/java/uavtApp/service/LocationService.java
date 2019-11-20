package uavtApp.service;

import java.util.List;

import uavtApp.entity.Location;

public interface LocationService {
	public List<Location> getLocationsAsList();
	public Location getLocation(String id);
}
