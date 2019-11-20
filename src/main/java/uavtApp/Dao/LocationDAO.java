package uavtApp.Dao;

import java.util.List;


import uavtApp.entity.Location;

public interface LocationDAO {
	public List<Location> getLocationsAsList();
	public Location getLocation(String id);

}
