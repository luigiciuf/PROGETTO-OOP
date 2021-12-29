package com.progettounivpm.SpringAPP.exception;

/* Eccezione che avvisa se l'hashtag usato nella prima rotta è inesistente.
 * Ovvero la chiamati API non restituisce nulla. 
 */
public class HashtagInexistentException extends Exception {
	private static final long serialVersionUID = 1L;
	 
	 public HashtagInexistentException () {
	 	super("ERRORE: hashtag inesistente. Effettuare nuovamente la chiamata.");
	 }

}
