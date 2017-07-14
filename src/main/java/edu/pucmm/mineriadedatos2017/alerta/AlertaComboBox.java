package edu.pucmm.mineriadedatos2017.alerta;

import edu.pucmm.mineriadedatos2017.enums.Letra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceDialog;

public class AlertaComboBox extends ChoiceDialog<Letra> {
    ObservableList<Letra> list;

    public AlertaComboBox() {
        super(null, Letra.values());
        list = FXCollections.observableArrayList(Letra.values());

        setTitle("Entrenamiento");
        setHeaderText("");
        setContentText("Entrenar letra como: ");
    }

    public void mostrar() {
        this.show();
    }
}
