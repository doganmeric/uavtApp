package uavtApp.Dao;

import java.util.List;


import uavtApp.entity.Region;

public interface RegionDAO {
	public List<Region> getRegionsAsList();
	public Region getRegion(String id);
}
