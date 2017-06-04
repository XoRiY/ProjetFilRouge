package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.TypeDAO;
import domain.Marque;
import domain.Type;

@Repository("typeDao")
public class TypeDAOImpl implements TypeDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345019167951497184L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	// @Interceptors({ TypeInterceptor.class })
	public Type insert(Type type) {

		sessionFactory.getCurrentSession().persist(type);
		return type;
	}

	@Override
	public List<Type> getAll() {

		List<Type> types;
		types = sessionFactory.getCurrentSession().createNamedQuery("Type.getAll", Type.class).getResultList();

		return types;
	}

	@Override
	public Type getBy(String libelle) {

		Type type;
		type = sessionFactory.getCurrentSession().createNamedQuery("Type.getByType", Type.class)
				.setParameter("type", libelle).getSingleResult();

		return type;

	}

	@Override
	public void update(Type type) {

		sessionFactory.getCurrentSession().merge(type);

	}

	@Override
	public Type getBy(Long id_type) {

		Type type;
		type = sessionFactory.getCurrentSession().find(Type.class, id_type);
		return type;
	}

	@Override
	public void delete(Type type) {

		sessionFactory.getCurrentSession().remove(type);

	}

	@Override
	public List<String> searchType(String typeString) {
		String query = "select t.type from Type t where t.type like :type";
		List<String> marqueString;
		marqueString = sessionFactory.getCurrentSession().createQuery(query, String.class)
				.setParameter("type", typeString + "%").getResultList();
		return marqueString;
	}

	@Override
	// @Interceptors({TrieTypeInterceptors.class})
	public List<Type> getTypesByMarque(Marque marque) {

		List<Type> types;
		types = sessionFactory.getCurrentSession().createNamedQuery("Type.getAll", Type.class).getResultList();
		return types;
	}

}
