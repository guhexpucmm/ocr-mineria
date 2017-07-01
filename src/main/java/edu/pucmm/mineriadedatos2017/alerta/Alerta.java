package edu.pucmm.mineriadedatos2017.alerta;

import javafx.scene.control.Alert;

public class Alerta extends Alert{
    private String titulo;
    private String header;
    private String contenido;

    public Alerta(String titulo, String header, String contenido, AlertType alertType) {
        super(alertType);
        this.titulo = titulo;
        this.header = header;
        this.contenido = contenido;
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
