package com.progettounivpm.SpringAPP.filter;

import org.json.simple.JSONObject;

public interface Filter {
	
	// Metodo che restituisce un JSONObject con i dati filtrati.
	public abstract JSONObject filter();

}
