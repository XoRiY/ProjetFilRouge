package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.DocumentDAO;
import domain.Document;
import domain.Piece;
@Repository
public class DocumentDAOImpl implements DocumentDAO , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2212284746891939520L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Override
	public Document get(int idDoc, String refPi) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public List<Document> getBy(Piece p) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public Document insert(Document d, Piece piOrigine) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int delete(Document d) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public List<Document> getBy(String ref_piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public Document get(Long idDoc) {
		throw new UnsupportedOperationException("not implemented yet");
	}

}
