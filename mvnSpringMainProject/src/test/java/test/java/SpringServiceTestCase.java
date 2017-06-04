package test.java;

import static org.junit.Assert.*;

import java.util.List;

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

public class SpringServiceTestCase {

	private static Logger logger = Logger.getLogger(SpringServiceTestCase.class);
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

			LigneDeCommande ligneDeCommande1 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			LigneDeCommande ligneDeCommande2 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			LigneDeCommande ligneDeCommande3 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			ligneDeCommande1.setPiece(piece);
			ligneDeCommande1.setQuantite((short) 5);

			ligneDeCommande2.setPiece(piece2);
			ligneDeCommande2.setQuantite((short) 7);

			ligneDeCommande3.setPiece(piece3);
			ligneDeCommande3.setQuantite((short) 7);

			Commande commande = (Commande) context.getBean("commandeInsert");

			commande.setClient(client);
			commande.ajouterLigneDeCommande(ligneDeCommande1);
			commande.ajouterLigneDeCommande(ligneDeCommande3);
			commande.ajouterLigneDeCommande(ligneDeCommande2);

			service.insererCommande(commande);
			assertTrue(commande.getIdCommande() > 0);

			Adresse adresse = new Adresse(48, TypeVoie.RUE, "adresse Commande livraison", 33220, "Sainte foy La grande",
					Pays.FRANCE, TypeAdresse.LIVRAISON);
			Adresse adresse2 = new Adresse(48, TypeVoie.RUE, "adresse Commande Facturation", 33220,
					"Sainte foy La grande", Pays.FRANCE, TypeAdresse.FACTURATION);

			adresse.setCommande(commande);

			service.insertAdresse(adresse);
			assertTrue(adresse.getIdAdresse() > 0);

			adresse2.setCommande(commande);

			service.insertAdresse(adresse2);
			assertTrue(adresse2.getIdAdresse() > 0);

			List<Adresse> adressesCommande = service.getAdresseByCommande(commande);
			assertNotNull(adressesCommande);
			assertEquals(adressesCommande.size(), 2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAdresseByClient() {
		try {
			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Client client = (Client) context.getBean("clientInsert");
			client.setCivilite(Civilite.M);
			client.setEmail("first_ashura" + aleatoire + "@" + aleatoire2 + "gmail.com");
			client.setMotDePasse("motdpasse" + aleatoire);
			client.setNom("ramzy");
			client.setPrenom("prenom");
			client.setTelephone("0.00.00.00.00");

			service.insertClient(client);
			assertTrue(client.getIdClient() > 0);

			Adresse adresseClientFacturation = (Adresse) context.getBean("adresseInsert");
			adresseClientFacturation.setNumeroVoie(48);
			adresseClientFacturation.setTypeVoie(TypeVoie.RUE);
			adresseClientFacturation.setNomVoie("adresse Client");
			adresseClientFacturation.setCodePostal(33220);
			adresseClientFacturation.setVille("saint machin");
			adresseClientFacturation.setPays(Pays.FRANCE);
			adresseClientFacturation.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClientFacturation.setClient(client);

			service.insertAdresse(adresseClientFacturation);
			assertTrue(adresseClientFacturation.getIdAdresse() > 0);

			Adresse adresseClientLivraison = (Adresse) context.getBean("adresseInsert");
			adresseClientLivraison.setNumeroVoie(48);
			adresseClientLivraison.setTypeVoie(TypeVoie.RUE);
			adresseClientLivraison.setNomVoie("adresse Client");
			adresseClientLivraison.setCodePostal(33220);
			adresseClientLivraison.setVille("saint machin");
			adresseClientLivraison.setPays(Pays.FRANCE);
			adresseClientLivraison.setTypeAdresse(TypeAdresse.LIVRAISON);
			adresseClientLivraison.setClient(client);

			service.insertAdresse(adresseClientLivraison);
			assertTrue(adresseClientLivraison.getIdAdresse() > 0);

			List<Adresse> adressesCommande = service.getAdresseByClient(client);
			assertNotNull(adressesCommande);
			assertEquals(adressesCommande.size(), 2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAdresseByCommande() {

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
			adresseClient.setNomVoie("Jean jacques rousseau");
			adresseClient.setCodePostal(33220);
			adresseClient.setVille("saint machin");
			adresseClient.setPays(Pays.FRANCE);
			adresseClient.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClient.setClient(client);

			service.insertAdresse(adresseClient);
			assertTrue(adresseClient.getIdAdresse() > 0);

			LigneDeCommande ligneDeCommande1 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			LigneDeCommande ligneDeCommande2 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			LigneDeCommande ligneDeCommande3 = (LigneDeCommande) context.getBean("ligneDeCommandeInsert");
			ligneDeCommande1.setPiece(piece);
			ligneDeCommande1.setQuantite((short) 5);

			ligneDeCommande2.setPiece(piece2);
			ligneDeCommande2.setQuantite((short) 7);

			ligneDeCommande3.setPiece(piece3);
			ligneDeCommande3.setQuantite((short) 7);

			Commande commande = (Commande) context.getBean("commandeInsert");

			commande.setClient(client);
			commande.ajouterLigneDeCommande(ligneDeCommande1);
			commande.ajouterLigneDeCommande(ligneDeCommande3);
			commande.ajouterLigneDeCommande(ligneDeCommande2);

			service.insererCommande(commande);
			assertTrue(commande.getIdCommande() > 0);

			Adresse adresseCommandeLivraison = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrrousseau", 33220,
					"Sainte foy La grande", Pays.FRANCE, TypeAdresse.LIVRAISON);
			Adresse adresseCommandeFacturation = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrousseau", 33220,
					"Sainte foy La grande", Pays.FRANCE, TypeAdresse.FACTURATION);

			adresseCommandeLivraison.setCommande(commande);

			service.insertAdresse(adresseCommandeLivraison);
			assertTrue(adresseCommandeLivraison.getIdAdresse() > 0);

			adresseCommandeFacturation.setCommande(commande);

			service.insertAdresse(adresseCommandeFacturation);
			assertTrue(adresseCommandeFacturation.getIdAdresse() > 0);

			List<Adresse> adressesCommande = service.getAdresseByCommande(commande);
			assertNotNull(adressesCommande);
			assertEquals(adressesCommande.size(), 2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAllAdresse() {

		try {

			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Client client = (Client) context.getBean("clientInsert");
			client.setCivilite(Civilite.M);
			client.setEmail("first_ashura" + aleatoire + "@" + aleatoire2 + "gmail.com");
			client.setMotDePasse("motdpasse" + aleatoire);
			client.setNom("ramzy");
			client.setPrenom("prenom");
			client.setTelephone("0.00.00.00.00");

			service.insertClient(client);
			assertTrue(client.getIdClient() > 0);

			Adresse adresseClientFacturation = (Adresse) context.getBean("adresseInsert");
			adresseClientFacturation.setNumeroVoie(48);
			adresseClientFacturation.setTypeVoie(TypeVoie.RUE);
			adresseClientFacturation.setNomVoie("adresse Client");
			adresseClientFacturation.setCodePostal(33220);
			adresseClientFacturation.setVille("saint machin");
			adresseClientFacturation.setPays(Pays.FRANCE);
			adresseClientFacturation.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClientFacturation.setClient(client);

			service.insertAdresse(adresseClientFacturation);
			assertTrue(adresseClientFacturation.getIdAdresse() > 0);

			Adresse adresseClientLivraison = (Adresse) context.getBean("adresseInsert");
			adresseClientLivraison.setNumeroVoie(48);
			adresseClientLivraison.setTypeVoie(TypeVoie.RUE);
			adresseClientLivraison.setNomVoie("adresse Client");
			adresseClientLivraison.setCodePostal(33220);
			adresseClientLivraison.setVille("saint machin");
			adresseClientLivraison.setPays(Pays.FRANCE);
			adresseClientLivraison.setTypeAdresse(TypeAdresse.LIVRAISON);
			adresseClientLivraison.setClient(client);

			service.insertAdresse(adresseClientLivraison);
			assertTrue(adresseClientLivraison.getIdAdresse() > 0);

			Adresse adresse3 = (Adresse) context.getBean("adresseInsert");
			adresse3.setNumeroVoie(48);
			adresse3.setTypeVoie(TypeVoie.RUE);
			adresse3.setNomVoie("adresse Client");
			adresse3.setCodePostal(33220);
			adresse3.setVille("saint machin");
			adresse3.setPays(Pays.FRANCE);
			adresse3.setTypeAdresse(TypeAdresse.FACTURATION);
			adresse3.setClient(client);

			service.insertAdresse(adresse3);
			assertTrue(adresse3.getIdAdresse() > 0);

			Adresse adresse4 = (Adresse) context.getBean("adresseInsert");
			adresse4.setNumeroVoie(48);
			adresse4.setTypeVoie(TypeVoie.RUE);
			adresse4.setNomVoie("adresse Client");
			adresse4.setCodePostal(33220);
			adresse4.setVille("saint machin");
			adresse4.setPays(Pays.FRANCE);
			adresse4.setTypeAdresse(TypeAdresse.LIVRAISON);
			adresse4.setClient(client);

			service.insertAdresse(adresse4);
			assertTrue(adresse4.getIdAdresse() > 0);

			List<Adresse> adresses = service.getAdresseByClient(client);
			assertNotNull(adresses);
			assertEquals(adresses.size(), 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInsertAdresse() {

		try {
			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Client client = (Client) context.getBean("clientInsert");
			client.setCivilite(Civilite.M);
			client.setEmail("first_ashura" + aleatoire + "@" + aleatoire2 + "gmail.com");
			client.setMotDePasse("motdpasse" + aleatoire);
			client.setNom("ramzy");
			client.setPrenom("prenom");
			client.setTelephone("0.00.00.00.00");

			service.insertClient(client);
			assertTrue(client.getIdClient() > 0);

			Adresse adresseClientFacturation = (Adresse) context.getBean("adresseInsert");
			adresseClientFacturation.setNumeroVoie(48);
			adresseClientFacturation.setTypeVoie(TypeVoie.RUE);
			adresseClientFacturation.setNomVoie("adresse Client");
			adresseClientFacturation.setCodePostal(33220);
			adresseClientFacturation.setVille("saint machin");
			adresseClientFacturation.setPays(Pays.FRANCE);
			adresseClientFacturation.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClientFacturation.setClient(client);

			service.insertAdresse(adresseClientFacturation);
			assertTrue(adresseClientFacturation.getIdAdresse() > 0);

			Adresse adresseClientLivraison = (Adresse) context.getBean("adresseInsert");
			adresseClientLivraison.setNumeroVoie(48);
			adresseClientLivraison.setTypeVoie(TypeVoie.RUE);
			adresseClientLivraison.setNomVoie("adresse Client");
			adresseClientLivraison.setCodePostal(33220);
			adresseClientLivraison.setVille("saint machin");
			adresseClientLivraison.setPays(Pays.FRANCE);
			adresseClientLivraison.setTypeAdresse(TypeAdresse.LIVRAISON);
			adresseClientLivraison.setClient(client);

			service.insertAdresse(adresseClientLivraison);
			assertTrue(adresseClientLivraison.getIdAdresse() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//
	@Test
	public void testUpdateAdresse() {

		try {

			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Client client = (Client) context.getBean("clientInsert");
			client.setCivilite(Civilite.M);
			client.setEmail("first_ashura" + aleatoire + "@" + aleatoire2 + "gmail.com");
			client.setMotDePasse("motdpasse" + aleatoire);
			client.setNom("ramzy");
			client.setPrenom("prenom");
			client.setTelephone("0.00.00.00.00");

			service.insertClient(client);
			assertTrue(client.getIdClient() > 0);

			Adresse adresseClientFacturation = (Adresse) context.getBean("adresseInsert");
			adresseClientFacturation.setNumeroVoie(48);
			adresseClientFacturation.setTypeVoie(TypeVoie.RUE);
			adresseClientFacturation.setNomVoie("adresse Client");
			adresseClientFacturation.setCodePostal(33220);
			adresseClientFacturation.setVille("saint machin");
			adresseClientFacturation.setPays(Pays.FRANCE);
			adresseClientFacturation.setTypeAdresse(TypeAdresse.FACTURATION);
			adresseClientFacturation.setClient(client);

			service.insertAdresse(adresseClientFacturation);
			assertTrue(adresseClientFacturation.getIdAdresse() > 0);

			Adresse adresseClientLivraison = (Adresse) context.getBean("adresseInsert");
			adresseClientLivraison.setNumeroVoie(48);
			adresseClientLivraison.setTypeVoie(TypeVoie.RUE);
			adresseClientLivraison.setNomVoie("adresse Client Livraison");
			adresseClientLivraison.setCodePostal(33220);
			adresseClientLivraison.setVille("saint machin");
			adresseClientLivraison.setPays(Pays.FRANCE);
			adresseClientLivraison.setTypeAdresse(TypeAdresse.LIVRAISON);
			adresseClientLivraison.setClient(client);

			service.insertAdresse(adresseClientLivraison);
			assertTrue(adresseClientLivraison.getIdAdresse() > 0);

			Long idAdresse = adresseClientLivraison.getIdAdresse();
			Adresse adresseOld = service.getAdresseID(idAdresse);

			adresseClientLivraison.setNomVoie("Adresse mise a jour");

			service.updateAdresse(adresseClientLivraison);
			assertFalse(adresseClientLivraison.equals(adresseOld));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDeleteAdresse() {

		try {
			Adresse adresse = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrrousseau", 33220, "Sainte foy La grande",
					Pays.FRANCE, TypeAdresse.LIVRAISON);
			Adresse adresse2 = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrousseau", 33220, "Sainte foy La grande",
					Pays.FRANCE, TypeAdresse.FACTURATION);

			service.insertAdresse(adresse);
			service.insertAdresse(adresse2);

			Long idAdresse1 = adresse.getIdAdresse();
			Long idAdresse2 = adresse2.getIdAdresse();

			assertTrue(idAdresse1 > 0);
			assertTrue(idAdresse2 > 0);

			service.deleteAdresse(adresse);
			service.deleteAdresse(adresse2);

			Adresse adresse1AfterRemove = service.getAdresseID(idAdresse1);
			Adresse adresse2AfterRemove = service.getAdresseID(idAdresse2);

			assertNull(adresse1AfterRemove);
			assertNull(adresse2AfterRemove);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInsertAppareil() {
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

			Long idAppareil = appareil.getIdAppareil();
			Appareil appGet;
			appGet = service.getAppareilBy(idAppareil);

			assertNotNull(appGet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetByAppareil() {

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

			Long idAppareil = appareil.getIdAppareil();
			Appareil appGet;
			appGet = service.getAppareilBy(idAppareil);

			assertNotNull(appGet);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Appareil appareil2 = (Appareil) context.getBean("appareilInsert");
			appareil2.setDescription("appareil de test");
			appareil2.setMarque(marque);
			appareil2.setType(type);
			String referenceAppareil2;
			referenceAppareil2 = "ABC" + aleatoire + "DEF" + aleatoire2;
			appareil2.setReferenceAppareil(referenceAppareil2);

			service.insertAppareil(appareil2);
			assertTrue(appareil2.getIdAppareil() > 0);

			Long idAppareil2 = appareil2.getIdAppareil();
			Appareil appGet2;
			appGet2 = service.getAppareilBy(idAppareil2);

			assertNotNull(appGet2);

			List<Appareil> appareils = service.getByAppareil(marque, type);
			assertNotNull(appareils);
			assertEquals(appareils.size(), 2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDeleteAppareil() {

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

			Long idAppareil = appareil.getIdAppareil();
			Appareil appGet;
			appGet = service.getAppareilBy(idAppareil);

			assertNotNull(appGet);

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));

			Appareil appareil2 = (Appareil) context.getBean("appareilInsert");
			appareil2.setDescription("appareil de test");
			appareil2.setMarque(marque);
			appareil2.setType(type);
			String referenceAppareil2;
			referenceAppareil2 = "ABC" + aleatoire + "DEF" + aleatoire2;
			appareil2.setReferenceAppareil(referenceAppareil2);

			service.insertAppareil(appareil2);
			assertTrue(appareil2.getIdAppareil() > 0);

			Long idAppareil2 = appareil2.getIdAppareil();
			Appareil appGet2;
			appGet2 = service.getAppareilBy(idAppareil2);

			assertNotNull(appGet2);

			List<Appareil> appareils = service.getByAppareil(marque, type);
			assertNotNull(appareils);
			assertEquals(appareils.size(), 2);

			for (Appareil appareil3 : appareils) {
				service.deleteAppareil(appareil3);
			}

			Appareil app1 = service.getAppareilBy(idAppareil);
			Appareil app2 = service.getAppareilBy(idAppareil2);

			assertNull(app1);
			assertNull(app2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAllAppareil() {

		try {

			// int aleatoire, aleatoire2;
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			//
			// Type type = service.getTypeBy("typeTest");
			// Marque marque = service.getMarqueBy("marqueTest");
			// @SuppressWarnings("deprecation")
			// Appareil appareil = new Appareil(type, marque, "IJK" + (aleatoire
			// + aleatoire2) + "LMN",
			// "description appareil de test");
			//
			// service.insertAppareil(appareil);
			//
			// List<Appareil> appareils;
			// appareils = service.getAllAppareil();
			//
			// assertNotNull(appareils);
			// assertTrue(appareils.size() > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAppareilByLong() {

		try {

			// int aleatoire, aleatoire2;
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			//
			// Type type = service.getTypeBy("typeTest");
			// Marque marque = service.getMarqueBy("marqueTest");
			// @SuppressWarnings("deprecation")
			// Appareil appareil = new Appareil(type, marque, "IJK" + (aleatoire
			// + aleatoire2) + "LMN",
			// "description appareil de test");
			//
			// service.insertAppareil(appareil);
			//
			// Long idAppareil;
			// idAppareil = appareil.getIdAppareil();
			// assertTrue(idAppareil > 0);
			//
			// Appareil appGet;
			// appGet = service.getAppareilBy(idAppareil);
			//
			// assertNotNull(appGet);
			//
			// service.deleteAppareil(appGet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAppareilByString() {

		try {

			// int aleatoire, aleatoire2;
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			// Type type = service.getTypeBy(1L);
			// Marque marque = service.getMarqueBy("marqueTest");
			// @SuppressWarnings("deprecation")
			// Appareil appareil = new Appareil(type, marque, "IJK" + (aleatoire
			// + aleatoire2) + "LMN",
			// "description appareil de test");
			//
			// service.insertAppareil(appareil);
			//
			// String RefAppareil;
			// RefAppareil = appareil.getReferenceAppareil();
			//
			// Appareil appGet;
			// appGet = service.getAppareilBy(RefAppareil);
			//
			// assertNotNull(appGet);
			//
			// service.deleteAppareil(appGet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdateAppareil() {

//		Appareil appareil1, appareil2;

		try {
			// int aleatoire, aleatoire2;
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			//
			// appareil1 = service.getAppareilBy(1L);
			//
			// appareil2 = service.getAppareilBy(1L);
			//
			// //assertNotSame(appareil1, appareil2);
			//
			// assertNotNull(appareil1);
			//
			// assertNotNull(appareil2);
			//
			// String ref = "Test" + (aleatoire + aleatoire2) + "Case";
			//
			// appareil1.setReferenceAppareil(ref);
			//
			// service.updateAppareil(appareil1);
			//
			// assertFalse(appareil1.equals(appareil2));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAppareilByMarque() {

		try {
			// int aleatoire, aleatoire2;
			// aleatoire2 = ((int) (Math.random() * 1000));
			// aleatoire = ((int) (Math.random() * 1000));
			//
			// @SuppressWarnings("deprecation")
			// Marque marque = new Marque("MarqueTest" + aleatoire);
			// Type type = new Type("TypeTest" + aleatoire2);
			// service.insertMarque(marque);
			// service.insertType(type);
			// for (int i = 0; i < 5; i++) {
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			// @SuppressWarnings("deprecation")
			// Appareil a = service.insertAppareil(new Appareil(type, marque,
			// "IJK" + (aleatoire + aleatoire2) + "LMN",
			// "description appareil de test"));
			// assertTrue(a.getIdAppareil() > 0);
			// }
			// List<Appareil> appareils = service.getAppareilByMarque(marque);
			//
			// assertNotNull(appareils);
			// assertTrue(appareils.size() == 5);
			//
			// for (Appareil appareil : appareils) {
			// service.deleteAppareil(appareil);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAppareilByType() {

		try {
			// int aleatoire, aleatoire2;
			// aleatoire2 = ((int) (Math.random() * 1000));
			// aleatoire = ((int) (Math.random() * 1000));
			//
			// @SuppressWarnings("deprecation")
			// Marque marque = new Marque("MarqueTest" + aleatoire);
			// Type type = new Type("TypeTest" + aleatoire2);
			// Marque marqueGet = service.insertMarque(marque);
			// Type typeGet = service.insertType(type);
			// for (int i = 0; i < 5; i++) {
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			// @SuppressWarnings("deprecation")
			// Appareil a = service.insertAppareil(new Appareil(type, marque,
			// "IJK" + (aleatoire + aleatoire2) + "LMN",
			// "description appareil de test"));
			// assertTrue(a.getIdAppareil() > 0);
			// }
			// List<Appareil> appareils = service.getAppareilByType(type);
			//
			// assertNotNull(appareils);
			// assertTrue(appareils.size() == 5);
			//
			// for (Appareil appareil : appareils) {
			// service.deleteAppareil(appareil);
			// }
			//
			// appareils = service.getAppareilByType(type);
			// assertNotNull(appareils);
			//
			// assertFalse(appareils.size() > 0);
			//
			// service.deleteMarque(marqueGet);
			//
			// service.deleteType(typeGet);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInsertCategorie() {

		try {

			// int aleatoire, aleatoire2;
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			//
			// Categorie categorie;
			// categorie = service.insertCategorie(new Categorie("CategorieTest"
			// + (aleatoire + aleatoire2)));
			//
			// assertNotNull(categorie);
			// assertTrue(categorie.getIdCategorie() > 0);
			//
			// Long idCategorie = categorie.getIdCategorie();
			//
			// service.deleteCategorie(categorie);
			//
			// Categorie categorieGet = service.getCategorieBy(idCategorie);
			// assertNull(categorieGet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAllCategorie() {
		try {

			// int aleatoire, aleatoire2;
			// List<Categorie> categories2 = new ArrayList<>();
			//
			// for (int i = 0; i < 5; i++) {
			// aleatoire = ((int) (Math.random() * 1000));
			// aleatoire2 = ((int) (Math.random() * 1000));
			// Categorie categorie;
			// categorie = service.insertCategorie(new Categorie("CategorieTest"
			// + (aleatoire + aleatoire2)));
			// categories2.add(categorie);
			// }
			//
			// List<Categorie> categories = service.getAllCategorie();
			// assertNotNull(categories);
			// assertTrue(categories.size() > 0);
			//
			// for (Categorie categorie : categories2) {
			// service.deleteCategorie(categorie);
			// }

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

//	@Test
//	public void testDeleteCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCategorieByString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCategorieByLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClientById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClientByEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClientByTel() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetClientByCommande() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllClients() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsererCommande() {
//		fail("Not yet implemented");
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
//
//	@Test
//	public void testInsertMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllMarques() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDesableMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetMarqueByString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetMarqueByLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEnableMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchMarque() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertPiece() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllPiecesByAppareilCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesOriginesByAppareilCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesEquivalentesByAppareilCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesOriginesByCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesOriginesByAppareil() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesEquivalentesByCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesEquivalentesByAppareil() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllPiecesByAppareil() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllPiecesByCategorie() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllPieces() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPiecesEquivalentesByPiece() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAssociePieceAppareil() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPieceById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPieceBy() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeletePiece() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdatePiece() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetTypeByString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetTypeByLong() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteType() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchType() {
//		fail("Not yet implemented");
//	}
//
//
//	@Test
//	public void testGetMarquesByType() {
//		fail("Not yet implemented");
//	}

}
