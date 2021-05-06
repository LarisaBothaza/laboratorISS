package server;

import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import biblioteca.Carte;
import persistance.AbonatRepository;
import persistance.BibliotecarRepository;
import persistance.CarteRepository;
import services.BibliotecaException;
import services.IBibliotecaObserver;
import services.IBibliotecaServices;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceImplementation implements IBibliotecaServices {

    private BibliotecarRepository bibliotecarRepository;
    private AbonatRepository abonatRepository;
    private CarteRepository carteRepository;

    private Map<Integer,IBibliotecaObserver> bibliotecariLogati;
    private Map<Integer,IBibliotecaObserver> abonatiLogati;

    public ServiceImplementation(BibliotecarRepository bibliotecarRepository, AbonatRepository abonatRepository,
                                 CarteRepository carteRepository) {

        this.bibliotecarRepository = bibliotecarRepository;
        this.abonatRepository = abonatRepository;
        this.carteRepository = carteRepository;

        bibliotecariLogati = new ConcurrentHashMap<>();
        abonatiLogati = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void loginB(Bibliotecar bibliotecar, IBibliotecaObserver obs) throws BibliotecaException {
        Bibliotecar bibliotecarR = bibliotecarRepository.findBibliotecarByUsernameParola(bibliotecar.getUsername(),
                bibliotecar.getParola());

        if(bibliotecarR != null) {
            if(bibliotecariLogati.get(bibliotecarR.getId()) != null){
                throw new BibliotecaException("Bibliotecarul deja s-a logat!");
            }
            bibliotecariLogati.put(bibliotecarR.getId(),obs);

        }else{
            throw new BibliotecaException("Autentificare esuata!");
        }
    }

    @Override
    public synchronized void logoutB(Bibliotecar bibliotecar, IBibliotecaObserver client) throws BibliotecaException {
        bibliotecariLogati.remove(bibliotecar);
    }

    @Override
    public synchronized void loginA(Abonat abonat, IBibliotecaObserver obs) throws BibliotecaException {
        Abonat abonatR = abonatRepository.findAbonatByUsernameParola(abonat.getUsername(),
                abonat.getParola());

        if(abonatR != null) {
            if(abonatiLogati.get(abonatR.getId()) != null){
                throw new BibliotecaException("Abonatul deja s-a logat!");
            }
            abonatiLogati.put(abonatR.getId(),obs);

        }else{
            throw new BibliotecaException("Autentificare esuata!");
        }

    }

    @Override
    public synchronized void logoutA(Abonat abonat, IBibliotecaObserver client) throws BibliotecaException {
        abonatiLogati.remove(abonat);
    }

    @Override
    public synchronized List<Carte> getToateCartile() {
        return carteRepository.findAll();
    }

    @Override
    public void adaugaCarte(String titlu, String autor) throws Exception {
        Carte carteNoua = new Carte(titlu,autor,true);
        carteRepository.add(carteNoua);

        notifyCarteAdded();
    }

    private final int defaultThreadsNo=5;

    private void notifyCarteAdded() {
        ExecutorService executor= Executors.newFixedThreadPool(defaultThreadsNo);
        for(var o: bibliotecariLogati.entrySet()) {
            executor.execute(() -> {
                try {
                    o.getValue().carteAdded();
                } catch (BibliotecaException | RemoteException e) {
                    System.err.println("Error notifying adaugare carte " + e);
                }
            });
        }
        executor.shutdown();
    }
}
