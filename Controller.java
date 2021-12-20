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

@RestController
public class Controller {
	public TwitterServiceImpl routh1;
	
	@GetMapping(value= "/tweet/get")
	public ResponseEntity<Object> getTweetInfo( 
			@RequestParam ( name= "hashtag", defaultValue= "univpm") String hashtag,
			@RequestParam ( name= "count", defaultValue = "5" )int count)
			
			 throws IOException{
	routh1= new TwitterServiceImpl();
	return new ResponseEntity<Object>(routh1.getJSONTweets(hashtag,count),HttpStatus.OK);
	
	
	
	
		
	}
	
	
	

	
	
	
	

	
	
	
		

}
