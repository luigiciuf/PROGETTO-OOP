package com.progettounivpm.SpringAPP.filter;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b>Classe</b> TemporalPeriodFilter che implementa Filter. Filtrerà dall' ArrayList tutti i tweet che sono stati postati nella data specificata.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 *
 */
public class TemporalPeriodFilter implements Filter{
	/**
	 * <b>ArrayList</b> che contiene tutti i tweet da filtrare.
	 */
	private ArrayList<Tweet> tweets;
	/**
	 * <b>int</b> che specifica il giorno in cui filtrare.
	 */
	private int giorno;
	/**
	 * <b>String</b> che specifica il mese filtrare. Ad esempio Dec per indicare Dicembre.
	 */
	private String mese;
	/**
	 * <b>int</b> che specifica l'anno in cui filtrare.
	 */
	private int anno;
	
	/**
	 * <b>Costruttore</b>
	 * @param tweets ArrayList che contiene tutti i tweet da filtrare.
	 * @param giorno int che specifica il giorno in cui filtrare.
	 * @param mese String che specifica il mese filtrare. Ad esempio Dec per indicare Dicembre.
	 * @param anno int che specifica l'anno in cui filtrare.
	 */
	public TemporalPeriodFilter(ArrayList<Tweet> tweets, int giorno, String mese, int anno) {
		this.tweets = tweets;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
	}
	
	/**
	 * <b>Metodo</b> che filtra tutti i tweet sono stati postati nella data specificata.
	 * @return Il JSONObject che restituiremo: ha come stringa ("Tweets postati il "+giorno+"/"+mese+"/"+anno+" = ") e come valore un JSONArray contenente svariati JSONObject (i tweet).
	 */
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
		
		return oggettoFiltrato;
	}

}
