![LOGO](https://user-images.githubusercontent.com/92534853/147455323-9d166ce3-7c73-410a-8125-8b3288322a40.jpg)

# PROGETTO PROGRAMMAZIONE AD OGGETTI 2021-2022
# INDICE
- [INTRODUZIONE](#INTRODUZIONE)
- [FILTRI](#FILTRI)
- [STATISTICHE](#STATISTICHE)

- [CONFIGURAZIONE](#CONFIGURAZIONE)
- [ROTTE](#ROTTE) 
- [PARAMETRI](#PARAMETRI)
- [TEST](#TEST)


# INTRODUZIONE 
Applicazione Java che utilizza le API di Twitter per fare ricerche in base ad un hashtag dato in input dall’utente, filtrare per giorno o hashtag e fare statistiche su giorno, hashtag e ora della pubblicazione dei tweets. Viene utilizzata un API fornitaci dal professore che si basa su cloud Amazon che ci ha permesso di evitare i lunghi tempi di autenticazione dell’API ufficiale di Tweeter permettendoci così di ottimizzare i tempi per la realizzazione dell’app.

Lo scopo principale dell’applicazione è quello di ricercare tweet attraverso un hashtag dato in input dall’utente come parametro. È possibile inoltre decidere il numero di tweet visualizzabili dando un valore al parametro “count” altrimenti viene passato il valore di default che corrisponde a 100 (che è anche il massimo valore utilizzabile). È possibile come richiesto nelle specifiche del progetto filtrare i risultati ottenuti e visualizzare delle statistiche.

# FILTRI 
TIPO DI FILTRO | COSA RESTITUISCE
------------ | -------------
GIORNO, MESE, ANNO: |  vengono restituiti i tweet postati in quella determinata data
HASHTAG: | vengono restituiti i tweet che al loro interno contengono un altro hashtag  definito come parametro

# STATISTICHE 

TIPO DI STATISTICA | COSA RESTITUISCE 
------------ | -------------
GIORNI: | viene restituito il numero e la percentuale di tweet pubblicati nei diversi giorni della settimana.
ORA: | vengono restituite statistiche su la pubblicazione nelle diverse fasce orarie giornaliere.
HASHTAG:| vengono restituite statistiche sulla ricorrenza di quell’hashtag all’interno dei tweet.

# CONFIGURAZIONE 
Per visionare il progetto è necessario clonare la repository situata su GitHub in locale oppure è possibile eseguire tramite terminale il seguente comando 
“ git clone https://github.com/luigiciuf/PROGETTO-OOP”
In questo modo è possibile lanciare il progetto come SpringBoot application da un IDE (noi abbiamo utilizzato Eclipse) oppure da terminale e quando il programma sarà in esecuzione bisogna utilizzare un client (ES. Postman) che ci permetterà di passare i vari parametri contattando l’indirizzo
http://localhost:8080

NOTA: in caso di problemi per l’utilizzo della porta 8080 è possibile modificarla attraverso il file presente in src/main/resourses/application.proprerties andando a definire una porta che al momento non è utilizzata.
# ROTTE
ROTTA | COSA RESTITUISCE
------------ | -------------
1)GET:  /tweet/get  | restituisce un JSONObject contenente tutte le informazioni relative ai dati di un tweet 
2)GET:  /hashtag_filter  | restituisce un JSONObject contenente tutti i tweet filtrati con l’hashtag inserito 
3)GET: /day_filter   |   restituisce un JSONObject contenente tutti i tweet filtrati in base al giorno contententi la data inserita
4)GET: /tweet/timestats  |   restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nelle diverse fasce orarie della giornata 
5)GET: /tweet/daystats    | restituisce un JSONObject contenente le statistiche di tutti i tweet pubblicati nei vari giorni della settimana 
6)GET: /tweet/hashtagsstats | restituisce una HashMap contentente la ricorrenza degli hashtag all'interno dei vari tweet


# PARAMETRI 

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

![1 rotta](https://user-images.githubusercontent.com/92534853/147735838-53b85865-11ac-474e-a4b5-2c69827d983e.png)

2) TWEET FILTRATI IN BASE ALL'HASHTAG INSERITO 

![hashtag filtro](https://user-images.githubusercontent.com/92534853/147735905-5bc65135-4058-4079-b80a-479579e1b756.png)

3) TWEET FILTRATI IN BASE ALLA DATA INSERITA

![tweet filtr data](https://user-images.githubusercontent.com/92534853/147735940-30e4b904-1a4e-48b6-9098-d4c8d8d40dce.png)

4) STATISTICHE TWEET IN BASE ALLE FASCE ORARIE

![fasce orarie](https://user-images.githubusercontent.com/92534853/147736004-a25d57c7-95dd-49dc-8669-e25b5659b64c.png)

5)STATISTICHE PUBBLICAZIONE TWEET NEI GIORNI DELLA SETTIMANA

![statische giorni](https://user-images.githubusercontent.com/92534853/147736036-2371d9d6-e46e-41b3-a61f-a30877bd2fe2.png)

6) INSERIRE SCREEN HASHTAGSTATS




# TEST






