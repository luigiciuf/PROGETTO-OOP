package com.progettounivpm.SpringAPP.model;

import java.util.ArrayList;

public class Tweet {
	private DataOra created_at;				// Data creazione tweet
	private ArrayList<String> hashtags;		// Elenco degli altri hastag nel tweet oltre quello indicato
	private String isolanguage_code;		// Lingua del tweet
	private String result_type; 			// Recente o in Evidenza, dovrebbero essere le due sezioni dove compaiono i tweet
	private String in_reply;				// ANCORA NON è ASSEGNATO A NULLA VISTO CHE CI SONO MOLTI TIPI DI INREPLY, IN GENERALE INDICA SE E' UN TWEET IN RISPOSTA 
	private String location;				// Luogo dove è stato pubblicato il tweet
	private DataOra created_at_user;		// Data creazione profilo che ha pubblicato il tweet
	private String statuses_count;			// Quanti altri tweet ha fatto l'utente che ha postato
	
	
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
	public String getIn_reply() {
		return in_reply;
	}
	public void setIn_reply(String in_reply) {
		this.in_reply = in_reply;
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
		// TODO
		return ("");
	}
}