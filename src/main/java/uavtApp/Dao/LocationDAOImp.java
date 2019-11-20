package uavtApp.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uavtApp.entity.Location;


@Repository
public class LocationDAOImp implements LocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Location> getLocationsAsList() {
		Session session = sessionFactory.getCurrentSession();		
		
		Query<Location> query = session.createQuery("from Location", Location.class);
		
		List<Location> locations = query.getResultList();
		return locations;
	}

	@Override
	public Location getLocation(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Location tempLoc = (Location) session.get(Location.class, id);
		
		return tempLoc;
	}

}
