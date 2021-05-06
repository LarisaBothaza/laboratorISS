package persistance;

import biblioteca.Bibliotecar;

public interface BibliotecarRepository extends CRUDRepository<Integer, Bibliotecar> {

    Bibliotecar findBibliotecarByUsernameParola(String username,String parola);

}
