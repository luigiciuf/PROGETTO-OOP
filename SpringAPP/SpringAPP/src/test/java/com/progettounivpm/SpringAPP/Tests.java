package com.progettounivpm.SpringAPP;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.progettounivpm.SpringAPP.filter.HashtagFilter;
import com.progettounivpm.SpringAPP.model.Tweet;
import com.progettounivpm.SpringAPP.service.TwitterServiceImpl;

@SpringBootTest
public class Tests {
	ArrayList<Tweet> diprova= null;
	JSONObject allTweetsData;
	TwitterServiceImpl downloadTweets = new TwitterServiceImpl();
	
	
	@BeforeEach 
	void inizializzazione() throws Exception{
		//Costruzione oggetto con il link come variabile interna e con i metodi per la chiamata API e PARSING.
		allTweetsData = downloadTweets.getJSONTweets("univpm",100);
		//Costruzione ArrayList con i Tweet
		diprova = downloadTweets.getTweetInfo(allTweetsData);
		//SOSTITUENDO LA CHIAMATA POSSIAMO USARE UN FILE PER LA LETTURA DEI TWEET
		//diprova= downloadTweets.readFile("chiamataprova.json");
		/*
		System.out.println("ARRAY CREATO:");
		System.out.println("-------------------------------------------------------------------");
		System.out.println(diprova);
		System.out.println("-------------------------------------------------------------------");
		 */
	}
	
	// assertArrayEquals(Object[] expecteds, Object[] actuals) Asserts that two object arrays are equal.
	
	@Test 
	@DisplayName ("Controllo chiamata API e parsing")
	void test1() throws Exception{
		//Siccome non possiamo usare assert con un arraylist facciamo un ciclo per controllare l'avvenuta del parsing
		for(Tweet t : diprova ) {
			//System.out.println(t); Stampa per verifare il corretto funzionamento
			Assert.notNull(t);		
		}
	}
	
	@Test
	@DisplayName("verifica filtro con zero risultati")
	void test2()throws Exception{
		//Usiamo un hashtag strano come parametro per il filtro, per ottenere zero risultati 
		String hashtag = "djcsDVCScdccas";
		//costruiamo l'output che ci aspettiamo
		JSONArray JarrayTweets= new JSONArray();
		JSONObject outputdesiderato = new JSONObject();
		outputdesiderato.put("Non ci sono tweets con hashtag: " + hashtag, JarrayTweets);
		//chiamiamo il filtro
		HashtagFilter filtroprova= new HashtagFilter(hashtag, diprova);
		JSONObject output= new JSONObject();
		output=filtroprova.filter();
		//TEST
		assertEquals(output,outputdesiderato);
	}
	

		
		
			
}
