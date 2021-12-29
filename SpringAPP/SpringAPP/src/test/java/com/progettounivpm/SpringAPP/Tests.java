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
	org.json.simple.JSONObject allTweetsData;
	TwitterServiceImpl downloadTweets = new TwitterServiceImpl();
	
	
	
	
	
	@BeforeEach 
	void inizializzazione() throws Exception{
	
		
		allTweetsData = downloadTweets.getJSONTweets("univpm",100);
		diprova = downloadTweets.getTweetInfo(allTweetsData);
		//String percorso = " C:\\Users\\luigi\\Desktop\\FILE RESTITUITI\\ prima chiamata.json";
		//diprova= downloadTweets.readFile( "primachiamata.json");
		
		
	}
	
	// assertArrayEquals(Object[] expecteds, Object[] actuals)
   // Asserts that two object arrays are equal.
	
	@Test 
	@DisplayName ("Controllo chiamata API e parsing")
	void test1() throws Exception{
		//siccome non possiamo usare assert con un arraylist facciamo un ciclo per controllare l'avvenuta del parsing
		for(Tweet t : diprova ) {
			Assert.notNull(t);
			//System.out.println(t); verifa corretto funzionamento
			
			
			
			
		}
	}
	
	@Test
	@DisplayName("verifica filtro con zero risultati")
	void test2()throws Exception{
		String hashtag = "djcsDVCScdccas";
		JSONArray JarrayTweets= new JSONArray();
		JSONObject outputdesiderato = new JSONObject();
		outputdesiderato.put("Non ci sono tweets con hashtag: " + hashtag, JarrayTweets);
		HashtagFilter filtroprova= new HashtagFilter(hashtag, diprova);
		JSONObject output= new JSONObject();
		output=filtroprova.filter();
		System.out.println(output);
		System.out.println(outputdesiderato);
		assertEquals(output,outputdesiderato);
		
		
		
		

		
	
	}
	

		
		
		
		
		
	}



	



	





		
		
		
		
		
		
		
		
		
	
	
	



		
		
		
		
		
		
		
		
		
		
	
	


