package com.progettounivpm.SpringAPP.service;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b> Interfaccia </b> TwitterService che definisce i metodi che useremo nelle varie classi che la erediteranno.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
public interface TwitterService {
	
	/**
	 * <b>Metodo</b> astratto che effettuerà la chiamata URL (con i rispettivi parametri che passiamo).
	 * @param hashtag 
	 * @param count 
	 * @return JSONObject 
	 * @throws IOException
	 */
	public abstract JSONObject getJSONTweets(String hashtag,int count) throws IOException;
	
	/**
	 * <b>Metodo</b> astratto che effettuerà il parsing del JSONObject.
	 * @param tweets JSONObject contenente tutti i tweet.
	 * @return ArrayList di tipo Tweet. 
	 * @throws IOException
	 */
	public abstract ArrayList<Tweet> getTweetInfo(JSONObject tweets);
	
	/**
	 *  <b> Metodo </b> astratto toJSON che useremo per l'output.
	 * @param tweets ArrayList di tipo Tweet
	 * @return JSONObject che contiene i nostri tweet.
	 */
	public abstract JSONObject toJSON(ArrayList<Tweet> tweets); 
}
