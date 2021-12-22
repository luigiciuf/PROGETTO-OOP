package com.progettounivpm.SpringAPP.service;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;


// INTERFACCIA CHE DEFINISCE I METODI CHE USEREMO NELLE CLASSI CHE LA EREDITERANNO 
 
public interface TwitterService {
	  
	// dichiarazione del metodo getJSONTweets che effettuerà  la chiamata URL (con i rispettivi parametri che passiamo) restituendo un JSONObject 
	public abstract JSONObject getJSONTweets(String hashtag,int count) throws IOException;
	// dichiarazione del metodo che fa il parsing del JSONObject e restituisce un array di tipo Tweet
	public abstract ArrayList<Tweet> getTweetInfo(JSONObject tweets);
	// dichiarazione del metodo toJSON che converte l'array con i nostri tweet in un JSONObject
	public abstract JSONObject toJSON(ArrayList<Tweet> tweets); 
}
