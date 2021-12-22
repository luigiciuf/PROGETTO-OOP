package com.progettounivpm.SpringAPP.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progettounivpm.SpringAPP.filter.HashtagFilter;
import com.progettounivpm.SpringAPP.filter.TemporalPeriodFilter;
import com.progettounivpm.SpringAPP.model.Tweet;
import com.progettounivpm.SpringAPP.service.TwitterServiceImpl;
import com.progettounivpm.SpringAPP.statistics.DayStats;
import com.progettounivpm.SpringAPP.statistics.HashtagsStats;
import com.progettounivpm.SpringAPP.statistics.TimeStats;

@RestController
public class Controller {
	
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private JSONObject allTweetsData;

	
	@GetMapping(value= "/tweet/get")
	public ResponseEntity<Object> getTweetInfo( 
			@RequestParam (name= "hashtag", defaultValue= "univpm") String hashtag,
			@RequestParam (name= "count", defaultValue = "5" )int count)
			throws IOException{
		TwitterServiceImpl downloadTweets = new TwitterServiceImpl();
		allTweetsData = downloadTweets.getJSONTweets(hashtag,count);
		if (allTweetsData == null)
			return new ResponseEntity<Object>("ERRORE, chiamata inesistente",HttpStatus.OK);
		else
			tweets = downloadTweets.getTweetInfo(allTweetsData);
			return new ResponseEntity<Object>(this.tweets,HttpStatus.OK);
	}
	
	
	@GetMapping(value= "/hastag_filter")
	public ResponseEntity<Object> filtroHashtag(
			// inserire eccezione se non è stato inserito il parametro
			@RequestParam (name= "hashtag") String hashtag){
		HashtagFilter hashtag_filter = new HashtagFilter(hashtag, tweets);
		return new ResponseEntity<Object>(hashtag_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/day_filter")
	public ResponseEntity<Object> filter(
			//TODO: defaultValue today
			@RequestParam (name= "day") int day,
			@RequestParam (name= "month")String month,
			@RequestParam (name= "year")int year){
		TemporalPeriodFilter day_filter = new TemporalPeriodFilter(tweets,day,month,year);
		return new ResponseEntity<Object>(day_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/tweet/timestats")
	public ResponseEntity<Object> timestats(){
		TimeStats time= new TimeStats(tweets);
		return new ResponseEntity<Object>(time.Statistic(),HttpStatus.OK);	
	}
	
	@GetMapping(value= "/tweet/daystats")
	public ResponseEntity<Object> stampastats(){
		DayStats statistiche= new DayStats(tweets);
		return new ResponseEntity<Object>(statistiche.Statistic(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/hashtagstats")
	public ResponseEntity<Object> hs(){
		HashtagsStats statistiche= new HashtagsStats(tweets);
		return new ResponseEntity<Object>(statistiche.Statistic1(), HttpStatus.OK);	
	}
		
		
	
	
		
		

	

		
	
	
	
	

	
	
	
	

	
	
	
		

}