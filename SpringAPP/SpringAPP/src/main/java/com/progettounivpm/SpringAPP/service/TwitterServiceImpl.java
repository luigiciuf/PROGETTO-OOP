package com.progettounivpm.SpringAPP.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Service;

import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b> Classe </b> TwitterServiceImpl che implementa TwitterService.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
@Service 
public class TwitterServiceImpl implements TwitterService{
	
	/**
	 * * URL base, da usare per la chiamata.
	 */
	private String url= "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=";
	//private String ApiKey = ""; TODO: Da implementare poi quando sostituiremo il url
	
	/**
	 * <b>Metodo</b> getJSONTweets che effettua la chiamata API. 
	 * @param hashtag da usare per costruire l'URL.
	 * @param count da usare per costruire l'URL.
	 * @return JSONObject contenente tutti i tweet estratti dalla chiamata all'api.
	 */
	@Override
	public JSONObject getJSONTweets(String hashtag,int count) throws IOException {
		
		JSONObject tweets = null; //oggetto locale usato per il return
		
		URLConnection openConnection= new URL( url + hashtag + "&count=" + count).openConnection(); // Open connection crea la connessione con il URL indicato.
		
		InputStream in = openConnection.getInputStream();  //Legge la connessione creando un oggetto in di tipo InputStream.
		String data= "";
		String line = "";
		
		try {
			InputStreamReader inR= new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);
			while((line= buf.readLine())!= null) {
				data+=line;
			}
			// Dopo aver salvato tutto quello letto su data, facciamo un cast di tipo JSONObject e salviamo sull'oggetto che restituiremo.
			tweets = (JSONObject)JSONValue.parseWithException(data);	
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// In finally ci entra: sia dopo il try se esegito correttamente, sia se ha trovato delle eccezioni. 
		finally { 
			in.close(); 
		}
		return tweets;
	}
	
	/**
	 * <b>Metodo</b> getTweetInfo che fa il parsing del JSONObject.
	 * @param jsonTweets un JSONObject contenente il file JSON contenente i tweet ottenuti dalla chiamata all'API.
	 * @return tweets ArrayList contenente tutte le info da noi richieste dei tweet.
	 */
	@Override
	public ArrayList<Tweet> getTweetInfo(JSONObject jsonTweets) {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		
		JSONArray statuses = (JSONArray)jsonTweets.get("statuses");
		for(int i=0; i < statuses.size(); i++) {
			JSONObject temp = (JSONObject) statuses.get(i);
			Tweet x = new Tweet(); //Oggetto temporaneo usato come variabile di appoggio.
			
			// Preleviamo Created_at.
			x.setCreated_at((String)temp.get("created_at"));
			// Preleviamo gli hashtag (hastag_text) all'interno dell'oggetto entities.
			JSONObject entities = (JSONObject)temp.get("entities");
			JSONArray jArray_hastags = (JSONArray)entities.get("hashtags");
			ArrayList<String> temp_hashtags = new ArrayList<String>();
			for(int j=0; j<jArray_hastags.size(); j++) {
				JSONObject hashtag_obj = (JSONObject)jArray_hastags.get(j);
				String text = (String) hashtag_obj.get("text");
				temp_hashtags.add(text);
			}
			x.setHashtags(temp_hashtags);
			// Preleviamo isolanguage_code e result typer dentro metadata.
			JSONObject metadata = (JSONObject)temp.get("metadata"); {
				x.setResult_type((String)metadata.get("result_type"));
				x.setIsolanguage_code((String)metadata.get("iso_language_code"));  
			}
			// Preleviamo in_reply
			x.setIn_reply((String)temp.get("in_reply_to_status_id ")); 
			// Dentro user e preleviamo location, created_at_user, statuses_count.
			JSONObject user= (JSONObject)temp.get("user"); {
				x.setLocation((String)user.get("location"));
				x.setCreated_at_user((String)user.get("created_at"));
				x.setStatuses_count(String.valueOf(user.get("statuses_count")));
			 }		
			//Infine aggiungiamo alla lista che restituiremo, l'oggetto temporaneo del ciclo.
			tweets.add(x);
		}
		return tweets;
	}
	
	/**
	 * <b> Metodo </b>toJSON usato per l'output. 
	 * Crea un JSONObject con Key "Tweets" e con valore un JSONArray contenente svariati JSONObject (i tweet convertiti da ArrayList a JSONObject).
	 * @return Un JSONObject contenente tutti i tweet.
	 */
	@Override
	public JSONObject toJSON(ArrayList<Tweet> tweets) {
		
		JSONObject oggettoFiltrato = new JSONObject();
		JSONArray arrayTweets = new JSONArray();
		
		for (Tweet t: tweets) {
			arrayTweets.add(t.toJSONObject());;
		}
		oggettoFiltrato.put("Tweets", arrayTweets);
		return oggettoFiltrato;	
	}	
	
	/**
	 * <b>Metodo</b> readFile utilizzato per leggere un file da locale.
	 * @param path stringa che contiene il percorso file. 
	 * @return ArrayList con tutti i tweet contenuti nel file.
	 */
	public ArrayList<Tweet> readFile(String path) {
		JSONParser jParser = new JSONParser();
		JSONObject jObj = new JSONObject();
		
		try (FileReader reader = new FileReader(path)){
			jObj = (JSONObject)jParser.parse(reader);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParseException e) { 
			e.printStackTrace();
		}
		//Richiamiamo il metodo getTweetInfo per estrapolare dal JSONObject i tweet (PARSING).
		return (getTweetInfo(jObj));	
	}	

}
