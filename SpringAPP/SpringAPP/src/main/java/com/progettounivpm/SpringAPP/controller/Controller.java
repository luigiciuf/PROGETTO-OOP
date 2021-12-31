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

/**
 * <b>Classe</b> Controller che gestisce tutte le chiamate al Server.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
@RestController
public class Controller {
	
	/**
	 * JSONObject contenente il JSON ottenuto dalla chiamata API.
	 */
	private JSONObject allTweetsData;
	/**
	 * ArrayList contenente i Tweet ottenuti dopo il PARSING, con solo i dati che ci interessano.
	 */
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	
	/**
	 * <b>Rotta</b> che esegue la chiamata alle API e parsing, salvando in allTweetsData il JSON ottenuto dalla chiamata API e in tweets il risultato del parsing.
	 * @param hashtag Indica quali tweet scaricare.
	 * @param count Indica quanti tweet scaricare.
	 * @return Un JSONObject contenente i tweet ottenuti dal parsing.
	 * @throws HashtagInexistentException Eccezione, se la chiamata API (usando l'hashtag specificato come parametro) non restituisce nulla.
	 * @throws IOException
	 * @see TwitterServiceImpl#getJSONTweets(String, int)
	 * @see TwitterServiceImpl#getTweetInfo(JSONObject)
	 * @see TwitterServiceImpl#toJSON(ArrayList)
	 */
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
	
	/**
	 * <b>Rotta</b> che visualizza i tweet contenenti uno specifico hashtag.
	 * @param hashtag da cercare nei tweet.
	 * @return Un JSONObject contenete i tweet filtrati.
	 * @throws TweetsIsEmptyException Eccezione, se prima non è stata lanciata la rotta /tweet/get.
	 * @see HashtagFilter#filter()  
	 */
	@GetMapping(value= "/hastag_filter") 
	public ResponseEntity<Object> filtroHashtag (
			@RequestParam (name= "hashtag") String hashtag) 
					throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagFilter hashtag_filter = new HashtagFilter(hashtag, tweets);
		return new ResponseEntity<Object>(hashtag_filter.filter(),HttpStatus.OK);
	}
	
	/**
	 * <b>Rotta</b> che visualizza i tweet pubblicati in una data specifica.
	 * @param day di tipo int, es 12.
	 * @param month di tipo String, es Dec per Dicembre.
	 * @param year di tipo int, es 2021.
	 * @return Un JSONObject contenete i tweet filtrati.
	 * @throws TweetsIsEmptyException Eccezione, se prima non è stata lanciata la rotta /tweet/get.
	 * @see TemporalPeriodFilter#filter()
	 */
	@GetMapping(value= "/day_filter")
	public ResponseEntity<Object> filtoGiorni (
			@RequestParam (name= "day") int day,
			@RequestParam (name= "month")String month,
			@RequestParam (name= "year")int year) 
					throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TemporalPeriodFilter day_filter = new TemporalPeriodFilter(tweets,day,month,year);
		return new ResponseEntity<Object>(day_filter.filter(),HttpStatus.OK);
	}
	
	/**
	 * <b>Rotta</b> che visualizza le varie statiche sulle fascie orarie in cui sono stati postati i tweet.
	 * @return Un JSONObject contenete le statistiche.
	 * @throws TweetsIsEmptyException Eccezione, se prima non è stata lanciata la rotta /tweet/get.
	 * @see TimeStats#statistic()
	 */
	@GetMapping(value = "/tweet/timestats")
	public ResponseEntity<Object> timestats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		TimeStats timestats = new TimeStats(tweets);
		return new ResponseEntity<Object>(timestats.statistic(),HttpStatus.OK);	
	}
	
	/**
	 * <b>Rotta</b> che visualizza le varie statiche sui giorni della settimana in cui sono stati postati i tweet.
	 * @return Un JSONObject contenete le statistiche.
	 * @throws TweetsIsEmptyException Eccezione, se prima non è stata lanciata la rotta /tweet/get.
	 * @see DayStats#statistic()
	 */
	@GetMapping(value= "/tweet/daystats")
	public ResponseEntity<Object> daystats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		DayStats daystats = new DayStats(tweets);
		return new ResponseEntity<Object>(daystats.statistic(),HttpStatus.OK);
	}
	
	/**
	 * <b>Rotta</b> che visualizza le varie statiche sui vari hashtag usati.
	 * @return Un JSONObject contenete le statistiche.
	 * @throws TweetsIsEmptyException Eccezione, se prima non è stata lanciata la rotta /tweet/get.
	 * @see HashtagsStats#statistic()
	 * @see HashtagsStats#statistic1()
	 */
	@GetMapping(value= "/tweet/hashtagstats")
	public ResponseEntity<Object> hashtagstats() throws TweetsIsEmptyException{
		TweetsisEmpty(tweets);
		HashtagsStats statistiche = new HashtagsStats(tweets);
		return new ResponseEntity<Object>(statistiche.statistic(), HttpStatus.OK);	
	}
	
	/**
	 * Metodo ausiliario, usato in tutte le rotte (eccetto la prima) per verificare se sono stati scaricati tweet, altimenti lancia TweetsIsEmptyException.
	 * @param tweets
	 * @throws TweetsIsEmptyException
	 */
	private static void TweetsisEmpty(ArrayList<Tweet> tweets) throws TweetsIsEmptyException {
		if (tweets.isEmpty()==true) 
			throw new TweetsIsEmptyException();		
	}
				

}