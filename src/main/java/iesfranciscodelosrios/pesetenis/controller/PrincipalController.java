package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.model.dataobject.Account;
import iesfranciscodelosrios.pesetenis.model.dataobject.Customer;
import iesfranciscodelosrios.pesetenis.model.dataobject.FileM;
import iesfranciscodelosrios.pesetenis.model.dataobject.Transition;
import iesfranciscodelosrios.pesetenis.utils.Operation;
import iesfranciscodelosrios.pesetenis.utils.Tools;
import iesfranciscodelosrios.pesetenis.utils.Windows;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController extends Operation implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane moneyPane;
    @FXML
    private Button depositBtn;
    @FXML
    private Button withdrawBtn;
    @FXML
    private Button extractBtn;
    @FXML
    private Button transactionBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Text money;
    @FXML
    private Button btnStadistics;
    @FXML
    private TextArea txtStadistics;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            Windows.closeRequest((Stage) anchorPane.getScene().getWindow());
        });
        opsAccount = new Account();
        opsCustomer = new Customer("Mock",0.0);
        opsTransactionType="none";
        Thread customerThread = new Thread(opsCustomer);
        customerThread.start();
        money.setText(String.valueOf(opsAccount.getBalance()+" €"));
    }

    @FXML
    public void showStadistics(){
        // Cooperatings threads
        Transition t1 = new Transition("enter");
        Transition t2 = new Transition("extract");
        t1.setName("Hilo Contador de Ingresos");
        t2.setName("Hilo Contador de Retiradas");
        t1.run();
        t2.run();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        txtStadistics.setText(t1.getName()+": "+t1.getDeposit() +"\n"+
                                t2.getName()+": "+t2.getWithdraw() +"\n"+
                                "Cuenta total de transacciones: "+(t1.getDeposit()+t2.getWithdraw()));
    }

    public void extract() throws IOException {
        Tools.getFileFromFileChooser();
    }

    public void switchToEnterTransaction(ActionEvent event) throws IOException {
        opsTransactionType="enter";
        App.loadScene(new Stage(),"Operation","Pesetenis",false,false);
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }

    public void switchToExtractTransaction(ActionEvent event) throws IOException {
        opsTransactionType="extract";
        App.loadScene(new Stage(),"Operation","Pesetenis",false,false);
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }

    public void switchToTransaction(ActionEvent event) throws IOException {
        App.loadScene(new Stage(),"Transaction","Pesetenis",false,false);
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }

    public void exit(ActionEvent event)throws  IOException{
        if(Windows.confirmAlert("¿Desea finalizar la aplicación?") == ButtonType.OK)
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }
}
