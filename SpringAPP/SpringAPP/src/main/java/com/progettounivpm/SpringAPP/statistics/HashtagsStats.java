 package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.exception.TweetsIsEmptyException;
import com.progettounivpm.SpringAPP.model.Tweet;

public class HashtagsStats implements Statistic {
	
	private ArrayList<Tweet> hstats;
	private int nulli;
	

	public HashtagsStats(ArrayList<Tweet> hstats) {
		
		
		this.hstats = hstats;
	}


	@Override
	public JSONObject Statistic() {
		JSONObject risultati = new JSONObject();
		risultati.put("Tweet scaricati:",hstats.size());
		risultati.put("Ricorrenze hashtag", Statistic1());
		risultati.put("Tweet con hashtag nulli: ", nulli);
	return risultati;
	}
	
	
	
	public HashMap<String, Integer> Statistic1() {
		HashMap<String,Integer> temp= new HashMap<String,Integer>();
		
		
		for ( Tweet t: hstats) {
			ArrayList<String> hashtags= t.getHashtags();
			if(hashtags.isEmpty()==true)
				nulli++;
			for(String h: hashtags) {
				//se l'HashMap è ancora vuota inseriamo il primo elemento , altrimetni non farebbe nessuna iterazione
				// del ciclo successvo
				if(temp.size()==0)
					temp.put(h, 1);
				else {
					int j=1; // usiamo j per verificare la posizone dell'HAshMap nel ciclo successivo 
					for(String i:temp.keySet()) {
						// se il keyvalue j-esimo dell'hashmap è uguale all' hashtag h , incrementa il valore
						
						if(h.equals(i)) {
							temp.replace(h,temp.get(i)+1);
						}
						//altrimenti se abbiamo ciclato per tutta l'hashmap  aggiunge l'hashtag in fondo
						
						else if ( j==temp.size()) {
							temp.put(h, 1);
							break; // inserito per securezza per evitare che al prossimo controllo del for non consideri anhc el'incremento
							
						}
						j++;
						// incrementiamo j per verificare succesivamente se siamo arrivati in fondo a l'hashmap
					}
				}
			}
		}
		
		
		
		
		
		return temp;
	}
}

		
			
			
			
			
		
		

		
		
		
	
	


