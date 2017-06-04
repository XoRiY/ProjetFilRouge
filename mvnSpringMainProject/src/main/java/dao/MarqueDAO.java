package dao;

import java.util.List;

import domain.Marque;



public interface MarqueDAO {
	public abstract Marque insert(Marque marque);
	public abstract List<Marque> getAll();
	public abstract int desable(Marque marque);
	public abstract Marque getBy(String libelle);
	public abstract Marque getBy(Long id_marque);
	public abstract int enable(Marque marque);
	public abstract void update(Marque marque);
	public abstract void delete(Marque marque);
	public abstract List<String> searchMarque(String name);
	public abstract void delete(Long id);
}
