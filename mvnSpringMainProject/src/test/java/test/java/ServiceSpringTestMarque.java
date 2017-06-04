package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.junit.After;
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

public class ServiceSpringTestMarque  {

	private static Logger logger = Logger.getLogger(ServiceSpringTestMarque.class);
	private static ApplicationContext context;

	@Autowired
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
	public void testInsertMarque() {
		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			List<Marque> marques;
			marques = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				Marque marque = (Marque) context.getBean("marqueInsert");
				marque.setEtatMarque(EtatMarque.ACTIVE);
				String stringMarque;
				stringMarque = "marqueTest" + aleatoire;
				marque.setMarque(stringMarque);

				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);
				Long idMarque = marque.getIdMarque();
				marques.add(service.getMarqueBy(idMarque));
			}

			assertFalse(marques.isEmpty());
			assertEquals(marques.size(), 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllMarques() {
		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			List<Marque> marques;

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				Marque marque = (Marque) context.getBean("marqueInsert");
				marque.setEtatMarque(EtatMarque.ACTIVE);
				String stringMarque;
				stringMarque = "marqueTest" + aleatoire;
				marque.setMarque(stringMarque);
				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);

			}

			marques = service.getAllMarques();
			assertFalse(marques.isEmpty());
			assertTrue(marques.size() >= 5);

		} catch (Exception e) {
			e.printStackTrace();
		}

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
	public void testDesableMarque() {

		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			aleatoire = ((int) (Math.random() * 10000));
			Marque marque = (Marque) context.getBean("marqueInsert");
			marque.setEtatMarque(EtatMarque.ACTIVE);
			String stringMarque;
			stringMarque = "marqueTest" + aleatoire;
			marque.setMarque(stringMarque);

			service.insertMarque(marque);
			assertTrue(marque.getIdMarque() > 0);
			Long idMarque = marque.getIdMarque();

			int i = service.desableMarque(marque);

			assertEquals(i, 1);
			marque = null;
			marque = service.getMarqueBy(idMarque);

			assertNotNull(marque);
			assertTrue(marque.getEtatMarque().equals(EtatMarque.INACTIVE));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetMarqueByString() {
		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			List<Marque> marques;

			marques = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				Marque marque = (Marque) context.getBean("marqueInsert");
				marque.setEtatMarque(EtatMarque.ACTIVE);
				String stringMarque;
				stringMarque = "marqueTest" + aleatoire;
				marque.setMarque(stringMarque);
				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);

				marques.add(service.getMarqueBy(stringMarque));

			}

			assertFalse(marques.isEmpty());
			assertTrue(marques.size() >= 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMarqueByLong() {
		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			List<Marque> marques;

			marques = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				Marque marque = (Marque) context.getBean("marqueInsert");
				marque.setEtatMarque(EtatMarque.ACTIVE);
				String stringMarque;
				stringMarque = "marqueTest" + aleatoire;
				marque.setMarque(stringMarque);
				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);
				Long idMarque = marque.getIdMarque();

				marques.add(service.getMarqueBy(idMarque));

			}

			assertFalse(marques.isEmpty());
			assertTrue(marques.size() >= 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEnableMarque() {

		try {

			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			aleatoire = ((int) (Math.random() * 10000));
			Marque marque = (Marque) context.getBean("marqueInsert");
			marque.setEtatMarque(EtatMarque.ACTIVE);
			String stringMarque;
			stringMarque = "marqueTest" + aleatoire;
			marque.setMarque(stringMarque);

			service.insertMarque(marque);
			assertTrue(marque.getIdMarque() > 0);
			Long idMarque = marque.getIdMarque();

			int i = service.enableMarque(marque);

			assertEquals(i, 1);
			marque = null;
			marque = service.getMarqueBy(idMarque);

			assertNotNull(marque);
			assertTrue(marque.getEtatMarque().equals(EtatMarque.ACTIVE));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdateMarque() {
		try {
			int aleatoire;
			aleatoire = ((int) (Math.random() * 10000));

			Marque marque = (Marque) context.getBean("marqueInsert");
			String stringType;
			stringType = "marqueTest" + aleatoire;
			marque.setMarque(stringType);
			marque.setEtatMarque(EtatMarque.ACTIVE);

			service.insertMarque(marque);
			assertTrue(marque.getIdMarque() > 0);

			Long idmarque;
			idmarque = marque.getIdMarque();
			Marque marque2, marque3, marque4;

			marque2 = service.getMarqueBy(idmarque);
			marque3 = service.getMarqueBy(idmarque);

			marque2.setMarque("test" + aleatoire + "Marque");

			service.updateMarque(marque2);

			marque4 = service.getMarqueBy(idmarque);
			logger.info(marque4);
			logger.info(marque3);
			assertFalse(marque4.equals(marque3));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(expected = ObjectNotFoundException.class)
	public void testDeleteMarque() {

		int aleatoire;
		aleatoire = ((int) (Math.random() * 10000));

		List<Marque> marques, marques2;
		marques = new ArrayList<>();
		marques2 = new ArrayList<>();
		try {

			for (int i = 0; i < 5; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				Marque marque = (Marque) context.getBean("marqueInsert");
				marque.setEtatMarque(EtatMarque.ACTIVE);
				String stringMarque;
				stringMarque = "marqueTest" + aleatoire;
				marque.setMarque(stringMarque);

				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);
				Long idMarque = marque.getIdMarque();
				marques.add(service.getMarqueBy(idMarque));
			}

			assertFalse(marques.isEmpty());
			assertEquals(marques.size(), 5);

			for (Marque marque : marques) {
				service.deleteMarque(marque);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Marque marque : marques) {
			marques2.add(service.getMarqueBy(marque.getIdMarque()));
		}
		assertTrue(marques.isEmpty());

	}

}
