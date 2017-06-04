package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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


public class SpringServiceTestPiece {

	private static Logger logger = Logger.getLogger(SpringServiceTestPiece.class);
	private static ApplicationContext context;
	
	@Autowired
	static MonService service;

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

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

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
			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece = (Piece) context.getBean("pieceInsert");
			piece.setCategorie(categorie);
			piece.setPrix(Math.random() * 100);
			piece.setLibelle("Piece de test");
			piece.setTypePiece(TypePiece.ORIGINE);
			String reference;
			reference = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece.setReference(reference);
			piece.setQuantite((int) Math.random() * 20);
			piece.addModele(appareil);

			service.insertPiece(piece);
			assertTrue(piece.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece2 = (Piece) context.getBean("pieceInsert");
			piece2.setCategorie(categorie);
			piece2.setPrix(Math.random() * 100);
			piece2.setLibelle("Piece de test");
			piece2.setTypePiece(TypePiece.ORIGINE);
			String reference2;
			reference2 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece2.setReference(reference2);
			piece2.setQuantite((int) (Math.random() * 20));
			piece2.addModele(appareil);

			service.insertPiece(piece2);
			assertTrue(piece2.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece3 = (Piece) context.getBean("pieceInsert");
			piece3.setCategorie(categorie);
			piece3.setPrix(Math.random() * 100);
			piece3.setLibelle("Piece de test");
			piece3.setTypePiece(TypePiece.ORIGINE);
			String reference3;
			reference3 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece3.setReference(reference3);
			piece3.setQuantite((int) Math.random() * 20);
			piece3.addModele(appareil);

			service.insertPiece(piece3);
			assertTrue(piece3.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece4 = (Piece) context.getBean("pieceInsert");
			piece4.setCategorie(categorie);
			piece4.setPrix(Math.random() * 100);
			piece4.setLibelle("Piece de test");
			piece4.setTypePiece(TypePiece.ORIGINE);
			String reference4;
			reference4 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece4.setReference(reference4);
			piece4.setQuantite((int) Math.random() * 20);
			piece4.addModele(appareil);

			service.insertPiece(piece4);
			assertTrue(piece4.getIdPiece() > 0);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece5 = (Piece) context.getBean("pieceInsert");
			piece5.setCategorie(categorie);
			piece5.setPrix(Math.random() * 100);
			piece5.setLibelle("Piece de test");
			piece5.setTypePiece(TypePiece.ORIGINE);
			String reference5;
			reference5 = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece5.setReference(reference5);
			piece5.setQuantite((int) Math.random() * 20);
			piece5.addModele(appareil);

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
	public void testInsertPiece() {

		int aleatoire, aleatoire2;

		try {
			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

			Categorie categorie = (Categorie) context.getBean("categorieInsert");
			String stringCategorie;
			stringCategorie = "categorieTest" + aleatoire;
			categorie.setLibelle(stringCategorie);

			List<Piece> pieces = new ArrayList<>();
			service.insertCategorie(categorie);
			assertTrue(categorie.getIdCategorie() > 0);

			for (int i = 0; i < 5; i++) {

				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
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
				pieces.add(service.getPieceById(piece.getIdPiece()));

			}

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 5);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAllPiecesByAppareilCategorie() {

		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 10; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getAllPiecesBy(appareil, categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 55);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetPiecesOriginesByAppareilCategorie() {

		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {

				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);

			}

			List<Piece> pieces = service.getAllPiecesBy(appareil, categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 5);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetPiecesEquivalentesByAppareilCategorie() {

		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 10; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getPiecesEquivalentesBy(appareil, categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 50);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPiecesOriginesByCategorie() {

		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 2; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getPiecesOriginesBy(categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPiecesOriginesByAppareil() {
		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 10; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 2; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getPiecesOriginesBy(appareil);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPiecesEquivalentesByCategorie() {
		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 2; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getPiecesEquivalentesBy(categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPiecesEquivalentesByAppareil() {
		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 10; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getPiecesEquivalentesBy(appareil);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 50);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllPiecesByAppareil() {
		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 10; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getAllPiecesBy(appareil);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 55);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllPiecesByCategorie() {
		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 10; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getAllPiecesBy(categorie);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 55);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllPieces() {

		int aleatoire, aleatoire2;
		try {

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

			for (int i = 0; i < 10; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				for (int j = 0; j < 12; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);
				}

			}

			List<Piece> pieces = service.getAllPieces();

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			// assertEquals(pieces.size(), 130);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetPiecesEquivalentesByPiece() {

		int aleatoire, aleatoire2;
		try {

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

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			Piece piece = (Piece) context.getBean("pieceInsert");
			piece.setCategorie(categorie);
			piece.setPrix(Math.random() * 100);
			piece.setLibelle("Piece de test");
			piece.setTypePiece(TypePiece.ORIGINE);
			String reference;
			reference = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece.setReference(reference);
			piece.setQuantite((int) Math.random() * 20);
			piece.addModele(appareil);

			service.insertPiece(piece);
			assertTrue(piece.getIdPiece() > 0);
			for (int j = 0; j < 27; j++) {

				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece1 = (Piece) context.getBean("pieceInsert");
				piece1.setCategorie(categorie);
				piece1.setPrix(Math.random() * 100);
				piece1.setLibelle("Piece de test");
				piece1.setTypePiece(TypePiece.EQUIVALENTE);
				String reference1;
				reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece1.setReference(reference1);
				piece1.setQuantite((int) Math.random() * 20);
				piece1.setPieceOrigine(piece);

				service.insertPiece(piece1);
				assertTrue(piece1.getIdPiece() > 0);
			}

			List<Piece> pieces = service.getPiecesEquivalentesBy(piece);

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), 27);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Test
	// public void testAssociePieceAppareil() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testGetPieceById() {
		int aleatoire, aleatoire2;
		try {

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

			List<Piece> pieces = new ArrayList<>();

			for (int i = 0; i < 9; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				Long idPieceOrigine = piece.getIdPiece();
				pieces.add(service.getPieceById(idPieceOrigine));

				for (int j = 0; j < 17; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);

					Long idPieceEquiv = piece1.getIdPiece();
					pieces.add(service.getPieceById(idPieceEquiv));
				}

			}

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), (17 * 9) + 9);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPieceBy() {
		int aleatoire, aleatoire2;
		try {

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

			List<Piece> pieces = new ArrayList<>();

			for (int i = 0; i < 9; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				pieces.add(service.getPieceBy(reference));

				for (int j = 0; j < 17; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);

					pieces.add(service.getPieceBy(reference1));
				}

			}

			assertNotNull(pieces);
			assertFalse(pieces.isEmpty());
			assertEquals(pieces.size(), (17 * 9) + 9);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDeletePiece() {
		int aleatoire, aleatoire2;
		try {

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

			List<Piece> piecesOrigines = new ArrayList<>();
			List<Piece> piecesEquivalente = new ArrayList<>();

			for (int i = 0; i < 9; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				Piece piece = (Piece) context.getBean("pieceInsert");
				piece.setCategorie(categorie);
				piece.setPrix(Math.random() * 100);
				piece.setLibelle("Piece de test");
				piece.setTypePiece(TypePiece.ORIGINE);
				String reference;
				reference = "GHI" + aleatoire + "JKL" + aleatoire2;
				piece.setReference(reference);
				piece.setQuantite((int) Math.random() * 20);
				piece.addModele(appareil);

				service.insertPiece(piece);
				assertTrue(piece.getIdPiece() > 0);
				Long idPieceOrigine = piece.getIdPiece();
				piecesOrigines.add(service.getPieceById(idPieceOrigine));

				for (int j = 0; j < 17; j++) {

					aleatoire = ((int) (Math.random() * 10000));
					aleatoire2 = ((int) (Math.random() * 10000));
					Piece piece1 = (Piece) context.getBean("pieceInsert");
					piece1.setCategorie(categorie);
					piece1.setPrix(Math.random() * 100);
					piece1.setLibelle("Piece de test");
					piece1.setTypePiece(TypePiece.EQUIVALENTE);
					String reference1;
					reference1 = "GHI" + aleatoire + "JKL" + aleatoire2;
					piece1.setReference(reference1);
					piece1.setQuantite((int) Math.random() * 20);
					piece1.setPieceOrigine(piece);

					service.insertPiece(piece1);
					assertTrue(piece1.getIdPiece() > 0);

					Long idPieceEquiv = piece1.getIdPiece();
					piecesEquivalente.add(service.getPieceById(idPieceEquiv));
				}

			}

			assertNotNull(piecesOrigines);
			assertFalse(piecesOrigines.isEmpty());
			assertEquals(piecesOrigines.size(), 9);

			assertNotNull(piecesEquivalente);
			assertFalse(piecesEquivalente.isEmpty());
			assertEquals(piecesEquivalente.size(), (17 * 9));

			for (Piece pieceEquivalente : piecesEquivalente) {
				service.deletePiece(pieceEquivalente);
			}

			for (Piece pieceOrigine : piecesOrigines) {
				service.deletePiece(pieceOrigine);
			}

			List<Piece> piecesRemoved = service.getAllPiecesBy(appareil);
			assertNotNull(piecesRemoved);
			logger.info(piecesRemoved.size());
			assertTrue(piecesRemoved.size() == 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdatePiece() {

		int aleatoire, aleatoire2;
		try {

			aleatoire = ((int) (Math.random() * 1000));
			aleatoire2 = ((int) (Math.random() * 1000));
			
			Categorie categorie = (Categorie) context.getBean("categorieInsert");
			String stringCategorie;
			stringCategorie = "categorieTest" + aleatoire;
			categorie.setLibelle(stringCategorie);

			service.insertCategorie(categorie);
			assertTrue(categorie.getIdCategorie() > 0);

			
			
			Categorie categorie2 = (Categorie) context.getBean("categorieInsert");
			String stringCategorie2;
			stringCategorie2 = "categorieTest" + aleatoire2;
			categorie2.setLibelle(stringCategorie2);

			service.insertCategorie(categorie2);
			assertTrue(categorie2.getIdCategorie() > 0);
			
			
			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));
			
			
			Piece piece = (Piece) context.getBean("pieceInsert");
			piece.setCategorie(categorie2);
			piece.setPrix(Math.random() * 100);
			piece.setLibelle("Piece de test");
			piece.setTypePiece(TypePiece.ORIGINE);
			String reference;
			reference = "GHI" + aleatoire + "JKL" + aleatoire2;
			piece.setReference(reference);
			piece.setQuantite((int) Math.random() * 20);

			service.insertPiece(piece);
			assertTrue(piece.getIdPiece() > 0);
			Long idPieceOrigine = piece.getIdPiece();
			
			Piece piece2 =service.getPieceById(idPieceOrigine);
			Piece piece3 =service.getPieceById(idPieceOrigine);
			
			
			piece2.setCategorie(categorie2);
			piece2.setPrix(Math.random() * 100);
			piece2.setLibelle("piece mises a jour");
			piece2.setTypePiece(TypePiece.ORIGINE);
			String reference2;
			reference2 = "waza" + aleatoire + "MAZA" + aleatoire2;
			piece2.setReference(reference2);
			piece2.setQuantite((int) Math.random() * 20);
		
			service.updatePiece(piece2);
			
			Piece piece4 =service.getPieceById(idPieceOrigine);
			logger.info(piece4.toString());
			logger.info(piece3.toString());
			logger.info(piece4.equals(piece3));
			assertFalse(piece4.equals(piece3));
			
			
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
