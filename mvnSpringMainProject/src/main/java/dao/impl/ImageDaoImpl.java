package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ImageDAO;
import domain.Image;
import domain.Piece;
@Repository
public class ImageDaoImpl implements ImageDAO , Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2163347267850347648L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public List<Image> getBy(Piece piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public List<Image> getBy(String ref_piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public Image insert(Image image) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int delete(Image image) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public Image get(Long idImage) {
		throw new UnsupportedOperationException("not implemented yet");
	}
	
	


}
