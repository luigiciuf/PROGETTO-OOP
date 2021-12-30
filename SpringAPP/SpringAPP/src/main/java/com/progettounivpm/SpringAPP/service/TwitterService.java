package com.progettounivpm.SpringAPP.service;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b> Interfaccia </b> TwitterService che definisce i metodi che useremo nelle varie classi che la erediteranno
 * 
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 *
 */
// Interfaccia che definisce i metodi che useremo nelle classi che la erediteranno. 
public interface TwitterService {
	/**
	 * <b> Metodo </b> astratto GetJSONTweets che effettua la chiamata all'api 
	 * @param hashtag parametro da passare 
	 * @param count  parametro da passare 
	 * @return JSONObject 
	 * @throws IOException
	 */
	  
	/* Dichiarazione del metodo getJSONTweets:
	 * effettuer� la chiamata URL (con i rispettivi parametri che passiamo) 
	 * restituendo un JSONObject
	 */
	
	public abstract JSONObject getJSONTweets(String hashtag,int count) throws IOException;
	/**
	 * <b> Metodo </b> astratto che fa il parsing del JSONObject
	 * @param tweets JSONObject contenente tutti i tweet
	 * @return ArrayList di tipo Tweet 
	 * @throws IOException
	 */
	/* Dichiarazione del metodo che fa il parsing del JSONObject
	 * e restituisce un array di tipo Tweet
	 */
	public abstract ArrayList<Tweet> getTweetInfo(JSONObject tweets);
	/**
	 *  <b> Metodo </b> astratto toJSON usato per l'output
	 * @param tweets
	 * @return JSONObject usato per convertire l'arraylist 
	 */
	/* Dichiarazione del metodo toJSON
	 * usato per l'output
	 * che converte l'array con i nostri tweet in un JSONObject
	 */
	public abstract JSONObject toJSON(ArrayList<Tweet> tweets); 
}
