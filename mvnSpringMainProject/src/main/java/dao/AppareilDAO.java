package dao;

import java.util.List;




import domain.Appareil;
import domain.Marque;
import domain.Type;

public interface AppareilDAO {

	public abstract Appareil insert( Appareil appareil);

	public abstract List<Appareil> getBy(Marque marque, Type type);

	public abstract void delete(Appareil appareil);

	public abstract List<Appareil> getAll();

	public abstract Appareil getAppareilBy(Long idAppareil);

	public abstract Appareil getAppareilBy(String referenceAppareil);
	
	public abstract List<Appareil> getAppareilBy(Marque marque);

	public abstract List<Appareil> getAppareilBy(Type type);
	
	public abstract List<String> searchAppareil(String reference);

	public abstract void updateAppareil(Appareil appareil);
	
}
