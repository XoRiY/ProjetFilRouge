package test.java;

import static org.junit.Assert.*;

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
import domain.Appareil;

import domain.Marque;
import domain.Marque.EtatMarque;
import domain.Type;
import services.MonService;

public class SpringServiceTestAppareil {

	private static Logger logger = Logger.getLogger(SpringServiceTestAppareil.class);
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
	public void testInsertAppareil() {
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

			Long idAppareil = appareil.getIdAppareil();
			Appareil appGet;
			appGet = service.getAppareilBy(idAppareil);

			assertNotNull(appGet);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(expected=Exception.class)
	public void testDoublonAppareil() {
		
		Appareil appareil2 = null ;
		
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

			appareil2 = (Appareil) context.getBean("appareilInsert");
			appareil2.setDescription("appareil de test");
			appareil2.setMarque(marque);
			appareil2.setType(type);
			appareil2.setReferenceAppareil(referenceAppareil);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		service.insertAppareil(appareil2);

	}

	@Test
	public void testGetByAppareil() {

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

			Long idAppareil = appareil.getIdAppareil();
			Appareil appGet;
			appGet = service.getAppareilBy(idAppareil);

			assertNotNull(appGet);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

	@Test(expected =Exception.class)
	public void testDeleteAppareil() {

		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();
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

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

			service.deleteMarque(marque);
			service.deleteType(type);

		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		Marque marqueRemove = service.getMarqueBy(idMarque);
		Type typeRemove = service.getTypeBy(idType);
		assertNull(typeRemove);
		assertNull(marqueRemove);
	}

	@SuppressWarnings("unused")
	@Test
	public void testGetAllAppareil() {

		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();

			for (int i = 0; i < 10; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));

				Appareil appareil = (Appareil) context.getBean("appareilInsert");
				appareil.setDescription("appareil de test");
				appareil.setMarque(marque);
				appareil.setType(type);
				String referenceAppareil;
				referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
				appareil.setReferenceAppareil(referenceAppareil);

				service.insertAppareil(appareil);
				assertTrue(appareil.getIdAppareil() > 0);

			}

			List<Appareil> appareils = service.getAllAppareil();
			assertNotNull(appareils);
			assertTrue(appareils.size() >= 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetAppareilByLong() {
		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();
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

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

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

		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetAppareilByString() {

		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();

			Appareil appareil = (Appareil) context.getBean("appareilInsert");
			appareil.setDescription("appareil de test");
			appareil.setMarque(marque);
			appareil.setType(type);
			String referenceAppareil;
			referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
			appareil.setReferenceAppareil(referenceAppareil);

			service.insertAppareil(appareil);
			assertTrue(appareil.getIdAppareil() > 0);

			Appareil appGet;
			appGet = service.getAppareilBy(referenceAppareil);

			assertNotNull(appGet);

			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

			Appareil appareil2 = (Appareil) context.getBean("appareilInsert");
			appareil2.setDescription("appareil de test");
			appareil2.setMarque(marque);
			appareil2.setType(type);
			String referenceAppareil2;
			referenceAppareil2 = "ABC" + aleatoire + "DEF" + aleatoire2;
			appareil2.setReferenceAppareil(referenceAppareil2);

			service.insertAppareil(appareil2);
			assertTrue(appareil2.getIdAppareil() > 0);

			Appareil appGet2;
			appGet2 = service.getAppareilBy(referenceAppareil2);

			assertNotNull(appGet2);

		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void testUpdateAppareil() {

		Long idMarque = null, idType = null;

		try {

			int aleatoire, aleatoire2;
			aleatoire = ((int) (Math.random() * 10000));
			aleatoire2 = ((int) (Math.random() * 10000));

			Marque marque = (Marque) context.getBean("marqueInsert");
			marque.setEtatMarque(EtatMarque.ACTIVE);
			String stringMarque;
			stringMarque = "marqueTest" + aleatoire;
			marque.setMarque(stringMarque);

			if (service != null) {
				
				service.insertMarque(marque);
				assertTrue(marque.getIdMarque() > 0);
				
				idMarque = marque.getIdMarque();
				
				Type type = (Type) context.getBean("typeInsert");
				String stringType;
				stringType = "typeTest" + aleatoire;
				type.setType(stringType);
				
				service.insertType(type);
				assertTrue(type.getIdType() > 0);
				
				idType = type.getIdType();
				
				Appareil appareil = (Appareil) context.getBean("appareilInsert");
				appareil.setDescription("appareil de test");
				appareil.setMarque(marque);
				appareil.setType(type);
				String referenceAppareil;
				referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
				appareil.setReferenceAppareil(referenceAppareil);
				
				service.insertAppareil(appareil);
				assertTrue(appareil.getIdAppareil() > 0);
				
				Appareil appGet;
				appGet = service.getAppareilBy(referenceAppareil);
				
				assertNotNull(appGet);
				
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));
				
				Marque mUpdate = new Marque("marque a jour" + aleatoire2);
				service.insertMarque(mUpdate);
				assertTrue(mUpdate.getIdMarque() > 0);
				
				Type tUpdate = new Type("Type a jour" + aleatoire2);
				service.insertType(tUpdate);
				assertTrue(tUpdate.getIdType() > 0);
				
				appareil.setDescription("appareil de test mis a jour");
				appareil.setMarque(mUpdate);
				appareil.setType(tUpdate);
				String referenceAppareil2;
				referenceAppareil2 = "ABC" + aleatoire + "DEF" + aleatoire2;
				appareil.setReferenceAppareil(referenceAppareil2);
				
				service.updateAppareil(appareil);
				
				assertFalse(appareil.equals(appGet));
			}else{
				throw new NullPointerException("l'objet service est null");
			}

		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetAppareilByMarque() {
		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();

			for (int i = 0; i < 10; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));

				Appareil appareil = (Appareil) context.getBean("appareilInsert");
				appareil.setDescription("appareil de test");
				appareil.setMarque(marque);
				appareil.setType(type);
				String referenceAppareil;
				referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
				appareil.setReferenceAppareil(referenceAppareil);

				service.insertAppareil(appareil);
				assertTrue(appareil.getIdAppareil() > 0);

			}

			List<Appareil> appareils = service.getAppareilByMarque(marque);
			assertNotNull(appareils);
			assertEquals(appareils.size(), 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@Test
	public void testGetAppareilByType() {

		Long idMarque = null, idType = null;

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

			idMarque = marque.getIdMarque();

			Type type = (Type) context.getBean("typeInsert");
			String stringType;
			stringType = "typeTest" + aleatoire;
			type.setType(stringType);

			service.insertType(type);
			assertTrue(type.getIdType() > 0);

			idType = type.getIdType();

			for (int i = 0; i < 10; i++) {
				aleatoire = ((int) (Math.random() * 10000));
				aleatoire2 = ((int) (Math.random() * 10000));

				Appareil appareil = (Appareil) context.getBean("appareilInsert");
				appareil.setDescription("appareil de test");
				appareil.setMarque(marque);
				appareil.setType(type);
				String referenceAppareil;
				referenceAppareil = "ABC" + aleatoire + "DEF" + aleatoire2;
				appareil.setReferenceAppareil(referenceAppareil);

				service.insertAppareil(appareil);
				assertTrue(appareil.getIdAppareil() > 0);

			}

			List<Appareil> appareils = service.getAppareilByType(type);
			assertNotNull(appareils);
			assertEquals(appareils.size(), 10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
