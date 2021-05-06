package services;

import biblioteca.Carte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBibliotecaObserver extends Remote {
    void carteUpdated(Carte carte) throws BibliotecaException, RemoteException;
    void carteAdded() throws BibliotecaException, RemoteException;
}
