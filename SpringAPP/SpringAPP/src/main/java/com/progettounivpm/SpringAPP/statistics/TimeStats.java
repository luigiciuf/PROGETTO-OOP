package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.DataOra;
import com.progettounivpm.SpringAPP.model.Tweet;

public class TimeStats implements Statistic{
	
	private ArrayList<Tweet> tweets;
	
	// definiamo il costruttore
	
	public TimeStats(ArrayList<Tweet> tweets) {
		super();
		this.tweets = tweets;
	}


	@Override
	public JSONObject Statistic() {
		int Fascia1 = 0;
		int Fascia2 = 0;
		int Fascia3 = 0;
		DataOra ora;
		JSONObject obj=new JSONObject();
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
		obj.put("Fascia 1 ( 09-14) : ", Fascia1*100/tweets.size()+"%");
		obj.put("Fascia 2 ( 14-20) : ", Fascia2*100/tweets.size()+"%");
		obj.put("Fascia 3 ( 21-04) : ", Fascia3*100/tweets.size()+"%");
		
		return obj;
	}


	@Override
	public HashMap Statistic1() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
