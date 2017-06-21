package edu.pucmm.mineriadedatos2017.aplicacion;

import edu.pucmm.mineriadedatos2017.hibernate.HibernateUtil;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;

public class Main extends Application {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    private final Insets insets = new Insets(5.0, 5.0, 5.0, 5.0);

    private final int PRELOADER_WIDTH = 600;
    private final int PRELOADER_HEIGHT = 400;

    private Stage stage;

    private Parent root;
    private StackPane stackPane;
    private VBox vBox;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Label label;

    public Main() {
    }

    public static void main(String[] args) {
        logger.info("Iniciando programa...");
        launch(args);
        StandardServiceRegistryBuilder.destroy(HibernateUtil.getSessionFactory()
                .getSessionFactoryOptions().getServiceRegistry());
        logger.info("Programa terminado.");
    }

    @Override
    public void init() throws Exception {
        super.init();
        root = setRoot();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(50);

                    switch (i) {
                        case 1:
                            new Thread(() -> HibernateUtil.openSession().close()).start();
                            break;
                    }
                }
                return null;
            }
        };

        mostrarPreloader(primaryStage, task, () -> mostrarPrograma(task.valueProperty()));

        new Thread(task).start();
    }

    private void mostrarPreloader(final Stage primaryStage, Task<?> task, InitCompletionHandler initCompletionHandler) {
        progressBar.progressProperty().bind(task.progressProperty());

        task.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                progressBar.progressProperty().unbind();
                progressBar.setProgress(1);
                primaryStage.toFront();

                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(0.5), root);
                fadeSplash.setFromValue(1.0);
                fadeSplash.setToValue(0.0);
                fadeSplash.setOnFinished(actionEvent -> {
                    primaryStage.hide();
                    if (!primaryStage.isShowing())
                        initCompletionHandler.complete();
                });
                fadeSplash.play();
            }
        });

        Scene scene = new Scene(root, Color.TRANSPARENT);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cargando...");
        primaryStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - PRELOADER_WIDTH / 2);
        primaryStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - PRELOADER_HEIGHT / 2);
        primaryStage.setAlwaysOnTop(false);
        primaryStage.show();
    }

    private void mostrarPrograma(ReadOnlyObjectProperty<ObservableList<Double>> task) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/PantallaPrincipal.fxml"));
            Parent parent = fxmlLoader.load();

            stage = new Stage();
            stage.setMinWidth(900.0);
            stage.setMinHeight(600.0);
            stage.setTitle("OCR-Mineria");
            stage.setMaximized(true);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            logger.debug("Error al cargar la pantalla principal.", e);
        }
    }

    private Parent setRoot() {
        stackPane = new StackPane();
        stackPane.setPrefWidth(600);
        stackPane.setPrefHeight(400);

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        imageView = new ImageView(new Image("/fotos/pucmm-logo.png"));
        VBox.setMargin(imageView, insets);

        progressBar = new ProgressBar();
        progressBar.setMinHeight(25);
        progressBar.setMaxWidth(Double.MAX_VALUE);
        VBox.setMargin(progressBar, insets);

        label = new Label("Cargando datos...");
        label.setMinHeight(25);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);
        VBox.setMargin(imageView, insets);

        stackPane.getChildren().add(vBox);
        vBox.getChildren().addAll(imageView, progressBar, label);

        StackPane.setAlignment(vBox, Pos.CENTER);

        return stackPane;
    }

    public interface InitCompletionHandler {
        void complete();
    }
}
