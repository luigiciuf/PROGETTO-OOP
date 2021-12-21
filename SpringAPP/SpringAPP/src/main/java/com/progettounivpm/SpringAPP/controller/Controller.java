package com.progettounivpm.SpringAPP.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progettounivpm.SpringAPP.model.Tweet;
import com.progettounivpm.SpringAPP.service.TwitterServiceImpl;
import com.progettounivpm.SpringAPP.statistics.DayStats;

@RestController
public class Controller {
	
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	public TwitterServiceImpl routh1;
	public JSONObject oggetto;
	
	@GetMapping(value= "/tweet/get")
	public ResponseEntity<Object> getTweetInfo( 
			@RequestParam ( name= "hashtag", defaultValue= "univpm") String hashtag,
			@RequestParam ( name= "count", defaultValue = "5" )int count)
			throws IOException{
		routh1= new TwitterServiceImpl();
		oggetto = routh1.getJSONTweets(hashtag,count);
		if (oggetto == null)
			return new ResponseEntity<Object>("ERRORE, chiamata inesistente",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(oggetto,HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/stampa")
	public ResponseEntity<Object> stampatweets(){
		tweets = routh1.getTweetInfo(oggetto);
		return new ResponseEntity<Object>(this.tweets,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping(value= "/tweet/daystats")
	public ResponseEntity<Object> stampastats(){
		DayStats statistiche= new DayStats(tweets);
		
		return new ResponseEntity<Object>(statistiche.Statistic(),HttpStatus.OK);
		
		
		
		
		

	

		
	}
	
	
	

	
	
	
	

	
	
	
		

}