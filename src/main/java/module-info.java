module iesfranciscodelosrios.pesetenis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.desktop;

    opens iesfranciscodelosrios.pesetenis.controller to javafx.fxml;
    exports iesfranciscodelosrios.pesetenis;
    exports iesfranciscodelosrios.pesetenis.controller;
    exports iesfranciscodelosrios.pesetenis.model.dataobject;
}