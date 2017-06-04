package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ClientDAO;
import domain.Client;
import domain.Commande;
@Repository
public class ClientDAOImpl implements ClientDAO , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1752070409474795749L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public Client getClientById(Long idClient) {

		Client client;
		client = sessionFactory.getCurrentSession().createNamedQuery("Client.getClientById", Client.class)
				.setParameter("idClient", idClient).getSingleResult();

		return client;
	}

	@Override
	public Client getClientByEmail(String Email) {

		Client client;

		client = sessionFactory.getCurrentSession().createNamedQuery("Client.getClientEmail", Client.class)
				.setParameter("email", Email).getSingleResult();
		return client;
	}

	@Override
	public Client getClientByTel(String telephone) {

		Client client;
		client = sessionFactory.getCurrentSession().createNamedQuery("Client.getClientByTelephone", Client.class)
				.setParameter("telephone", telephone).getSingleResult();

		return client;

	}

	@Override

	public Client getClientByCommande(Commande commande) {

		throw new java.lang.UnsupportedOperationException(
				"Méthode non implémente : " + "this.getClientByCommande(commande)");

	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clients;
		clients = sessionFactory.getCurrentSession().createNamedQuery("Client.getAll", Client.class).getResultList();

		return clients;
	}

	@Override
	public void updateClient(Client newClient) {
		sessionFactory.getCurrentSession().merge(newClient);
	}

	@Override

	public Client deleteClient(Client client) {

		sessionFactory.getCurrentSession().remove(client);

		return client;
	}

	@Override
	// @Interceptors(ClientInterceptor.class)
	public Client inserer(Client client) {

		sessionFactory.getCurrentSession().persist(client);
		client.setIdClient(client.getIdClient());

		return client;
	}

}
