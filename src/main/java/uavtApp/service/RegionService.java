package uavtApp.service;

import java.util.List;

import uavtApp.entity.Region;

public interface RegionService {
	public List<Region> getRegionsAsList();
	public Region getRegion(String id);
}
