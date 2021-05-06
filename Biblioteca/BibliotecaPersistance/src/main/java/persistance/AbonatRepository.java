package persistance;

import biblioteca.Abonat;

public interface AbonatRepository extends CRUDRepository<Integer, Abonat> {

    Abonat findAbonatByUsernameParola(String username,String parola);
}
