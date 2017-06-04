package dao;

import java.util.List;


import domain.*;

public interface DocumentDAO {

	public abstract Document get(int idDoc, String refPi);

	public abstract List<Document> getBy(Piece p);

	public abstract Document insert(Document d, Piece piOrigine);

	public abstract int delete(Document d);

	public abstract List<Document> getBy(String ref_piece);

	public Document get(Long idDoc);

}
