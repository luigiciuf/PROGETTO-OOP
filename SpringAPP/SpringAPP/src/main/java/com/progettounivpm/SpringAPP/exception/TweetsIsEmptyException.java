package com.progettounivpm.SpringAPP.exception;

/* Eccezione che avvisa se non sono ancora stati scaricati tweet.
 * La prima Rotta da deve essere /tweet/get. 
 */
public class TweetsIsEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	public TweetsIsEmptyException () {
		super("ERRORE: Lanciare prima la Rotta /tweet/get");
	}
	
}