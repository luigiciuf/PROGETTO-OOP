package com.progettounivpm.SpringAPP.service;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;


// INTERFACCIA CHE DEFINISCE (STANDARDIZZA) I METODI CHE USEREMO NELLE CLASSI CHE LA EREDITERANNO 
 
public interface TwitterService {
	  
	
	// dichiarazione del metodo getJSONTweets che effettuerà la chiamata URL (con i rispettivi parametri che passiamo) restituendo un JSONObkect 
	public abstract JSONObject getJSONTweets(String hashtag) throws IOException;
	// dichiarazione del metodo che fa il parsing del json e restituisce un array di tipo Tweet
	public abstract ArrayList<Tweet> getTweetInfo(JSONObject tweets);
	// dichiarazione del metodo toJSON (di tipo JSONObject) che fornisce L'OUTPUT DEL NOSTRO PROGRAMMA
	public abstract JSONObject toJSON(); 
}
