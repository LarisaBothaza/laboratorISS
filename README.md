# laboratorISS

Enunț problemă: BIBLIOTECA 

O bibliotecă oferă o aplicație de gestiune: cont pentru bibliotecar și cont pentru abonat.

> Abonații văd o listă de cărți ce pot fi împrumutate + încă o secțiune specială unde apar cărțile împrumutate.
> - Selecteaza si imuprumuta o carte din cele disponibile
	
> Bibliotecarii văd toate cărțile: disponibile, iar la cele împrumutate abonatul la care este cartea 
> - Gestionează împrumuturi: 
>	- adauga carte noua in biblioteca
>	- sterge o carte din biblioteca
>	- modifica datele unei carti
>	- returneaza o carte a unui abonat
 	 
Pentru un abonat, se retin în sistem informații legate de cnp, nume, adresa, telefon și un cod unic de identificare a acestuia în cadrul bibliotecii. 

Pentru un bibliotecar, se retin în sistem informații legate de cnp, nume, adresa, telefon, un cod unic de identificare a acestuia în cadrul bibliotecii.
Fiecare carte poate exista în unul sau mai multe exemplare, identificate prin coduri unice.

Pentru a putea folosi un sistemul, un abonat trebuie să se autentifice. Dupa autentificare, acesta vede lista exemplarelor disponibile în acel moment si poate imprumuta unul sau mai multe exemplare.

Pentru restituirea cartilor, fiecare carte se returneaza la bibliotecar. 

Dupa fiecare împrumut/restituire, toți utilizatorii terminalelor bibliotecii văd lista actualizata a cartilor disponibile: in lista abonatilor apare cartea, in lista bibliotecarului se schimba statusul in libera.
