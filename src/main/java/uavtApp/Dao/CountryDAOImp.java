package uavtApp.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uavtApp.entity.Country;


@Repository
public class CountryDAOImp implements CountryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Country> getCountriesAsList() {
		Session session = sessionFactory.getCurrentSession();		
		
		Query<Country> query = session.createQuery("from Country", Country.class);
		
		List<Country> countries = query.getResultList();
		return countries;
	}

	@Override
	public Country getCountry(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Country tempCoun = (Country) session.get(Country.class, id);
		
		return tempCoun;
	}

}
