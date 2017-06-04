package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.AdresseDAO;
import domain.Adresse;
import domain.Client;
import domain.Commande;

@Repository("adresseDao")
public class AdresseDAOImpl implements AdresseDAO , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2325327862508328632L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<Adresse> getAdresseByClient(Client client) {

		List<Adresse> adresses;
		adresses = sessionFactory.getCurrentSession().createNamedQuery("Adresse.findByClient", Adresse.class).setParameter("client", client)
				.getResultList();

		return adresses;
	}

	@Override
	public List<Adresse> getAdresseByCommande(Commande commande) {
		List<Adresse> adresses;
		adresses = sessionFactory.getCurrentSession().createNamedQuery("Adresse.findByCommande", Adresse.class).setParameter("commande", commande)
				.getResultList();
		return adresses;
	}

	@Override
	public List<Adresse> getAllAdresse() {

		List<Adresse> adresses;
		adresses = sessionFactory.getCurrentSession().createNamedQuery("Adresse.getAll", Adresse.class).getResultList();

		return adresses;
	}

	@Override
	public Adresse insert(Adresse adresse) {
		sessionFactory.getCurrentSession().persist(adresse);
		return adresse;
	}

	@Override
	public Adresse updateAdresse(Adresse newAdresse) {
		
		Adresse a ;
		a = (Adresse ) sessionFactory.getCurrentSession().merge(newAdresse);

		return  a;
	}

	@Override
	public void deleteAdresse(Adresse adresse) {
		
		sessionFactory.getCurrentSession().remove(adresse);
	}

	@Override
	public Adresse getAdresseID(Long idADresse) {
			Adresse adresse;
			adresse = sessionFactory.getCurrentSession().find(Adresse.class, idADresse);
			return adresse ;
	}

}
