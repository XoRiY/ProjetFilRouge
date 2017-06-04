package services;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.*;
import dao.LigneDeCommandesDAO;
import dao.MarqueDAO;
import dao.TypeDAO;
import dao.impl.AdresseDAOImpl;
import dao.impl.AppareilDAOImp;
import dao.impl.CategorieDAOImpl;
import dao.impl.ClientDAOImpl;
import dao.impl.CommandeDAOImpl;
import dao.impl.DocumentDAOImpl;
import dao.impl.PieceDAOImpl;

@Service("monService")
@Transactional
public class SpringServices implements MonService, Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -8778427171907119573L;

	@Autowired
	private MarqueDAO marqueDAO;

	@Autowired
	private AdresseDAOImpl adresseDAO;

	@Autowired
	private AppareilDAOImp appareilDAO;

	@Autowired
	private CategorieDAOImpl categorieDAO;

	@Autowired
	private ClientDAOImpl clientDAO;

	@Autowired
	private CommandeDAOImpl commandeDAO;

	@Autowired
	private DocumentDAOImpl documentDAO;

	@Autowired
	private PieceDAOImpl pieceDAO;

	@Autowired
	private TypeDAO typeDAO;

	@Autowired
	private LigneDeCommandesDAO ligneDeCommandesDAO;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MarqueDAO getMarqueDAO() {
		return marqueDAO;
	}

	public AdresseDAOImpl getAdresseDAO() {
		return adresseDAO;
	}

	public AppareilDAOImp getAppareilDAO() {
		return appareilDAO;
	}

	public CategorieDAOImpl getCategorieDAO() {
		return categorieDAO;
	}

	public ClientDAOImpl getClientDAO() {
		return clientDAO;
	}

	public CommandeDAOImpl getCommandeDAO() {
		return commandeDAO;
	}

	public DocumentDAOImpl getDocumentDAO() {
		return documentDAO;
	}

	public PieceDAOImpl getPieceDAO() {
		return pieceDAO;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public LigneDeCommandesDAO getLigneDeCommandesDAO() {
		return ligneDeCommandesDAO;
	}

	public void setMarqueDAO(MarqueDAO marqueDAO) {
		this.marqueDAO = marqueDAO;
	}

	public void setAdresseDAO(AdresseDAOImpl adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	public void setAppareilDAO(AppareilDAOImp appareilDAO) {
		this.appareilDAO = appareilDAO;
	}

	public void setCategorieDAO(CategorieDAOImpl categorieDAO) {
		this.categorieDAO = categorieDAO;
	}

	public void setClientDAO(ClientDAOImpl clientDAO) {
		this.clientDAO = clientDAO;
	}

	public void setCommandeDAO(CommandeDAOImpl commandeDAO) {
		this.commandeDAO = commandeDAO;
	}

	public void setDocumentDAO(DocumentDAOImpl documentDAO) {
		this.documentDAO = documentDAO;
	}

	public void setPieceDAO(PieceDAOImpl pieceDAO) {
		this.pieceDAO = pieceDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public void setLigneDeCommandesDAO(LigneDeCommandesDAO ligneDeCommandesDAO) {
		this.ligneDeCommandesDAO = ligneDeCommandesDAO;
	}

	/****************************************************/
	/******************* Adresse ***********************/
	/****************************************************/

	@Override
	public List<Adresse> getAdresseByClient(Client client) {
		List<Adresse> adresses;
		adresses = adresseDAO.getAdresseByClient(client);
		return adresses;
	}

	@Override
	public List<Adresse> getAdresseByCommande(Commande commande) {
		List<Adresse> adresses;
		adresses = adresseDAO.getAdresseByCommande(commande);
		return adresses;
	}

	@Override
	public List<Adresse> getAllAdresse() {
		List<Adresse> adresses;
		adresses = adresseDAO.getAllAdresse();
		return adresses;
	}

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Adresse insertAdresse(Adresse adresse) {

		return adresseDAO.insert(adresse);

	}

	@Override
	public Adresse updateAdresse(Adresse newAdresse) {
		Adresse a;
		a = adresseDAO.updateAdresse(newAdresse);
		return a;
	}

	@Override
	public int deleteAdresse(Adresse adresse) {
		adresseDAO.deleteAdresse(adresse);
		return 0;

	}

	public Adresse getAdresseID(Long idADresse) {
		Adresse adresse;
		adresse = adresseDAO.getAdresseID(idADresse);
		return adresse;
	}

	/****************************************************/
	/******************* Appareil ***********************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Appareil insertAppareil(Appareil appareil) {
		Appareil appareilPersist;
		appareilPersist = appareilDAO.insert(appareil);
		return appareilPersist;
	}

	@Override
	public List<Appareil> getByAppareil(Marque marque, Type type) {
		List<Appareil> appareils;
		appareils = appareilDAO.getBy(marque, type);
		return appareils;
	}

	@Override
	public void deleteAppareil(Appareil appareil) {

		appareilDAO.delete(appareil);

	}

	@Override
	public List<Appareil> getAllAppareil() {
		List<Appareil> appareils;
		appareils = appareilDAO.getAll();
		return appareils;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Appareil getAppareilBy(Long idAppareil) {

		Appareil appareil;
		appareil = appareilDAO.getAppareilBy(idAppareil);
		return appareil;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Appareil getAppareilBy(String referenceAppareil) {
		Appareil appareil;
		appareil = appareilDAO.getAppareilBy(referenceAppareil);
		return appareil;
	}

	@Override
	public void updateAppareil(Appareil appareil) {
		appareilDAO.updateAppareil(appareil);
	}

	@Override
	public List<Appareil> getAppareilByMarque(Marque marque) {
		List<Appareil> appareils;
		appareils = appareilDAO.getAppareilBy(marque);
		return appareils;

	}

	@Override
	public List<Appareil> getAppareilByType(Type type) {
		List<Appareil> appareils;
		appareils = appareilDAO.getAppareilBy(type);
		return appareils;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public List<String> searchAppareil(String reference) {
		List<String> appareils;
		appareils = appareilDAO.searchAppareil(reference);
		return appareils;
	}

	/****************************************************/
	/******************* Categorie **********************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Categorie insertCategorie(Categorie categorie) {
		return categorieDAO.insert(categorie);

	}

	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie> categories;
		categories = categorieDAO.getAllCategorie();
		return categories;
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		
		 categorieDAO.delete(categorie);
		
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Categorie getCategorieBy(String libelle) {
		Categorie categorie;
		categorie = categorieDAO.getBy(libelle);
		return categorie;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void updateCategorie(Categorie categorie) {

		categorieDAO.update(categorie);
		
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Categorie getCategorieBy(Long idCategorie) {
		Categorie categorie;
		categorie = categorieDAO.getBy(idCategorie);
		return categorie;
	}

	/****************************************************/
	/******************* Client ***********************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Client getClientById(Long idClient) {
		Client client;
		client = clientDAO.getClientById(idClient);
		return client;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Client getClientByEmail(String Email) {
		Client client;
		client = clientDAO.getClientByEmail(Email);
		return client;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Client getClientByTel(String Telephone) {
		Client client;
		client = clientDAO.getClientByTel(Telephone);
		return client;
	}

	@Override
	public Client getClientByCommande(Commande commande) {
		Client client;
		client = clientDAO.getClientByCommande(commande);
		return client;
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clients;
		clients = clientDAO.getAllClients();
		return clients;
	}

	@Override
	public void updateClient(Client newClient) {

		clientDAO.updateClient(newClient);

	}

	@Override
	public Client deleteClient(Client client) {
		Client c = clientDAO.deleteClient(client);
		return c;
	}

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Client insertClient(Client client) {
		Client clientPersist;
		clientPersist = clientDAO.inserer(client);
		return clientPersist;
	}

	/****************************************************/
	/******************* Commande ***********************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Commande insererCommande(Commande commande) {
		Commande commandepersist;
		commandepersist = commandeDAO.insererCommande(commande);
		return commandepersist;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Commande getCommandByID(Long idCommande) {
		Commande commande;
		commande = commandeDAO.getCommandByID(idCommande);
		return commande;
	}

	@Override
	public List<Commande> getCommandeByClient(Client client) {
		List<Commande> commandes;
		commandes = commandeDAO.getCommandeByClient(client);
		return commandes;
	}

	@Override
	public List<Commande> getAllCommande() {
		List<Commande> commandes;
		commandes = commandeDAO.getAllCommande();
		return commandes;
	}

	@Override
	public void update(Commande commande) {
		commandeDAO.update(commande);
	}

	@Override
	public void annulerCommande(Commande commande) {

		commandeDAO.annulerCommande(commande);
	}

	@Override
	public void ValiderCommande(Commande commande, Client client) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public void deleteCommande(Commande commande) {

		commandeDAO.delete(commande);
	}

	/****************************************************/
	/******************* Marque ***********************/
	/****************************************************/

	@Override
	// @Interceptors({ LogInterceptors.class
	// ,ValidationInsertInterceptor.class})
	public Marque insertMarque(Marque marque) {
		Marque marquePersist;
		marquePersist = marqueDAO.insert(marque);
		return marquePersist;
	}

	@Override
	public List<Marque> getAllMarques() {
		List<Marque> marques;
		marques = marqueDAO.getAll();
		return marques;
	}

	@Override
	public int desableMarque(Marque r) {
		int i;
		i = marqueDAO.desable(r);
		return i;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Marque getMarqueBy(String libelle) {
		Marque marque;
		marque = marqueDAO.getBy(libelle);
		return marque;
	}

	@Override
	// @Interceptors({ValidationParametersInterceptor.class})
	public Marque getMarqueBy(Long idMarque) {
		Marque marque;
		marque = marqueDAO.getBy(idMarque);
		return marque;
	}

	@Override
	public int enableMarque(Marque r) {
		int i;
		i = marqueDAO.enable(r);
		return i;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void updateMarque(Marque marque) {

		marqueDAO.update(marque);

	}

	@Override
	public void deleteMarque(Marque r) {

		marqueDAO.delete(r);

	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public List<String> searchMarque(String name) {
		List<String> marquesStrings;
		marquesStrings = marqueDAO.searchMarque(name);
		return marquesStrings;
	}

	/****************************************************/
	/******************** Piece *************************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Piece insertPiece(Piece piece) {
		Piece piecePersist;
		piecePersist = pieceDAO.insert(piece);
		return piecePersist;
	}

	@Override
	public List<Piece> getAllPiecesBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getAllBy(appareil, categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesOriginesBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getOriginesBy(appareil, categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getEquivalentesBy(appareil, categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesOriginesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getOriginesBy(categorie);
		return pieces;

	}

	@Override
	public List<Piece> getPiecesOriginesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceDAO.getOriginesBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getEquivalentesBy(categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceDAO.getEquivalentesBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getAllPiecesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceDAO.getAllBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getAllPiecesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceDAO.getAllBy(categorie);
		return pieces;
	}

	@Override
	public List<Piece> getAllPieces() {
		List<Piece> pieces;
		pieces = pieceDAO.getAll();
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Piece pieceOrigine) {
		List<Piece> pieces;
		pieces = pieceDAO.getEquivalentesBy(pieceOrigine);
		return pieces;
	}

	@Override
	public void associePieceAppareil(Piece piOrigine, Appareil appareil) {
		pieceDAO.associe(piOrigine, appareil);
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Piece getPieceById(Long id_piece) {
		Piece piece;
		piece = pieceDAO.getPieceById(id_piece);
		return piece;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Piece getPieceBy(String ref_piece) {
		Piece piece;
		piece = pieceDAO.getPieceBy(ref_piece);
		return piece;
	}

	@Override
	public void deletePiece(Piece pi) {

		pieceDAO.delete(pi);

	}

	@Override
	public void updatePiece(Piece newPiece) {

		pieceDAO.update(newPiece);

	}

	/****************************************************/
	/********************* Type *************************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Type insertType(Type type) {
		Type typePersist;
		typePersist = typeDAO.insert(type);
		return typePersist;
	}

	@Override
	public List<Type> getAllType() {
		List<Type> types;
		types = typeDAO.getAll();
		return types;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Type getTypeBy(String libelle) {
		Type type;
		type = typeDAO.getBy(libelle);
		return type;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Type getTypeBy(Long idType) {
		Type type;
		type = typeDAO.getBy(idType);
		return type;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void updateType(Type type) {
		
		typeDAO.update(type);
		
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void deleteType(Type idType) {

		typeDAO.delete(idType);

	}

	@Override
	public List<String> searchType(String typeString) {

		List<String> typesStrings;
		typesStrings = typeDAO.searchType(typeString);
		return typesStrings;

	}

	@Override
	// @Interceptors({ TrieTypeInterceptors.class })
	public Set<Type> getTypesByMarque(Marque marque) {
		Set<Type> types;
		types = new HashSet<>();
		types.addAll(typeDAO.getAll());
		return types;
	}

	/****************************************************/
	/******************* Document ***********************/
	/****************************************************/

	@Override
	public List<Document> getDocumentBy(Piece piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Document insertDocument(Document d, Piece piOrigine) {

		return documentDAO.insert(d, piOrigine);
	}

	@Override
	public int deleteDocument(Document document) {
		throw new UnsupportedOperationException("not implemented yet");

	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public List<Document> getDocumentBy(String ref_piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Document getDocumentById(Long idDoc) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	/****************************************************/
	/******************* Image ***********************/
	/****************************************************/

	@Override
	public List<Image> getImageBy(Piece piece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public List<Image> getImageBy(String referencePiece) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Image insertImage(Image image) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int deleteImage(Image image) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Image getImageById(Long idImage) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	// @Interceptors({ TrieMarqueInterceptors.class })
	public Set<Marque> getMarquesByType(Type type) {
		Set<Marque> marques;
		marques = new HashSet<>();
		marques.addAll(marqueDAO.getAll());
		return marques;
	}

	@Override
	public LigneDeCommande insererLigneDeCommande(LigneDeCommande ligneDeCommande) {

		LigneDeCommande ligneDeCommandesInsert;

		ligneDeCommandesInsert = ligneDeCommandesDAO.insererLigneDeCommande(ligneDeCommande);

		return ligneDeCommandesInsert;
	}

	@Override
	public LigneDeCommande getLigneDeCommandeByID(Long idLigneDeCommande) {

		return ligneDeCommandesDAO.getLigneDeCommandeByID(idLigneDeCommande);

	}

	@Override
	public List<LigneDeCommande> getLigneDeCommandeByCommande(Commande commande) {
		// TODO Auto-generated method stub
		return ligneDeCommandesDAO.getLigneDeCommandeByCommande(commande);
	}

	@Override
	public List<LigneDeCommande> getAllLigneDeCommande() {
		// TODO Auto-generated method stub
		return ligneDeCommandesDAO.getAllLigneDeCommande();
	}

	@Override
	public void update(LigneDeCommande ligneDeCommande) {
		ligneDeCommandesDAO.update(ligneDeCommande);
	}

	@Override
	public void deleteLigneDeCommande(LigneDeCommande ligneDeCommande) {
		ligneDeCommandesDAO.deleteLigneDeCommande(ligneDeCommande);

	}

}
