package br.upe.utils;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AbrirPopup {
    public static void abrirPopup(ActionEvent event, String fxml, String texto) throws IOException {
        Parent root = FXMLLoader.load(AbrirPopup.class.getResource(fxml));
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(texto);
        popupStage.setScene(new Scene(root));
        popupStage.setResizable(false);
        popupStage.show();
    }

}
