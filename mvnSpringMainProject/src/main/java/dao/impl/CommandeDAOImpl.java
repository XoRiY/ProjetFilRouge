package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CommandeDAO;
import domain.Client;
import domain.Commande;


@Repository
public class CommandeDAOImpl implements CommandeDAO , Serializable {

	private static Logger logger = Logger.getLogger(CommandeDAOImpl.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8921178232063761048L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Commande insererCommande(Commande commande) {
		commande.confirmer();
		sessionFactory.getCurrentSession().persist(commande);
		return commande;

	}

	@Override
	public Commande getCommandByID(Long idCommande) {

		Commande commande;
		commande = sessionFactory.getCurrentSession().createQuery("select commande From Commande commande where commande.idCommande=:idCommande",
				Commande.class).setParameter("idCommande", idCommande).getSingleResult();
		if (commande == null) {
			logger.info("null");
			throw new ObjectNotFoundException("" + idCommande, "Aucun objet trouvé avec cet identifiant :");
		}
		
		
		return commande;
	}

	@Override
	public List<Commande> getCommandeByClient(Client client) {

		List<Commande> commandes;
		commandes = sessionFactory.getCurrentSession()
				.createQuery("select commande From Commande commande where commande.client=:client", Commande.class)
				.setParameter("client", client).getResultList();

		return commandes;
	}

	@Override
	public List<Commande> getAllCommande() {

		List<Commande> commandes;
		commandes = sessionFactory.getCurrentSession().createQuery("select commande From Commande commande", Commande.class).getResultList();

		return commandes;
	}

	@Override
	public void annulerCommande(Commande commande) {
		throw new java.lang.UnsupportedOperationException("not implementer yet)");
	}

	@Override
	public void update(Commande commande) {
		
		sessionFactory.getCurrentSession().merge(commande);
		
	}

	@Override
	public void delete(Commande commande) {
		sessionFactory.getCurrentSession().delete(commande);
	}

}
