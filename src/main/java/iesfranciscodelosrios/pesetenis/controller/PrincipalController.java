package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.utils.Windows;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            Windows.closeRequest((Stage) anchorPane.getScene().getWindow());
        });
    }


    public void switchToTransaction(ActionEvent event) throws IOException {
        App.loadScene(new Stage(),"Transaction","Pesetenis",false,false);
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }
}