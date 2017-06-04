package dao;

import java.util.List;

import domain.Commande;
import domain.LigneDeCommande;

public interface LigneDeCommandesDAO {
	
	
	public abstract LigneDeCommande insererLigneDeCommande(LigneDeCommande ligneDeCommande);

	public abstract LigneDeCommande getLigneDeCommandeByID(Long idLigneDeCommande);

	public abstract List<LigneDeCommande> getLigneDeCommandeByCommande(Commande commande);

	public abstract List<LigneDeCommande> getAllLigneDeCommande();
	
	public abstract void update(LigneDeCommande ligneDeCommande);

	public abstract void deleteLigneDeCommande(LigneDeCommande ligneDeCommande);

}
