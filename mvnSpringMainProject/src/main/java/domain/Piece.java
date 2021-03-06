package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import domain.enumerated.*;

@Entity
@Table(name = "PIECES")
@NamedQueries(value = { @NamedQuery(name = "Piece.getAll", query = "select c from Piece c"),
		@NamedQuery(name = "Piece.getByRef", query = "select p from Piece p where p.reference=:reference"),
		@NamedQuery(name = "Piece.getByPiece", query = "select p from Piece p where p=:piece") })

public class Piece implements Serializable {



	private static final long serialVersionUID = -1647155862030601711L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PIECE")	
	private Long idPiece;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PIECE_ORIGINE", nullable = true)
	private Piece pieceOrigine;

	@ManyToOne()
	@JoinColumn(name = "ID_CATEGORIE", nullable=false)
	@NotNull
	private Categorie categorie;

	@Column(name = "REFERENCE_PIECE", unique = true, nullable = false, length = 20)
	@Size(min = 12, max = 20, message = "la taille doit �tre comprise entre {min} et  {max}")
	@NotNull
	private String reference;

	@Column(name = "LIBELLE", length = 50)
	@NotNull
	private String libelle;

	@Column(name = "DESCRIPTION", length = 250)
	@Size(min=10, max=250, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String description;

	@Column(name = "PRIX", scale = 2)
	@NotNull
	@Min(0)
	@Digits(integer=7,fraction=2)
	private Double prix = 0.0;

	@Column(name = "QUANTITE")
	@NotNull(message = "Le champ ne peut pas �tre null")
	@Min(0)
	private Integer quantite;

	@OneToMany(mappedBy = "pieceOrigine", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private Set<Piece> pieceEquivalentes = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "DOCUMENTER", joinColumns = @JoinColumn(name = "ID_PIECE", nullable = false), inverseJoinColumns = @JoinColumn(name = "ID_DOCUMENT", nullable = false))
	private Set<Document> documents = new HashSet<>();

	@OneToMany(mappedBy = "piece", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE })
	private Set<Image> images = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "INSTALLER", joinColumns = @JoinColumn(name = "ID_PIECE", referencedColumnName = "ID_PIECE", nullable = false), inverseJoinColumns = @JoinColumn(name = "ID_APPAREIL"))
	private Set<Appareil> appareils = new HashSet<>();

	@Column(name = "TYPE_PIECE", length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypePiece TypePiece;

	public Piece() {
	}

	public Piece(Long id_piece, Piece pi_Origine, Categorie categorie, String reference, String libelle,
			String description, Double prix, Integer qte) {
		super();
		// this.idPiece = id_piece;
		this.pieceOrigine = pi_Origine;
		this.categorie = categorie;
		this.reference = reference;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = qte;

	}

	@SuppressWarnings("static-access")
	@Deprecated
	public Piece(String ref_Piece, String description, Categorie categorie) {

		this.reference = ref_Piece;
		this.description = description;
		this.categorie = categorie;
		this.libelle = "La Piece";
		this.prix = Math.random() * 100;
		this.quantite = (int) ((Math.random() * 10));
		this.TypePiece = TypePiece.ORIGINE;

	}

	@Deprecated
	public Piece(String ref_Piece, Piece pieceDOrigin, String description, Categorie categorie) {
		this.pieceOrigine = pieceDOrigin;
		this.reference = ref_Piece;
		this.description = description;
		this.categorie = categorie;
	}

	public void addModele(Appareil modele) {
		appareils.add(modele);
	}

	public void addDocument(Document document) {
		this.documents.add(document);
	}

	public void addPieceEquivalent(Piece pieceEquivalente) {
		this.getPieceEquivalentes().add(pieceEquivalente);
		pieceEquivalente.setPieceOrigine(this);
	}

	public void addImage(Image image) {
		this.getImages().add(image);
		image.setPiece(this);
	}

	public void removeAppareils(Appareil appareil) {
		this.getAppareils().remove(appareil);
	}

	public void removeDocument(Document document) {
		this.getDocuments().remove(document);
	}

	public void removePieceEquivalent(Piece pieceEquivalente) {
		this.getPieceEquivalentes().remove(pieceEquivalente);
		pieceEquivalente.setPieceOrigine(null);
	}

	public void removeImage(Image image) {
		this.getImages().remove(image);
		image.setPiece(null);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdPiece() {
		return idPiece;
	}

	public Piece getPieceOrigine() {
		return pieceOrigine;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public String getReference() {
		return reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrix() {
		return prix;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public Set<Piece> getPieceEquivalentes() {
		return pieceEquivalentes;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public Set<Image> getImages() {
		return images;
	}

	public Set<Appareil> getAppareils() {
		return appareils;
	}

	public TypePiece getTypePiece() {
		return TypePiece;
	}

	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}

	public void setPieceOrigine(Piece pieceOrigine) {
		this.pieceOrigine = pieceOrigine;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public void setPieceEquivalentes(Set<Piece> pieceEquivalentes) {
		this.pieceEquivalentes = pieceEquivalentes;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public void setAppareils(Set<Appareil> appareils) {
		this.appareils = appareils;
	}

	public void setTypePiece(TypePiece typePiece) {
		TypePiece = typePiece;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [idPiece=" + idPiece + ", reference=" + reference + ", libelle=" + libelle + ", description="
				+ description + ", prix=" + prix + ", quantite=" + quantite + ", TypePiece=" + TypePiece + "]";
	}

	
	
	
}
