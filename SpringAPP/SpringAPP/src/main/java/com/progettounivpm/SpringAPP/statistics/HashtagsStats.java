package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;

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
			for (String h: hashtags) {
				int j=0; 
				for(String i : temp.keySet())
				{
					if (h.equals(i)) 
						temp.replace(h, temp.get(i)+1);												
					if(j==temp.size())
						temp.put(h,1);
					j++;
				}
					
			}
		}
		return temp;
			
	}

}		
			
			
			
			
		
		

		
		
		
	
	


