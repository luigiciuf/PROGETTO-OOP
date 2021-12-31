package com.progettounivpm.SpringAPP.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

import com.progettounivpm.SpringAPP.model.DataOra;
import com.progettounivpm.SpringAPP.model.Tweet;

/**
 * <b>Classe </b> DayStats che implementa Statistic. Si occupa delle statistiche giornaliere.
 * @author Luigi Ciuffreda
 * @author Federico Rossolini
 */
public class DayStats implements Statistic {
	/**
	 * ArrayList che contiene tutti i tweet scaricati.
	 */
	private ArrayList<Tweet> tweets;

	/**
	 * Costruttore della classe DayStats che prende come parametro un ArrayList. 
	 * @param tweets ArrayList 
	 */
	public DayStats(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	/**
	 * <b>Metodo</b> Statistic che inserisce dentro un arraylist i giorni della settimana e conta la loro ricorrenza.
	 * @param day1,day2,day3,day4,day5,day6,day7 contatori. 
	 * @param nulli contatore dei tweet contenenti la stringa dei giorni nulla.
	 * @see DataOra classe dataora utilizzata per modellare la data.
	 * @return JSONObject contenente tutte le statistiche giornaliere.
	 */
	@Override
	public JSONObject statistic() {
		
		DataOra data;
		int day1=0,day2=0,day3=0,day4=0,day5=0,day6=0,day7=0;
		int nulli=0;
		JSONObject obj=new JSONObject();
		
		for(int i=0; i<tweets.size(); i++) {
			data = tweets.get(i).getCreated_at();
			
			if (data.getGiornosettimana().equals("Mon"))
			{
				day1++;
			}
			else if (data.getGiornosettimana().equals("Tue"))
			{
				day2++;			
			}
			else if (data.getGiornosettimana().equals("Wed"))
			{
				day3++;	
			}
			else if (data.getGiornosettimana().equals("Thu"))
			{
				day4++;
			}
			else if (data.getGiornosettimana().equals("Fry"))
			{
				day5++;
			}
			else if (data.getGiornosettimana().equals("Sat"))
			{
				day6++;
			}
			else if (data.getGiornosettimana().equals("Sun"))
			{
				day7++;
			}
			else if (data.getGiornosettimana().equals("Null"))
			{
				nulli++;
			}		
		}
		obj.put("Tweet analizzati", tweets.size());
		obj.put("Tweet postati di lunedi", day1);
		obj.put("Tweet postati di martedi", day2);
		obj.put("Tweet postati di mercoledi", day3);
		obj.put("Tweet postati di giovedi", day4);
		obj.put("Tweet postati di venerdi", day5);
		obj.put("Tweet postati di sabato", day6);
		obj.put("Tweet postati di domenica", day7);
		obj.put("Tweet con giorni nulli", nulli);
		return obj;
	}
	
	
	@Override
	public HashMap statistic1() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
