package dao;

import java.util.List;

import domain.Adresse;
import domain.Client;
import domain.Commande;


public interface AdresseDAO {
	
	
	public abstract Adresse getAdresseID(Long idADresse);
	
	public abstract List<Adresse> getAdresseByClient(Client client);

	public abstract List<Adresse> getAdresseByCommande(Commande commande);

	public abstract List<Adresse> getAllAdresse();

	public abstract Adresse insert(Adresse adresse);

	public abstract Adresse updateAdresse(Adresse newAdresse);

	public abstract void deleteAdresse(Adresse adresse);
	

}
