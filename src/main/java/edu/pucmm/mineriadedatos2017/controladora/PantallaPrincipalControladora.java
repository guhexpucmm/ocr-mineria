package edu.pucmm.mineriadedatos2017.controladora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPrincipalControladora implements Initializable {

    private GraphicsContext graphicsContext;


    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vBox;

    @FXML
    private Button btnBorrar;

    @FXML
    private Pane pane;

    @FXML
    private Canvas canvas;

    @FXML
    private HBox hBox;

    @FXML
    private Button btnEntrenarModelo;

    @FXML
    private Button btnSuperEntrenamiento;

    @FXML
    private Button btnReconocerLetra;


    public PantallaPrincipalControladora() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage();

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(5);
    }

    @FXML
    void btnBorrarClick(ActionEvent event) {
        borrar();
    }

    @FXML
    void canvasMousePressed(MouseEvent event) {
        graphicsContext.beginPath();
        graphicsContext.lineTo(event.getX(), event.getY());
        graphicsContext.stroke();
    }

    @FXML
    void canvasMouseDragged(MouseEvent event) {
        graphicsContext.lineTo(event.getX(), event.getY());
        graphicsContext.stroke();
    }

    @FXML
    void btnReconocerLetraClick(ActionEvent event) {
        reconocerLetra();
    }

    @FXML
    void btnSuperEntrenamientoClick(ActionEvent event) {

    }

    @FXML
    void btnEntrenarModeloClick(ActionEvent event) {

    }

    private void reconocerLetra() {

    }

    private void analizar() {

    }

    private void setImage() {
        Image image = new Image("/fotos/fondo_principal.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        stackPane.setBackground(new Background(backgroundImage));
    }

    private void borrar() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
