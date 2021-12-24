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
			JSONObject tweet = new JSONObject();
			ArrayList<String> hashtags = t.getHashtags();
			for (String h: hashtags) {
				if (h.equals(hashtag)) {
					//solo se ha verificato la presenza dell'hashtag 
					//prima aggiunge all'oggetto temporaneo
					tweet.put("created_at",t.getCreated_at_Text());
					tweet.put("hastags",t.getHashtagsText());
					tweet.put("isolanguage_code",t.getIsolanguage_code());
					tweet.put("result_type",t.getResult_type());
					tweet.put("in_reply",t.getIn_reply());
					tweet.put("created_at_user",t.getCreated_at_user_Text());
					tweet.put("statuses_count",t.getStatuses_count());
					//poi aggiunge all'array contenente tutti i tweet filtrati
					arrayTweets.add(tweet);
					break; // per evitare che continui a cercare nuovamente tra gli hashtag
				}
			}
			oggettoFiltrato.put("tweets with hashtag " + hashtag, arrayTweets);
			//l'oggetto che restituiremo sarà formato da una stringa (tweets with hashtag+nome hashtag) e come valore, da un array contenente svariati oggetti che rappresentano i tweet
			
			//TODO: se arrayTweets è vuoto
		}	
		return oggettoFiltrato;
	}

}
