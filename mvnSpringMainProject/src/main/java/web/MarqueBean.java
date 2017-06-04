package web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import domain.Appareil;
import domain.Marque;
import domain.Piece;
import domain.Type;
import services.SpringServices;

public class MarqueBean {

	@Autowired
	private SpringServices service;

	public SpringServices getServices() {
		return service;
	}

	public void setServices(SpringServices service) {
		this.service = service;
	}
	


	private Marque marque;

	private List<Marque> marques;

	private Set<Marque> marques2;

	private Type type;


	private List<Type> types;


	private Set<Type> types2;

	private Appareil appareil;

	private Set<Appareil> appareils;

	private Set<Appareil> appareils2;

	private Piece piece;

	private List<Piece> pieces;
	
	private Set<Piece> pieces2;

//	@PostConstruct
//	public void init() {
//		System.out.println("merde");
//		marques = service.getAllMarque();
//		types = service.getAllType();
//		pieces = service.getAllPieces();
//		appareils = new HashSet<>(service.getAllAppareil());
//		types2 = new HashSet<>(types);
//		marques2 = new HashSet<>(marques);
//		appareils2 = new HashSet<>(appareils);
//		pieces2 = new HashSet<Piece>(pieces);
//	}


	public void onMarqueChange() {

		System.out.println(marque);
		types2.addAll(types);
		appareils2.addAll(appareils);
		marque = (marque.getMarque().equals("mrq")) ? null : service.getMarqueBy(marque.getMarque());
		System.out.println(marque != null);
		if (marque != null) {
			
			types2 = service.getTypesByMarque(marque);
			List<Appareil> lesAppareils = service.getAppareilByMarque(marque);
			System.out.println(lesAppareils.size());
			appareils2 = new HashSet<>(lesAppareils);
			System.out.println(appareils2.size());

		}

	}

	public void onTypeChange() {
		
		if (type != null) {
			type = service.getTypeBy(type.getType());
			if (marque != null) {
				marque = (marque.getMarque().equals("mrq")) ? null : service.getMarqueBy(marque.getMarque());
			}
	
			System.out.println(type);
			System.out.println(marque);
			if (type != null && marque != null) {
				appareils2 = new HashSet<>(service.getByAppareil(marque, type));
				System.out.println(appareils2.size());
			}
		}

		// types2.addAll(types);
		// appareils2.addAll(appareils);
		// marque = (marque.getMarque().equals("mrq"))? null :
		// service.getMarqueBy(marque.getMarque());
		// System.out.println(marque != null);
		// if (marque != null) {
		// types2 = service.getTypesByMarque(marque);
		// List<Appareil> lesAppareils = service.getAppareilByMarque(marque);
		// System.out.println(lesAppareils.size());
		// appareils2 = new HashSet<>(lesAppareils);
		// System.out.println(appareils2.size());
		//
		// }

	}

	
	public void onModeleChange(){
		System.out.println(appareil);
		if (appareil!= null) {
			appareil = service.getAppareilBy(appareil.getReferenceAppareil()); 
		}
		
		if (appareil != null) {
			pieces2 = new HashSet<Piece>();
			System.out.println(pieces2.size());
			pieces2.addAll(service.getAllPiecesBy(appareil));
			System.out.println(pieces2.size());
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void change() {
		System.out.println(type + " : " + marque);
		if (marque != null) {
		
		}
		
		if (type != null) {
			type = (type.getType().equals("typ")) ? null : service.getTypeBy(type.getType());
		}
		
		
		if (type == null && marque == null) {
			types2.addAll(types);
			appareils2.addAll(appareils);
		}

		if (marque != null && type == null) {
			types2 = service.getTypesByMarque(marque);
			List<Appareil> lesAppareils = service.getAppareilByMarque(marque);
			System.out.println(lesAppareils.size());
			appareils2 = new HashSet<>(lesAppareils);
			System.out.println(appareils2.size());
			types2 = new HashSet<>(types);
		}

		if (marque == null && type != null) {
			setMarques2(service.getMarquesByType(type));
			List<Appareil> lesAppareils = service.getAppareilByType(type);
			System.out.println(lesAppareils.size());
			appareils2 = new HashSet<>(lesAppareils);
			System.out.println(appareils2.size());
			setMarques2(new HashSet<>(marques));
		}

		if (marque != null && type != null) {
			List<Appareil> lesAppareils = service.getByAppareil(marque, type);
			appareils2 = new HashSet<>(lesAppareils);

		}
		
		
	

	}

	public Set<Marque> getMarques2() {
		return marques2;
	}

	public void setMarques2(Set<Marque> marques2) {
		this.marques2 = marques2;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	
	
}
