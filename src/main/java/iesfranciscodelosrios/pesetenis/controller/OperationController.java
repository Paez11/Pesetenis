package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.model.dataobject.FileM;
import iesfranciscodelosrios.pesetenis.model.dataobject.Producer;
import iesfranciscodelosrios.pesetenis.utils.Operation;
import iesfranciscodelosrios.pesetenis.utils.Tools;
import iesfranciscodelosrios.pesetenis.utils.Windows;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OperationController extends Operation implements Initializable {

    /**
     * Attributes
     */
    @FXML
    private Label lblOperation;
    @FXML
    private Label lblBalance;
    @FXML
    private TextField txtAmount;
    @FXML
    private Label lblUpdateBalance;

    FileM filem = new FileM();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            Windows.closeRequest((Stage) lblOperation.getScene().getWindow());
        });

        //opsAccount.setBalance(filem.read());
        if(opsTransactionType.equals("enter")) {
            this.lblOperation.setText("Ingresos");
        }
        else if(opsTransactionType.equals("extract")){
            this.lblOperation.setText("Retiros");
        }
        this.lblBalance.setText(String.valueOf(opsAccount.getBalance()+" €"));
    }
    @FXML
    public void operation() {
        synchronized (opsAccount){
            if(!opsAccount.isTransaction()) {
                opsAccount.notifyAll();
            }
            else {
                if(txtAmount.getText().isEmpty()){
                    Windows.mostrarInfo("Atención","Cantidad vacía","No ha introducido ninguna cantidad.");
                }
                else {
                    if(Tools.validateAmount(txtAmount.getText())) {
                        if(opsTransactionType.equals("enter")) {
                            opsTransactionType="enter";
                            this.lblUpdateBalance.setText(String.valueOf((opsAccount.enterBalance(
                                    Double.parseDouble(this.txtAmount.getText())))));
                        }
                        if(opsTransactionType.equals("extract")) {
                            if(Windows.confirmAlert("¿Desea continuar con la transacción?") == ButtonType.OK){
                                opsTransactionType="extract";
                                this.lblUpdateBalance.setText(String.valueOf((opsAccount.drawBalance(
                                        Double.parseDouble(this.txtAmount.getText())))));
                            }
                        }
                        txtAmount.setText("");
                    }
                    else {
                        Windows.mostrarInfo("Atención","Datos no numéricos.","Solo se permite la entrada de datos numéricos (0-9).");
                        txtAmount.setText("");
                    }
                }
            }
        }
        producer = new Producer(filem,opsAccount,opsCustomer,opsTransactionType);
        producer.start();
    }

    @FXML
    private void closeWindow() throws IOException {
        if(Windows.confirmAlert("¿Desea finalizar la transacción?") == ButtonType.OK){
            Stage stage = (Stage) this.lblOperation.getScene().getWindow();
            stage.close();
            switchToPrincipal();
        }
    }

    public void switchToPrincipal() throws IOException {
        App.loadScene(new Stage(),"Principal","Pesetenis",false,false);
        App.closeScene((Stage) lblOperation.getScene().getWindow());
    }
}
