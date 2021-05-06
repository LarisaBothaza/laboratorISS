package persistance;

import biblioteca.Carte;

import java.util.List;

public interface CarteRepository extends CRUDRepository<Integer, Carte> {
    List<Carte> toateCartileDisponibile();
}
