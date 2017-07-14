package edu.pucmm.mineriadedatos2017.alerta;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

public class Alerta extends Alert{
    private String titulo;
    private String header;
    private String contenido;
    private DialogPane dialogPane;

    public Alerta(String titulo, String header, String contenido, AlertType alertType) {
        super(alertType);
        this.titulo = titulo;
        this.header = header;
        this.contenido = contenido;
        dialogPane = getDialogPane();
        dialogPane.getStylesheets().add("/css/main.css");
    }

    public Alerta aviso() {
        setTitle(titulo);
        setHeaderText(header);
        setContentText(contenido);

        return this;
    }

    public void mostrar() {
        show();
    }
}
