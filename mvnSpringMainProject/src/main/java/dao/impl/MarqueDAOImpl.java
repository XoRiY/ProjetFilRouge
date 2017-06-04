package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.MarqueDAO;
import domain.Marque;

@Repository
public class MarqueDAOImpl implements MarqueDAO, Serializable {

	private static final long serialVersionUID = -7764244340267729555L;

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Marque insert(Marque m) {
		sessionFactory.getCurrentSession().persist(m);
		return m;
	}

	@Override
	public List<Marque> getAll() {

		List<Marque> marques = sessionFactory.getCurrentSession().createNamedQuery("Marque.getAll", Marque.class)
				.getResultList();

		return marques;
	}

	@Override
	public int desable(Marque marque) {
		return sessionFactory.getCurrentSession().createNamedQuery("Marque.desable").setParameter("marque", marque)
				.executeUpdate();
	}

	@Override
	public int enable(Marque marque) {

		return sessionFactory.getCurrentSession().createNamedQuery("Marque.enable").setParameter("marque", marque)
				.executeUpdate();

	}

	@Override
	public Marque getBy(String libelle) {

		Marque m = sessionFactory.getCurrentSession().createNamedQuery("Marque.getByMarque", Marque.class)
				.setParameter("libelle", libelle).getSingleResult();
		if (m == null) {
			throw new ObjectNotFoundException("" + libelle, "Aucun objet trouvé avec cet identifiant :");
		}
		return m;

	}

	@Override
	public void update(Marque marque) {

		sessionFactory.getCurrentSession().merge(marque);

	}

	@Override
	public Marque getBy(Long idMarque) {

		Marque m = sessionFactory.getCurrentSession().find(Marque.class, idMarque);
		if (m == null) {
			throw new ObjectNotFoundException("" + idMarque, "Aucun objet trouvé avec cet identifiant :");
		}
		return m;
	}

	@Override
	public void delete(Marque marque) {

		sessionFactory.getCurrentSession().remove(marque);

	}

	@Override
	public List<String> searchMarque(String marque) {
		String query = "select m.marque from Marque m where m.marque like :marque";
		List<String> marqueString;
		marqueString = sessionFactory.getCurrentSession().createQuery(query, String.class)
				.setParameter("marque", marque + "%").getResultList();
		return marqueString;
	}

	@Override
	public void delete(Long id) {

		sessionFactory.getCurrentSession().remove(id);

	}

	// @Override
	// public Marque insert(Marque marque) {
	// sessionFactory.getCurrentSession().persist(marque);
	// return marque;
	// }
	//
	// @Override
	// public List<Marque> getAll() {
	// return
	// sessionFactory.getCurrentSession().createNamedQuery("Marque.getAll",
	// Marque.class).list();
	// }
	//
	// @Override
	// public int desable(Marque marque) {
	// return
	// sessionFactory.getCurrentSession().createNamedQuery("Marque.desable").setParameter("marque",
	// marque).executeUpdate();
	// }
	//
	// @Override
	// public Marque getBy(String libelle) {
	// return
	// sessionFactory.getCurrentSession().createNamedQuery("Marque.getByMarque",
	// Marque.class).setParameter("libelle", libelle).getSingleResult();
	//
	// }
	//
	// @Override
	// public Marque getBy(Long id_marque) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public int enable(Marque marque) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int update(String oldMarque, String newMarque) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public int delete(Marque marque) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public List<String> searchMarque(String name) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public void delete(Long id) {
	// // TODO Auto-generated method stub
	//
	// }

}
