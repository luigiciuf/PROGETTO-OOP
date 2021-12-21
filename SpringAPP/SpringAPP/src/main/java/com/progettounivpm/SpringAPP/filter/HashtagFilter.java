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
		JSONArray jarray = new JSONArray();
		for (Tweet t: tweets) {
			JSONObject tweet = null;
			ArrayList<String> hashtags = t.getHashtags();
			for (String h: hashtags) {
				if (h.equals(hashtag)) {
					tweet.put("created_at",t.getCreated_at_Text());
					// da continuare
				}
				if(tweet != null) {
					jarray.add(tweet);
					break; // per evitare che continui a cercare nuovamente tra gli hashtag
				}
			}
			oggettoFiltrato.put("tweets with hashtag " + hashtag, jarray);
		}	
		return oggettoFiltrato;
	}

}
