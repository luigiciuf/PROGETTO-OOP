package com.progettounivpm.SpringAPP.model;


public class DataOra {
	
	// Tue Dec 14 17:32:42 +0000 2021
	// visto che all'interno del json è una stringa, possiamo usare la funzione .split(" ") 
	// e poi dei possibili cast
	
	private String giornosettimana;
	private String mese;
	private int giorno;
	private int ora;
	private int minuti;
	private int anno;

	public DataOra(String str) {
		String s [] = str.split(" ");
		this.giornosettimana = s[0];
		this.mese = s[1];
		this.giorno = Integer.parseInt(s[2]);
	    String orario_completo = s[3];
	    String orario_split [] = orario_completo.split(":");
	    this.ora = Integer.parseInt(orario_split[0]);
	    this.minuti = Integer.parseInt(orario_split[1]);
		this.anno = Integer.parseInt(s[5]);
	}
	
	public String getGiornosettimana() {
		return giornosettimana;
	}
	public String getMese() {
		return mese;
	}
	public int getGiorno() {
		return giorno;
	}
	public int getOra() {
		return ora;
	}
	public int getMinuti() {
		return minuti;
	}
	public int getAnno() {
		return anno;
	}
	
	public String toString() {
		String text_ora;
		if (this.ora<10)
			text_ora = "0"+String.valueOf(this.ora);
		else text_ora = String.valueOf(this.ora);
		return this.giornosettimana+" "+this.giorno+" "+this.mese+" "+ this.anno+" - "+ text_ora+":"+this.minuti;
	}
	
}