package services;

import biblioteca.Carte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBibliotecaObserver extends Remote {
    void carteUpdated() throws BibliotecaException, RemoteException;
    void imprumutAdded() throws BibliotecaException, RemoteException;

}
