package persistance;

import biblioteca.Carte;
import biblioteca.Imprumut;

import java.util.List;

public interface ImprumutRepository extends CRUDRepository<Integer, Imprumut>{
    List<Imprumut> getImprumuturiActiveAbonat(int idAbonat);
}
