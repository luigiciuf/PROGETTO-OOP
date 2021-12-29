package com.progettounivpm.SpringAPP.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progettounivpm.SpringAPP.exception.HashtagInexistentException;
import com.progettounivpm.SpringAPP.exception.TweetsIsEmptyException;
import com.progettounivpm.SpringAPP.filter.HashtagFilter;
import com.progettounivpm.SpringAPP.filter.TemporalPeriodFilter;
import com.progettounivpm.SpringAPP.model.Tweet;
import com.progettounivpm.SpringAPP.service.TwitterServiceImpl;
import com.progettounivpm.SpringAPP.statistics.DayStats;
import com.progettounivpm.SpringAPP.statistics.HashtagsStats;
import com.progettounivpm.SpringAPP.statistics.TimeStats;

@RestController
public class Controller {
	
	private JSONObject allTweetsData; //JSONObject contenente il JSON ottenuto dalla chiamata API.
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); //ArrayList contenente i Tweet ottenuti dopo il PARSING.
	
	
	@GetMapping(value= "/tweet/get")
	public ResponseEntity<Object> getTweetInfo( 
			@RequestParam (name= "hashtag", defaultValue= "univpm") String hashtag,
			@RequestParam (name= "count", defaultValue = "100" )int count)
					throws HashtagInexistentException, IOException{
		TwitterServiceImpl downloadTweets = new TwitterServiceImpl();
		allTweetsData = downloadTweets.getJSONTweets(hashtag,count);
		tweets = downloadTweets.getTweetInfo(allTweetsData);
		if (tweets.size() == 0)
			throw new HashtagInexistentException();
		else
			return new ResponseEntity<Object>(downloadTweets.toJSON(tweets),HttpStatus.OK);
	}
	
	@GetMapping(value= "/hastag_filter") 
	public ResponseEntity<Object> filtroHashtag (
			@RequestParam (name= "hashtag") String hashtag) 
					throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagFilter hashtag_filter = new HashtagFilter(hashtag, tweets);
		return new ResponseEntity<Object>(hashtag_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/day_filter")
	public ResponseEntity<Object> filter(
			@RequestParam (name= "day") int day,
			@RequestParam (name= "month")String month,
			@RequestParam (name= "year")int year) 
					throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TemporalPeriodFilter day_filter = new TemporalPeriodFilter(tweets,day,month,year);
		return new ResponseEntity<Object>(day_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/tweet/timestats")
	public ResponseEntity<Object> timestats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TimeStats timestats = new TimeStats(tweets);
		return new ResponseEntity<Object>(timestats.Statistic(),HttpStatus.OK);	
	}
	
	@GetMapping(value= "/tweet/daystats")
	public ResponseEntity<Object> stampastats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		DayStats daystats = new DayStats(tweets);
		return new ResponseEntity<Object>(daystats.Statistic(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/hashtagstats")
	public ResponseEntity<Object> hs() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagsStats statistiche = new HashtagsStats(tweets);
		return new ResponseEntity<Object>(statistiche.Statistic(), HttpStatus.OK);	
	}
	
	//Metodo ausiliario, usato in tutte le rotte (eccetto la prima) per verificare se sono stati scaricati tweet.
	private static void TweetsisEmpty(ArrayList<Tweet> tweets) throws TweetsIsEmptyException {
		if (tweets.isEmpty()==true) 
			throw new TweetsIsEmptyException();		
	}
				

}