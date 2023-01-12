package iesfranciscodelosrios.pesetenis.controller;

import iesfranciscodelosrios.pesetenis.utils.Windows;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button CancelBtn;

    @FXML
    private TextField AccountField;

    @FXML
    private TextField transferenceField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            Windows.closeRequest((Stage) anchorPane.getScene().getWindow());
        });
    }


    public void switchToPrincipal(ActionEvent event) throws IOException {
        App.loadScene(new Stage(),"Principal","Pesetenis",false,false);
        App.closeScene((Stage) anchorPane.getScene().getWindow());
    }
}
