package test.java;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Adresse;
import domain.Appareil;
import domain.Categorie;
import domain.Client;
import domain.Commande;
import domain.LigneDeCommande;
import domain.Marque;
import domain.Marque.EtatMarque;
import domain.Piece;
import domain.Type;
import domain.enumerated.Civilite;
import domain.enumerated.Pays;
import domain.enumerated.TypeAdresse;
import domain.enumerated.TypePiece;
import domain.enumerated.TypeVoie;
import services.MonService;

public class SpringServiceTestCommande {

	private static Logger logger = Logger.getLogger(SpringServiceTestCommande.class);
	private static ApplicationContext context;
	private static MonService service;

	@BeforeClass
	public static void setUpBeforeClass() {

		try {

			logger.info("----------- @setUpBeforeClass --------------");

			context = new ClassPathXmlApplicationContext("application-context.xml");
			service = (MonService) context.getBean("monService");
			assertNotNull(context);
			assertNotNull(service);

		} catch (NullPointerException e) {
			logger.info("----------- Exception : setUpBeforeClass --------------");
			e.printStackTrace();
		}

		// try {
		//
		// logger.info("----------- @setUpBeforeClass --------------");
		//
		// List<Adresse> adresses;
		// List<Appareil> appareils;
		// List<Marque> marques;
		// List<Type> types;
		// List<Categorie> categories;
		// List<Client> clients;
		// List<Commande> commandes;
		// List<LigneDeCommande> lignesDeCommandes;
		// List<Piece> pieces;
		//
		// pieces = service.getAllPieces();
		//
		// logger.info(
		// "----------- @setUpBeforeClass : recupération des tous objects
		// présent dans la base de données --------------");
		//
		// categories = service.getAllCategorie();
		//
		// appareils = service.getAllAppareil();
		//
		// marques = service.getAllMarques();
		//
		// types = service.getAllType();
		//
		// adresses = service.getAllAdresse();
		//
		// lignesDeCommandes = service.getAllLigneDeCommande();
		//
		// commandes = service.getAllCommande();
		//
		// clients = service.getAllClients();
		//
		// logger.info("----------- @setUpBeforeClass : recupération des " +
		// clients.size()
		// + " object 'CLIENT' présent dans la base de données --------------");
		//
		// logger.info(
		// "----------- @setUpBeforeClass :--------------------------------
		// Supression --------------------------------");
		// logger.info(
		// "----------- @setUpBeforeClass :--------------------------------
		// ---------- --------------------------------");
		// logger.info(
		// "----------- @setUpBeforeClass : suppression de tous les objects
		// présent dans la base de données --------------");
		//
		// if (!pieces.isEmpty()) {
		// for (Piece piece : pieces) {
		// service.deletePiece(piece);
		// }
		// }
		//
		// if (!categories.isEmpty()) {
		// for (Categorie categorie : categories) {
		// service.deleteCategorie(categorie);
		// }
		// }
		//
		// if (!appareils.isEmpty()) {
		// for (Appareil appareil : appareils) {
		// service.deleteAppareil(appareil);
		// }
		//
		// }
		//
		// if (!marques.isEmpty()) {
		//
		// for (Marque marque : marques) {
		// service.deleteMarque(marque);
		// }
		// }
		//
		// if (!types.isEmpty()) {
		// for (Type type : types) {
		// service.deleteType(type);
		// }
		// }
		//
		// if (!adresses.isEmpty()) {
		// for (Adresse adresse : adresses) {
		// service.deleteAdresse(adresse);
		// }
		//
		// }
		//
		// if (lignesDeCommandes.isEmpty()) {
		// for (LigneDeCommande ligneDeCommande : lignesDeCommandes) {
		// service.deleteLigneDeCommande(ligneDeCommande);
		// }
		//
		// }
		//
		// if (commandes.isEmpty()) {
		// for (Commande commande : commandes) {
		// service.deleteCommande(commande);
		// }
		// }
		//
		// if (clients.isEmpty()) {
		//
		// for (Client client : clients) {
		// service.deleteClient(client);
		// }
		// }
		//
		// logger.info(
		// "----------- @setUpBeforeClass : suppression terminée de tous les
		// objects présent dans la base de données --------------");
		//
		// } catch (Exception e) {
		// logger.info("-----------Exception : @setUpBeforeClass
		// --------------");
		// e.printStackTrace();
		// }

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		// try {
		//
		// logger.info("----------- @tearDownAfterClass --------------");
		//
		// List<Adresse> adresses;
		// List<Appareil> appareils;
		// List<Marque> marques;
		// List<Type> types;
		// List<Categorie> categories;
		// List<Client> clients;
		// List<Commande> commandes;
		// List<LigneDeCommande> lignesDeCommandes;
		// List<Piece> pieces;
		//
		// pieces = service.getAllPieces();
		//
		// logger.info(
		// "----------- @tearDownAfterClass : recupération des tous objects
		// présent dans la base de données --------------");
		//
		// categories = service.getAllCategorie();
		//
		// appareils = service.getAllAppareil();
		//
		// marques = service.getAllMarques();
		//
		// types = service.getAllType();
		//
		// adresses = service.getAllAdresse();
		//
		// lignesDeCommandes = service.getAllLigneDeCommande();
		//
		// commandes = service.getAllCommande();
		//
		// clients = service.getAllClients();
		//
		// logger.info("----------- @tearDownAfterClass : recupération des " +
		// clients.size()
		// + " object 'CLIENT' présent dans la base de données --------------");
		//
		// logger.info(
		// "----------- @tearDownAfterClass :--------------------------------
		// Supression --------------------------------");
		// logger.info(
		// "----------- @tearDownAfterClass :--------------------------------
		// ---------- --------------------------------");
		// logger.info(
		// "----------- @tearDownAfterClass : suppression de tous les objects
		// présent dans la base de données --------------");
		//
		// if (!pieces.isEmpty()) {
		// for (Piece piece : pieces) {
		// service.deletePiece(piece);
		// }
		// }
		//
		// if (!categories.isEmpty()) {
		// for (Categorie categorie : categories) {
		// service.deleteCategorie(categorie);
		// }
		// }
		//
		// if (!appareils.isEmpty()) {
		// for (Appareil appareil : appareils) {
		// service.deleteAppareil(appareil);
		// }
		//
		// }
		//
		// if (!marques.isEmpty()) {
		//
		// for (Marque marque : marques) {
		// service.deleteMarque(marque);
		// }
		// }
		//
		// if (!types.isEmpty()) {
		// for (Type type : types) {
		// service.deleteType(type);
		// }
		// }
		//
		// if (!adresses.isEmpty()) {
		// for (Adresse adresse : adresses) {
		// service.deleteAdresse(adresse);
		// }
		//
		// }
		//
		// if (lignesDeCommandes.isEmpty()) {
		// for (LigneDeCommande ligneDeCommande : lignesDeCommandes) {
		// service.deleteLigneDeCommande(ligneDeCommande);
		// }
		//
		// }
		//
		// if (commandes.isEmpty()) {
		// for (Commande commande : commandes) {
		// service.deleteCommande(commande);
		// }
		// }
		//
		// if (clients.isEmpty()) {
		//
		// for (Client client : clients) {
		// service.deleteClient(client);
		// }
		// }
		//
		// logger.info(
		// "----------- @tearDownAfterClass : suppression terminée de tous les
		// objects présent dans la base de données --------------");
		//
		// } catch (Exception e) {
		// logger.info("-----------Exception : @tearDownAfterClass
		// --------------");
		// e.printStackTrace();
		// }

	}

	@Before
	public void setUp() throws Exception {

		// try {
		//
		// logger.info("----------- @setUp --------------");
		//
		// List<Adresse> adresses;
		// List<Appareil> appareils;
		// List<Marque> marques;
		// List<Type> types;
		// List<Categorie> categories;
		// List<Client> clients;
		// List<Commande> commandes;
		// List<LigneDeCommande> lignesDeCommandes;
		// List<Piece> pieces;
		//
		// pieces = service.getAllPieces();
		//
		// logger.info(
		// "----------- @setUp : recupération des tous objects présent dans la
		// base de données --------------");
		//
		// categories = service.getAllCategorie();
		//
		// appareils = service.getAllAppareil();
		//
		// marques = service.getAllMarques();
		//
		// types = service.getAllType();
		//
		// adresses = service.getAllAdresse();
		//
		// lignesDeCommandes = service.getAllLigneDeCommande();
		//
		// commandes = service.getAllCommande();
		//
		// clients = service.getAllClients();
		//
		// logger.info("----------- @setUp : recupération des " + clients.size()
		// + " object 'CLIENT' présent dans la base de données --------------");
		//
		// logger.info(
		// "----------- @setUp :-------------------------------- Supression
		// --------------------------------");
		// logger.info(
		// "----------- @setUp :-------------------------------- ----------
		// --------------------------------");
		// logger.info(
		// "----------- @setUp : suppression de tous les objects présent dans la
		// base de données --------------");
		//
		// if (!pieces.isEmpty()) {
		// for (Piece piece : pieces) {
		// service.deletePiece(piece);
		// }
		// }
		//
		// if (!categories.isEmpty()) {
		// for (Categorie categorie : categories) {
		// service.deleteCategorie(categorie);
		// }
		// }
		//
		// if (!appareils.isEmpty()) {
		// for (Appareil appareil : appareils) {
		// service.deleteAppareil(appareil);
		// }
		//
		// }
		//
		// if (!marques.isEmpty()) {
		//
		// for (Marque marque : marques) {
		// service.deleteMarque(marque);
		// }
		// }
		//
		// if (!types.isEmpty()) {
		// for (Type type : types) {
		// service.deleteType(type);
		// }
		// }
		//
		// if (!adresses.isEmpty()) {
		// for (Adresse adresse : adresses) {
		// service.deleteAdresse(adresse);
		// }
		//
		// }
		//
		// if (lignesDeCommandes.isEmpty()) {
		// for (LigneDeCommande ligneDeCommande : lignesDeCommandes) {
		// service.deleteLigneDeCommande(ligneDeCommande);
		// }
		//
		// }
		//
		// if (commandes.isEmpty()) {
		// for (Commande commande : commandes) {
		// service.deleteCommande(commande);
		// }
		// }
		//
		// if (clients.isEmpty()) {
		//
		// for (Client client : clients) {
		// service.deleteClient(client);
		// }
		// }
		//
		// logger.info(
		// "----------- @setUp : suppression terminée de tous les objects
		// présent dans la base de données --------------");
		//
		// } catch (Exception e) {
		// logger.info("-----------Exception : @setUp --------------");
		// e.printStackTrace();
		// }

	}

	@After
	public void tearDown() throws Exception {

		// try {
		//
		// logger.info("----------- @tearDown after Methode --------------");
		//
		// List<Adresse> adresses;
		// List<Appareil> appareils;
		// List<Marque> marques;
		// List<Type> types;
		// List<Categorie> categories;
		// List<Client> clients;
		// List<Commande> commandes;
		// List<LigneDeCommande> lignesDeCommandes;
		// List<Piece> pieces;
		//
		// pieces = service.getAllPieces();
		//
		// logger.info(
		// "----------- @tearDown after Methodes : recupération des tous objects
		// présent dans la base de données --------------");
		//
		// categories = service.getAllCategorie();
		//
		// appareils = service.getAllAppareil();
		//
		// marques = service.getAllMarques();
		//
		// types = service.getAllType();
		//
		// adresses = service.getAllAdresse();
		//
		// lignesDeCommandes = service.getAllLigneDeCommande();
		//
		// commandes = service.getAllCommande();
		//
		// clients = service.getAllClients();
		//
		// logger.info("----------- @tearDown after Methode : recupération des "
		// + clients.size()
		// + " object 'CLIENT' présent dans la base de données --------------");
		//
		// logger.info(
		// "----------- @tearDown after Methode
		// :-------------------------------- Supression
		// --------------------------------");
		// logger.info(
		// "----------- @tearDown after Methode
		// :-------------------------------- ----------
		// --------------------------------");
		// logger.info(
		// "----------- @tearDown after Methode : suppression de tous les
		// objects présent dans la base de données --------------");
		//
		// if (!pieces.isEmpty()) {
		// for (Piece piece : pieces) {
		// service.deletePiece(piece);
		// }
		// }
		//
		// if (!categories.isEmpty()) {
		// for (Categorie categorie : categories) {
		// service.deleteCategorie(categorie);
		// }
		// }
		//
		// if (!appareils.isEmpty()) {
		// for (Appareil appareil : appareils) {
		// service.deleteAppareil(appareil);
		// }
		//
		// }
		//
		// if (!marques.isEmpty()) {
		//
		// for (Marque marque : marques) {
		// service.deleteMarque(marque);
		// }
		// }
		//
		// if (!types.isEmpty()) {
		// for (Type type : types) {
		// service.deleteType(type);
		// }
		// }
		//
		// if (!adresses.isEmpty()) {
		// for (Adresse adresse : adresses) {
		// service.deleteAdresse(adresse);
		// }
		//
		// }
		//
		// if (lignesDeCommandes.isEmpty()) {
		// for (LigneDeCommande ligneDeCommande : lignesDeCommandes) {
		// service.deleteLigneDeCommande(ligneDeCommande);
		// }
		//
		// }
		//
		// if (commandes.isEmpty()) {
		// for (Commande commande : commandes) {
		// service.deleteCommande(commande);
		// }
		// }
		//
		// if (clients.isEmpty()) {
		//
		// for (Client client : clients) {
		// service.deleteClient(client);
		// }
		// }
		//
		// logger.info(
		// "----------- @tearDown after Methode : suppression terminée de tous
		// les objects présent dans la base de données --------------");
		//
		// } catch (Exception e) {
		// logger.info("-----------Exception : @tearDown after Methode
		// --------------");
		// e.printStackTrace();
		// }

	}

	@Test
	public void testGet() {
		try {
			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Marque marque = (Marque) context.getBean("marqueInsert");
			marque.setEtatMarque(EtatMarque.ACTIVE);
			String stringMarque;
			stringMarque = "marqueTest" + aleatoire;
			marque.setMarque(stringMarque);

			service.insertMarque(marque);
			assertTrue(marque.getIdMarque() > 0);

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			Appareil appareil = (Appareil) context.getBean("appareilInsert");
			appareil.setDescription("appareil de test");
			appareil.setMarque(marque);
			appareil.setType(type);
			String referenceAppareil;
			referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
			appareil.setReferenceAppareil(referenceAppareil);

			service.insertAppareil(appareil);
			assertTrue(appareil.getIdAppareil() > 0);

			Categorie categorie = (Categorie) context.getBean("categorieInsert");
			String stringCategorie;
			stringCategorie = "categorieTest" + aleatoire;
			categorie.setLibelle(stringCategorie);

			service.insertCategorie(categorie);
			assertTrue(categorie.getIdCategorie() > 0);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			Piece piece = (Piece) context.getBean("pieceInsert");
			piece.setCategorie(categorie);
			piece.setPrix(Math.random() * 100);
			piece.setLibelle("Piece de test");
			piece.setTypePiece(TypePiece.ORIGINE);
			String reference;
			reference = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece.setReference(reference);
			piece.setQuantite((int) Math.random() * 20);

			service.insertPiece(piece);
			assertTrue(piece.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			Piece piece2 = (Piece) context.getBean("pieceInsert");
			piece2.setCategorie(categorie);
			piece2.setPrix(Math.random() * 100);
			piece2.setLibelle("Piece de test");
			piece2.setTypePiece(TypePiece.ORIGINE);
			String reference2;
			reference2 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece2.setReference(reference2);
			piece2.setQuantite((int) (Math.random() * 20));

			service.insertPiece(piece2);
			assertTrue(piece2.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			Piece piece3 = (Piece) context.getBean("pieceInsert");
			piece3.setCategorie(categorie);
			piece3.setPrix(Math.random() * 100);
			piece3.setLibelle("Piece de test");
			piece3.setTypePiece(TypePiece.ORIGINE);
			String reference3;
			reference3 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece3.setReference(reference3);
			piece3.setQuantite((int) Math.random() * 20);

			service.insertPiece(piece3);
			assertTrue(piece3.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			Piece piece4 = (Piece) context.getBean("pieceInsert");
			piece4.setCategorie(categorie);
			piece4.setPrix(Math.random() * 100);
			piece4.setLibelle("Piece de test");
			piece4.setTypePiece(TypePiece.ORIGINE);
			String reference4;
			reference4 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece4.setReference(reference4);
			piece4.setQuantite((int) Math.random() * 20);

			service.insertPiece(piece4);
			assertTrue(piece4.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			Piece piece5 = (Piece) context.getBean("pieceInsert");
			piece5.setCategorie(categorie);
			piece5.setPrix(Math.random() * 100);
			piece5.setLibelle("Piece de test");
			piece5.setTypePiece(TypePiece.ORIGINE);
			String reference5;
			reference5 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece5.setReference(reference5);
			piece5.setQuantite((int) Math.random() * 20);

			service.insertPiece(piece5);
			assertTrue(piece5.getIdPiece() > 0);

			Client client = (Client) context.getBean("clientInsert");
			client.setCivilite(Civilite.M);
			client.setEmail("first_ashura" + aleatoire + "@" + aleatoire2 + "gmail.com");
			client.setMotDePasse("motdpasse" + aleatoire);
			client.setNom("ramzy");
			client.setPrenom("prenom");
			client.setTelephone("0.00.00.00.00");

			service.insertClient(client);
			assertTrue(client.getIdClient() > 0);

			Adresse adresseClient = (Adresse) context.getBean("adresseInsert");
			adresseClient.setNumeroVoie(48);
			adresseClient.setTypeVoie(TypeVoie.RUE);
			adresseClient.setNomVoie("adresse Client");
			adresseClient.setCodePostal(33220);
			adresseClient.setVille("saint machin");
			adresseClient.setPays(Pays.FRANCE);
			adresseClient.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClient.setClient(client);

			service.insertAdresse(adresseClient);
			assertTrue(adresseClient.getIdAdresse() > 0);

//			LigneDeCommande ligneDeCommande1 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
//			LigneDeCommande ligneDeCommande2 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
//			LigneDeCommande ligneDeCommande3 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
//			ligneDeCommande1.setPiece(piece);
//			ligneDeCommande1.setQuantite((short) 5);
//
//			ligneDeCommande2.setPiece(piece2);
//			ligneDeCommande2.setQuantite((short) 7);
//
//			ligneDeCommande3.setPiece(piece3);
//			ligneDeCommande3.setQuantite((short) 7);

			Commande commande = service.getCommandByID(3L); 
					//(Commande) context.getBean("commandeInsert");

//			commande.setClient(client);
//			commande.ajouterLigneDeCommande(ligneDeCommande1);
//			commande.ajouterLigneDeCommande(ligneDeCommande3);
//			commande.ajouterLigneDeCommande(ligneDeCommande2);

			//service.insererCommande(commande);
			assertTrue(commande.getIdCommande() > 0);
			
//			Long idCommande;
//			idCommande = commande.getIdCommande();
//
//			Adresse adresse = (Adresse) context.getBean("adresseInsert");
//			adresse.setNumeroVoie(48);
//			adresse.setTypeVoie(TypeVoie.RUE);
//			adresse.setNomVoie("adresse Client");
//			adresse.setCodePostal(33220);
//			adresse.setVille("saint machin");
//			adresse.setPays(Pays.FRANCE);
//			adresse.setTypeAdresse(TypeAdresse.LIVRAISON);
//			
//			Adresse adresse2 = (Adresse) context.getBean("adresseInsert");
//			adresse2.setNumeroVoie(48);
//			adresse2.setTypeVoie(TypeVoie.RUE);
//			adresse2.setNomVoie("adresse Client");
//			adresse2.setCodePostal(33220);
//			adresse2.setVille("saint machin");
//			adresse2.setPays(Pays.FRANCE);
//			adresse2.setTypeAdresse(TypeAdresse.FACTURATION);
//			
//			adresse.setCommande(commande);
//
//			service.insertAdresse(adresse);
//			assertTrue(adresse.getIdAdresse() > 0);
//
//			adresse2.setCommande(commande);
//
//			service.insertAdresse(adresse2);
//			assertTrue(adresse2.getIdAdresse() > 0);
//
//			List<Adresse> adressesCommande = service.getAdresseByCommande(commande);
//			assertNotNull(adressesCommande);
//			assertEquals(adressesCommande.size(), 2);

//			
//			logger.info("get commande by id");
//			
//			
//			commande = null;
//			
//			commande = service.getCommandByID(idCommande);
//			
//			assertNotNull(commande);
			
//			List<Commande>commandes = service.getCommandeByClient(client);
//			
//			assertNotNull(commandes);
//			assertFalse(commandes.isEmpty());
			
//			commandes.clear();
//			commandes = service.getAllCommande();
			

//			assertNotNull(commandes);
//			assertFalse(commandes.isEmpty());
			
//			commande = null;
//			commande = service.getCommandByID(idCommande);
//			Commande commande2, commande3;
//			commande2 = service.getCommandByID(idCommande);
			
			LigneDeCommande ligneDeCommande4 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			Piece piece55 = service.getPieceById(14L);
			ligneDeCommande4.setPiece(piece55);
			ligneDeCommande4.setQuantite((short) 12);
			commande.ajouterLigneDeCommande(ligneDeCommande4);
			service.update(commande);
			
			//commande3 = service.getCommandByID(idCommande);
			
			//assertFalse((commande3.getTotalCommande()).equals(commande2.getTotalCommande()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Test
//	public void testInsererCommande() {
//		
//	}
//
//	@Test
//	public void testGetCommandByID() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCommandeByClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllCommande() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAnnulerCommande() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testValiderCommande() {
//		fail("Not yet implemented");
//	}



}
