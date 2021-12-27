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
	
	//Costruttore
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
			if ((t.getCreated_at().getGiorno()==giorno)&&(t.getCreated_at().getMese().equals(mese))&&(t.getCreated_at().getAnno()==anno)) {
				arrayTweets.add(t.toJSONObject());
			}
			oggettoFiltrato.put("tweets posted on "+giorno+"/"+mese+"/"+anno, arrayTweets);
		}
		return oggettoFiltrato;
	}

}
