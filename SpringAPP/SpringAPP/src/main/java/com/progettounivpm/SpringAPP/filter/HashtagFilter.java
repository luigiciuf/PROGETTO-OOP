package com.progettounivpm.SpringAPP.filter;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b>Classe</b> HashtagFilter che implementa Filter. Filtrerà dall' ArrayList tutti i tweet che contengono l'hashtag specificato.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 *
 */
public class HashtagFilter implements Filter{
	/**
	 * <b>ArrayList</b> che contiene tutti i tweet da filtrare.
	 */
	private ArrayList<Tweet> tweets;
	/**
	 * Hashtag usato come parametro per filtrare i tweet.
	 */
	private String 	hashtag;

	/**
	 * <b>Costruttore</b>
	 * @param hashtag Stringa usata come parametro per filtrare i tweet
	 * @param tweets ArrayList che contiene tutti i tweet da filtrare.
	 */
	public HashtagFilter(String hashtag, ArrayList<Tweet> tweets) {
		this.hashtag = hashtag;
		this.tweets = tweets;
	}
	
	/**
	 * <b>Metodo</b> che filtra tutti i tweet contenenti l'hastag.
	 * @return Il JSONObject che restituiremo: ha come stringa ("tweets with hashtag"+nome dell'hashtag) e come valore un JSONArray contenente svariati JSONObject (i tweet).
	 */
	@Override
	public JSONObject filter() {
		
		JSONObject oggettoFiltrato = new JSONObject();
		JSONArray JarrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			ArrayList<String> hashtags = t.getHashtags();
			for (String h: hashtags) {
				if (h.equals(hashtag)) {
					//Solo se ha verificato la presenza dell'hashtag aggiunge il tweet all'array. 
					JarrayTweets.add(t.toJSONObject());
					//Per evitare che continui a cercare nuovamente tra gli hashtag usciamo dal ciclo for. 
					break;
				}
			}	
		}
		if (JarrayTweets.isEmpty()==true)
			oggettoFiltrato.put("Non ci sono tweets con hashtag: " + hashtag, JarrayTweets);
		else oggettoFiltrato.put("Tweets con hashtag: "+hashtag+" = "+JarrayTweets.size()+" ", JarrayTweets);
		
		return oggettoFiltrato;
	}

}
