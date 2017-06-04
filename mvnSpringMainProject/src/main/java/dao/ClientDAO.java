package dao;

import java.util.List;


import domain.Client;
import domain.Commande;

public interface ClientDAO {

	public abstract Client getClientById(Long idClient);

	public abstract Client getClientByEmail(String Email);

	public abstract Client getClientByTel(String Telephone);
	
	public abstract Client getClientByCommande(Commande commande);

	public abstract List<Client> getAllClients();
	
	public abstract void updateClient(Client newClient);
	
	public abstract Client deleteClient(Client client);
	
	public abstract Client inserer(Client client);

}
