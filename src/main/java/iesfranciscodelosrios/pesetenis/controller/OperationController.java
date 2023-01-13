package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.model.dataobject.Account;
import iesfranciscodelosrios.pesetenis.model.dataobject.Customer;
import iesfranciscodelosrios.pesetenis.utils.Windows;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OperationController {

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
    private Account account;
    private Customer customer;
    private String transactionType;

    /**
     * Constructor with params
     * @param account
     * @param transactionType
     */
    public OperationController(Account account, Customer customer, String transactionType) {
        this.account=account;
        this.customer=customer;
        this.transactionType=transactionType;
    }

    @FXML
    public void operation() {

        this.lblBalance.setText(String.valueOf(this.account.getBalance()));
        if(transactionType.equals("enter")) {
            this.customer.setTransactionType("enter");
            this.lblOperation.setText("Ingresos");
            this.lblUpdateBalance.setText(String.valueOf((this.account.enterBalance(
                    Double.parseDouble(this.txtAmount.getText())))));
        }
        if(transactionType.equals("extract")) {
            if(Windows.confirmAlert("¿Desea continuar con la transacción?") == ButtonType.OK){
                this.customer.setTransactionType("extract");
                this.lblOperation.setText("Retiros");
                this.lblUpdateBalance.setText(String.valueOf((this.account.drawBalance(
                        Double.parseDouble(this.txtAmount.getText())))));
            }
        }
    }

    @FXML
    private void closeWindow() {
        if(Windows.confirmAlert("¿Desea finalizar la transacción?") == ButtonType.OK){
            Stage stage = (Stage) this.lblOperation.getScene().getWindow();
            stage.close();
        }
    }
}
