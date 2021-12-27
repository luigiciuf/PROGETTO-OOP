![LOGO](https://user-images.githubusercontent.com/92534853/147455323-9d166ce3-7c73-410a-8125-8b3288322a40.jpg)

# PROGETTO PROGRAMMAZIONE AD OGGETTI 2021-2022
# INDICE
- [INTRODUZIONE](#INTRODUZIONE)
- [FILTRI](#FILTRI)
- [STATISTICHE](#STATISTICHE)

- [CONFIGURAZIONE](#CONFIGURAZIONE)
- [ROTTE](#ROTTE) 
- [PARAMETRI](#PARAMETRI )


# INTRODUZIONE 
Applicazione Java che utilizza le API di Twitter per fare ricerche in base ad un hashtag dato in input dall’utente, filtrare per giorno o hashtag e fare statistiche su giorno, hashtag e ora della pubblicazione dei tweets. Viene utilizzata un API fornitaci dal professore che si basa su cloud Amazon che ci ha permesso di evitare i lunghi tempi di autenticazione dell’API ufficiale di Tweeter permettendoci così di ottimizzare i tempi per la realizzazione dell’app.

Lo scopo principale dell’applicazione è quello di ricercare tweet attraverso un hashtag dato in input dall’utente come parametro. È possibile inoltre decidere il numero di tweet visualizzabili dando un valore al parametro “count” altrimenti viene passato il valore di default che corrisponde a 5. È possibile come richiesto nelle specifiche del progetto filtrare i risultati ottenuti e visualizzare delle statistiche.

# FILTRI 
GIORNO, MESE, ANNO: vengono restituiti i tweet postati in quella determinata data
HASHTAG: vengono restituiti i tweet che al loro interno contengono un altro hashtag  definito come parametro

# STATISTICHE 
  GIORNI: viene restituito il numero e la percentuale di tweet pubblicati nei diversi giorni della settimana.
	ORA:  vengono restituite statistiche su la pubblicazione nelle diverse fasce orarie giornaliere.
	HASHTAG: vengono restituite statistiche sulla ricorrenza di quell’hashtag all’interno dei tweet.
# CONFIGURAZIONE 
Per visionare il progetto è necessario clonare la repository situata su GitHub in locale oppure è possibile eseguire tramite terminale il seguente comando 
“ git clone https://github.com/luigiciuf/PROGETTO-OOP”
In questo modo è possibile lanciare il progetto come SpringBoot application da un IDE ( noi abbiamo utilizzato Eclipse) oppure da terminale e quando il programma sarà in esecuzione bisogna utilizzare un client ( ES. Postman)che ci permetterà di passare i vari parametri contattando l’indirizzo
http://localhost:8080

NOTA: in caso di problemi per l’utilizzo della porta 8080 è possibile modificarla attraverso il file presente in src/main/resourses/application.proprerties andando a definire una porta che al momento non è utilizzata.
# ROTTE
1)	Get   /tweet/get  restituisce un JSONObject contenente tutte le informazioni relative ai dati di un tweet 
2)	Get /tweet/hashtag_filter restituisce un JSONObject contenente tutti i tweet filtrati con l’hashtag inserito 
3)	Get /tweet/day_filter restituisce un JSONObject contenente tutti i tweet filtrati in base al giorno contententi la data inserita
4)	Get /tweet/timestats restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nelle diverse fasce orarie della giornata 
5)	Get / tweet/daystats restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nei vari giorni della settimana 
6)	Get /tweet/hashtagstats restituisce una Hashmap contenente il numero di tweet contenenti l’hashtag inserito  e  calcola …..
# PARAMETRI 
1)	Hashtag ,count, di tipo stringa e int sono richiesti per una ricerca specifica altrimenti questi avranno il valore di defaul ( univpm, 5).
2)	Hashtag, di tipo stringa è un parametro richiesto per poter filtrare i tweet 
3)	Day, Mount, Year , tutti di tipo int sono parametri obbligatori da inserire per poter efettuare na ricerca filtratata dei tweet
4)	Nessun parametro richiesto
5)	Nessun parametro richiesto
6)	Nessun parametro richiesto








