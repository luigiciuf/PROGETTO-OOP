package com.progettounivpm.SpringAPP.exception;

public class TweetsIsEmptyException extends Exception {
	
	private static final long serialVersionUID = 1L;

	TweetsIsEmptyException () {
		super();
	}
	
	TweetsIsEmptyException (String msg) {
		super(msg);
	}
	
}