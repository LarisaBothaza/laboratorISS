package controllers;

import biblioteca.Abonat;
import biblioteca.Bibliotecar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.IBibliotecaServices;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginController extends UnicastRemoteObject {

    private BibliotecarController bibliotecarController;
    private AbonatController abonatController;
    private Parent parentBibliotecar;
    private Parent parentAbonat;
    private IBibliotecaServices service;

    public LoginController() throws RemoteException {
    }

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwdField;

    @FXML
    Button buttonLogIn;

    @FXML
    public void initialize() {

    }


    public void setContext(IBibliotecaServices service) throws RemoteException {
        this.service = service;
    }

    public void setControllerBibliotecar(BibliotecarController bibliotecarController){
        this.bibliotecarController = bibliotecarController;
    }

    public void setControllerAbonat(AbonatController abonatController){
        this.abonatController = abonatController;
    }

    public void setParents(Parent parentBibliotecar, Parent parentAbonat){

        this.parentBibliotecar = parentBibliotecar;
        this.parentAbonat = parentAbonat;
    }

    public void handleLogin(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String parola = passwdField.getText();

        if (username.startsWith("admin")){

            Bibliotecar bibliotecar = new Bibliotecar("", username, parola, "");

            try{
                service.loginB(bibliotecar, bibliotecarController);

                Stage stage=new Stage();
                stage.setScene(new Scene(parentBibliotecar));

                stage.setOnCloseRequest(event -> {
                    bibliotecarController.logout();
                    System.exit(0);
                });
                bibliotecarController.setBibliotecarConectat(bibliotecar);
                stage.show();

                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

            } catch (Exception e) {
                MessageBox.showErrorMessage(null,e.getMessage());
            }
        }
        else {

            Abonat abonat = new Abonat("", username, parola, "");

            try{
                service.loginA(abonat, abonatController);

                Stage stage=new Stage();
                stage.setScene(new Scene(parentAbonat));

                stage.setOnCloseRequest(event -> {
                    abonatController.logout();
                    System.exit(0);
                });
                abonatController.setAbonatConectat(abonat);
                stage.show();

                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

            } catch (Exception e) {
                MessageBox.showErrorMessage(null,e.getMessage());
            }
        }
    }
}
