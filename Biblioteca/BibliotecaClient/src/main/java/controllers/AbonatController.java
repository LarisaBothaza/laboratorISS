package controllers;

import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import biblioteca.Carte;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import services.BibliotecaException;
import services.IBibliotecaObserver;
import services.IBibliotecaServices;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AbonatController extends UnicastRemoteObject implements IBibliotecaObserver, Serializable {

    private IBibliotecaServices service;
    private Abonat abonatConectat;
    private ObservableList<Carte> modelCartiDisponibile = FXCollections.observableArrayList();

    public AbonatController() throws RemoteException { }

    @FXML
    TableView<Carte> tabelCartiDisponibile;

    public void initialize() {
        tabelCartiDisponibile.setItems(modelCartiDisponibile);
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
        initModel();
    }

    public void initModel()  {
        modelCartiDisponibile.setAll(service.getToateCartileDisponibile());
    }


    @Override
    public void carteUpdated() throws BibliotecaException, RemoteException {
        Platform.runLater(()->{
            modelCartiDisponibile.setAll(service.getToateCartileDisponibile());
            tabelCartiDisponibile.refresh();
        });
    }


}
