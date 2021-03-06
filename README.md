![LOGO](https://user-images.githubusercontent.com/92534853/147455323-9d166ce3-7c73-410a-8125-8b3288322a40.jpg)

# PROGETTO PROGRAMMAZIONE AD OGGETTI 2021-2022
# INDICE  :bookmark_tabs:
- [INTRODUZIONE](#INTRODUZIONE)
- [FILTRI](#FILTRI-memo)
- [STATISTICHE](#STATISTICHE-bar_chart)

- [CONFIGURAZIONE](#CONFIGURAZIONE-computer)
- [ROTTE](#ROTTE-globe_with_meridians) 
- [PARAMETRI](#PARAMETRI-page_with_curl)
- [ECCEZIONI](#ECCEZIONI-exclamation)
- [TEST](#TEST-interrobang)
- [DOCUMENTAZIONE](#DOCUMENTAZIONE-memo)
- [AUTORI](#AUTORI-busts_in_silhouette)
- [FILE RESTITUITI](#FILE-RESTITUITI)


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

# CONFIGURAZIONE :computer:
Per visionare il progetto è necessario clonare la repository situata su GitHub in locale oppure è possibile eseguire tramite terminale il seguente comando 
“ git clone https://github.com/luigiciuf/PROGETTO-OOP”
In questo modo è possibile lanciare il progetto come SpringBoot application da un IDE (noi abbiamo utilizzato Eclipse) oppure da terminale e quando il programma sarà in esecuzione bisogna utilizzare un client (ES. Postman) che ci permetterà di passare i vari parametri contattando l’indirizzo
http://localhost:8080

NOTA: in caso di problemi per l’utilizzo della porta 8080 è possibile modificarla attraverso il file presente in src/main/resourses/application.proprerties andando a definire una porta che al momento non è utilizzata.
# ROTTE :globe_with_meridians:
ROTTA | COSA RESTITUISCE
------------ | -------------
1)GET:  /tweet/get  | Restituisce un JSONObject contenente tutte le informazioni relative ai vari tweet.
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
3)Day,Mounth,Year | Int,String,Int | SI | SI
4)Non richiesti | --- | --- | ---
5)Non richiesti | --- | --- | ---
6)Non richiesti | --- | --- | ---


CHIAMATE ROTTE, PARAMETRI E ESECUZIONE SU POSTMAN  :

1) DATI TWEET

![1](https://user-images.githubusercontent.com/92534853/147749762-226157f4-06e0-4e01-a74d-8cbdf1f7a304.PNG)


2) TWEET FILTRATI IN BASE ALL'HASHTAG INSERITO 

![2](https://user-images.githubusercontent.com/92534853/147749773-1ff3542c-43d9-4640-af21-bb8ddf445b8c.PNG)


3) TWEET FILTRATI IN BASE ALLA DATA INSERITA

![3](https://user-images.githubusercontent.com/92534853/147749779-4d692ea0-9205-4526-bb3a-20477330d403.PNG)


4) STATISTICHE TWEET IN BASE ALLE FASCE ORARIE

![4](https://user-images.githubusercontent.com/92534853/147749784-d838281d-291c-4dcb-9433-ca6d2ba803db.PNG)


5) STATISTICHE PUBBLICAZIONE TWEET NEI GIORNI DELLA SETTIMANA

![5](https://user-images.githubusercontent.com/92534853/147749792-18aa17cf-9c53-443e-b6ce-439c49fa20f6.PNG)



6) STATISTICHE RICORRENZA HASHTAG NEI VARI TWEETS

![6](https://user-images.githubusercontent.com/92534853/147749798-14d1623e-d239-4448-abd1-7414d349e6f4.PNG)




# ECCEZIONI :exclamation:
Oltre alle eccezioni standard di java sono state inserite altre eccezioni personalizzate reperibili [qui.](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/SpringAPP/SpringAPP/src/main/java/com/progettounivpm/SpringAPP/exception)
* **TweetsIsEmptyException:** viene lanciata se provo a lanciare altre rotta prima di quella obbligatoria. Viene visualizzato il seguente messaggio: 
  ### "ERRORE: Lanciare prima la Rotta /tweet/get"
* **HashtagInexistentException:** viene lanciata se l'hashtag inserito nella prima rotta è inesistente. Viene visualizzato il seguente messaggio:
  ### "ERRORE: hashtag inesistente. Effettuare nuovamente la chiamata."

# TEST :interrobang:
Utilizzando il frameword JUnit abbiamo implementato 2 test che si possono consultare [qui.](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/SpringAPP/SpringAPP/src/test/java/com/progettounivpm/SpringAPP)
* Test 1 : Controllo chiamata API e parsing.
* Test 2: Verifica filtro con zero risultati

# DOCUMENTAZIONE :memo:
Tutto il progetto è documentato in javadoc ed è possibile visualizzarlo [qui](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/SpringAPP/SpringAPP/doc)

# FILE RESTITUITI  
E' possibile visualizzare i vari file in formato json restituiti al lancio delle varie rotte [qui.](https://github.com/luigiciuf/PROGETTO-OOP/tree/master/FILE%20RESTITUITI)

# AUTORI :busts_in_silhouette:
Il seguente progett è stato realizzato da :
* [Federico Rossolini](https://github.com/Fede-Rosso): filtri,eccezioni,service ,controller,test,model, javadoc. 
* [Luigi Ciuffreda](https://github.com/luigiciuf): statitiche, readme ,controller, javadoc, service,test, javadoc.

Il seguente progetto è stato sviluppato in circa 3 settimane di lavoro documentando il tutto su git hub con i vari commit che ci hanno permesso di poter effettuare dei confronti ed eventuali correzioni di coppia. Tutte le specifiche richieste sono state implementate aggiungendo anche un plus sulla parte delle statistiche dei tweet nelle varie fasce orarie giornaliere.
Si ringrazia il professor Emanuele Frontoni e tutti i suoi collaboratori per la disponibilità e i consigli.





