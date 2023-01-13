package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.model.dataobject.Account;
import iesfranciscodelosrios.pesetenis.model.dataobject.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private String transactionType;

    /**
     * Constructor with params
     * @param account
     * @param transactionType
     */
    public OperationController(Account account, String transactionType) {
        this.account=account;
        this.transactionType=transactionType;
    }


    public void operation() {
        this.lblBalance.setText(String.valueOf(this.account.getBalance()));
        if(transactionType.equals("enter")) {
            this.lblOperation.setText("Ingresos");
            this.lblUpdateBalance.setText(String.valueOf((this.account.enterBalance
                    (Double.parseDouble(this.txtAmount.getText())))));
        }
        if(transactionType.equals("extract")) {
            this.lblOperation.setText("Retiro");
        }
    }
}
