package com.progettounivpm.SpringAPP.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tweet {
	private String created_at;
	private ArrayList<String> hashtags;
	private String isolanguage_code;
	private String result_type;
	private String in_reply;
	private String location;
	private String statuses_count;
	private String created_atuser;
	

	public String getCreated_atuser() {
		return created_atuser;
	}
	public void setCreated_atuser(String created_atuser) {
		this.created_atuser = created_atuser;
	}
	public String getStatuses_count() {
		return statuses_count;
	}
	public  void setStatuses_count(String statuses_count) {
		this.statuses_count = statuses_count;
	}
	private String created_at_user;
	public Tweet() {
		
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public ArrayList<String> getHashtags() {
		return hashtags;
	}
	public void setHashtags(ArrayList<String> temp_hashtags) {
		this.hashtags = temp_hashtags;
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

	
	public Tweet(String created_at, ArrayList<String> hashtags, String isolanguage_code, String result_type,
			String in_reply, String location, String statuses_count, String created_atuser, String created_at_user) {
		super();
		this.created_at = created_at;
		this.hashtags = hashtags;
		this.isolanguage_code = isolanguage_code;
		this.result_type = result_type;
		this.in_reply = in_reply;
		this.location = location;
		this.statuses_count = statuses_count;
		this.created_atuser = created_atuser;
		this.created_at_user = created_at_user;
	}
	public String getCreated_at_user() {
		return created_at_user;
	}
	public void setCreated_at_user(String created_at_user) {
		this.created_at_user = created_at_user;
	}
	
	
	
}


	
	
