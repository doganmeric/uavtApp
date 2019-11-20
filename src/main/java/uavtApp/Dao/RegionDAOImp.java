package uavtApp.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




import uavtApp.entity.Region;

@Repository
public class RegionDAOImp implements RegionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Region> getRegionsAsList() {
		
		Session session = sessionFactory.getCurrentSession();		
		
		Query<Region> query = session.createQuery("from Region", Region.class);
		
		List<Region> regions = query.getResultList();
		return regions;
		
	}

	@Override
	public Region getRegion(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Region tempReg = (Region) session.get(Region.class, id);
		
		return tempReg;
	}

}
