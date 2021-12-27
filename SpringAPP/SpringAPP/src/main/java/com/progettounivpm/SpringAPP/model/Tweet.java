package com.progettounivpm.SpringAPP.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Tweet {
	private DataOra created_at;				// Data creazione tweet.
	private ArrayList<String> hashtags;		// Elenco degli altri hastag nel tweet oltre quello indicato.
	private String isolanguage_code;		// Lingua del tweet.
	private String result_type; 			// Recente o in Evidenza, dovrebbero essere le due sezioni dove compaiono i tweet.
	private Boolean in_reply;				// Se True si tratta di un tweet in risposta ad un altro. 
	private String location;				// Luogo di pubblicazione del tweet.
	private DataOra created_at_user;		// Data di creazione del profilo che ha pubblicato il tweet.
	private String statuses_count;			// Quanti altri tweet ha fatto l'utente che ha postato il tweet.
	
	
	public Tweet() {
		
	}
	
	public DataOra getCreated_at() {
		return created_at;
	}
	public String getCreated_at_Text() {
		return created_at.toString();
	}
	public void setCreated_at(String created_at) {
		this.created_at = new DataOra(created_at);
	}
	public ArrayList<String> getHashtags() {
		return hashtags;
	}
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
	
	public String toString() {
		return ("\n"+"Created at: "+getCreated_at_Text()+
				"\n"+"Location: "+getLocation()+
				"\n"+"Other Hashtags: "+getHashtagsText()+
				"\n"+"Tweet lenguage: "+getIsolanguage_code()+
				"\n"+"Result type: "+getResult_type()+
				"\n"+"In Repy: "+getIn_reply()+
				"\n"+"User_acount Created at: "+getCreated_at_user_Text()+
				"\n"+"Statuses count: "+getStatuses_count());
	}	

	public JSONObject toJSONObject() {
		JSONObject JoTweet = new JSONObject();
		
		JoTweet.put("created_at",getCreated_at_Text());
		JoTweet.put("hastags",getHashtagsText());
		JoTweet.put("isolanguage_code",getIsolanguage_code());
		JoTweet.put("result_type",getResult_type());
		JoTweet.put("in_reply",getIn_reply());
		JoTweet.put("created_at_user",getCreated_at_user_Text());
		JoTweet.put("statuses_count",getStatuses_count());
		
		return JoTweet;
	}
}
