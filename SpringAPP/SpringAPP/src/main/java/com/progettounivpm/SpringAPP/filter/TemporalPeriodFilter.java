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
		JSONArray JarrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			if ((t.getCreated_at().getGiorno()==giorno)&&(t.getCreated_at().getMese().equals(mese))&&(t.getCreated_at().getAnno()==anno))
				JarrayTweets.add(t.toJSONObject());
		}
		
		if (JarrayTweets.isEmpty()==true)
			oggettoFiltrato.put("Non ci sono tweets postati il "+giorno+"/"+mese+"/"+anno, JarrayTweets);
		else oggettoFiltrato.put("Tweets postati il "+giorno+"/"+mese+"/"+anno+" = "+JarrayTweets.size()+" ", JarrayTweets);
		
		/* Il JSONObject che restituiremo: 
		 * ha come stringa (tweets with hashtag+nome hashtag) 
		 * e come valore un JSONArray contenente svariati JSONObject (i tweet).
		 */
		return oggettoFiltrato;
	}

}
