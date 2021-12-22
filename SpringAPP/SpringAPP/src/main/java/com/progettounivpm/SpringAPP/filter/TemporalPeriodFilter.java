package com.progettounivpm.SpringAPP.filter;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

public class TemporalPeriodFilter implements Filter{
	private ArrayList<Tweet> tweets;
	private int giorno;
	private String mese;
	private int anno;
	
	public TemporalPeriodFilter(ArrayList<Tweet> tweets, int giorno, String mese, int anno) {
		this.tweets = tweets;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
	}
	
	@Override
	public JSONObject filter() {
		
		JSONObject oggettoFiltrato = new JSONObject();
		JSONArray arrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			JSONObject tweet = new JSONObject();
			if ((t.getCreated_at().getGiorno()==giorno)&&(t.getCreated_at().getMese().equals(mese))&&(t.getCreated_at().getAnno()==anno)) {
				tweet.put("created_at",t.getCreated_at_Text());
				tweet.put("hastags",t.getHashtagsText());
				tweet.put("isolanguage_code",t.getIsolanguage_code());
				tweet.put("result_type",t.getResult_type());
				tweet.put("in_reply",t.getIn_reply());
				tweet.put("created_at_user",t.getCreated_at_user());
				tweet.put("statuses_count",t.getStatuses_count());
				
				arrayTweets.add(tweet);
			}
			oggettoFiltrato.put("tweets posted on "+giorno+"/"+mese+"/"+anno, arrayTweets);
		}
		return oggettoFiltrato;
	}

}
