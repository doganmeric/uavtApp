package uavtApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uavtApp.Dao.RegionDAO;
import uavtApp.entity.Region;

@Service
public class RegionServiceImp implements RegionService {
	
	@Autowired
	RegionDAO regionDAO;
	
	@Override
	@Transactional
	public List<Region> getRegionsAsList() {
		
		return regionDAO.getRegionsAsList();
	}

	@Override
	@Transactional
	public Region getRegion(String id) {
		
		return regionDAO.getRegion(id);
	}

}
