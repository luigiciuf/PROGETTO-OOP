package com.progettounivpm.SpringAPP.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;
/**
 * <b> Classe </b> Tweet

 */

public class Tweet {
	/**
	 * Data creazione tweet
	 */
	private DataOra created_at;
	/**
	 * Elenco degli altri hastag nel tweet oltre quello indicato.									
	 */
	
	private ArrayList<String> hashtags;
	/**
	 *  Lingua del tweet.
	 */
	 										
	private String isolanguage_code;
	/**
	 * Recente o in Evidenza, dovrebbero essere le due sezioni dove compaiono i tweet.
	 */										
	private String result_type;
	/**
	 * Se True si tratta di un tweet in risposta ad un altro. 
	 */										
	private Boolean in_reply;
	/**
	 * Luogo di pubblicazione del tweet.
	 */										 
	private String location;
	/**
	 * Data di creazione del profilo che ha pubblicato il tweet.
	 */										
	private DataOra created_at_user;
	/**
	 * Quanti altri tweet ha fatto l'utente che ha postato il tweet
	 */										
	private String statuses_count;			
	
	
	public Tweet() {
		
	}
	
	public DataOra getCreated_at() {
		return created_at;
	}
	/**
	 *  Metodo che utilizza toString di DataOra per riottenere una Stringa.
	 */
	public String getCreated_at_Text() {
		return created_at.toString();
	}
	public void setCreated_at(String created_at) {
		this.created_at = new DataOra(created_at);
	}
	public ArrayList<String> getHashtags() {
		return hashtags;
	}
	/**
	 * Metodo per riottenere una stringa con tutti gli hashtag.
	 */
	// Metodo per riottenere una stringa con tutti gli hashtag.
	public String getHashtagsText() {
		String s = null;
		for (String str: hashtags) {
			if (s == null) s = str;
			else s = s + ", " + str;
		}
		if (s==null) s="";
		return s;
		}
		
	public void setHashtags(ArrayList<String> hashtags) {
		this.hashtags = hashtags;
	}
	public String getIsolanguage_code() {
		return isolanguage_code;
	}
	public void setIsolanguage_code(String isolanguage_code) {
		this.isolanguage_code = isolanguage_code;
	}
	public String getResult_type() {
		return result_type;
	}
	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}
	public boolean getIn_reply() {
		return in_reply;
	}
	public void setIn_reply(String in_reply_to_status_id ) {
		if (in_reply_to_status_id == null) 
			this.in_reply = false;
		else 
			this.in_reply = true;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public DataOra getCreated_at_user() {
		return created_at_user;
	}
	public String getCreated_at_user_Text() {
		return created_at_user.toString();
	}
	public void setCreated_at_user(String created_at_user) {
		this.created_at_user = new DataOra(created_at_user);
	}
	public String getStatuses_count() {
		return statuses_count;
	}
	public void setStatuses_count(String statuses_count) {
		this.statuses_count = statuses_count;
	}
	/**
	 * <b> Metodo </b> toString ridefinito per essere utilizzato
	 */
	
	public String toString() {
		return ("\n"+"Created at: "+getCreated_at_Text()+
				"\n"+"Location: "+getLocation()+
				"\n"+"Other Hashtags: "+getHashtagsText()+
				"\n"+"Tweet lenguage: "+getIsolanguage_code()+
				"\n"+"Result type: "+getResult_type()+
				"\n"+"In Repy: "+getIn_reply()+
				"\n"+"User_account Created at: "+getCreated_at_user_Text()+
				"\n"+"Statuses count: "+getStatuses_count());
	}	

	/**
	 * <b> Metodo </b> toJSONObject che restituisce un jsonObject con tutte le variabuli interne della classe tweet
	 * 
	 * @return <JoTweet> JSONObject
	 */
	public JSONObject toJSONObject() {
		JSONObject JoTweet = new JSONObject();
		//Purtroppo non � possibile conservare l'ordine dei put.
		JoTweet.put("created_at",getCreated_at_Text());
		JoTweet.put("hastags",getHashtagsText());
		JoTweet.put("isolanguage_code",getIsolanguage_code());
		JoTweet.put("result_type",getResult_type());
		JoTweet.put("in_reply",getIn_reply());
		JoTweet.put("location",getLocation());
		JoTweet.put("created_at_user",getCreated_at_user_Text());
		JoTweet.put("statuses_count",getStatuses_count());
		
		return JoTweet;
	}
}
