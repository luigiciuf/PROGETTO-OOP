package com.progettounivpm.SpringAPP.statistics;

import java.util.HashMap;
import org.json.simple.JSONObject;

/**
 * <b>Interfaccia</b> Statistic che definisce i metodi usati per le statistiche.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
public interface Statistic {
	
	/**
	 * Metodo astratto che verrà sovrascritto dalle varie classi. 
	 * @return JSONObject 
	 */
	public abstract JSONObject statistic();
	
	/**
	 * Metodo astratto che verrà sovrascritto dalle varie classi. 
	 * @return Hashmap 
	 */
	public abstract HashMap statistic1();

}
