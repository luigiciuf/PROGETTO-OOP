package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

public class HashtagsStats implements Statistic {
	
	private ArrayList<Tweet> hstats;
	

	public HashtagsStats(ArrayList<Tweet> hstats) {
		
		
		this.hstats = hstats;
	}


	@Override
	public JSONObject Statistic() {
		
		return null;
	}
	
	
	
	public HashMap<String, Integer> Statistic1() {
		HashMap<String,Integer> temp= new HashMap<String,Integer>();
		
		for ( Tweet t: hstats) {
			ArrayList<String> hashtags= t.getHashtags();	
			for(String h: hashtags) {
				if(temp.size()==0)
					temp.put(h, 1);
				else {
					int j=1;
					for(String i:temp.keySet()) {
						if(h.equals(i)) {
							temp.replace(h,temp.get(i)+1);
						}
						else if ( j==temp.size()) {
							temp.put(h, 1);
							break;
						}
						j++;
					}
				}
			}
		}
		temp.put("Tweet scaricati" ,hstats.size());
		
		return temp;
	}
}

		
			
			
			
			
		
		

		
		
		
	
	


