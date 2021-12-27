package com.progettounivpm.SpringAPP.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private JSONObject allTweetsData;

	
	@GetMapping(value= "/tweet/get")
	public ResponseEntity<Object> getTweetInfo( 
			@RequestParam (name= "hashtag", defaultValue= "univpm") String hashtag,
			@RequestParam (name= "count", defaultValue = "5" )int count)
			throws IOException{
		TwitterServiceImpl downloadTweets = new TwitterServiceImpl();
		allTweetsData = downloadTweets.getJSONTweets(hashtag,count);
		tweets = downloadTweets.getTweetInfo(allTweetsData);
		if (tweets.size() == 0)
			return new ResponseEntity<Object>("ERRORE, hashtag inesistente. Effettuare nuovamente la chiamata.",HttpStatus.OK);
		else
			return new ResponseEntity<Object>(downloadTweets.toJSON(tweets),HttpStatus.OK);
	}
	
	@GetMapping(value= "/hastag_filter") 
	public ResponseEntity<Object> filtroHashtag (
			// inserire eccezione se non � stato inserito il parametro
			@RequestParam (name= "hashtag") String hashtag) throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagFilter hashtag_filter = new HashtagFilter(hashtag, tweets);
		return new ResponseEntity<Object>(hashtag_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/day_filter")
	public ResponseEntity<Object> filter(
			//TODO: defaultValue today
			@RequestParam (name= "day") int day,
			@RequestParam (name= "month")String month,
			@RequestParam (name= "year")int year) throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TemporalPeriodFilter day_filter = new TemporalPeriodFilter(tweets,day,month,year);
		return new ResponseEntity<Object>(day_filter.filter(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/tweet/timestats")
	public ResponseEntity<Object> timestats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TimeStats time= new TimeStats(tweets);
		return new ResponseEntity<Object>(time.Statistic(),HttpStatus.OK);	
	}
	
	@GetMapping(value= "/tweet/daystats")
	public ResponseEntity<Object> stampastats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		DayStats statistiche= new DayStats(tweets);
		return new ResponseEntity<Object>(statistiche.Statistic(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/tweet/hashtagstats")
	public ResponseEntity<Object> hs() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagsStats statistiche= new HashtagsStats(tweets);
		return new ResponseEntity<Object>(" tweet scaricati: "+ tweets.size()+statistiche.Statistic1(), HttpStatus.OK);	
		
	}
	
	//Metodo ausiliario, usato in tutte le rotte (eccetto la prima) per verificare se sono stati scaricati tweet.
	private static void TweetsisEmpty(ArrayList<Tweet> tweets) throws TweetsIsEmptyException {
		if (tweets.isEmpty()==true) 
			throw new TweetsIsEmptyException();		
	}
				

}