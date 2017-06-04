package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.LigneDeCommandesDAO;
import domain.Commande;
import domain.LigneDeCommande;

@Repository
public class LigneDeCommandeDAOImpl implements LigneDeCommandesDAO , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7669021959699342199L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public LigneDeCommande insererLigneDeCommande(LigneDeCommande ligneDeCommande) {
		sessionFactory.getCurrentSession().persist(ligneDeCommande);
		return ligneDeCommande;
	}

	@Override
	public LigneDeCommande getLigneDeCommandeByID(Long idLigneDeCommande) {

		LigneDeCommande ligneDeCommande;

		ligneDeCommande = sessionFactory.getCurrentSession().find(LigneDeCommande.class, idLigneDeCommande);

		return ligneDeCommande;
	}

	@Override
	public List<LigneDeCommande> getLigneDeCommandeByCommande(Commande commande) {

		String sql;
		sql = "select lCommande from LigneDeCommande as lCommande where Commande =:commande";

		List<LigneDeCommande> ligneDeCommandes;
		ligneDeCommandes = sessionFactory.getCurrentSession().createQuery(sql, LigneDeCommande.class)
				.setParameter("commande", commande).getResultList();

		return ligneDeCommandes;
	}

	@Override
	public List<LigneDeCommande> getAllLigneDeCommande() {

		String sql;
		sql = "from LigneDeCommande";

		List<LigneDeCommande> ligneDeCommandes;
		
		ligneDeCommandes = sessionFactory.getCurrentSession().createQuery(sql, LigneDeCommande.class).getResultList();

		return ligneDeCommandes;

	}

	@Override
	public void update(LigneDeCommande ligneDeCommande) {

		sessionFactory.getCurrentSession().merge(ligneDeCommande);

	}

	@Override
	public void deleteLigneDeCommande(LigneDeCommande ligneDeCommande) {

		sessionFactory.getCurrentSession().delete(ligneDeCommande);

	}

}
