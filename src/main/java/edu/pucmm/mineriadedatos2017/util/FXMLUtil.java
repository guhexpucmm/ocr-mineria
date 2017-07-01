package edu.pucmm.mineriadedatos2017.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class FXMLUtil {
    private static final Logger logger = LogManager.getLogger();
    private static FXMLUtil instance;

    private FXMLUtil() {

    }

    public static FXMLUtil getInstance() {
        if (instance == null)
            instance = new FXMLUtil();

        return instance;
    }

    public Parent getParentFromFXML(String rutaFXML){
        FXMLLoader fxmlLoader;

        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(rutaFXML));

            return fxmlLoader.load();
        } catch (IOException e) {
            logger.info("Error al cargar el archivo fxml.", e);
            return null;
        }
    }
}
