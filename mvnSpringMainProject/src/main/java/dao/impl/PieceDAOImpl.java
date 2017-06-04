package dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.PieceDAO;
import domain.Categorie;

import domain.Appareil;
import domain.Piece;

@Repository
public class PieceDAOImpl implements PieceDAO , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5683465299807840622L;
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	//@Interceptors({ PieceIntercepteur.class })
	public Piece insert(Piece piece) {

		sessionFactory.getCurrentSession().persist(piece);

		return piece;
	}

	@Override
	public List<Piece> getAll() {
		List<Piece> pieces;

		pieces = sessionFactory.getCurrentSession().createQuery("Select piece from Piece piece", Piece.class).getResultList();

		return pieces;
	}

	@Override
	public List<Piece> getAllBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = new ArrayList<>();
		
		for (Piece piece : getOriginesBy(appareil, categorie)) {
			if (!pieces.contains(piece)) {
				pieces.add(piece);
			}
		}
		for (Piece piece : getEquivalentesBy(appareil, categorie)) {
			if (!pieces.contains(piece)) {
				pieces.add(piece);
			}
		}
		
		return pieces;
	}

	@Override
	public List<Piece> getOriginesBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = sessionFactory.getCurrentSession()
				.createQuery(
						"select piece from Piece as piece join piece.appareils as app where app=:appareil and piece.categorie =:categorie",
						Piece.class)
				.setParameter("categorie", categorie).setParameter("appareil", appareil).getResultList();
		return pieces;
	}

	
	@Override
	public List<Piece> getEquivalentesBy(Appareil appareil, Categorie categorie) {
		// "SELECT piece From Piece piece join piece.pieceEquivalentes pcsE join
		// Piece pieceO join pieceO.Appareils app where app=:appareil and
		// piece.categorie=:categorie",
		// "SELECT pieceE FROM Piece pieceE JOIN Piece pieceO JOIN
		// pieceO.appareils app where app =:appareil where pieceE.categorie
		// =:categorie",

		/*
		 * SELECT DISTINCT mag FROM Magazine mag, IN(mag.articles) art WHERE
		 * art.author.lastName = 'Grisham'
		 */
		List<Piece> pieces;
		pieces = sessionFactory.getCurrentSession()
				.createNativeQuery(
						"SELECT DISTINCT A.* FROM `PIECES` AS A JOIN  (`PIECES` AS B, `INSTALLER` AS C )	ON ( B.`ID_PIECE` = A.`ID_PIECE_ORIGINE` OR B.`ID_PIECE` = C.`ID_PIECE`) WHERE A.`ID_CATEGORIE`=:categorie AND C.`ID_APPAREIL` =:appareil AND A.`TYPE_PIECE` = 'EQUIVALENTE'",
						Piece.class)
				.setParameter("categorie", categorie).setParameter("appareil", appareil).getResultList();
		return pieces;
	}

	@Override
	public List<Piece> getOriginesBy(Categorie ca) {

		List<Piece> pieces = sessionFactory.getCurrentSession()
				.createQuery("select p FROM Piece as p where p.categorie=:categorie and p.pieceOrigine is null",
						Piece.class)
				.setParameter("categorie", ca).getResultList();

		return pieces;
	}

	@Override
	public List<Piece> getOriginesBy(Appareil appareil) {

		List<Piece> pieces;
		pieces = sessionFactory.getCurrentSession().createQuery("select p FROM Piece as p join p.appareils as m where m=:appareil", Piece.class)
				.setParameter("appareil", appareil).getResultList();

		return pieces;
	}

	/*
	 * getallpieceby appareils
	 * 
	 * 
	 */
	@Override
	public List<Piece> getEquivalentesBy(Piece pieceOrigine) {
		List<Piece> pieces;
		pieces = sessionFactory.getCurrentSession()
				.createQuery("SELECT pieceE FROM Piece AS pieceE WHERE pieceE.pieceOrigine =:pieceOrigine", Piece.class)
				.setParameter("pieceOrigine", pieceOrigine).getResultList();

		return pieces;
	}

	@Override
	public void associe(Piece piOrigine, Appareil mo) {
		throw new UnsupportedOperationException("Not implemented Yet : ");
	}

	@Override
	public Piece getPieceById(Long idPiece) {
		Piece piece;
		piece = sessionFactory.getCurrentSession().find(Piece.class, idPiece);
		return piece;
	}

	@Override
	public Piece getPieceBy(String ref_piece) {

		Piece piece;
		piece = (Piece) sessionFactory.getCurrentSession().createNamedQuery("Piece.getByRef").setParameter("reference", ref_piece).getSingleResult();

		return piece;
	}

	@Override
	public void delete(Piece piece) {

		sessionFactory.getCurrentSession().remove(piece);
	}

	@Override
	public void update(Piece newPiece) {
		sessionFactory.getCurrentSession().merge(newPiece);

	}

	@Override
	public List<Piece> getEquivalentesBy(Categorie categorie) {

		List<Piece> pieces;
		pieces = (List<Piece>) sessionFactory.getCurrentSession().createQuery(
				"SELECT piece FROM Piece AS piece where piece.categorie =:categorie and piece.pieceOrigine is not null",
				Piece.class).setParameter("categorie", categorie).getResultList();

		return pieces;
	}

	@Override
	public List<Piece> getEquivalentesBy(Appareil appareil) {

		List<Piece> pieces;
		pieces = sessionFactory.getCurrentSession().createQuery(
				"select p FROM Piece as p join p.appareils as m join p.pieceEquivalentes as p where m=:appareil",
				Piece.class).setParameter("appareil", appareil).getResultList();

		return pieces;
		/*
		 * "SELECT DISTINCT A.* FROM `PIECES` AS A JOIN  (`PIECES` AS B, `INSTALLER` AS C ) ON ( B.`ID_PIECE` = A.`ID_PIECE_ORIGINE` AND B.`ID_PIECE` = C.`ID_PIECE`) AND C.`ID_APPAREIL` =:appareil AND A.`TYPE_PIECE` = 'EQUIVALENTE';"
		 * //"SELECT pieceE FROM Piece AS pieceE JOIN Piece AS pieceO ON pieceE.pieceOrigine = pieceO JOIN pieceO.appareils as app ON app =:appareil"
		 * ,
		 */

	}

	@Override
	public List<Piece> getAllBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = new ArrayList<>();
		pieces.addAll(getOriginesBy(appareil));
		pieces.addAll(getEquivalentesBy(appareil));

		return pieces;
	}

	@Override
	public List<Piece> getAllBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = new ArrayList<>();
		pieces.addAll(getOriginesBy(categorie));
		pieces.addAll(getEquivalentesBy(categorie));
		return pieces;
	}

}
