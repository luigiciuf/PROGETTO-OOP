package com.progettounivpm.SpringAPP.filter;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.progettounivpm.SpringAPP.model.Tweet;

public class HashtagFilter implements Filter{
	private ArrayList<Tweet> tweets;
	private String 	hashtag;

	//Costruttore
	public HashtagFilter(String hashtag, ArrayList<Tweet> tweets) {
		this.hashtag = hashtag;
		this.tweets = tweets;
	}
	
	@Override
	public JSONObject filter() {
		
		JSONObject oggettoFiltrato = new JSONObject();
		JSONArray JarrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			ArrayList<String> hashtags = t.getHashtags();
			for (String h: hashtags) {
				if (h.equals(hashtag)) {
					//Solo se ha verificato la presenza dell'hashtag aggiunge il tweet all'array. 
					JarrayTweets.add(t.toJSONObject());
					//Per evitare che continui a cercare nuovamente tra gli hashtag usciamo dal ciclo for. 
					break;
				}
			}	
		}
		if (JarrayTweets.isEmpty()==true)
			oggettoFiltrato.put("Non ci sono tweets con hashtag: " + hashtag, JarrayTweets);
		else oggettoFiltrato.put("Tweets con hashtag: "+hashtag+" = "+JarrayTweets.size()+" ", JarrayTweets);
		
		/* Il JSONObject che restituiremo: 
		 * ha come stringa (tweets with hashtag+nome hashtag) 
		 * e come valore un JSONArray contenente svariati JSONObject (i tweet).
		 */
		return oggettoFiltrato;
	}

}
