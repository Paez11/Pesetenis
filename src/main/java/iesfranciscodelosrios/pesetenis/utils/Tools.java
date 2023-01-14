package iesfranciscodelosrios.pesetenis.utils;

import javafx.stage.FileChooser;

import java.io.File;

public class Tools {
    public static String getFilePathFromFileChooser() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            Log.info("No file selected");
            return null;
        }
    }

    public static boolean validateAmount(String amount) {
        return amount.matches("\\d*");
    }
}
