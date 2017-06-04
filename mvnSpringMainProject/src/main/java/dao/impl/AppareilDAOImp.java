package dao.impl;

import java.io.Serializable;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.AppareilDAO;
import domain.Appareil;
import domain.Marque;
import domain.Type;


@Repository("appareilDAO")
public class AppareilDAOImp implements AppareilDAO , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8667824770051098857L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	//@Interceptors({AppareilInterceptor.class})
	public Appareil insert(Appareil appareil) {

		sessionFactory.getCurrentSession().persist(appareil);

		return appareil;

	}

	@Override
	//@Interceptors(ValidationInsertInterceptor.class)
	public List<Appareil> getBy(Marque marque, Type type) {

		List<Appareil> appareils;
		appareils = sessionFactory.getCurrentSession().createNamedQuery("Appareil.getBy_Marque_Type", Appareil.class)
				.setParameter("marque", marque).setParameter("type", type).getResultList();

		return appareils;
	}

	@Override
	public void delete(Appareil appareil) {
		sessionFactory.getCurrentSession().remove(appareil);
		

		

	}

	@Override
	public List<Appareil> getAll() {

		List<Appareil> appareils;
		appareils = sessionFactory.getCurrentSession().createNamedQuery("Appareil.getAll", Appareil.class).getResultList();

		return appareils;

	}


	@Override
	public Appareil getAppareilBy(Long idAppareil) {
		

		
		Appareil appareil;

		appareil = sessionFactory.getCurrentSession().find(Appareil.class, idAppareil);

		return appareil;

	}

	@Override
	public Appareil getAppareilBy(String ref_Model) {

		Appareil appareil;

		appareil = (Appareil) sessionFactory.getCurrentSession().createNamedQuery("Appareil.getByRef").setParameter("referenceAppareil", ref_Model)
				.getSingleResult();

		return appareil;

	}

	@Override
	public List<Appareil> getAppareilBy(Marque marque) {
		List<Appareil> appareils;
		appareils = sessionFactory.getCurrentSession().createQuery("select app from Appareil as app where app.marque =:marque", Appareil.class)
				.setParameter("marque", marque).getResultList();
		return appareils;
	}

	@Override
	public List<Appareil> getAppareilBy(Type type) {
		List<Appareil> appareils;
		appareils = sessionFactory.getCurrentSession().createQuery("select app from Appareil as app where app.type =:type", Appareil.class)
				.setParameter("type", type).getResultList();
		return appareils;
	}

	@Override
	public List<String> searchAppareil(String reference) {
	
			String query = "select app.referenceAppareil from Appareil as app where app.referenceAppareil like :ref";
			List<String> referencesStrings;
			referencesStrings = sessionFactory.getCurrentSession().createQuery(query, String.class).setParameter("ref", reference+"%").getResultList();
			return referencesStrings;
		
	}

	@Override
	public void updateAppareil(Appareil appareil) {
		sessionFactory.getCurrentSession().merge(appareil);
	}
	
}
