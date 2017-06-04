package dao;

import java.util.List;


import domain.Categorie;

public interface CategorieDAO {

	public abstract Categorie insert(Categorie categorie);

	public abstract List<Categorie> getAllCategorie();

	public abstract void delete(Categorie categorie);

	public abstract Categorie getBy(String libelle);

	public abstract void update(Categorie categorie);
	
	public abstract Categorie getBy(Long idCategorie);
	
}
