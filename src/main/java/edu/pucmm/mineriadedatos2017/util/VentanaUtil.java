package edu.pucmm.mineriadedatos2017.util;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VentanaUtil {
    private Stage stage;
    private String titulo;
    private String rutaFXML;

    public VentanaUtil(Stage stage, String titulo, String rutaFXML) {
        this.stage = stage;
        this.titulo = titulo;
        this.rutaFXML = rutaFXML;
    }

    public VentanaUtil setClosable() {
        stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue)
                stage.close();
        });

        return this;
    }

    public VentanaUtil propiedades() {
        stage.setTitle(titulo);
        stage.setScene(new Scene(FXMLUtil.getInstance().getParentFromFXML(rutaFXML)));
        stage.toFront();
        stage.getIcons().add(new Image("/icons/ocr_icon.png"));
        stage.setResizable(false);

        return this;
    }

    public void abrir() {

        stage.show();
    }
}
