package services;
import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import biblioteca.Carte;

import java.util.List;

public interface IBibliotecaServices {
    public void loginB(Bibliotecar bibliotecar, IBibliotecaObserver obs) throws BibliotecaException ;
    public void logoutB(Bibliotecar bibliotecar, IBibliotecaObserver client) throws BibliotecaException;

    public void loginA(Abonat abonat, IBibliotecaObserver obs) throws BibliotecaException ;
    public void logoutA(Abonat abonat, IBibliotecaObserver client) throws BibliotecaException;

    public List<Carte> getToateCartile();
    public List<Carte> getToateCartileDisponibile();

    public void adaugaCarte (String titlu, String autor) throws Exception;
    public void modificaCarte (Integer id,String titlu, String autor, Boolean stare) throws Exception;
    public void stergeCarte (Integer id);

/*    public List<ProbaDTO> getToateProbeleDTO()throws ConcursException;
    public List<Participant> getParticipantiInscrisiLaProba(int idProba);
    public void inscriere(InregistrareDTO inregistrareDTO) throws ConcursException;
    public List<ParticipantDTO> getAllParticipantiDTOptProbaData(int idProba) throws ConcursException;

    public void adaugareParticipant(String nume, String prenume, int varsta) throws Exception;
    public List<Participant> getAllParticipanti();
    public List<Proba> getProbeleUnuiParticipant(int idParticipant);
    public Organizator findOneOrganizatorByUsernameParola(String username,String parola);*/
}
