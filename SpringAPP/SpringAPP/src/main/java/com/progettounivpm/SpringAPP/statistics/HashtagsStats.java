 package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

public class HashtagsStats implements Statistic {
	private ArrayList<Tweet> tweets;
	private int nulli;
	

	//Costruttore
	public HashtagsStats(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	@Override
	public JSONObject Statistic() {
		JSONObject risultati = new JSONObject();
		risultati.put("Tweet scaricati:",tweets.size());
		nulli=0;
		risultati.put("Ricorrenze hashtag", Statistic1());
		risultati.put("Tweet senza altri hashtag: ", nulli);
		return risultati;
	}
	
	public HashMap<String, Integer> Statistic1() {
		HashMap<String,Integer> temp= new LinkedHashMap<String,Integer>();
		//Usiamo LinkedHashMap per mantenere l'ordine di inserimento.
		//Purtroppo non è possibile fare lo stesso per i jsonobject.
		
		for (Tweet t: tweets) {
			ArrayList<String> hashtags= t.getHashtags();
			if(hashtags.isEmpty()==true)
				nulli++;
			for(String h: hashtags) {
				//Inseriamo il primo elemento, nel caso in cui l'HashMap sia ancora vuota. Altrimetni non farebbe nessuna iterazione del ciclo che segue.
				if(temp.size()==0)
					temp.put(h, 1);
				else {
					int j=1; //Usiamo j per verificare la posizone nell'HashMap nel ciclo seguente. 
					for(String i:temp.keySet()) {
						//Se il keyvalue j-esimo dell'HashMap corrisponde all' hashtag h, incrementa il valore.
						if(h.equals(i)) {
							temp.replace(h,temp.get(i)+1);
						}
						//Altrimenti, se abbiamo ciclato per tutta l'hashmap  aggiunge l'hashtag in fondo.
						else if (j==temp.size()) {
							temp.put(h, 1);
							break; // Inserito per evitare che al prossimo controllo del for non consideri anche il nuovo elemento aggiunto.
						}
						//Incrementiamo j per verificare alla prossima iterazione se siamo arrivati in fondo a l'HashMap.
						j++;
					}
				}
			}
		}
		return temp;
	}
	
}