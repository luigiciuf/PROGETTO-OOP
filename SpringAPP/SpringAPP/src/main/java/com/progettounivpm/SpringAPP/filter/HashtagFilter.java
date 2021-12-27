package com.progettounivpm.SpringAPP.filter;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.progettounivpm.SpringAPP.model.Tweet;

public class HashtagFilter implements Filter{
	private String 	hashtag;
	private ArrayList<Tweet> tweets;

	//Costruttore
	public HashtagFilter(String hashtag, ArrayList<Tweet> tweets) {
		this.hashtag = hashtag;
		this.tweets = tweets;
	}
	
	@Override
	public JSONObject filter() {
		
		JSONObject oggettoFiltrato = new JSONObject();
		JSONArray arrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			ArrayList<String> hashtags = t.getHashtags();
			for (String h: hashtags) {
				if (h.equals(hashtag)) {
					//solo se ha verificato la presenza dell'hashtag 
					//aggiunge all'array il tweet
					arrayTweets.add(t.toJSONObject());
					break; // per evitare che continui a cercare nuovamente tra gli hashtag
				}
			}
			oggettoFiltrato.put("tweets with hashtag " + hashtag, arrayTweets);
			//l'oggetto che restituiremo sarà formato da una stringa (tweets with hashtag+nome hashtag) e come valore, da un array contenente svariati oggetti che rappresentano i tweet
			
			//TODO: eccezione se arrayTweets vuoto
		}	
		return oggettoFiltrato;
	}

}
