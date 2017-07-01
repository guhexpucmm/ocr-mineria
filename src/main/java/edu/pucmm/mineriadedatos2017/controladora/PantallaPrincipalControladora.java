package edu.pucmm.mineriadedatos2017.controladora;

import edu.pucmm.mineriadedatos2017.util.VentanaUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPrincipalControladora implements Initializable {

    private StringProperty archivo;

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vBox;

    @FXML
    private HBox hBox;

    @FXML
    private Button btnEntrenarModelo;

    @FXML
    private Button btnReconocerLetra;

    @FXML
    private CustomTextField txtField;

    public PantallaPrincipalControladora() {
        archivo = new SimpleStringProperty("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage();
    }

    @FXML
    void btnEjecutarModeloClick(ActionEvent event) {
        ejecutarModelo();
    }

    @FXML
    void btnReconocerLetraClick(ActionEvent event) {
        reconocerLetra();
    }

    @FXML
    void stackPaneDragDetected(MouseEvent event) {

    }

    @FXML
    void stackPaneDragDone(DragEvent event) {

    }

    @FXML
    void stackPaneDragDropped(DragEvent event) {

    }

    @FXML
    void stackPaneDragEntered(DragEvent event) {

    }

    private void ejecutarModelo() {

    }

    private void reconocerLetra() {
        new VentanaUtil(new Stage(), "Resultado", "/vista/Resultado.fxml").propiedades().setClosable().abrir();
    }

    private void setImage() {
        Image image = new Image("/fotos/fondo_principal.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        stackPane.setBackground(new Background(backgroundImage));
    }
}
