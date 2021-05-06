package controllers;

import biblioteca.Bibliotecar;
import biblioteca.Carte;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.BibliotecaException;
import services.IBibliotecaObserver;
import services.IBibliotecaServices;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BibliotecarController  extends UnicastRemoteObject implements IBibliotecaObserver, Serializable {

    private IBibliotecaServices service;
    private Bibliotecar bibliotecarConectat;
    private ObservableList<Carte> modelCarti = FXCollections.observableArrayList();

    public BibliotecarController() throws RemoteException { }

    @FXML
    TableView<Carte> tabelCarti;

    @FXML
    TextField textFdCodCarte;

    @FXML
    TextField textFdTitlu;

    @FXML
    TextField textFdAutor;

    public void initialize() {
        tabelCarti.setItems(modelCarti);
    }

    public void setContext(IBibliotecaServices service) throws RemoteException{
        this.service = service;
    }

    public void logout(){
        try {
            service.logoutB(bibliotecarConectat,this);
            System.exit(0);
        } catch (BibliotecaException e) {
            System.out.println("Logout error " + e);
        }
    }

    public void setBibliotecarConectat(Bibliotecar bibliotecarConectat) throws BibliotecaException {
        this.bibliotecarConectat = bibliotecarConectat;
        initModel();
    }

    public void initModel()  {
        modelCarti.setAll(service.getToateCartile());
    }

    public void selectCarte(MouseEvent mouseEvent) {
        Carte carteSelectata = tabelCarti.getSelectionModel().getSelectedItem();

        textFdCodCarte.setText(carteSelectata.getId().toString());
        textFdTitlu.setText(carteSelectata.getTitlu());
        textFdAutor.setText(carteSelectata.getAutor());

    }

    public void stergeCarte(MouseEvent mouseEvent) {
        Carte carteSelectata = tabelCarti.getSelectionModel().getSelectedItem();

        if (carteSelectata != null){
            try{
                service.stergeCarte(carteSelectata.getId());
                MessageBox.showMessage(null, Alert.AlertType.INFORMATION,"Yeey!", "Stergere cu succes!");
                textFdCodCarte.setText("");
                textFdTitlu.setText("");
                textFdAutor.setText("");
            } catch (Exception e) {
                MessageBox.showErrorMessage(null, e.getMessage());
            }
        }
        else{
            MessageBox.showErrorMessage(null, "NIMIC SELECTAT!");
        }

    }

    public void modificaCarte(MouseEvent mouseEvent) {
        Carte carteSelectata = tabelCarti.getSelectionModel().getSelectedItem();

        if (carteSelectata != null){

            String titlu = textFdTitlu.getText();
            String autor = textFdAutor.getText();

            String err = "";

            if (titlu.length() < 3) {
                err += "Titlu invalid!\n";
            }
            if ( autor.length() < 3){
                err += "Autor invalid!\n";
            }

            if (err.length() == 0){
                try{
                    service.modificaCarte(carteSelectata.getId(), titlu, autor, carteSelectata.getDisponibila());
                    MessageBox.showMessage(null, Alert.AlertType.INFORMATION,"Yeey!", "Carte modificata cu succes!");
                    textFdCodCarte.setText("");
                    textFdTitlu.setText("");
                    textFdAutor.setText("");
                } catch (Exception e) {
                    MessageBox.showErrorMessage(null, e.getMessage());
                }
            }
            else{
                MessageBox.showErrorMessage(null, err);
            }

        }else{
            MessageBox.showErrorMessage(null, "NIMIC SELECTAT!");
        }

    }

    public void adaugaCarte(MouseEvent mouseEvent) {
        String titlu = textFdTitlu.getText();
        String autor = textFdAutor.getText();

        String err = "";

        if (titlu.length() < 3) {
            err += "Titlu invalid!\n";
        }
        if ( autor.length() < 3){
            err += "Autor invalid!\n";
        }

        if (err.length() == 0){
            try{
                service.adaugaCarte(titlu, autor);
                MessageBox.showMessage(null, Alert.AlertType.INFORMATION,"Yeey!", "Carte adaugata cu succes!");
                textFdCodCarte.setText("");
                textFdTitlu.setText("");
                textFdAutor.setText("");
            } catch (Exception e) {
                MessageBox.showErrorMessage(null, e.getMessage());
            }
        }
        else{
            MessageBox.showErrorMessage(null, err);
        }

    }

    @Override
    public void carteUpdated() throws BibliotecaException, RemoteException {
        Platform.runLater(()->{
            modelCarti.setAll(service.getToateCartile());
            tabelCarti.refresh();
        });
    }

    @Override
    public void imprumutAdded() throws BibliotecaException, RemoteException {
        Platform.runLater(()->{
            modelCarti.setAll(service.getToateCartile());
            tabelCarti.refresh();
        });
    }



}
