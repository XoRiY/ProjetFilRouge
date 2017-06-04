package dao;

import java.util.List;


import domain.*;

public interface PieceDAO {
	
	public abstract Piece insert(Piece piece);

	public abstract List<Piece> getAllBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getOriginesBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getEquivalentesBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getOriginesBy(Categorie categorie);

	public abstract List<Piece> getOriginesBy(Appareil appareil);

	public abstract List<Piece> getEquivalentesBy(Categorie categorie);
	
	public abstract List<Piece> getEquivalentesBy(Appareil appareil);

	public abstract List<Piece> getAllBy(Appareil appareil);

	public abstract List<Piece> getAllBy(Categorie categorie);
	
	public abstract List<Piece> getAll();

	public abstract List<Piece> getEquivalentesBy(Piece pieceOrigine);

	public abstract void associe(Piece piOrigine, Appareil appareil);

	public abstract Piece getPieceById(Long idPiece);

	public abstract Piece getPieceBy(String referencePiece);

	public abstract void delete(Piece piece);

	public abstract void update(Piece newPiece);
}
//
/// *
// * @(#)Blah.java 1.82 99/03/18
// *
// * Copyright (c) 1994-1999 Sun Microsystems, Inc.
// * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
// * All Rights Reserved.
// *
// * This software is the confidential and proprietary information of Sun
// * Microsystems, Inc. ("Confidential Information"). You shall not
// * disclose such Confidential Information and shall use it only in
// * accordance with the terms of the license agreement you entered into
// * with Sun.
// */
/// *package java.blah;
// import java.blah.blahdy.BlahBlah;
/// **
// * Class description goes here.
// *
// * @version 1.82 18 Mar 1999
// * @author Firstname Lastname
// */
// public class Blah extends SomeClass {
/// * A class implementation comment can go here. */
/// ** classVar1 documentation comment */
// public static int classVar1;
/// **
// * classVar2 documentation comment that happens to be
// * more than one line long
// */
// private static Object classVar2;
/// ** instanceVar1 documentation comment */
// public Object instanceVar1;
/// ** instanceVar2 documentation comment */
// protected int instanceVar2;
/// ** instanceVar3 documentation comment */
// private Object[] instanceVar3;
/// **
// * ...constructor Blah documentation comment...
// */
// public Blah() {
//// ...implementation goes here...
// }
/// **
// * ...method doSomething documentation comment...
// */
// public void doSomething() {
//// ...implementation goes here...
// }
// 11 - Code Examples
// 20
/// **
// * ...method doSomethingElse documentation comment...
// * @param someParam description
// */
// public void doSomethingElse(Object someParam) {
//// ...implementation goes here...
// }
// }