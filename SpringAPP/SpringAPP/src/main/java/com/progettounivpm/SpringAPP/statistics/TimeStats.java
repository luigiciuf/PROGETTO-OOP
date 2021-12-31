package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.DataOra;
import com.progettounivpm.SpringAPP.model.Tweet;

/**
 *  <b>Classe</b> TimeStats che implementa Statistic e che restituisce le statistiche delle varie fasce orarie giornaliere.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
public class TimeStats implements Statistic{
	/**
	 * ArrayList che contiene tutti i tweet.
	 */
	private ArrayList<Tweet> tweets;

	/**
	 * Costruttore TimeStats che richiede come parametro un arraylist.
	 * @param tweets
	 */
	public TimeStats(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
	/**
	 *  <b>Metodo</b> statistic che restutuisce un JSONObject contenente le statistiche delle varie fascie orarie giornaliere.
	 *  @return JSONObject contenente tutte le statistiche, 
	 */
	@Override
	public JSONObject statistic() {
		JSONObject obj = new JSONObject();
		int Fascia1 = 0, Fascia2 = 0, Fascia3 = 0;
		DataOra ora;
		
		for(int i=0; i<tweets.size();i++) {
			ora= tweets.get(i).getCreated_at();
			if(ora.getOra()<=14 && ora.getOra()>=4)
				Fascia1++;
			else if(ora.getOra()<=20 && ora.getOra()>=14)
				Fascia2++;
			else 
				Fascia3++;	
		}
		obj.put("Tweet analizzati nelle 3 fasce orarie", tweets.size());
		obj.put("Fascia 1 (09-14) : ", Fascia1*100/tweets.size()+"%");
		obj.put("Fascia 2 (14-20) : ", Fascia2*100/tweets.size()+"%");
		obj.put("Fascia 3 (21-04) : ", Fascia3*100/tweets.size()+"%");
		
		return obj;
	}

	@Override
	public HashMap statistic1() {
		// TODO Auto-generated method stub
		return null;
	}

}
