package com.progettounivpm.SpringAPP.statistics;

import java.util.HashMap;
import org.json.simple.JSONObject;
/**
 * <b> Interfaccia </b> Statistic che definisce viene utilizzata per la formazione delle statistiche
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 *
 */

public interface Statistic {
	/**
	 * metodo astratto che verrà sovrascritto dalle varie classi 
	 * @return JSONObject 
	 */
	
	public abstract JSONObject statistic();
	/**
	 * metodo astratto che verrà sovrascritto dalle varie classi 
	 * @return Hashmap 
	 */
	public abstract HashMap statistic1();

}
