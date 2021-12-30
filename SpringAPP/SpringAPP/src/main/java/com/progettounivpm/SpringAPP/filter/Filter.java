package com.progettounivpm.SpringAPP.filter;

import org.json.simple.JSONObject;

/**
 * <b>Interfaccia</b> che definisce i metodi dei filtri.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 *
 */
public interface Filter {
	
	/**
	 * <b>Metodo astratto</b> che verrà sovrascritto dalle classi che erediteranno l'interfaccia. Utilizzato per il filtraggio.
	 * @return JSONObject
	 */
	public abstract JSONObject filter();

}
