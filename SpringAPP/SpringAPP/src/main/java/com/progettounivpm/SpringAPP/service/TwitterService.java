package com.progettounivpm.SpringAPP.service;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;


// Interfaccia che definisce i metodi che useremo nelle classi che la erediteranno. 
public interface TwitterService {
	  
	/* Dichiarazione del metodo getJSONTweets:
	 * effettuerà  la chiamata URL (con i rispettivi parametri che passiamo) 
	 * restituendo un JSONObject
	 */
	public abstract JSONObject getJSONTweets(String hashtag,int count) throws IOException;
	/* Dichiarazione del metodo che fa il parsing del JSONObject
	 * e restituisce un array di tipo Tweet
	 */
	public abstract ArrayList<Tweet> getTweetInfo(JSONObject tweets);
	/* Dichiarazione del metodo toJSON
	 * usato per l'output
	 * che converte l'array con i nostri tweet in un JSONObject
	 */
	public abstract JSONObject toJSON(ArrayList<Tweet> tweets); 
}
