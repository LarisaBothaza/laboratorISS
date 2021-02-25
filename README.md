# laboratorISS

Enunț problemă: BIBLIOTECA 

O bibliotecă oferă o aplicație de gestiune: cont pentru bibliotecar și cont pentru abonat.

> Abonații văd o listă de cărți ce pot fi împrumutate pentru fiecare terminal + încă o secțiune specială unde apar cărțile împrumutate.
> - Pentru împrumut – poate trimite cerere de rezervare o carte
> - Mai poate trimite cerere de prelungire imprumut
	
> Bibliotecarii văd toate cărțile pe secțiuni(terminale): disponibile, iar la cele împrumutate abonatul la care este cartea și perioada împrumutului.
> - Gestionează împrumuturi: 
> 	- selectează o carte disponibilă și pe baza codului unic împrumută cartea selectată (perioada standard e 2 săptămâni) 
>	- selectează o carte imprumutata si in momentul in care un abonat restituie o carte, o marcheaza disponibila
>	- ( pentru ambele se poate face selecție multiplă a cărților )
> - Trimite notificări abonaților care întârzie.
 	 
Pentru un abonat, se retin în sistem informații legate de cnp, nume, adresa, telefon și un cod unic de identificare a acestuia în cadrul bibliotecii. 

Pentru un bibliotecar, se retin în sistem informații legate de cnp, nume, adresa, telefon, un cod unic de identificare a acestuia în cadrul bibliotecii si sectiunea din biblioteca unde activeaza (ex. Sectiune copii, adolescenti, adulti)

Fiecare carte poate exista în unul sau mai multe exemplare, identificate prin coduri unice, precum si sectiunea in care poate fi gasita.

Biblioteca are mai multe terminale (sectiuni), de unde abonatii pot sa imprumute carti.

Pentru a putea folosi un terminal, un abonat trebuie să se autentifice. Dupa autentificare, acesta vede lista exemplarelor disponibile în acel moment si poate imprumuta unul sau mai multe exemplare.

Pentru restituirea cartilor, fiecare carte se returneaza la bibliotecarul din terminaul in care apartine cartea. Daca abonatul merge la un terminal gresit, apare mesaj de redirectionare.

Dupa fiecare împrumut/restituire, toți utilizatorii terminalelor bibliotecii văd lista actualizata a cartilor disponibile: in lista abonatilor apare cartea, in lista bibliotecarului se schimba statusul in libera.
