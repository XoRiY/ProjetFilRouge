package dao;

import java.util.List;

import domain.Client;
import domain.Commande;


public interface CommandeDAO {

	public abstract Commande insererCommande(Commande commande);

	public abstract Commande getCommandByID(Long idCommande);

	public abstract List<Commande> getCommandeByClient(Client client);

	public abstract List<Commande> getAllCommande();
	
	public abstract void update(Commande commande);

	public abstract void annulerCommande(Commande commande);
	
	public abstract void delete(Commande commande);
	
	
}
