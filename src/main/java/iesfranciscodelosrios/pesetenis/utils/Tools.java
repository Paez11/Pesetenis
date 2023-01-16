package iesfranciscodelosrios.pesetenis.utils;

import javafx.stage.FileChooser;

import java.io.File;

import java.awt.Desktop;
import java.io.IOException;

public class Tools {
    public static void getFileFromFileChooser() throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fc.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = fc.showOpenDialog(null);
        Desktop desktop = Desktop.getDesktop();
        if (selectedFile != null) {
            desktop.open(selectedFile);
        } else {
            Log.info("No file selected");
        }
    }

    public static boolean validateAmount(String amount) {
        return amount.matches("\\d*");
    }
}
