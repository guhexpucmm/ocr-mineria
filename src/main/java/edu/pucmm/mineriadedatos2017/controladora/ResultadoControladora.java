package edu.pucmm.mineriadedatos2017.controladora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultadoControladora implements Initializable {

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vBox;

    @FXML
    private Label lblTitulo;

    @FXML
    private ImageView imageView;

    @FXML
    private Button btnCerrar;

    @FXML
    private ListView<String> listViewMayus;

    @FXML
    private ListView<String> listViewMinus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage();
    }

    @FXML
    void btnCerrarClick(ActionEvent event) {
        cerrar();
    }

    private void cerrar() {
        ((Stage) btnCerrar.getScene().getWindow()).close();
    }

    private void setImage() {
        Image image = new Image("/fotos/resultado_fondo.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        stackPane.setBackground(new Background(backgroundImage));
    }
}
