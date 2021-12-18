package com.progettounivpm.SpringAPP;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.progettounivpm.SpringAPP.model.Tweet;
import com.progettounivpm.SpringAPP.service.TwitterServiceImpl;

import java.util.ArrayList;
import org.json.simple.*;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) throws java.io.IOException {
		SpringApplication.run(SpringAppApplication.class, args);
			
		//TEST
		/*String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=";
		
		JSONObject t = new TwitterServiceImpl().getJSONTweets("univpm");
		ArrayList<Tweet> r = new ArrayList<Tweet>();
		r = new TwitterServiceImpl().getTweetInfo(t);
		//stampiamo un valore dei vari Tweet per vedere se il parsing ha funzionato
		for ( Tweet s: r)
			System.out.println(s.getCreated_at());*/
		
	}
}

