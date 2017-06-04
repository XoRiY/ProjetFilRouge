package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CategorieDAO;
import domain.Categorie;
@Repository
public class CategorieDAOImpl implements CategorieDAO , Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7155068496365547716L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	//@Interceptors({CategorieInterceptor.class})
	public Categorie insert(Categorie categorie) {

		sessionFactory.getCurrentSession().persist(categorie);

		return categorie;
	}

	@Override
	public List<Categorie> getAllCategorie() {

		List<Categorie> categories;
		categories = sessionFactory.getCurrentSession().createNamedQuery("Categorie.getAll", Categorie.class).getResultList();

		return categories;
	}

	@Override
	public Categorie getBy(String libelle) {

		Categorie categorie;
		categorie = (Categorie) sessionFactory.getCurrentSession().createNamedQuery("Categorie.getByLibelle").setParameter("libelle", libelle)
				.getSingleResult();

		return categorie;
	}

	@Override
	public void update(Categorie categorie) {

		 sessionFactory.getCurrentSession().merge(categorie);
		 
	}

	@Override
	public Categorie getBy(Long idCategorie) {

		Categorie categorie;
		categorie = sessionFactory.getCurrentSession().find(Categorie.class, idCategorie);
		return categorie;
	}

	@Override
	public void delete(Categorie categorie) {

	 sessionFactory.getCurrentSession().remove(categorie);

	
	}

}
