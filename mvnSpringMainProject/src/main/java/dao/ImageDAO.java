package dao;

import java.util.List;

import domain.Image;
import domain.Piece;

public interface ImageDAO {


	public abstract List<Image> getBy(Piece piece);

	public abstract List<Image> getBy(String ref_piece);
	
	public abstract Image insert(Image image);

	public abstract int delete(Image image);

	public Image get(Long idImage);
	
}
