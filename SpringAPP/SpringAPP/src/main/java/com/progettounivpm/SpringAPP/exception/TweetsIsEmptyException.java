package com.progettounivpm.SpringAPP.exception;

public class TweetsIsEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	public TweetsIsEmptyException () {
		super();
	}
	
	public TweetsIsEmptyException (String mesage) {
		super(mesage);
	}
	
}