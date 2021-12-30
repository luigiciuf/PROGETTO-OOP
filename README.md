![LOGO](https://user-images.githubusercontent.com/92534853/147455323-9d166ce3-7c73-410a-8125-8b3288322a40.jpg)

# PROGETTO PROGRAMMAZIONE AD OGGETTI 2021-2022
# INDICE  :bookmark_tabs:
- [INTRODUZIONE](#INTRODUZIONE)
- [FILTRI](#FILTRI :memo:)
- [STATISTICHE](#STATISTICHE)

- [CONFIGURAZIONE](#CONFIGURAZIONE)
- [ROTTE](#ROTTE) 
- [PARAMETRI](#PARAMETRI)
- [ECCEZIONI](#ECCEZIONI)
- [TEST](#TEST)
- [DOCUMENTAZIONE](#DOCUMENTAZIONE)
- [AUTORI](#AUTORI)


# INTRODUZIONE 
Applicazione Java che utilizza le API di Twitter per fare ricerche in base ad un hashtag dato in input dall’utente, filtrare per giorno o hashtag e fare statistiche su giorno, hashtag e ora della pubblicazione dei tweets. Viene utilizzata un API fornitaci dal professore che si basa su cloud Amazon che ci ha permesso di evitare i lunghi tempi di autenticazione dell’API ufficiale di Tweeter permettendoci così di ottimizzare i tempi per la realizzazione dell’app.

Lo scopo principale dell’applicazione è quello di ricercare tweet attraverso un hashtag dato in input dall’utente come parametro. È possibile inoltre decidere il numero di tweet visualizzabili dando un valore al parametro “count” altrimenti viene passato il valore di default che corrisponde a 100 (che è anche il massimo valore utilizzabile). È possibile come richiesto nelle specifiche del progetto filtrare i risultati ottenuti e visualizzare delle statistiche.

# FILTRI :memo:
TIPO DI FILTRO | COSA RESTITUISCE
------------ | -------------
GIORNO, MESE, ANNO: |  Vengono restituiti i tweet postati in quella determinata data.
HASHTAG: | Vengono restituiti i tweet che al loro interno contengono un altro hashtag  definito come parametro.

# STATISTICHE :bar_chart:

TIPO DI STATISTICA | COSA RESTITUISCE 
------------ | -------------
GIORNI: | Viene restituito il numero e la percentuale di tweet pubblicati nei diversi giorni della settimana.
ORA: | Vengono restituite statistiche su la pubblicazione nelle diverse fasce orarie giornaliere.
HASHTAG:| Vengono restituite statistiche sulla ricorrenza di quell’hashtag all’interno dei tweet.

# CONFIGURAZIONE  :computer:
Per visionare il progetto è necessario clonare la repository situata su GitHub in locale oppure è possibile eseguire tramite terminale il seguente comando 
“ git clone https://github.com/luigiciuf/PROGETTO-OOP”
In questo modo è possibile lanciare il progetto come SpringBoot application da un IDE (noi abbiamo utilizzato Eclipse) oppure da terminale e quando il programma sarà in esecuzione bisogna utilizzare un client (ES. Postman) che ci permetterà di passare i vari parametri contattando l’indirizzo
http://localhost:8080

NOTA: in caso di problemi per l’utilizzo della porta 8080 è possibile modificarla attraverso il file presente in src/main/resourses/application.proprerties andando a definire una porta che al momento non è utilizzata.
# ROTTE   :globe_with_meridians:
ROTTA | COSA RESTITUISCE
------------ | -------------
1)GET:  /tweet/get  | Restituisce un JSONObject contenente tutte le informazioni relative ai dati di un tweet .
2)GET:  /hashtag_filter  | Restituisce un JSONObject contenente tutti i tweet filtrati con l’hashtag inserito .
3)GET: /day_filter   |   Restituisce un JSONObject contenente tutti i tweet filtrati in base al giorno contententi la data inserita.
4)GET: /tweet/timestats  |   Restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nelle diverse fasce orarie della giornata .
5)GET: /tweet/daystats    | Restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nei vari giorni della settimana .
6)GET: /tweet/hashtagsstats | Restituisce una HashMap contentente la ricorrenza degli hashtag all'interno dei vari tweet.

ATTENZIONE :warning: : non è possibile lanciare le rotte dei filtri e degli hashtag senza prima effettuare la prima rotta(/tweet/get). 


# PARAMETRI :page_with_curl:

PARAMETRI | TIPO | RICHIESTI | OBBLIGATORI
------------ | ------------- | ------------ | -------------
1)Hashtag, Count | String, Int | SI | No
2)Hashtag | String | SI | SI 
3)Day,Mounth,Year | Int,Int,Int | SI | SI
4)Non richiesti | --- | --- | ---
5)Non richiesti | --- | --- | ---
6)Non richiesti | --- | --- | ---

RISULTATI DELLE RICERCHE: 

1) DATI TWEET

![prima rotta](https://user-images.githubusercontent.com/92534853/147741545-d5a1f809-eb82-412c-bb3d-19e2391c15b6.png)


2) TWEET FILTRATI IN BASE ALL'HASHTAG INSERITO 

![hashtag filter](https://user-images.githubusercontent.com/92534853/147741558-ea10e1c1-7a5f-4623-b24c-3355f8cacf10.png)

3) TWEET FILTRATI IN BASE ALLA DATA INSERITA

![daily filter](https://user-images.githubusercontent.com/92534853/147741584-17260c23-cf44-437a-84cf-1272767f3c4c.png)

4) STATISTICHE TWEET IN BASE ALLE FASCE ORARIE

![fasce orarie stats](https://user-images.githubusercontent.com/92534853/147741611-d4b365a2-e326-48b5-a9dc-4fa2da99737d.png)

5)STATISTICHE PUBBLICAZIONE TWEET NEI GIORNI DELLA SETTIMANA

![giorni stats](https://user-images.githubusercontent.com/92534853/147741660-26c2b1c3-9b73-4888-b11d-f0e64632ea28.png)

6) STATISTICHE RICORRENZA HASHTAG NEI VARI TWEETS

![hashtags stats](https://user-images.githubusercontent.com/92534853/147741698-add42e6b-a712-40d7-9fa4-167b67101002.png)



# ECCEZIONI  :exclamation:
Oltre alle eccezioni standard di java sono state inserite altre eccezioni personalizzate reperibili [qui.](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/SpringAPP/SpringAPP/src/main/java/com/progettounivpm/SpringAPP/exception)
* **TweetsIsEmptyException:** viene lanciata se provo a lanciare altre rotta prima di quella obbligatoria. Viene visualizzato il seguente messaggio: 
  ### "ERRORE: Lanciare prima la Rotta /tweet/get"
* **HashtagInexistentException:** viene lanciata se l'hashtag inserito nella prima rotta è inesistente. Viene visualizzato il seguente messaggio:
  ### "ERRORE: hashtag inesistente. Effettuare nuovamente la chiamata."

# TEST :interrobang:
Utilizzando il frameword JUnit abbiamo implementato 2 test che si possono consultare [qui.](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/SpringAPP/SpringAPP/src/test/java/com/progettounivpm/SpringAPP)
* Test 1 : Controllo chiamata API e parsing.
* Test 2: Verifica filtro con zero risultati

# DOCUMENTAZIONE  :memo:
Tutto il progetto è documentato in javadoc

# AUTORI  :busts_in_silhouette:
Il seguente progett è stato realizzato da :
* [Federico Rossolini](https://github.com/Fede-Rosso): filtri,eccezioni,service , test
* [Luigi Ciuffreda](https://github.com/luigiciuf): statitiche, readme ,controller, javadoc

Il seguente progetto è stato sviluppato in circa 3 settimane di lavoro documentando il tutto su git hub con i vari commit che ci hanno permesso di poter effettuare dei confronti ed eventuali correzzioni di coppia. Tutte le specifiche richieste sono state implementate aggiungendo anche un plus sulla parte delle statistiche dei tweet nelle varie fasce orarie giornaliere.
Si ringrazia il professor Emanuele Frontoni e tutti i suoi collaboratori per la disponibilità e i consigli.





