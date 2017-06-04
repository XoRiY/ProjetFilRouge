package main;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Adresse;
import domain.Appareil;
import domain.Client;
import domain.Commande;
import domain.LigneDeCommande;
import domain.Piece;
import domain.enumerated.Pays;
import domain.enumerated.TypeAdresse;
import domain.enumerated.TypeVoie;
import services.MonService;

public class Main {

	public static Logger logger = Logger.getLogger(Main.class);

	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Autowired
	private static MonService monService;

	public static void main(String[] args) {
		try {
			
			monService = (MonService) appContext.getBean("monService");

			if (monService != null) {

				// m.setEtatMarque(Marque.EtatMarque.ACTIVE);
				// m.setMarque("wazZZaaaaa");
				// monService.insertMarque(m);

				// System.out.println(monService.getAllMarques().size());
				// System.out.println(monService.getAllAdresse().size());
				// System.out.println(monService.getAllAppareil().size());
				// System.out.println(monService.getAllCategorie().size());
				// System.out.println(monService.getAllClients().size());
				// System.out.println(monService.getAllCommande().size());
				// System.out.println(monService.getAllPieces().size());
				// System.out.println(monService.getAllType().size());

				Appareil appareil = (Appareil) appContext.getBean("appareilInsert");
				Appareil appareil2 = (Appareil) appContext.getBean("appareilInsert");
				System.out.println(appareil == appareil2);

				Short quantite = 2;

				Piece piece1, piece2, piece4;
				piece1 = monService.getPieceById(7l);
				piece2 = monService.getPieceById(8l);
				piece4 = monService.getPieceById(9l);

				Client client;
				client = monService.getClientById(15l);

				Adresse adresse = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrrousseau", 33220, "Sainte foy La grande",
						Pays.FRANCE, TypeAdresse.LIVRAISON);
				Adresse adresse2 = new Adresse(48, TypeVoie.RUE, "Jean Jacquesrrousseau", 33220, "Sainte foy La grande",
						Pays.FRANCE, TypeAdresse.FACTURATION);
				Commande commande = new Commande();

				LigneDeCommande ligneDeCommande = new LigneDeCommande();

				ligneDeCommande.setPiece(piece4);
				ligneDeCommande.setQuantite(quantite);
				ligneDeCommande.setTotalLigneCommande();

				LigneDeCommande ligneDeCommande2 = new LigneDeCommande();

				ligneDeCommande2.setPiece(piece2);
				ligneDeCommande2.setQuantite((short) (1));
				ligneDeCommande2.setTotalLigneCommande();

				LigneDeCommande ligneDeCommande3 = new LigneDeCommande();
				ligneDeCommande3.setPiece(piece1);
				ligneDeCommande3.setQuantite(quantite);
				ligneDeCommande3.setTotalLigneCommande();

				LigneDeCommande ligneDeCommande4 = new LigneDeCommande();
				ligneDeCommande4.setPiece(piece1);
				ligneDeCommande4.setQuantite((short) (5));
				ligneDeCommande4.setTotalLigneCommande();

				commande.setClient(client);

				commande.ajouterLigneDeCommande(ligneDeCommande);
				commande.ajouterLigneDeCommande(ligneDeCommande2);
				commande.ajouterLigneDeCommande(ligneDeCommande3);
				commande.ajouterLigneDeCommande(ligneDeCommande4);

				commande.addAdresse(adresse);
				commande.addAdresse(adresse2);

				commande.confirmer();

				Commande c = monService.insererCommande(commande);

				System.out.println(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
