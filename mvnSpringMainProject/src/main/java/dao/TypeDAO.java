package dao;

import java.util.List;

import domain.Marque;
import domain.Type;



public interface TypeDAO {

	public abstract Type insert(Type r);

	public abstract List<Type> getAll();

	public abstract Type getBy(String libelle);

	public abstract Type getBy(Long id_type);

	public abstract void update(Type type);

	public abstract void delete(Type type);
	
	public abstract List<String> searchType(String name);

	public abstract  List<Type> getTypesByMarque(Marque marque);
	

}
