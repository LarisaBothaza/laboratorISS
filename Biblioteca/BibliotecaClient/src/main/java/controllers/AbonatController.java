package controllers;

import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import biblioteca.Carte;
import services.BibliotecaException;
import services.IBibliotecaObserver;
import services.IBibliotecaServices;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AbonatController extends UnicastRemoteObject implements IBibliotecaObserver, Serializable {

    private IBibliotecaServices service;
    private Abonat abonatConectat;

    public AbonatController() throws RemoteException {
    }

    public void setContext(IBibliotecaServices service) throws RemoteException{
        this.service = service;
    }

    public void logout(){
        try {
            service.logoutA(abonatConectat,this);
            System.exit(0);
        } catch (BibliotecaException e) {
            System.out.println("Logout error " + e);
        }
    }

    public void setAbonatConectat(Abonat abonatConectat) throws BibliotecaException {
        this.abonatConectat = abonatConectat;
        //initModel();
    }

    @Override
    public void carteUpdated(Carte carte) throws BibliotecaException, RemoteException {

    }

    @Override
    public void carteAdded() throws BibliotecaException, RemoteException {

    }
}
