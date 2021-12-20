package com.progettounivpm.SpringAPP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.core.codec.AbstractDataBufferDecoder;
import org.springframework.stereotype.Service;

import com.progettounivpm.SpringAPP.model.Tweet;

@Service 
// deve implementare tutti i metodi usati sull'interfaccia che eredita
public class TwitterServiceImpl implements TwitterService{
	
	private String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=";
	private String ApiKey = ""; // TODO: Da implementare poi quando sostituiremo il url
	
	@Override
	public JSONObject getJSONTweets(String hashtag) throws IOException {
		JSONObject tweets = null; //oggetto locale che servirà per il return
		
		URLConnection openConnection= new URL( url + hashtag ).openConnection(); // Open connection crea la connessione con il URL indicato
		/*POSSIBILE IMPLEMENTAZIONE:
		 *	int count; //stabilisce quanti tweet cercare
		 *  new URL( url + hastag + "&count=" + conunt ).openConnection()
		 */
		
		// Volendo è possibile ridefinire openConnection come lettura di un file json o txt da un percorso stabilito
		
		InputStream in = openConnection.getInputStream();  //legge la connessione creando un oggetto in di tipo InputStream
		String data= "";
		String line = "";
		
		try {
			InputStreamReader inR= new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);
			while((line= buf.readLine())!= null) {
				data+=line;
			}
			// dopo aver salvato tutto quello letto su data facciamo un cast di tipo JSONObject e salviamo sull'oggetto che restituiremo
			tweets = (JSONObject)JSONValue.parseWithException(data);	
		}
		//******************************************************************************
		// CI DOVREBBE ESSERE ANCHE:
		//catch (IOException | ParseException e) {
		// e.printStackTrace();
		//}
		// MA DA ERRORE

		catch (Exception e) {
			e.printStackTrace();
		}
		// in finally ci entra: sia dopo il try se esegito correttamente, sia se ha trovato delle eccezioni 
		finally { 
			in.close(); 
		}
		return tweets;
	}
	
	@Override
	public ArrayList<Tweet> getTweetInfo(JSONObject jsonTweets) {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		JSONArray statuses = (JSONArray)jsonTweets.get("statuses");
		
		for(int i=0; i < statuses.size(); i++) {
			JSONObject temp = (JSONObject) statuses.get(i);
			Tweet x = new Tweet(); //oggetto temporaneo usato come variabile di appoggio
			
			// Preleviamo Created_at
			x.setCreated_at((String)temp.get("created_at"));
			// Preleviamo gli Hastags (hastag_text) all'interno dell'oggetto entities
			JSONObject entities = (JSONObject)temp.get("entities");
			JSONArray jArray_hastags = (JSONArray)entities.get("hashtags");
			ArrayList<String> temp_hashtags = new ArrayList<String>();
			for(int j=0; j<jArray_hastags.size(); j++) {
				JSONObject hashtag_obj = (JSONObject)jArray_hastags.get(j);
				String text = (String) hashtag_obj.get("text");
				temp_hashtags.add(text);
			}
			x.setHashtags(temp_hashtags);
			// Preleviamo isolanguage_code e result typer dentro metadata
			JSONObject metadata = (JSONObject)temp.get("metadata"); {
				x.setResult_type((String)metadata.get("result_type"));
				x.setIsolanguage_code((String)metadata.get("iso_language_code"));  
			}
			// TODO: Preleviamo in_reply
			x.setIn_reply("");
			// Entriamo dentro user e Preleviamo location, created_at_user, statuses_count
			JSONObject user= (JSONObject)temp.get("user"); {
				x.setLocation((String)user.get("location"));
				x.setCreated_at_user((String)user.get("created_at"));
				x.setStatuses_count(String.valueOf(user.get("statuses_count")));
			 }		
			//infine aggiungiamo alla lista che restituiremo l'oggetto temporaneo del ciclo
			tweets.add(x);
		}
		return tweets;
	}
	
	@Override
	public JSONObject toJSON() {
		return null;
	}

}
